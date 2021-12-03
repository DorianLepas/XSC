package cea.language.xsc.folding;

import cea.language.xsc.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class XCSFoldingBuilder extends FoldingBuilderEx implements DumbAware {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        // Initialize the group of folding regions that will expand/collapse together.
        // Initialize the list of folding regions
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        // Get a collection of the XCSFunctionCore in the document below root
        Collection<XCSFunctionCore> Cores = PsiTreeUtil.findChildrenOfType(root, XCSFunctionCore.class);
        // Evaluate the collection
        for (final XCSFunctionCore Core : Cores) {
            descriptors.add(new FoldingDescriptor(Core.getNode(),
                    new TextRange(Core.getTextRange().getStartOffset(),
                            Core.getTextRange().getEndOffset() - Core.getCommentSize())));
        }

        // Get a collection of the XCSProperty in the document below root
        Collection<XCSProperty> Properties = PsiTreeUtil.findChildrenOfType(root, XCSProperty.class);
        // Evaluate the collection
        for (final XCSProperty Property : Properties) {
            descriptors.add(new FoldingDescriptor(Property.getNode(),
                    new TextRange(Property.getTextRange().getStartOffset() + 1,
                            Property.getTextRange().getEndOffset() - 1)));
        }

        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        String retTxt = "...";
        if (node.getPsi() instanceof XCSFunctionCore) {
            XCSFunctionCore nodeElement = (XCSFunctionCore) node.getPsi();
            retTxt = "<" + nodeElement.getFirstChild().getNextSibling().getText() + " ... >";
        }
        if (node.getPsi() instanceof XCSProperty) {
            XCSProperty nodeElement = (XCSProperty) node.getPsi();
            Collection<XCSProperty_> Properties = PsiTreeUtil.findChildrenOfType(nodeElement, XCSProperty_.class);
            Properties.removeIf(property -> !property.getProp().equals("VfeiName"));
            if (Properties.size() == 1){
                retTxt = ((XCSProperty_)Properties.toArray()[0]).getName().replace("\"","");
            }
        }
        return retTxt;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return node.getPsi() instanceof XCSProperty;
    }
}

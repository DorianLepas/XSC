package cea.language.sml.reference;

import cea.language.sml.fileType.SmlIcons;
import cea.language.sml.psi.SmlAliasBlock;
import cea.language.sml.psi.SmlFile;
import cea.language.sml.psi.SmlTypes;
import cea.language.sml.psi.SmlUtil;
import cea.language.xsc.psi.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import cea.language.xsc.filetype.XCSIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SmlEventReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String value;

    public SmlEventReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        value = "\"" + element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset()) + "\"";
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        List<ResolveResult> results = new ArrayList<>();
        // Search in the project collection_events.xsc file and the sml file
        if (value.indexOf('&') == 1){
            final List<SmlAliasBlock> propertiesAlias = SmlUtil.findPropertiesInAlias((SmlFile) myElement.getContainingFile(),value.replace("\"","").substring(1));
            for (SmlAliasBlock alias : propertiesAlias) {
                results.add(new PsiElementResolveResult(alias));
            }
        }
        else {
            //Search in Collection Events
            final List<XCSCeProperty_> propertiesCe = SmlUtil.findProperties((SmlFile) myElement.getContainingFile(), project, value);
            for (XCSCeProperty_ property : propertiesCe) {
                results.add(new PsiElementResolveResult(property));
            }
            //Search in Equipment event declaration
            final List<PsiLiteralExpression> propertiesDeclaration = SmlUtil.findPropertiesInDeclaration((SmlFile) myElement.getContainingFile(), project, value);
            for (PsiLiteralExpression property : propertiesDeclaration) {
                results.add(new PsiElementResolveResult(property));
            }
            if (myElement.getContainingFile().getVirtualFile().getCanonicalPath().contains("FFC")){
                //Search in eventHandler
                final List<PsiLiteralExpression> eventHandlers = SmlUtil.findPropertiesInEventHandler((SmlFile) myElement.getContainingFile(), project, value);
                for (PsiLiteralExpression eventHandler : eventHandlers) {
                    results.add(new PsiElementResolveResult(eventHandler));
                }
            }
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<LookupElement> variants = new ArrayList<>();
        // Create LookUpElement with element of XCSCeProperty_
        List<XCSCeProperty_> propertiesCe = SmlUtil.findProperties((SmlFile) myElement.getContainingFile(), project);
        for (final XCSCeProperty_ property : propertiesCe) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0 && property.getFirstChild().getText().equals("VfeiName")) {
                variants.add(LookupElementBuilder
                        .create(property.getLastChild().getText().replace("\"",""))
                        .withIcon(XCSIcons.FILE)
                        .withPresentableText(property.getLastChild().getText().replace("\"",""))
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        // Create LookUpElement with element of Sml Alias Blocks
        List<SmlAliasBlock> alias = SmlUtil.findPropertiesInAlias((SmlFile) myElement.getContainingFile());
        for (final SmlAliasBlock alias_ : alias) {
            if (alias_.getNode().findChildByType(SmlTypes.ALIAS_NAME) != null) {
                variants.add(LookupElementBuilder
                        .create("&"+alias_.getNode().findChildByType(SmlTypes.ALIAS_NAME).getText())
                        .withIcon(SmlIcons.FILE)
                        .withPresentableText(alias_.getNode().findChildByType(SmlTypes.ALIAS_NAME).getText())
                        .withTypeText("Alias")
                );
            }
        }
        return variants.toArray();
    }
}

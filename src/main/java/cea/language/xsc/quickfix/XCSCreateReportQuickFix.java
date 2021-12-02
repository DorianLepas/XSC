package cea.language.xsc.quickfix;

import cea.language.xsc.filetype.XCSFileType;
import cea.language.xsc.psi.*;
import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class XCSCreateReportQuickFix extends BaseIntentionAction {

    private final String key;
    private final PsiElement element;

    public XCSCreateReportQuickFix(String key, PsiElement element) {
        this.key = key;
        this.element = element;
    }

    @NotNull
    @Override
    public String getText() {
        return "Create report '" + key + "'";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "Create report";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return file instanceof XCSFile;
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws
            IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(() -> {
            XCSFile xcsFile = (XCSFile) file;
            if (xcsFile != null) {
                // Create Report in the file
                createProperty(project, xcsFile.getVirtualFile());
            }
        });
    }

    private void createProperty(final Project project, final VirtualFile file) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            boolean done = false;
            ASTNode lastChildNode = null;
            // Create a report
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(file);
            Collection<XCSFunctions> functions = PsiTreeUtil.findChildrenOfType(xcsFile, XCSFunctions.class);
            for (XCSFunctions function : functions) {
                String name = function.getNode().findChildByType(XCSTypes.FUNCTION_NAME).getText();
                String SF = function.getNode().findChildByType(XCSTypes.STREAM_FUNCTION).getText();
                if (SF.contains("S2F33") && name.replace("DR_","").equals(((XCSFunctionCore)element).getFunctionName().replace("LER_",""))) {
                    XCSFunctionCore List = PsiTreeUtil.findChildOfType(function,XCSFunctionCore.class);
                    if (List != null) {
                        PsiElement[] Cores = List.getChildren();
                        if (Cores[Cores.length-1] != null && Cores[Cores.length-1] instanceof XCSFunctionCore){
                            PsiElement[] InnerCores = ((XCSFunctionCore)Cores[Cores.length-1]).getChildren();
                            if (InnerCores[InnerCores.length-1] != null && InnerCores[InnerCores.length-1] instanceof XCSFunctionCore){
                                lastChildNode = ((XCSFunctionCore)InnerCores[InnerCores.length-1]).getNode();
                                lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                                lastChildNode.addChild(XCSElementFactory.createReport(lastChildNode,element,project).getNode());
                                //XCSElementFactory.createReport(Objects.requireNonNull(lastChildNode), element);
                                // Move to where the property has been created
                                ((Navigatable) Objects.requireNonNull(lastChildNode).getTreeNext().getPsi().getNavigationElement()).navigate(true);
                                Objects.requireNonNull(FileEditorManager.getInstance(project).getSelectedTextEditor()).getCaretModel().moveCaretRelatively(2, 0, false, false, false);
                                done = true;
                            }
                        }
                    }
                }
            }
            if (!done){
                ASTNode valueNode = element.getNode();
                while (valueNode != null && !(valueNode.getPsi() instanceof XCSFunctions)) {
                    valueNode = valueNode.getTreeParent();
                }
                if (valueNode != null){
                    lastChildNode = valueNode;
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                    lastChildNode.addChild(XCSElementFactory.createFunctionReport(lastChildNode,element,project).getNode());
                    // Move to where the property has been created
                    ((Navigatable) Objects.requireNonNull(lastChildNode).getTreeNext().getPsi().getNavigationElement()).navigate(true);
                    Objects.requireNonNull(FileEditorManager.getInstance(project).getSelectedTextEditor()).getCaretModel().moveCaretRelatively(2, 0, false, false, false);
                }
            }
        });
    }

}

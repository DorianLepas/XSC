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
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public class XCSCreatePropertyQuickFix extends BaseIntentionAction {

    private final String key;
    private final PsiElement element;

    public XCSCreatePropertyQuickFix(String key, PsiElement element) {
        this.key = key;
        this.element = element;
    }

    @NotNull
    @Override
    public String getText() {
        return "Create property '" + key + "'";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "Create property";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return file instanceof XCSFile;
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws
            IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(() -> {
            // Get all XCSFile in the xsc directory
            Collection<VirtualFile> virtualFiles =
                    FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
            virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
            String section = getType();
            // Search the file where to create the property
            for (VirtualFile virtualFile : virtualFiles) {
                XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
                if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                    // Create Property in collection_events file
                    if (section.equals("CEID") && xcsFile.getName().equals("collection_events.xsc")) {
                        createProperty(project, xcsFile.getVirtualFile());
                        return;
                    }
                    // Create Property in data_variables file
                    if (section.equals("DVID") && xcsFile.getName().equals("data_variables.xsc")) {
                        createProperty(project, xcsFile.getVirtualFile());
                        return;
                    }
                    // Create Property in constants file
                    if (section.equals("ECID") && xcsFile.getName().equals("constants.xsc")) {
                        createProperty(project, xcsFile.getVirtualFile());
                        return;
                    }
                    // Create Property in status_variables file
                    if (section.equals("SVID") && xcsFile.getName().equals("status_variables.xsc")) {
                        createProperty(project, xcsFile.getVirtualFile());
                        return;
                    }
                }
            }
        });
    }

    /**
     * Check the property type
     *
     * @return String type
     */
    private String getType() {
        PsiElement valueNode = element.getNode().getPsi().getParent();
        valueNode = valueNode.getPrevSibling();
        while (!valueNode.getText().equals("<")) {
            if (valueNode.getText().equals("CEID") || valueNode.getText().equals("DVID") || valueNode.getText().equals("ECID") || valueNode.getText().equals("SVID")) {
                return valueNode.getText();
            }
            valueNode = valueNode.getPrevSibling();
        }
        return "";
    }

    private void createProperty(final Project project, final VirtualFile file) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            ASTNode lastChildNode = null;
            VirtualFile dir = Objects.requireNonNull(PsiManager.getInstance(project).findFile(file)).getContainingDirectory().getVirtualFile();
            String section = getType();
            // Create a CEID property
            if (section.equals("CEID")) {
                XCSFile xcsFile = (XCSFile) Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(dir)).findFile("collection_events.xsc");
                XCSCollectionEventSection CE = PsiTreeUtil.findChildOfType(xcsFile, XCSCollectionEventSection.class);
                if (CE != null && CE.getChildren()[0].getChildren().length != 0) {
                    lastChildNode = CE.getChildren()[0].getChildren()[CE.getChildren()[0].getChildren().length - 1].getNode();
                } else {
                    return;
                }
                if (lastChildNode != null) {
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                    lastChildNode.addChild(XCSElementFactory.createPropertyCe("VfeiName",key,project).getNode());
                }
            }
            // Create a SVID property
            if (section.equals("SVID")) {
                XCSFile xcsFile = (XCSFile) Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(dir)).findFile("status_variables.xsc");
                XCSStatusVariableSection SV = PsiTreeUtil.findChildOfType(xcsFile, XCSStatusVariableSection.class);
                if (SV != null && SV.getChildren()[0].getChildren().length != 0) {
                    lastChildNode = SV.getChildren()[0].getChildren()[SV.getChildren()[0].getChildren().length - 1].getNode();
                } else {
                    return;
                }
                if (lastChildNode != null) {
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                    lastChildNode.addChild(XCSElementFactory.createPropertySv("VfeiName",key,project).getNode());
                }
            }
            // Create a ECID property
            if (section.equals("ECID")) {
                XCSFile xcsFile = (XCSFile) Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(dir)).findFile("constants.xsc");
                XCSEquipmentConstantSection EC = PsiTreeUtil.findChildOfType(xcsFile, XCSEquipmentConstantSection.class);
                if (EC != null && EC.getChildren()[0].getChildren().length != 0) {
                    lastChildNode = EC.getChildren()[0].getChildren()[EC.getChildren()[0].getChildren().length - 1].getNode();
                } else {
                    return;
                }
                if (lastChildNode != null) {
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                    lastChildNode.addChild(XCSElementFactory.createPropertyEc("VfeiName",key,project).getNode());
                }
            }
            // Create a DVID property
            if (section.equals("DVID")) {
                XCSFile xcsFile = (XCSFile) Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(dir)).findFile("data_variables.xsc");
                XCSDataVariableSection DV = PsiTreeUtil.findChildOfType(xcsFile, XCSDataVariableSection.class);
                if (DV != null && DV.getChildren()[0].getChildren().length != 0) {
                    lastChildNode = DV.getChildren()[0].getChildren()[DV.getChildren()[0].getChildren().length - 1].getNode();
                } else {
                    return;
                }
                if (lastChildNode != null) {
                    lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
                    lastChildNode.addChild(XCSElementFactory.createPropertyDv("VfeiName",key,project).getNode());
                }
            }
            // Move to where the property has been created
            ((Navigatable) Objects.requireNonNull(lastChildNode).getTreeNext().getPsi().getNavigationElement()).navigate(true);
            Objects.requireNonNull(FileEditorManager.getInstance(project).getSelectedTextEditor()).getCaretModel().moveCaretRelatively(2, 0, false, false, false);
        });
    }

}

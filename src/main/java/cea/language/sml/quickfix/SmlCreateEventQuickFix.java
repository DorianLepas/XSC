package cea.language.sml.quickfix;

import cea.language.sml.psi.SmlFile;
import cea.language.xsc.filetype.XCSFileType;
import cea.language.xsc.psi.XCSElementFactory;
import cea.language.xsc.psi.XCSFile;
import cea.language.xsc.psi.XCSTypes;
import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public class SmlCreateEventQuickFix extends BaseIntentionAction {

    private final String key;

    public SmlCreateEventQuickFix(String key) {
        this.key = key;
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
        return file instanceof SmlFile;
    }
    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws
            IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(() -> {
            Collection<VirtualFile> virtualFiles =
                    FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
            // Search the file where to create the property
            for (VirtualFile virtualFile : virtualFiles) {
                XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
                if (xcsFile != null && (xcsFile.getContainingDirectory().getParentDirectory().getParentDirectory().getParentDirectory() == file.getContainingDirectory().getParentDirectory().getParentDirectory().getParentDirectory())) {
                    // Create Property in collection_events file
                    if (xcsFile.getName().equals("collection_events.xsc")) {
                        createProperty(project, xcsFile.getVirtualFile());
                        return;
                    }
                }
            }
        });
    }

    private void createProperty(final Project project, final VirtualFile file) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            ASTNode lastChildNode = null;
            VirtualFile dir = Objects.requireNonNull(PsiManager.getInstance(project).findFile(file)).getContainingDirectory().getParentDirectory().getParentDirectory().getParentDirectory().findSubdirectory("EQS").findSubdirectory("src").findSubdirectory("xsc").getVirtualFile();
            // Create a CEID property
            XCSFile xcsFile = (XCSFile) Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(dir)).findFile("collection_events.xsc");
            ASTNode @NotNull [] children = Objects.requireNonNull(xcsFile).getNode().getChildren(TokenSet.ANY);
            for (ASTNode child : children) {
                if (child.getFirstChildNode() != null) {
                    if (child.getFirstChildNode().getElementType().equals(XCSTypes.COLLECTION_EVENT)) {
                        if (child.getPsi().getChildren()[0].getChildren().length != 0) {
                            lastChildNode = child.getPsi().getChildren()[0].getChildren()[child.getPsi().getChildren()[0].getChildren().length - 1].getNode();
                        } else {
                            return;
                        }
                    }
                }
            }
            if (lastChildNode != null) {
                lastChildNode.addChild(XCSElementFactory.createCRLF(project).getNode());
            }
            XCSElementFactory.createPropertyCe(Objects.requireNonNull(lastChildNode), "VfeiName", "\"" + key + "\"");
            // Move to where the property has been created
            ((Navigatable) Objects.requireNonNull(lastChildNode).getTreeNext().getPsi().getNavigationElement()).navigate(true);
            Objects.requireNonNull(FileEditorManager.getInstance(project).getSelectedTextEditor()).getCaretModel().moveCaretRelatively(2, 0, false, false, false);
        });
    }

}


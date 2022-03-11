package cea.language.sml.quickfix;

import cea.language.sml.psi.SmlElementFactory;
import cea.language.sml.psi.SmlFile;
import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SmlCreateStateQuickFix extends BaseIntentionAction {

    private final String key;
    private final PsiElement element;

    public SmlCreateStateQuickFix(String key, PsiElement element) {
        this.key = key;
        this.element = element;
    }

    @NotNull
    @Override
    public String getText() {
        return "Create state '" + key + "'";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "Create state";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return file instanceof SmlFile;
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws
            IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(() -> createProperty(project));
    }

    private void createProperty(final Project project) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            ASTNode lastChildNode;
            // Create an alias
            lastChildNode = element.getNode();
            while (lastChildNode.getTreeParent() != null) {
                lastChildNode = lastChildNode.getTreeParent();
            }
            lastChildNode.addChild(SmlElementFactory.createCRLF(project).getNode());
            lastChildNode.addChild(SmlElementFactory.createCRLF(project).getNode());
            lastChildNode.addChild(SmlElementFactory.createStateBlock(key, project).getNode());
            // Move to where the property has been created
            ((Navigatable) lastChildNode.getLastChildNode().getPsi().getNavigationElement()).navigate(true);
            Objects.requireNonNull(FileEditorManager.getInstance(project).getSelectedTextEditor()).getCaretModel().moveCaretRelatively(2, 0, false, false, false);
        });
    }

}


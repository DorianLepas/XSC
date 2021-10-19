package cea.language.xsc.reference;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import cea.language.xsc.psi.XCSProperty_;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class XCSRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
        return (elementToRename instanceof XCSProperty_);
    }

}

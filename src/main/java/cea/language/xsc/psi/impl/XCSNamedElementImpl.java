package cea.language.xsc.psi.impl;

import cea.language.xsc.psi.XCSNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class XCSNamedElementImpl extends ASTWrapperPsiElement implements XCSNamedElement {

    public XCSNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}

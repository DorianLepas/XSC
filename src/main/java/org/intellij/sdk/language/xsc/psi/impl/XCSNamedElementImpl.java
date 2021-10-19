package org.intellij.sdk.language.xsc.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.xsc.psi.XCSNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class XCSNamedElementImpl extends ASTWrapperPsiElement implements XCSNamedElement {

    public XCSNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}

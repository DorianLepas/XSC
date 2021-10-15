// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.xsc.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.xsc.psi.XCSTypes.*;
import org.intellij.sdk.language.xsc.psi.*;
import com.intellij.psi.PsiReference;

public class XCSProperty_Impl extends XCSNamedElementImpl implements XCSProperty_ {

  public XCSProperty_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XCSVisitor visitor) {
    visitor.visitProperty_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XCSVisitor) accept((XCSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getProp() {
    return XCSPsiImplUtil.getProp(this);
  }

  @Override
  public String getValue() {
    return XCSPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return XCSPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return XCSPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return XCSPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public PsiReference getReference() {
    return XCSPsiImplUtil.getReference(this);
  }

  @Override
  public String getReferenceType() {
    return XCSPsiImplUtil.getReferenceType(this);
  }

}

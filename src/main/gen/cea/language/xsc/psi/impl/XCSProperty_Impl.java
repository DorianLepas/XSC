// This is a generated file. Not intended for manual editing.
package cea.language.xsc.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import cea.language.xsc.psi.*;

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
  public PsiElement setName(@NotNull String newName) {
    return XCSPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return XCSPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public String getReferenceType() {
    return XCSPsiImplUtil.getReferenceType(this);
  }

}

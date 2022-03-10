// This is a generated file. Not intended for manual editing.
package cea.language.xsc.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static cea.language.xsc.psi.XCSTypes.*;
import cea.language.xsc.psi.*;
import com.intellij.navigation.ItemPresentation;

public class XCSCeProperty_Impl extends XCSNamedElementImpl implements XCSCeProperty_ {

  public XCSCeProperty_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XCSVisitor visitor) {
    visitor.visitCeProperty_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XCSVisitor) accept((XCSVisitor)visitor);
    else super.accept(visitor);
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
  public ItemPresentation getPresentation() {
    return XCSPsiImplUtil.getPresentation(this);
  }

}

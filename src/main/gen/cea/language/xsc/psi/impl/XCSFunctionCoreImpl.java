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

public class XCSFunctionCoreImpl extends XCSNamedElementImpl implements XCSFunctionCore {

  public XCSFunctionCoreImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull XCSVisitor visitor) {
    visitor.visitFunctionCore(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof XCSVisitor) accept((XCSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<XCSFunctionCore> getFunctionCoreList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, XCSFunctionCore.class);
  }

  @Override
  @Nullable
  public XCSProperty getProperty() {
    return findChildByClass(XCSProperty.class);
  }

  @Override
  public String getFunctionName() {
    return XCSPsiImplUtil.getFunctionName(this);
  }

  @Override
  public String getSF() {
    return XCSPsiImplUtil.getSF(this);
  }

  @Override
  public int getDepth() {
    return XCSPsiImplUtil.getDepth(this);
  }

  @Override
  public int getCommentSize() {
    return XCSPsiImplUtil.getCommentSize(this);
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

// This is a generated file. Not intended for manual editing.
package cea.language.sml.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static cea.language.sml.psi.SmlTypes.*;
import cea.language.sml.psi.*;
import com.intellij.navigation.ItemPresentation;

public class SmlAliasBlockImpl extends SmlNamedElementImpl implements SmlAliasBlock {

  public SmlAliasBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmlVisitor visitor) {
    visitor.visitAliasBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmlVisitor) accept((SmlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return SmlPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return SmlPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return SmlPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return SmlPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return SmlPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return SmlPsiImplUtil.getPresentation(this);
  }

}

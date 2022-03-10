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

public class SmlStateBlockImpl extends SmlNamedElementImpl implements SmlStateBlock {

  public SmlStateBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmlVisitor visitor) {
    visitor.visitStateBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmlVisitor) accept((SmlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SmlAlarmBlock> getAlarmBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlAlarmBlock.class);
  }

  @Override
  @NotNull
  public List<SmlAliasBlock> getAliasBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlAliasBlock.class);
  }

  @Override
  @NotNull
  public List<SmlEnterBlock> getEnterBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlEnterBlock.class);
  }

  @Override
  @NotNull
  public List<SmlEventBlock> getEventBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlEventBlock.class);
  }

  @Override
  @NotNull
  public List<SmlExitBlock> getExitBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlExitBlock.class);
  }

  @Override
  @NotNull
  public List<SmlOptionsBlock> getOptionsBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlOptionsBlock.class);
  }

  @Override
  @NotNull
  public List<SmlStateBlock> getStateBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlStateBlock.class);
  }

  @Override
  @Nullable
  public SmlStateNames getStateNames() {
    return findChildByClass(SmlStateNames.class);
  }

  @Override
  @NotNull
  public List<SmlTraceBlock> getTraceBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlTraceBlock.class);
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

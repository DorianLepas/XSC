// This is a generated file. Not intended for manual editing.
package cea.language.sml.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static cea.language.sml.psi.SmlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import cea.language.sml.psi.*;

public class SmlStateBlockImpl extends ASTWrapperPsiElement implements SmlStateBlock {

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
  @NotNull
  public List<SmlTraceBlock> getTraceBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlTraceBlock.class);
  }

}

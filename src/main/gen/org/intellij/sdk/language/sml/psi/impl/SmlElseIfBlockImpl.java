// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.sml.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.sml.psi.SmlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.sml.psi.*;

public class SmlElseIfBlockImpl extends ASTWrapperPsiElement implements SmlElseIfBlock {

  public SmlElseIfBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmlVisitor visitor) {
    visitor.visitElseIfBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmlVisitor) accept((SmlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SmlCallJavaFunctionInstruction> getCallJavaFunctionInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlCallJavaFunctionInstruction.class);
  }

  @Override
  @NotNull
  public List<SmlConditionBlock> getConditionBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlConditionBlock.class);
  }

  @Override
  @NotNull
  public List<SmlConsumeEventInstruction> getConsumeEventInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlConsumeEventInstruction.class);
  }

  @Override
  @NotNull
  public List<SmlElseBlock> getElseBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlElseBlock.class);
  }

  @Override
  @NotNull
  public List<SmlElseIfBlock> getElseIfBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlElseIfBlock.class);
  }

  @Override
  @NotNull
  public List<SmlExecEndInstruction> getExecEndInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlExecEndInstruction.class);
  }

  @Override
  @NotNull
  public List<SmlGotoStateInstruction> getGotoStateInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlGotoStateInstruction.class);
  }

  @Override
  @NotNull
  public List<SmlIfBlock> getIfBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlIfBlock.class);
  }

  @Override
  @Nullable
  public SmlIfConditions getIfConditions() {
    return findChildByClass(SmlIfConditions.class);
  }

  @Override
  @NotNull
  public List<SmlProcessStateInstruction> getProcessStateInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlProcessStateInstruction.class);
  }

  @Override
  @NotNull
  public List<SmlScriptBlock> getScriptBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlScriptBlock.class);
  }

  @Override
  @NotNull
  public List<SmlThreadEndInstruction> getThreadEndInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlThreadEndInstruction.class);
  }

  @Override
  @NotNull
  public List<SmlThreadStateInstruction> getThreadStateInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlThreadStateInstruction.class);
  }

  @Override
  @NotNull
  public List<SmlTraceInstruction> getTraceInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmlTraceInstruction.class);
  }

}

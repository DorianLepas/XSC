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

public class SmlTraceInstructionImpl extends ASTWrapperPsiElement implements SmlTraceInstruction {

  public SmlTraceInstructionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmlVisitor visitor) {
    visitor.visitTraceInstruction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmlVisitor) accept((SmlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmlTraceMessage getTraceMessage() {
    return findChildByClass(SmlTraceMessage.class);
  }

}

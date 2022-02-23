// This is a generated file. Not intended for manual editing.
package cea.language.sml.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmlElseBlock extends PsiElement {

  @NotNull
  List<SmlCallJavaFunctionInstruction> getCallJavaFunctionInstructionList();

  @NotNull
  List<SmlConditionBlock> getConditionBlockList();

  @NotNull
  List<SmlConsumeEventInstruction> getConsumeEventInstructionList();

  @NotNull
  List<SmlElseBlock> getElseBlockList();

  @NotNull
  List<SmlElseIfBlock> getElseIfBlockList();

  @NotNull
  List<SmlExecEndInstruction> getExecEndInstructionList();

  @NotNull
  List<SmlGotoStateInstruction> getGotoStateInstructionList();

  @NotNull
  List<SmlIfBlock> getIfBlockList();

  @NotNull
  List<SmlProcessStateInstruction> getProcessStateInstructionList();

  @NotNull
  List<SmlScriptBlock> getScriptBlockList();

  @NotNull
  List<SmlSetInstruction> getSetInstructionList();

  @NotNull
  List<SmlThreadEndInstruction> getThreadEndInstructionList();

  @NotNull
  List<SmlThreadStateInstruction> getThreadStateInstructionList();

  @NotNull
  List<SmlTraceInstruction> getTraceInstructionList();

}

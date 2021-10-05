// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.sml.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmlStateBlock extends PsiElement {

  @NotNull
  List<SmlAlarmBlock> getAlarmBlockList();

  @NotNull
  List<SmlAliasBlock> getAliasBlockList();

  @NotNull
  List<SmlEnterBlock> getEnterBlockList();

  @NotNull
  List<SmlEventBlock> getEventBlockList();

  @NotNull
  List<SmlExitBlock> getExitBlockList();

  @NotNull
  List<SmlOptionsBlock> getOptionsBlockList();

  @NotNull
  List<SmlStateBlock> getStateBlockList();

  @NotNull
  List<SmlTraceBlock> getTraceBlockList();

}

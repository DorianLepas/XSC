// This is a generated file. Not intended for manual editing.
package cea.language.sml.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface SmlStateBlock extends SmlNamedElement {

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

  @Nullable
  SmlStateNames getStateNames();

  @NotNull
  List<SmlTraceBlock> getTraceBlockList();

  String getKey();

  String getValue();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}

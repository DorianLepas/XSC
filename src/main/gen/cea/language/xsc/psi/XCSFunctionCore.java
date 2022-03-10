// This is a generated file. Not intended for manual editing.
package cea.language.xsc.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface XCSFunctionCore extends XCSNamedElement {

  @NotNull
  List<XCSFunctionCore> getFunctionCoreList();

  @Nullable
  XCSProperty getProperty();

  String getFunctionName();

  String getSF();

  int getDepth();

  int getCommentSize();

  String getValue();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}

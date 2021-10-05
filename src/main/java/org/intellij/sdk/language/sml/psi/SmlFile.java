package org.intellij.sdk.language.sml.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.intellij.sdk.language.sml.fileType.SmlFileType;
import org.intellij.sdk.language.sml.fileType.SmlLanguage;
import org.jetbrains.annotations.NotNull;

public class SmlFile extends PsiFileBase
{
  // Inner classes

  // Instance fields

  // Static code

  // Constructors
  public SmlFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, SmlLanguage.INSTANCE);
  }

  // Methods
  @NotNull
  @Override
  public FileType getFileType() {
    return SmlFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Sml File";
  }
}

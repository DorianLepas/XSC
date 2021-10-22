package cea.language.sml.psi;

import cea.language.sml.fileType.SmlFileType;
import cea.language.sml.fileType.SmlLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
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

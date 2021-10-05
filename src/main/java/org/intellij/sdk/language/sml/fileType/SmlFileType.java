package org.intellij.sdk.language.sml.fileType;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

public class SmlFileType extends LanguageFileType
{
  // Inner classes

  // Instance fields
  public static final SmlFileType INSTANCE = new SmlFileType();

  // Static code

  // Constructors
  private SmlFileType()
  {
    super(SmlLanguage.INSTANCE);
  }

  // Methods
  @NotNull
  @Override
  public String getName() {
    return "Sml ";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "State machine language";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "sml";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return SmlIcons.FILE;
  }
}

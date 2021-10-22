package cea.language.sml.psi;

import cea.language.sml.fileType.SmlLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;

import javax.annotation.Nonnull;

public class SmlTokenType extends IElementType
{
  // Inner classes

  // Instance fields

  // Static code

  // Constructors
  public SmlTokenType(@Nonnull @NonNls String debugName)
  {
    super(debugName, SmlLanguage.INSTANCE);
  }

  // Methods
  @Override
  public String toString()
  {
    return "SmlTokenType" + super.toString();
  }
}

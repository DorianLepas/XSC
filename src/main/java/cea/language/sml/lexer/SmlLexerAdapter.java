package cea.language.sml.lexer;

import cea.language.sml.SmlLexer;
import com.intellij.lexer.FlexAdapter;

public class SmlLexerAdapter extends FlexAdapter
{
  // Inner classes

  // Instance fields

  // Static code

  // Constructors
  public SmlLexerAdapter() {
    super(new SmlLexer(null));
  }

  // Methods
}

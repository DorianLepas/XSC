package org.intellij.sdk.language.sml.lexer;

import com.intellij.lexer.FlexAdapter;
import org.intellij.sdk.language.sml.SmlLexer;

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

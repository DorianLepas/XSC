package cea.language.sml.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import cea.language.sml.lexer.SmlLexerAdapter;
import cea.language.sml.psi.SmlTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SmlSyntaxHighlighter extends SyntaxHighlighterBase
{
  // Inner classes

  // Instance fields
  public static final TextAttributesKey COMMENT =
          createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey KEYWORDS =
          createTextAttributesKey("KEYWORDS", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey STATE_NAMES =
          createTextAttributesKey("STATE_NAMES", DefaultLanguageHighlighterColors.CLASS_NAME);
  public static final TextAttributesKey EVENT_DEFINITIONS =
          createTextAttributesKey("EVENT_DEFINITIONS", DefaultLanguageHighlighterColors.IDENTIFIER);
  public static final TextAttributesKey VARIABLES =
          createTextAttributesKey("VARIABLES", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
  public static final TextAttributesKey TRACE_MESSAGES =
          createTextAttributesKey("TRACE_MESSAGES", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey CONDITION_CONSTANTES =
          createTextAttributesKey("CONDITION_CONSTANTES", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey BAD_CHARACTER =
          createTextAttributesKey("_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
  public static final TextAttributesKey JAVASCRIPT_CODE =
          createTextAttributesKey("JAVASCRIPT_CODE", HighlighterColors.TEXT);
  public static final TextAttributesKey JAVA_FUNCTION =
          createTextAttributesKey("JAVA_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_CALL);


  private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
  private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
  private static final TextAttributesKey[] KEYWORDS_KEYS = new TextAttributesKey[]{KEYWORDS};
  private static final TextAttributesKey[] STATE_NAME_KEYS = new TextAttributesKey[]{STATE_NAMES};
  private static final TextAttributesKey[] EVENTS_DEFINITION_KEYS = new TextAttributesKey[]{EVENT_DEFINITIONS};
  private static final TextAttributesKey[] VARIABLES_KEYS = new TextAttributesKey[]{VARIABLES};
  private static final TextAttributesKey[] TRACE_MESSAGES_KEYS = new TextAttributesKey[]{TRACE_MESSAGES};
  private static final TextAttributesKey[] CONDITIONS_CONSTANTES_KEYS = new TextAttributesKey[]{CONDITION_CONSTANTES};
  private static final TextAttributesKey[] JAVASCRIPT_CODE_KEYS = new TextAttributesKey[]{JAVASCRIPT_CODE};
  private static final TextAttributesKey[] JAVA_FUNCTION_KEYS = new TextAttributesKey[]{JAVA_FUNCTION};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  // Static code

  // Constructors

  // Methods
  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new SmlLexerAdapter();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
    /* Commentaires */
    if (tokenType.equals(SmlTypes.COMMENT)) {
      return COMMENT_KEYS;
    }
    /* Mots clés */
    else if (tokenType.equals(SmlTypes.STATE)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.ALIAS)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.EVENT)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.ALARM)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.TRACE)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.SCRIPT)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.BINDING)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.ENTER)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.EXIT)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.OPTION)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.GOTO_STATE)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.CALL)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.MESSAGE)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.WARNING)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.WAIT)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.DEBUG)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.THREAD_STATE)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.THREAD_END)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.EXEC_END)) {
      return KEYWORDS_KEYS;
    }  else if (tokenType.equals(SmlTypes.PROCESS_STATE)) {
      return KEYWORDS_KEYS;
    }  else if (tokenType.equals(SmlTypes.CONSUME_EVENT)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.IF)) {
      return KEYWORDS_KEYS;
    } else if (tokenType.equals(SmlTypes.ELSE_IF)) {
      return KEYWORDS_KEYS;
    }  else if (tokenType.equals(SmlTypes.ELSE)) {
      return KEYWORDS_KEYS;
    }  else if (tokenType.equals(SmlTypes.CONDITION)) {
      return KEYWORDS_KEYS;
    }  else if (tokenType.equals(SmlTypes.SET)) {
      return KEYWORDS_KEYS;
    }
    /* Noms d'états */
    else if(tokenType.equals(SmlTypes.STATE_NAME)) {
      return STATE_NAME_KEYS;
    }
    /* Définitions d'événements et noms d'événements */
    else if(tokenType.equals(SmlTypes.ALL_EVENTS)) {
      return EVENTS_DEFINITION_KEYS;
    } else if(tokenType.equals(SmlTypes.EVENT_NAME)) {
      return EVENTS_DEFINITION_KEYS;
    }
    /* Variables du sml */
    else if(tokenType.equals(SmlTypes.SML_VARS)) {
      return VARIABLES_KEYS;
    }
    /* Constantes dans les conditions */
    else if(tokenType.equals(SmlTypes.CONST_CONDS)) {
      return CONDITIONS_CONSTANTES_KEYS;
    }
    /* Chaines de caractères dans les messages de traces */
    else if(tokenType.equals(SmlTypes.TRACE_MESSAGE_STRING)) {
      return TRACE_MESSAGES_KEYS;
    }
    /* Code javascript */
    else if(tokenType.equals(SmlTypes.JAVASCRIPT_CODE)) {
      return JAVASCRIPT_CODE_KEYS;
    }
    else if(tokenType.equals(SmlTypes.JAVA_FUNCTION_CALL)) {
      return JAVA_FUNCTION_KEYS;
    }
    /* Mauvais caractères */
   else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
      return BAD_CHAR_KEYS;
    } else {
      return EMPTY_KEYS;
    }
  }
}

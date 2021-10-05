package org.intellij.sdk.language.sml.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.intellij.sdk.language.sml.fileType.SmlLanguage;
import org.intellij.sdk.language.sml.lexer.SmlLexerAdapter;
import org.intellij.sdk.language.sml.psi.SmlFile;
import org.intellij.sdk.language.sml.psi.SmlTypes;
import org.jetbrains.annotations.NotNull;

public class SmlParserDefinition implements ParserDefinition
{
  // Inner classes

  // Instance fields
  public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE, SmlTypes.LINE_END);
  public static final TokenSet COMMENTS = TokenSet.create(SmlTypes.COMMENT);
  public static final TokenSet BLOCK_DELIMITERS = TokenSet.create(SmlTypes.BEGIN_BLOCK, SmlTypes.END_BLOCK);
  public static final TokenSet BLOCKS = TokenSet.create(SmlTypes.STATE_BLOCK,
          SmlTypes.ALIAS_BLOCK,
          SmlTypes.ALARM_BLOCK,
          SmlTypes.EVENT_BLOCK,
          SmlTypes.TRACE_BLOCK,
          SmlTypes.SCRIPT_BLOCK,
          SmlTypes.ENTER_BLOCK,
          SmlTypes.EXIT_BLOCK,
          SmlTypes.OPTIONS_BLOCK);
  public static final TokenSet INSTRUCTIONS = TokenSet.create(SmlTypes.CALL_JAVA_FUNCTION_INSTRUCTION,
          SmlTypes.CONSUME_EVENT_INSTRUCTION,
          SmlTypes.EXEC_END_INSTRUCTION,
          SmlTypes.GOTO_STATE_INSTRUCTION,
          SmlTypes.TRACE_INSTRUCTION,
          SmlTypes.PROCESS_STATE_INSTRUCTION,
          SmlTypes.THREAD_STATE_INSTRUCTION,
          SmlTypes.THREAD_END_INSTRUCTION);

  public static final IFileElementType FILE = new IFileElementType(SmlLanguage.INSTANCE);

  // Static code

  // Constructors

  // Methods
  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new SmlLexerAdapter();
  }

  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return WHITE_SPACES;
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }

  @NotNull
  @Override
  public PsiParser createParser(final Project project) {
    return new SmlParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @Override
  public PsiFile createFile(FileViewProvider viewProvider) {
    return new SmlFile(viewProvider);
  }

  @Override
  public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return SmlTypes.Factory.createElement(node);
  }
}

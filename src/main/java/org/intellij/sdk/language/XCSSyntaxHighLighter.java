package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.XCSTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class XCSSyntaxHighLighter extends SyntaxHighlighterBase {
    //STRUCTURE
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("XCS_LINE_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey FUNCTION_COMMENT =
            createTextAttributesKey("XCS_FUNCTION_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey FUNCTION_NAME =
            createTextAttributesKey("XCS_FUNCTION_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey SECTION_STANDART =
            createTextAttributesKey("XCS_SECTION_STANDART", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COLON =
            createTextAttributesKey("XCS_COLON", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey STREAM_FUNCTION =
            createTextAttributesKey("XCS_STREAM_FUNCTION", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey CORE_START_END =
            createTextAttributesKey("XCS_CORE_START_END", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey FUNCTION_END =
            createTextAttributesKey("XCS_FUNCTION_END", DefaultLanguageHighlighterColors.DOT);

    //PROPERTY
    public static final TextAttributesKey PROPERTY_START_END =
            createTextAttributesKey("XCS_PROPERTY_START_END", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey PROPERTY_NAME =
            createTextAttributesKey("XCS_PROPERTY_NAME", DefaultLanguageHighlighterColors.INTERFACE_NAME);
    public static final TextAttributesKey PROPERTY_EQUALS =
            createTextAttributesKey("XCS_PROPERTY_EQUALS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey PROPERTY_VALUE =
            createTextAttributesKey("XCS_PROPERTY_VALUE", DefaultLanguageHighlighterColors.STRING);

    //TYPE
    public static final TextAttributesKey VARIABLE_TYPE =
            createTextAttributesKey("XCS_VARIABLE_TYPE", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey VARIABLE_NAME =
            createTextAttributesKey("XCS_VARIABLE_NAME", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey VARIABLE_VALUE =
            createTextAttributesKey("XCS_VARIABLE_VALUE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey NAMES =
            createTextAttributesKey("XCS_NAMES", DefaultLanguageHighlighterColors.HIGHLIGHTED_REFERENCE);


    private static final TextAttributesKey[] COLON_KEYS = new TextAttributesKey[]{COLON};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] CORE_START_END_KEYS = new TextAttributesKey[]{CORE_START_END};
    private static final TextAttributesKey[] FUNCTION_COMMENT_KEYS = new TextAttributesKey[]{FUNCTION_COMMENT};
    private static final TextAttributesKey[] FUNCTION_END_KEYS = new TextAttributesKey[]{FUNCTION_END};
    private static final TextAttributesKey[] FUNCTION_NAME_KEYS = new TextAttributesKey[]{FUNCTION_NAME};
    private static final TextAttributesKey[] NAMES_KEYS = new TextAttributesKey[]{NAMES};
    private static final TextAttributesKey[] PROPERTY_EQUALS_KEYS = new TextAttributesKey[]{PROPERTY_EQUALS};
    private static final TextAttributesKey[] PROPERTY_NAME_KEYS = new TextAttributesKey[]{PROPERTY_NAME};
    private static final TextAttributesKey[] PROPERTY_START_END_KEYS = new TextAttributesKey[]{PROPERTY_START_END};
    private static final TextAttributesKey[] PROPERTY_VALUE_KEYS = new TextAttributesKey[]{PROPERTY_VALUE};
    private static final TextAttributesKey[] SECTION_STANDART_KEYS = new TextAttributesKey[]{SECTION_STANDART};
    private static final TextAttributesKey[] STREAM_FUNCTION_KEYS = new TextAttributesKey[]{STREAM_FUNCTION};
    private static final TextAttributesKey[] VARIABLE_NAME_KEYS = new TextAttributesKey[]{VARIABLE_NAME};
    private static final TextAttributesKey[] VARIABLE_TYPE_KEYS = new TextAttributesKey[]{VARIABLE_TYPE};
    private static final TextAttributesKey[] VARIABLE_VALUE_KEYS = new TextAttributesKey[]{VARIABLE_VALUE};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new XCSLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(XCSTypes.ASCII_TYPE)) {
            return VARIABLE_TYPE_KEYS;
        } else if (tokenType.equals(XCSTypes.ASCII_VALUE)) {
            return VARIABLE_VALUE_KEYS;
        } else if (tokenType.equals(XCSTypes.COLON))  {
            return COLON_KEYS;
        } else if (tokenType.equals(XCSTypes.COLLECTION_EVENT))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.DATA_VARIABLE))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.EQUIPMENT_CONSTANT))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.EVENTS))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.SCENARIOS))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.STANDART_SECTION))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.STATUS_VARIABLE))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.SECS_ITEM_TYPE))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.VFEI_SECS_SEQ))  {
            return SECTION_STANDART_KEYS;
        } else if (tokenType.equals(XCSTypes.COMMENT))  {
            return COMMENT_KEYS;
        } else if (tokenType.equals(XCSTypes.CORE_START))  {
            return CORE_START_END_KEYS;
        } else if (tokenType.equals(XCSTypes.CORE_END))  {
            return CORE_START_END_KEYS;
        } else if (tokenType.equals(XCSTypes.EQUALS))  {
            return PROPERTY_EQUALS_KEYS;
        } else if (tokenType.equals(XCSTypes.FUNCTION_COMMENT))  {
            return FUNCTION_COMMENT_KEYS;
        } else if (tokenType.equals(XCSTypes.FUNCTION_END))  {
            return FUNCTION_END_KEYS;
        } else if (tokenType.equals(XCSTypes.FUNCTION_NAME))  {
            return FUNCTION_NAME_KEYS;
        } else if (tokenType.equals(XCSTypes.LIST_TYPE))  {
            return VARIABLE_TYPE_KEYS;
        } else if (tokenType.equals(XCSTypes.PROPERTY_START))  {
            return PROPERTY_START_END_KEYS;
        } else if (tokenType.equals(XCSTypes.PROPERTY_END))  {
            return PROPERTY_START_END_KEYS;
        } else if (tokenType.equals(XCSTypes.PROPERTY_NAME))  {
            return PROPERTY_NAME_KEYS;
        } else if (tokenType.equals(XCSTypes.PROPERTY_NAME_CE))  {
            return PROPERTY_NAME_KEYS;
        } else if (tokenType.equals(XCSTypes.PROPERTY_VALUE))  {
            return PROPERTY_VALUE_KEYS;
        } else if (tokenType.equals(XCSTypes.STREAM_FUNCTION))  {
            return STREAM_FUNCTION_KEYS;
        } else if (tokenType.equals(XCSTypes.VARIABLE_NAME))  {
            return VARIABLE_NAME_KEYS;
        } else if (tokenType.equals(XCSTypes.VARIABLE_TYPE))  {
            return VARIABLE_TYPE_KEYS;
        } else if (tokenType.equals(XCSTypes.VARIABLE_VALUE))  {
            return VARIABLE_VALUE_KEYS;
        } else if (tokenType.equals(XCSTypes.CEID))  {
            return NAMES_KEYS;
        } else if (tokenType.equals(XCSTypes.DVID))  {
            return NAMES_KEYS;
        } else if (tokenType.equals(XCSTypes.ECID))  {
            return NAMES_KEYS;
        } else if (tokenType.equals(XCSTypes.SVID))  {
            return NAMES_KEYS;
        } else if (tokenType.equals(XCSTypes.VFEI_CMD_ITEM_NAME))  {
            return NAMES_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

}

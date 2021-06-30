// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.sdk.language.psi.XCSTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class XCSParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return xsc_file(b, l + 1);
  }

  /* ********************************************************** */
  // (CORE_START ASCII_TYPE [CEID] [CE_PROPERTY] ASCII_VALUE CORE_END [FUNCTION_COMMENT]) |
  //             (CORE_START VARIABLE_TYPE [CEID] [CE_PROPERTY] VARIABLE_VALUE CORE_END [FUNCTION_COMMENT])
  public static boolean CE_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CE_CORE_0(b, l + 1);
    if (!r) r = CE_CORE_1(b, l + 1);
    exit_section_(b, m, CE_CORE, r);
    return r;
  }

  // CORE_START ASCII_TYPE [CEID] [CE_PROPERTY] ASCII_VALUE CORE_END [FUNCTION_COMMENT]
  private static boolean CE_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && CE_CORE_0_2(b, l + 1);
    r = r && CE_CORE_0_3(b, l + 1);
    r = r && consumeTokens(b, 0, ASCII_VALUE, CORE_END);
    r = r && CE_CORE_0_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [CEID]
  private static boolean CE_CORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_0_2")) return false;
    consumeToken(b, CEID);
    return true;
  }

  // [CE_PROPERTY]
  private static boolean CE_CORE_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_0_3")) return false;
    CE_PROPERTY(b, l + 1);
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean CE_CORE_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_0_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START VARIABLE_TYPE [CEID] [CE_PROPERTY] VARIABLE_VALUE CORE_END [FUNCTION_COMMENT]
  private static boolean CE_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, VARIABLE_TYPE);
    r = r && CE_CORE_1_2(b, l + 1);
    r = r && CE_CORE_1_3(b, l + 1);
    r = r && consumeTokens(b, 0, VARIABLE_VALUE, CORE_END);
    r = r && CE_CORE_1_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [CEID]
  private static boolean CE_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_1_2")) return false;
    consumeToken(b, CEID);
    return true;
  }

  // [CE_PROPERTY]
  private static boolean CE_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_1_3")) return false;
    CE_PROPERTY(b, l + 1);
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean CE_CORE_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_1_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE CE_CORE* CORE_END [FUNCTION_COMMENT]
  public static boolean CE_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_LIST")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && CE_LIST_2(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && CE_LIST_4(b, l + 1);
    exit_section_(b, m, CE_LIST, r);
    return r;
  }

  // CE_CORE*
  private static boolean CE_LIST_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_LIST_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CE_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CE_LIST_2", c)) break;
    }
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean CE_LIST_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_LIST_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // PROPERTY_START CE_PROPERTY_+ PROPERTY_END
  public static boolean CE_PROPERTY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_PROPERTY")) return false;
    if (!nextTokenIs(b, PROPERTY_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY_START);
    r = r && CE_PROPERTY_1(b, l + 1);
    r = r && consumeToken(b, PROPERTY_END);
    exit_section_(b, m, CE_PROPERTY, r);
    return r;
  }

  // CE_PROPERTY_+
  private static boolean CE_PROPERTY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_PROPERTY_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CE_PROPERTY_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!CE_PROPERTY_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CE_PROPERTY_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROPERTY_NAME_CE EQUALS PROPERTY_VALUE
  public static boolean CE_PROPERTY_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_PROPERTY_")) return false;
    if (!nextTokenIs(b, PROPERTY_NAME_CE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPERTY_NAME_CE, EQUALS, PROPERTY_VALUE);
    exit_section_(b, m, CE_PROPERTY_, r);
    return r;
  }

  /* ********************************************************** */
  // (CORE_START VARIABLE_TYPE [VARIABLE_NAME] [PROPERTY] [VARIABLE_VALUE] CORE_END [FUNCTION_COMMENT]) |
  //                   (CORE_START ASCII_TYPE [VARIABLE_NAME] [PROPERTY] [ASCII_VALUE] CORE_END [FUNCTION_COMMENT]) |
  //                   (CORE_START LIST_TYPE [VARIABLE_NAME] FUNCTION_CORE* CORE_END [FUNCTION_COMMENT]) |
  public static boolean FUNCTION_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CORE, "<function core>");
    r = FUNCTION_CORE_0(b, l + 1);
    if (!r) r = FUNCTION_CORE_1(b, l + 1);
    if (!r) r = FUNCTION_CORE_2(b, l + 1);
    if (!r) r = consumeToken(b, FUNCTION_CORE_3_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CORE_START VARIABLE_TYPE [VARIABLE_NAME] [PROPERTY] [VARIABLE_VALUE] CORE_END [FUNCTION_COMMENT]
  private static boolean FUNCTION_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, VARIABLE_TYPE);
    r = r && FUNCTION_CORE_0_2(b, l + 1);
    r = r && FUNCTION_CORE_0_3(b, l + 1);
    r = r && FUNCTION_CORE_0_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && FUNCTION_CORE_0_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [VARIABLE_NAME]
  private static boolean FUNCTION_CORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // [PROPERTY]
  private static boolean FUNCTION_CORE_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0_3")) return false;
    PROPERTY(b, l + 1);
    return true;
  }

  // [VARIABLE_VALUE]
  private static boolean FUNCTION_CORE_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0_4")) return false;
    consumeToken(b, VARIABLE_VALUE);
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean FUNCTION_CORE_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START ASCII_TYPE [VARIABLE_NAME] [PROPERTY] [ASCII_VALUE] CORE_END [FUNCTION_COMMENT]
  private static boolean FUNCTION_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && FUNCTION_CORE_1_2(b, l + 1);
    r = r && FUNCTION_CORE_1_3(b, l + 1);
    r = r && FUNCTION_CORE_1_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && FUNCTION_CORE_1_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [VARIABLE_NAME]
  private static boolean FUNCTION_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // [PROPERTY]
  private static boolean FUNCTION_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1_3")) return false;
    PROPERTY(b, l + 1);
    return true;
  }

  // [ASCII_VALUE]
  private static boolean FUNCTION_CORE_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1_4")) return false;
    consumeToken(b, ASCII_VALUE);
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean FUNCTION_CORE_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START LIST_TYPE [VARIABLE_NAME] FUNCTION_CORE* CORE_END [FUNCTION_COMMENT]
  private static boolean FUNCTION_CORE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && FUNCTION_CORE_2_2(b, l + 1);
    r = r && FUNCTION_CORE_2_3(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && FUNCTION_CORE_2_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [VARIABLE_NAME]
  private static boolean FUNCTION_CORE_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // FUNCTION_CORE*
  private static boolean FUNCTION_CORE_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FUNCTION_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FUNCTION_CORE_2_3", c)) break;
    }
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean FUNCTION_CORE_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // PROPERTY_START PROPERTY_+ PROPERTY_END
  public static boolean PROPERTY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PROPERTY")) return false;
    if (!nextTokenIs(b, PROPERTY_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY_START);
    r = r && PROPERTY_1(b, l + 1);
    r = r && consumeToken(b, PROPERTY_END);
    exit_section_(b, m, PROPERTY, r);
    return r;
  }

  // PROPERTY_+
  private static boolean PROPERTY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PROPERTY_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PROPERTY_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!PROPERTY_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PROPERTY_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROPERTY_NAME EQUALS PROPERTY_VALUE
  public static boolean PROPERTY_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PROPERTY_")) return false;
    if (!nextTokenIs(b, PROPERTY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPERTY_NAME, EQUALS, PROPERTY_VALUE);
    exit_section_(b, m, PROPERTY_, r);
    return r;
  }

  /* ********************************************************** */
  // CORE_START ASCII_TYPE [VSS_PROPERTY] ASCII_VALUE CORE_END [FUNCTION_COMMENT]
  public static boolean VSS_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && VSS_CORE_2(b, l + 1);
    r = r && consumeTokens(b, 0, ASCII_VALUE, CORE_END);
    r = r && VSS_CORE_5(b, l + 1);
    exit_section_(b, m, VSS_CORE, r);
    return r;
  }

  // [VSS_PROPERTY]
  private static boolean VSS_CORE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_2")) return false;
    VSS_PROPERTY(b, l + 1);
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean VSS_CORE_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE VSS_LIST_2 CORE_END [FUNCTION_COMMENT]
  public static boolean VSS_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_LIST")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && VSS_LIST_2(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && VSS_LIST_4(b, l + 1);
    exit_section_(b, m, VSS_LIST, r);
    return r;
  }

  // [FUNCTION_COMMENT]
  private static boolean VSS_LIST_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_LIST_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE VFEI_CMD_ITEM_NAME VSS_CORE* CORE_END [FUNCTION_COMMENT]
  public static boolean VSS_LIST_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_LIST_2")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE, VFEI_CMD_ITEM_NAME);
    r = r && VSS_LIST_2_3(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && VSS_LIST_2_5(b, l + 1);
    exit_section_(b, m, VSS_LIST_2, r);
    return r;
  }

  // VSS_CORE*
  private static boolean VSS_LIST_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_LIST_2_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VSS_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VSS_LIST_2_3", c)) break;
    }
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean VSS_LIST_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_LIST_2_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // PROPERTY_START VSS_PROPERTY_+ PROPERTY_END
  public static boolean VSS_PROPERTY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_PROPERTY")) return false;
    if (!nextTokenIs(b, PROPERTY_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY_START);
    r = r && VSS_PROPERTY_1(b, l + 1);
    r = r && consumeToken(b, PROPERTY_END);
    exit_section_(b, m, VSS_PROPERTY, r);
    return r;
  }

  // VSS_PROPERTY_+
  private static boolean VSS_PROPERTY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_PROPERTY_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VSS_PROPERTY_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!VSS_PROPERTY_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VSS_PROPERTY_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROPERTY_NAME_VSS EQUALS PROPERTY_VALUE
  public static boolean VSS_PROPERTY_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_PROPERTY_")) return false;
    if (!nextTokenIs(b, PROPERTY_NAME_VSS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPERTY_NAME_VSS, EQUALS, PROPERTY_VALUE);
    exit_section_(b, m, VSS_PROPERTY_, r);
    return r;
  }

  /* ********************************************************** */
  // COLLECTION_EVENT COLON [FUNCTION_COMMENT] [CE_LIST] FUNCTION_END [FUNCTION_COMMENT]
  public static boolean collection_event_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection_event_section")) return false;
    if (!nextTokenIs(b, COLLECTION_EVENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLLECTION_EVENT, COLON);
    r = r && collection_event_section_2(b, l + 1);
    r = r && collection_event_section_3(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && collection_event_section_5(b, l + 1);
    exit_section_(b, m, COLLECTION_EVENT_SECTION, r);
    return r;
  }

  // [FUNCTION_COMMENT]
  private static boolean collection_event_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection_event_section_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // [CE_LIST]
  private static boolean collection_event_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection_event_section_3")) return false;
    CE_LIST(b, l + 1);
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean collection_event_section_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection_event_section_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // FUNCTION_NAME COLON STREAM_FUNCTION [FUNCTION_COMMENT] FUNCTION_CORE* FUNCTION_END [FUNCTION_COMMENT]
  public static boolean functions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functions")) return false;
    if (!nextTokenIs(b, FUNCTION_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION_NAME, COLON, STREAM_FUNCTION);
    r = r && functions_3(b, l + 1);
    r = r && functions_4(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && functions_6(b, l + 1);
    exit_section_(b, m, FUNCTIONS, r);
    return r;
  }

  // [FUNCTION_COMMENT]
  private static boolean functions_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functions_3")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // FUNCTION_CORE*
  private static boolean functions_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functions_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FUNCTION_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functions_4", c)) break;
    }
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean functions_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functions_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // collection_event_section|vfei_secs_seq_section|functions|COMMENT
  static boolean items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "items")) return false;
    boolean r;
    r = collection_event_section(b, l + 1);
    if (!r) r = vfei_secs_seq_section(b, l + 1);
    if (!r) r = functions(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // VFEI_SECS_SEQ COLON [FUNCTION_COMMENT] [VSS_LIST] FUNCTION_END [FUNCTION_COMMENT]
  public static boolean vfei_secs_seq_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vfei_secs_seq_section")) return false;
    if (!nextTokenIs(b, VFEI_SECS_SEQ)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VFEI_SECS_SEQ, COLON);
    r = r && vfei_secs_seq_section_2(b, l + 1);
    r = r && vfei_secs_seq_section_3(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && vfei_secs_seq_section_5(b, l + 1);
    exit_section_(b, m, VFEI_SECS_SEQ_SECTION, r);
    return r;
  }

  // [FUNCTION_COMMENT]
  private static boolean vfei_secs_seq_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vfei_secs_seq_section_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // [VSS_LIST]
  private static boolean vfei_secs_seq_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vfei_secs_seq_section_3")) return false;
    VSS_LIST(b, l + 1);
    return true;
  }

  // [FUNCTION_COMMENT]
  private static boolean vfei_secs_seq_section_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vfei_secs_seq_section_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // items *
  static boolean xsc_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xsc_file")) return false;
    while (true) {
      int c = current_position_(b);
      if (!items(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xsc_file", c)) break;
    }
    return true;
  }

}

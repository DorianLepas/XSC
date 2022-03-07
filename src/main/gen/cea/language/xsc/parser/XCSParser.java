// This is a generated file. Not intended for manual editing.
package cea.language.xsc.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static cea.language.xsc.psi.XCSTypes.*;
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
  // ASCII_VALUE ASCII_VALUE ASCII_VALUE ASCII_VALUE
  public static boolean ASCII_VALUES_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ASCII_VALUES_4")) return false;
    if (!nextTokenIs(b, ASCII_VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ASCII_VALUE, ASCII_VALUE, ASCII_VALUE, ASCII_VALUE);
    exit_section_(b, m, ASCII_VALUES_4, r);
    return r;
  }

  /* ********************************************************** */
  // ASCII_VALUE ASCII_VALUE ASCII_VALUE ASCII_VALUE ASCII_VALUE
  public static boolean ASCII_VALUES_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ASCII_VALUES_5")) return false;
    if (!nextTokenIs(b, ASCII_VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ASCII_VALUE, ASCII_VALUE, ASCII_VALUE, ASCII_VALUE, ASCII_VALUE);
    exit_section_(b, m, ASCII_VALUES_5, r);
    return r;
  }

  /* ********************************************************** */
  // (CORE_START ASCII_TYPE CEID? CE_PROPERTY? ASCII_VALUE CORE_END FUNCTION_COMMENT?) |
  //             (CORE_START VARIABLE_TYPE CEID? CE_PROPERTY? VARIABLE_VALUE CORE_END FUNCTION_COMMENT?)
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

  // CORE_START ASCII_TYPE CEID? CE_PROPERTY? ASCII_VALUE CORE_END FUNCTION_COMMENT?
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

  // CEID?
  private static boolean CE_CORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_0_2")) return false;
    consumeToken(b, CEID);
    return true;
  }

  // CE_PROPERTY?
  private static boolean CE_CORE_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_0_3")) return false;
    CE_PROPERTY(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean CE_CORE_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_0_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START VARIABLE_TYPE CEID? CE_PROPERTY? VARIABLE_VALUE CORE_END FUNCTION_COMMENT?
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

  // CEID?
  private static boolean CE_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_1_2")) return false;
    consumeToken(b, CEID);
    return true;
  }

  // CE_PROPERTY?
  private static boolean CE_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_1_3")) return false;
    CE_PROPERTY(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean CE_CORE_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CE_CORE_1_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE CE_CORE* CORE_END FUNCTION_COMMENT?
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

  // FUNCTION_COMMENT?
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
  // (CORE_START ASCII_TYPE (DVID|VARIABLE_NAME)? DV_PROPERTY? ASCII_VALUE? CORE_END FUNCTION_COMMENT?) |
  //             (CORE_START LIST_TYPE VARIABLE_NAME? DV_PROPERTY? DV_CORE* CORE_END FUNCTION_COMMENT?) |
  //             (CORE_START VARIABLE_TYPE (DVID|VARIABLE_NAME)? DV_PROPERTY? VARIABLE_VALUE? CORE_END FUNCTION_COMMENT?)
  public static boolean DV_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DV_CORE_0(b, l + 1);
    if (!r) r = DV_CORE_1(b, l + 1);
    if (!r) r = DV_CORE_2(b, l + 1);
    exit_section_(b, m, DV_CORE, r);
    return r;
  }

  // CORE_START ASCII_TYPE (DVID|VARIABLE_NAME)? DV_PROPERTY? ASCII_VALUE? CORE_END FUNCTION_COMMENT?
  private static boolean DV_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && DV_CORE_0_2(b, l + 1);
    r = r && DV_CORE_0_3(b, l + 1);
    r = r && DV_CORE_0_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && DV_CORE_0_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DVID|VARIABLE_NAME)?
  private static boolean DV_CORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_0_2")) return false;
    DV_CORE_0_2_0(b, l + 1);
    return true;
  }

  // DVID|VARIABLE_NAME
  private static boolean DV_CORE_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_0_2_0")) return false;
    boolean r;
    r = consumeToken(b, DVID);
    if (!r) r = consumeToken(b, VARIABLE_NAME);
    return r;
  }

  // DV_PROPERTY?
  private static boolean DV_CORE_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_0_3")) return false;
    DV_PROPERTY(b, l + 1);
    return true;
  }

  // ASCII_VALUE?
  private static boolean DV_CORE_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_0_4")) return false;
    consumeToken(b, ASCII_VALUE);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean DV_CORE_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_0_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START LIST_TYPE VARIABLE_NAME? DV_PROPERTY? DV_CORE* CORE_END FUNCTION_COMMENT?
  private static boolean DV_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && DV_CORE_1_2(b, l + 1);
    r = r && DV_CORE_1_3(b, l + 1);
    r = r && DV_CORE_1_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && DV_CORE_1_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VARIABLE_NAME?
  private static boolean DV_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_1_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // DV_PROPERTY?
  private static boolean DV_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_1_3")) return false;
    DV_PROPERTY(b, l + 1);
    return true;
  }

  // DV_CORE*
  private static boolean DV_CORE_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_1_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DV_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DV_CORE_1_4", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean DV_CORE_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_1_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START VARIABLE_TYPE (DVID|VARIABLE_NAME)? DV_PROPERTY? VARIABLE_VALUE? CORE_END FUNCTION_COMMENT?
  private static boolean DV_CORE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, VARIABLE_TYPE);
    r = r && DV_CORE_2_2(b, l + 1);
    r = r && DV_CORE_2_3(b, l + 1);
    r = r && DV_CORE_2_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && DV_CORE_2_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DVID|VARIABLE_NAME)?
  private static boolean DV_CORE_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_2_2")) return false;
    DV_CORE_2_2_0(b, l + 1);
    return true;
  }

  // DVID|VARIABLE_NAME
  private static boolean DV_CORE_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_2_2_0")) return false;
    boolean r;
    r = consumeToken(b, DVID);
    if (!r) r = consumeToken(b, VARIABLE_NAME);
    return r;
  }

  // DV_PROPERTY?
  private static boolean DV_CORE_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_2_3")) return false;
    DV_PROPERTY(b, l + 1);
    return true;
  }

  // VARIABLE_VALUE?
  private static boolean DV_CORE_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_2_4")) return false;
    consumeToken(b, VARIABLE_VALUE);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean DV_CORE_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_CORE_2_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE DV_CORE* CORE_END FUNCTION_COMMENT?
  public static boolean DV_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_LIST")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && DV_LIST_2(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && DV_LIST_4(b, l + 1);
    exit_section_(b, m, DV_LIST, r);
    return r;
  }

  // DV_CORE*
  private static boolean DV_LIST_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_LIST_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DV_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DV_LIST_2", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean DV_LIST_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_LIST_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // PROPERTY_START DV_PROPERTY_+ PROPERTY_END
  public static boolean DV_PROPERTY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_PROPERTY")) return false;
    if (!nextTokenIs(b, PROPERTY_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY_START);
    r = r && DV_PROPERTY_1(b, l + 1);
    r = r && consumeToken(b, PROPERTY_END);
    exit_section_(b, m, DV_PROPERTY, r);
    return r;
  }

  // DV_PROPERTY_+
  private static boolean DV_PROPERTY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_PROPERTY_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DV_PROPERTY_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!DV_PROPERTY_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DV_PROPERTY_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROPERTY_NAME_DV EQUALS PROPERTY_VALUE
  public static boolean DV_PROPERTY_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DV_PROPERTY_")) return false;
    if (!nextTokenIs(b, PROPERTY_NAME_DV)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPERTY_NAME_DV, EQUALS, PROPERTY_VALUE);
    exit_section_(b, m, DV_PROPERTY_, r);
    return r;
  }

  /* ********************************************************** */
  // (CORE_START ASCII_TYPE ECID? EC_PROPERTY? ASCII_VALUE CORE_END FUNCTION_COMMENT?) |
  //             (CORE_START VARIABLE_TYPE ECID? EC_PROPERTY? VARIABLE_VALUE CORE_END FUNCTION_COMMENT?)
  public static boolean EC_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EC_CORE_0(b, l + 1);
    if (!r) r = EC_CORE_1(b, l + 1);
    exit_section_(b, m, EC_CORE, r);
    return r;
  }

  // CORE_START ASCII_TYPE ECID? EC_PROPERTY? ASCII_VALUE CORE_END FUNCTION_COMMENT?
  private static boolean EC_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && EC_CORE_0_2(b, l + 1);
    r = r && EC_CORE_0_3(b, l + 1);
    r = r && consumeTokens(b, 0, ASCII_VALUE, CORE_END);
    r = r && EC_CORE_0_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ECID?
  private static boolean EC_CORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE_0_2")) return false;
    consumeToken(b, ECID);
    return true;
  }

  // EC_PROPERTY?
  private static boolean EC_CORE_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE_0_3")) return false;
    EC_PROPERTY(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean EC_CORE_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE_0_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START VARIABLE_TYPE ECID? EC_PROPERTY? VARIABLE_VALUE CORE_END FUNCTION_COMMENT?
  private static boolean EC_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, VARIABLE_TYPE);
    r = r && EC_CORE_1_2(b, l + 1);
    r = r && EC_CORE_1_3(b, l + 1);
    r = r && consumeTokens(b, 0, VARIABLE_VALUE, CORE_END);
    r = r && EC_CORE_1_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ECID?
  private static boolean EC_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE_1_2")) return false;
    consumeToken(b, ECID);
    return true;
  }

  // EC_PROPERTY?
  private static boolean EC_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE_1_3")) return false;
    EC_PROPERTY(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean EC_CORE_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_CORE_1_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE EC_CORE* CORE_END FUNCTION_COMMENT?
  public static boolean EC_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_LIST")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && EC_LIST_2(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && EC_LIST_4(b, l + 1);
    exit_section_(b, m, EC_LIST, r);
    return r;
  }

  // EC_CORE*
  private static boolean EC_LIST_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_LIST_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EC_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EC_LIST_2", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean EC_LIST_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_LIST_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // PROPERTY_START EC_PROPERTY_+ PROPERTY_END
  public static boolean EC_PROPERTY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_PROPERTY")) return false;
    if (!nextTokenIs(b, PROPERTY_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY_START);
    r = r && EC_PROPERTY_1(b, l + 1);
    r = r && consumeToken(b, PROPERTY_END);
    exit_section_(b, m, EC_PROPERTY, r);
    return r;
  }

  // EC_PROPERTY_+
  private static boolean EC_PROPERTY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_PROPERTY_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EC_PROPERTY_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!EC_PROPERTY_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EC_PROPERTY_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROPERTY_NAME_EC EQUALS PROPERTY_VALUE
  public static boolean EC_PROPERTY_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EC_PROPERTY_")) return false;
    if (!nextTokenIs(b, PROPERTY_NAME_EC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPERTY_NAME_EC, EQUALS, PROPERTY_VALUE);
    exit_section_(b, m, EC_PROPERTY_, r);
    return r;
  }

  /* ********************************************************** */
  // (CORE_START ASCII_TYPE ASCII_VALUES_4 CORE_END FUNCTION_COMMENT?) |
  //                 (CORE_START LIST_TYPE VARIABLE_NAME? EVENTS_CORE* CORE_END FUNCTION_COMMENT?) |
  public static boolean EVENTS_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EVENTS_CORE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EVENTS_CORE, "<events core>");
    r = EVENTS_CORE_0(b, l + 1);
    if (!r) r = EVENTS_CORE_1(b, l + 1);
    if (!r) r = consumeToken(b, EVENTS_CORE_2_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CORE_START ASCII_TYPE ASCII_VALUES_4 CORE_END FUNCTION_COMMENT?
  private static boolean EVENTS_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EVENTS_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && ASCII_VALUES_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && EVENTS_CORE_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean EVENTS_CORE_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EVENTS_CORE_0_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START LIST_TYPE VARIABLE_NAME? EVENTS_CORE* CORE_END FUNCTION_COMMENT?
  private static boolean EVENTS_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EVENTS_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && EVENTS_CORE_1_2(b, l + 1);
    r = r && EVENTS_CORE_1_3(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && EVENTS_CORE_1_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VARIABLE_NAME?
  private static boolean EVENTS_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EVENTS_CORE_1_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // EVENTS_CORE*
  private static boolean EVENTS_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EVENTS_CORE_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EVENTS_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EVENTS_CORE_1_3", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean EVENTS_CORE_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EVENTS_CORE_1_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // (CORE_START VARIABLE_TYPE VARIABLE_NAME? PROPERTY? VARIABLE_VALUE* CORE_END FUNCTION_COMMENT?) |
  //                   (CORE_START ASCII_TYPE VARIABLE_NAME? PROPERTY? ASCII_VALUE* CORE_END FUNCTION_COMMENT?) |
  //                   (CORE_START LIST_TYPE VARIABLE_NAME? PROPERTY? FUNCTION_COMMENT? FUNCTION_CORE* CORE_END FUNCTION_COMMENT?)
  public static boolean FUNCTION_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FUNCTION_CORE_0(b, l + 1);
    if (!r) r = FUNCTION_CORE_1(b, l + 1);
    if (!r) r = FUNCTION_CORE_2(b, l + 1);
    exit_section_(b, m, FUNCTION_CORE, r);
    return r;
  }

  // CORE_START VARIABLE_TYPE VARIABLE_NAME? PROPERTY? VARIABLE_VALUE* CORE_END FUNCTION_COMMENT?
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

  // VARIABLE_NAME?
  private static boolean FUNCTION_CORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // PROPERTY?
  private static boolean FUNCTION_CORE_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0_3")) return false;
    PROPERTY(b, l + 1);
    return true;
  }

  // VARIABLE_VALUE*
  private static boolean FUNCTION_CORE_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, VARIABLE_VALUE)) break;
      if (!empty_element_parsed_guard_(b, "FUNCTION_CORE_0_4", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean FUNCTION_CORE_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_0_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START ASCII_TYPE VARIABLE_NAME? PROPERTY? ASCII_VALUE* CORE_END FUNCTION_COMMENT?
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

  // VARIABLE_NAME?
  private static boolean FUNCTION_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // PROPERTY?
  private static boolean FUNCTION_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1_3")) return false;
    PROPERTY(b, l + 1);
    return true;
  }

  // ASCII_VALUE*
  private static boolean FUNCTION_CORE_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, ASCII_VALUE)) break;
      if (!empty_element_parsed_guard_(b, "FUNCTION_CORE_1_4", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean FUNCTION_CORE_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_1_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START LIST_TYPE VARIABLE_NAME? PROPERTY? FUNCTION_COMMENT? FUNCTION_CORE* CORE_END FUNCTION_COMMENT?
  private static boolean FUNCTION_CORE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && FUNCTION_CORE_2_2(b, l + 1);
    r = r && FUNCTION_CORE_2_3(b, l + 1);
    r = r && FUNCTION_CORE_2_4(b, l + 1);
    r = r && FUNCTION_CORE_2_5(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && FUNCTION_CORE_2_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VARIABLE_NAME?
  private static boolean FUNCTION_CORE_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // PROPERTY?
  private static boolean FUNCTION_CORE_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2_3")) return false;
    PROPERTY(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean FUNCTION_CORE_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // FUNCTION_CORE*
  private static boolean FUNCTION_CORE_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FUNCTION_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FUNCTION_CORE_2_5", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean FUNCTION_CORE_2_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_CORE_2_7")) return false;
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
  // (CORE_START ASCII_TYPE ASCII_VALUES_5 CORE_END FUNCTION_COMMENT?) |
  //                    (CORE_START LIST_TYPE VARIABLE_NAME? SCENARIOS_CORE* CORE_END FUNCTION_COMMENT?) |
  public static boolean SCENARIOS_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCENARIOS_CORE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCENARIOS_CORE, "<scenarios core>");
    r = SCENARIOS_CORE_0(b, l + 1);
    if (!r) r = SCENARIOS_CORE_1(b, l + 1);
    if (!r) r = consumeToken(b, SCENARIOS_CORE_2_0);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CORE_START ASCII_TYPE ASCII_VALUES_5 CORE_END FUNCTION_COMMENT?
  private static boolean SCENARIOS_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCENARIOS_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && ASCII_VALUES_5(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && SCENARIOS_CORE_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean SCENARIOS_CORE_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCENARIOS_CORE_0_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START LIST_TYPE VARIABLE_NAME? SCENARIOS_CORE* CORE_END FUNCTION_COMMENT?
  private static boolean SCENARIOS_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCENARIOS_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && SCENARIOS_CORE_1_2(b, l + 1);
    r = r && SCENARIOS_CORE_1_3(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && SCENARIOS_CORE_1_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VARIABLE_NAME?
  private static boolean SCENARIOS_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCENARIOS_CORE_1_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // SCENARIOS_CORE*
  private static boolean SCENARIOS_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCENARIOS_CORE_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SCENARIOS_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SCENARIOS_CORE_1_3", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean SCENARIOS_CORE_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCENARIOS_CORE_1_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // (CORE_START ASCII_TYPE VARIABLE_NAME CORE_END FUNCTION_COMMENT?) |
  //              (CORE_START VARIABLE_TYPE VARIABLE_NAME CORE_END FUNCTION_COMMENT?)
  public static boolean SIT_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIT_CORE")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SIT_CORE_0(b, l + 1);
    if (!r) r = SIT_CORE_1(b, l + 1);
    exit_section_(b, m, SIT_CORE, r);
    return r;
  }

  // CORE_START ASCII_TYPE VARIABLE_NAME CORE_END FUNCTION_COMMENT?
  private static boolean SIT_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIT_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE, VARIABLE_NAME, CORE_END);
    r = r && SIT_CORE_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean SIT_CORE_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIT_CORE_0_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START VARIABLE_TYPE VARIABLE_NAME CORE_END FUNCTION_COMMENT?
  private static boolean SIT_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIT_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, VARIABLE_TYPE, VARIABLE_NAME, CORE_END);
    r = r && SIT_CORE_1_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean SIT_CORE_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIT_CORE_1_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE SIT_CORE* CORE_END FUNCTION_COMMENT?
  public static boolean SIT_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIT_LIST")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && SIT_LIST_2(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && SIT_LIST_4(b, l + 1);
    exit_section_(b, m, SIT_LIST, r);
    return r;
  }

  // SIT_CORE*
  private static boolean SIT_LIST_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIT_LIST_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SIT_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SIT_LIST_2", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean SIT_LIST_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SIT_LIST_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // (CORE_START ASCII_TYPE (SVID|VARIABLE_NAME)? SV_PROPERTY? ASCII_VALUE? CORE_END FUNCTION_COMMENT?) |
  //             (CORE_START LIST_TYPE VARIABLE_NAME? SV_PROPERTY? SV_CORE* CORE_END FUNCTION_COMMENT?) |
  //             (CORE_START VARIABLE_TYPE (SVID|VARIABLE_NAME)? SV_PROPERTY? VARIABLE_VALUE? CORE_END FUNCTION_COMMENT?)
  public static boolean SV_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SV_CORE_0(b, l + 1);
    if (!r) r = SV_CORE_1(b, l + 1);
    if (!r) r = SV_CORE_2(b, l + 1);
    exit_section_(b, m, SV_CORE, r);
    return r;
  }

  // CORE_START ASCII_TYPE (SVID|VARIABLE_NAME)? SV_PROPERTY? ASCII_VALUE? CORE_END FUNCTION_COMMENT?
  private static boolean SV_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && SV_CORE_0_2(b, l + 1);
    r = r && SV_CORE_0_3(b, l + 1);
    r = r && SV_CORE_0_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && SV_CORE_0_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SVID|VARIABLE_NAME)?
  private static boolean SV_CORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_0_2")) return false;
    SV_CORE_0_2_0(b, l + 1);
    return true;
  }

  // SVID|VARIABLE_NAME
  private static boolean SV_CORE_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_0_2_0")) return false;
    boolean r;
    r = consumeToken(b, SVID);
    if (!r) r = consumeToken(b, VARIABLE_NAME);
    return r;
  }

  // SV_PROPERTY?
  private static boolean SV_CORE_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_0_3")) return false;
    SV_PROPERTY(b, l + 1);
    return true;
  }

  // ASCII_VALUE?
  private static boolean SV_CORE_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_0_4")) return false;
    consumeToken(b, ASCII_VALUE);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean SV_CORE_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_0_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START LIST_TYPE VARIABLE_NAME? SV_PROPERTY? SV_CORE* CORE_END FUNCTION_COMMENT?
  private static boolean SV_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && SV_CORE_1_2(b, l + 1);
    r = r && SV_CORE_1_3(b, l + 1);
    r = r && SV_CORE_1_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && SV_CORE_1_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VARIABLE_NAME?
  private static boolean SV_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_1_2")) return false;
    consumeToken(b, VARIABLE_NAME);
    return true;
  }

  // SV_PROPERTY?
  private static boolean SV_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_1_3")) return false;
    SV_PROPERTY(b, l + 1);
    return true;
  }

  // SV_CORE*
  private static boolean SV_CORE_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_1_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SV_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SV_CORE_1_4", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean SV_CORE_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_1_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START VARIABLE_TYPE (SVID|VARIABLE_NAME)? SV_PROPERTY? VARIABLE_VALUE? CORE_END FUNCTION_COMMENT?
  private static boolean SV_CORE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, VARIABLE_TYPE);
    r = r && SV_CORE_2_2(b, l + 1);
    r = r && SV_CORE_2_3(b, l + 1);
    r = r && SV_CORE_2_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && SV_CORE_2_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SVID|VARIABLE_NAME)?
  private static boolean SV_CORE_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_2_2")) return false;
    SV_CORE_2_2_0(b, l + 1);
    return true;
  }

  // SVID|VARIABLE_NAME
  private static boolean SV_CORE_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_2_2_0")) return false;
    boolean r;
    r = consumeToken(b, SVID);
    if (!r) r = consumeToken(b, VARIABLE_NAME);
    return r;
  }

  // SV_PROPERTY?
  private static boolean SV_CORE_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_2_3")) return false;
    SV_PROPERTY(b, l + 1);
    return true;
  }

  // VARIABLE_VALUE?
  private static boolean SV_CORE_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_2_4")) return false;
    consumeToken(b, VARIABLE_VALUE);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean SV_CORE_2_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_CORE_2_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE SV_CORE* CORE_END FUNCTION_COMMENT?
  public static boolean SV_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_LIST")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && SV_LIST_2(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && SV_LIST_4(b, l + 1);
    exit_section_(b, m, SV_LIST, r);
    return r;
  }

  // SV_CORE*
  private static boolean SV_LIST_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_LIST_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SV_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SV_LIST_2", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean SV_LIST_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_LIST_4")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // PROPERTY_START SV_PROPERTY_+ PROPERTY_END
  public static boolean SV_PROPERTY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_PROPERTY")) return false;
    if (!nextTokenIs(b, PROPERTY_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY_START);
    r = r && SV_PROPERTY_1(b, l + 1);
    r = r && consumeToken(b, PROPERTY_END);
    exit_section_(b, m, SV_PROPERTY, r);
    return r;
  }

  // SV_PROPERTY_+
  private static boolean SV_PROPERTY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_PROPERTY_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SV_PROPERTY_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!SV_PROPERTY_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SV_PROPERTY_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROPERTY_NAME_SV EQUALS PROPERTY_VALUE
  public static boolean SV_PROPERTY_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SV_PROPERTY_")) return false;
    if (!nextTokenIs(b, PROPERTY_NAME_SV)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPERTY_NAME_SV, EQUALS, PROPERTY_VALUE);
    exit_section_(b, m, SV_PROPERTY_, r);
    return r;
  }

  /* ********************************************************** */
  // (CORE_START ASCII_TYPE VSS_PROPERTY? ASCII_VALUE CORE_END FUNCTION_COMMENT?) |
  //               (CORE_START LIST_TYPE (VFEI_CMD_ITEM_NAME|VARIABLE_NAME)? VSS_PROPERTY? VSS_CORE* CORE_END FUNCTION_COMMENT?)
  public static boolean VSS_CORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE")) return false;
    if (!nextTokenIs(b, CORE_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VSS_CORE_0(b, l + 1);
    if (!r) r = VSS_CORE_1(b, l + 1);
    exit_section_(b, m, VSS_CORE, r);
    return r;
  }

  // CORE_START ASCII_TYPE VSS_PROPERTY? ASCII_VALUE CORE_END FUNCTION_COMMENT?
  private static boolean VSS_CORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, ASCII_TYPE);
    r = r && VSS_CORE_0_2(b, l + 1);
    r = r && consumeTokens(b, 0, ASCII_VALUE, CORE_END);
    r = r && VSS_CORE_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VSS_PROPERTY?
  private static boolean VSS_CORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_0_2")) return false;
    VSS_PROPERTY(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean VSS_CORE_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_0_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CORE_START LIST_TYPE (VFEI_CMD_ITEM_NAME|VARIABLE_NAME)? VSS_PROPERTY? VSS_CORE* CORE_END FUNCTION_COMMENT?
  private static boolean VSS_CORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CORE_START, LIST_TYPE);
    r = r && VSS_CORE_1_2(b, l + 1);
    r = r && VSS_CORE_1_3(b, l + 1);
    r = r && VSS_CORE_1_4(b, l + 1);
    r = r && consumeToken(b, CORE_END);
    r = r && VSS_CORE_1_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (VFEI_CMD_ITEM_NAME|VARIABLE_NAME)?
  private static boolean VSS_CORE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_1_2")) return false;
    VSS_CORE_1_2_0(b, l + 1);
    return true;
  }

  // VFEI_CMD_ITEM_NAME|VARIABLE_NAME
  private static boolean VSS_CORE_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_1_2_0")) return false;
    boolean r;
    r = consumeToken(b, VFEI_CMD_ITEM_NAME);
    if (!r) r = consumeToken(b, VARIABLE_NAME);
    return r;
  }

  // VSS_PROPERTY?
  private static boolean VSS_CORE_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_1_3")) return false;
    VSS_PROPERTY(b, l + 1);
    return true;
  }

  // VSS_CORE*
  private static boolean VSS_CORE_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_1_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VSS_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VSS_CORE_1_4", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean VSS_CORE_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_CORE_1_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // CORE_START LIST_TYPE VSS_CORE* CORE_END FUNCTION_COMMENT?
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

  // VSS_CORE*
  private static boolean VSS_LIST_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_LIST_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VSS_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VSS_LIST_2", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean VSS_LIST_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VSS_LIST_4")) return false;
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
  // COLLECTION_EVENT COLON FUNCTION_COMMENT? CE_LIST? FUNCTION_END FUNCTION_COMMENT?
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

  // FUNCTION_COMMENT?
  private static boolean collection_event_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection_event_section_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // CE_LIST?
  private static boolean collection_event_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection_event_section_3")) return false;
    CE_LIST(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean collection_event_section_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection_event_section_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // DATA_VARIABLE COLON FUNCTION_COMMENT? DV_LIST? FUNCTION_END FUNCTION_COMMENT?
  public static boolean data_variable_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_variable_section")) return false;
    if (!nextTokenIs(b, DATA_VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DATA_VARIABLE, COLON);
    r = r && data_variable_section_2(b, l + 1);
    r = r && data_variable_section_3(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && data_variable_section_5(b, l + 1);
    exit_section_(b, m, DATA_VARIABLE_SECTION, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean data_variable_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_variable_section_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // DV_LIST?
  private static boolean data_variable_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_variable_section_3")) return false;
    DV_LIST(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean data_variable_section_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_variable_section_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // EQUIPMENT_CONSTANT COLON FUNCTION_COMMENT? EC_LIST? FUNCTION_END FUNCTION_COMMENT?
  public static boolean equipment_constant_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equipment_constant_section")) return false;
    if (!nextTokenIs(b, EQUIPMENT_CONSTANT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EQUIPMENT_CONSTANT, COLON);
    r = r && equipment_constant_section_2(b, l + 1);
    r = r && equipment_constant_section_3(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && equipment_constant_section_5(b, l + 1);
    exit_section_(b, m, EQUIPMENT_CONSTANT_SECTION, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean equipment_constant_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equipment_constant_section_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // EC_LIST?
  private static boolean equipment_constant_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equipment_constant_section_3")) return false;
    EC_LIST(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean equipment_constant_section_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equipment_constant_section_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // EVENTS COLON STREAM_FUNCTION FUNCTION_COMMENT? EVENTS_CORE* FUNCTION_END FUNCTION_COMMENT?
  public static boolean events_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "events_section")) return false;
    if (!nextTokenIs(b, EVENTS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EVENTS, COLON, STREAM_FUNCTION);
    r = r && events_section_3(b, l + 1);
    r = r && events_section_4(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && events_section_6(b, l + 1);
    exit_section_(b, m, EVENTS_SECTION, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean events_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "events_section_3")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // EVENTS_CORE*
  private static boolean events_section_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "events_section_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EVENTS_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "events_section_4", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean events_section_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "events_section_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // FUNCTION_NAME COLON STREAM_FUNCTION FUNCTION_COMMENT? FUNCTION_CORE* FUNCTION_END FUNCTION_COMMENT?
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

  // FUNCTION_COMMENT?
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

  // FUNCTION_COMMENT?
  private static boolean functions_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functions_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // collection_event_section|data_variable_section|equipment_constant_section|events_section|scenarios_section|secs_item_type_section|standart_sections|status_variable_section|vfei_secs_seq_section|functions|COMMENT
  static boolean items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "items")) return false;
    boolean r;
    r = collection_event_section(b, l + 1);
    if (!r) r = data_variable_section(b, l + 1);
    if (!r) r = equipment_constant_section(b, l + 1);
    if (!r) r = events_section(b, l + 1);
    if (!r) r = scenarios_section(b, l + 1);
    if (!r) r = secs_item_type_section(b, l + 1);
    if (!r) r = standart_sections(b, l + 1);
    if (!r) r = status_variable_section(b, l + 1);
    if (!r) r = vfei_secs_seq_section(b, l + 1);
    if (!r) r = functions(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // SCENARIOS COLON STREAM_FUNCTION FUNCTION_COMMENT? SCENARIOS_CORE* FUNCTION_END FUNCTION_COMMENT?
  public static boolean scenarios_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scenarios_section")) return false;
    if (!nextTokenIs(b, SCENARIOS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SCENARIOS, COLON, STREAM_FUNCTION);
    r = r && scenarios_section_3(b, l + 1);
    r = r && scenarios_section_4(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && scenarios_section_6(b, l + 1);
    exit_section_(b, m, SCENARIOS_SECTION, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean scenarios_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scenarios_section_3")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // SCENARIOS_CORE*
  private static boolean scenarios_section_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scenarios_section_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SCENARIOS_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "scenarios_section_4", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean scenarios_section_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scenarios_section_6")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // SECS_ITEM_TYPE COLON FUNCTION_COMMENT? SIT_LIST? FUNCTION_END FUNCTION_COMMENT?
  public static boolean secs_item_type_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "secs_item_type_section")) return false;
    if (!nextTokenIs(b, SECS_ITEM_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SECS_ITEM_TYPE, COLON);
    r = r && secs_item_type_section_2(b, l + 1);
    r = r && secs_item_type_section_3(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && secs_item_type_section_5(b, l + 1);
    exit_section_(b, m, SECS_ITEM_TYPE_SECTION, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean secs_item_type_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "secs_item_type_section_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // SIT_LIST?
  private static boolean secs_item_type_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "secs_item_type_section_3")) return false;
    SIT_LIST(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean secs_item_type_section_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "secs_item_type_section_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // STANDART_SECTION COLON FUNCTION_COMMENT? FUNCTION_CORE* FUNCTION_END FUNCTION_COMMENT?
  public static boolean standart_sections(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standart_sections")) return false;
    if (!nextTokenIs(b, STANDART_SECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STANDART_SECTION, COLON);
    r = r && standart_sections_2(b, l + 1);
    r = r && standart_sections_3(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && standart_sections_5(b, l + 1);
    exit_section_(b, m, STANDART_SECTIONS, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean standart_sections_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standart_sections_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // FUNCTION_CORE*
  private static boolean standart_sections_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standart_sections_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FUNCTION_CORE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "standart_sections_3", c)) break;
    }
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean standart_sections_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standart_sections_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // STATUS_VARIABLE COLON FUNCTION_COMMENT? SV_LIST? FUNCTION_END FUNCTION_COMMENT?
  public static boolean status_variable_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_variable_section")) return false;
    if (!nextTokenIs(b, STATUS_VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STATUS_VARIABLE, COLON);
    r = r && status_variable_section_2(b, l + 1);
    r = r && status_variable_section_3(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    r = r && status_variable_section_5(b, l + 1);
    exit_section_(b, m, STATUS_VARIABLE_SECTION, r);
    return r;
  }

  // FUNCTION_COMMENT?
  private static boolean status_variable_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_variable_section_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // SV_LIST?
  private static boolean status_variable_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_variable_section_3")) return false;
    SV_LIST(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
  private static boolean status_variable_section_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_variable_section_5")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // VFEI_SECS_SEQ COLON FUNCTION_COMMENT? VSS_LIST? FUNCTION_END FUNCTION_COMMENT?
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

  // FUNCTION_COMMENT?
  private static boolean vfei_secs_seq_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vfei_secs_seq_section_2")) return false;
    consumeToken(b, FUNCTION_COMMENT);
    return true;
  }

  // VSS_LIST?
  private static boolean vfei_secs_seq_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vfei_secs_seq_section_3")) return false;
    VSS_LIST(b, l + 1);
    return true;
  }

  // FUNCTION_COMMENT?
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

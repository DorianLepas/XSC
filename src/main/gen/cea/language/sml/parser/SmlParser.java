// This is a generated file. Not intended for manual editing.
package cea.language.sml.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static cea.language.sml.psi.SmlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SmlParser implements PsiParser, LightPsiParser {

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
    return smlFile(b, l + 1);
  }

  /* ********************************************************** */
  // ALARM separator eventsDefinition beginBlock instructions* endBlock
  public static boolean alarmBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alarmBlock")) return false;
    if (!nextTokenIs(b, ALARM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ALARM_BLOCK, null);
    r = consumeToken(b, ALARM);
    p = r; // pin = 1
    r = r && report_error_(b, separator(b, l + 1));
    r = p && report_error_(b, eventsDefinition(b, l + 1)) && r;
    r = p && report_error_(b, beginBlock(b, l + 1)) && r;
    r = p && report_error_(b, alarmBlock_4(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instructions*
  private static boolean alarmBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alarmBlock_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "alarmBlock_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ALIAS separator aliasName beginBlock aliasBlockBody endBlock
  public static boolean aliasBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasBlock")) return false;
    if (!nextTokenIs(b, ALIAS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ALIAS_BLOCK, null);
    r = consumeToken(b, ALIAS);
    p = r; // pin = 1
    r = r && report_error_(b, separator(b, l + 1));
    r = p && report_error_(b, aliasName(b, l + 1)) && r;
    r = p && report_error_(b, beginBlock(b, l + 1)) && r;
    r = p && report_error_(b, aliasBlockBody(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // EVENT_NAME+
  static boolean aliasBlockBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasBlockBody")) return false;
    if (!nextTokenIs(b, "<Events names>", EVENT_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<Events names>");
    r = consumeToken(b, EVENT_NAME);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, EVENT_NAME)) break;
      if (!empty_element_parsed_guard_(b, "aliasBlockBody", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ALIAS_NAME
  static boolean aliasName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasName")) return false;
    if (!nextTokenIs(b, "<Alias name>", ALIAS_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<Alias name>");
    r = consumeToken(b, ALIAS_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BEGIN_BLOCK
  static boolean beginBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "beginBlock")) return false;
    if (!nextTokenIs(b, "<Begin block '{' >", BEGIN_BLOCK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<Begin block '{' >");
    r = consumeToken(b, BEGIN_BLOCK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BIND_NAME EQUALS_SEPARATOR smlVars
  public static boolean bind(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bind")) return false;
    if (!nextTokenIs(b, "<Bindings>", BIND_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BIND, "<Bindings>");
    r = consumeTokens(b, 1, BIND_NAME, EQUALS_SEPARATOR);
    p = r; // pin = 1
    r = r && smlVars(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // BINDING beginBlock bind+ endBlock
  public static boolean bindingBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingBlock")) return false;
    if (!nextTokenIs(b, BINDING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BINDING_BLOCK, null);
    r = consumeToken(b, BINDING);
    p = r; // pin = 1
    r = r && report_error_(b, beginBlock(b, l + 1));
    r = p && report_error_(b, bindingBlock_2(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // bind+
  private static boolean bindingBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingBlock_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bind(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!bind(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bindingBlock_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BINDS
  static boolean binds(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binds")) return false;
    if (!nextTokenIs(b, "<Bindings>", BINDS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<Bindings>");
    r = consumeToken(b, BINDS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CALL JAVA_FUNCTION_CALL
  public static boolean callJavaFunctionInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callJavaFunctionInstruction")) return false;
    if (!nextTokenIs(b, "<Call Java Function>", CALL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CALL_JAVA_FUNCTION_INSTRUCTION, "<Call Java Function>");
    r = consumeTokens(b, 1, CALL, JAVA_FUNCTION_CALL);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // CONDITION beginBlock conditions* endBlock
  public static boolean conditionBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionBlock")) return false;
    if (!nextTokenIs(b, CONDITION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONDITION_BLOCK, null);
    r = consumeToken(b, CONDITION);
    p = r; // pin = 1
    r = r && report_error_(b, beginBlock(b, l + 1));
    r = p && report_error_(b, conditionBlock_2(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // conditions*
  private static boolean conditionBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditionBlock_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (SML_VARS|CONST_CONDS) ((OP_CONDS|COMP_CONDS) (SML_VARS|CONST_CONDS))*
  public static boolean conditions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditions")) return false;
    if (!nextTokenIs(b, "<conditions>", CONST_CONDS, SML_VARS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONS, "<conditions>");
    r = conditions_0(b, l + 1);
    p = r; // pin = 1
    r = r && conditions_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SML_VARS|CONST_CONDS
  private static boolean conditions_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditions_0")) return false;
    boolean r;
    r = consumeToken(b, SML_VARS);
    if (!r) r = consumeToken(b, CONST_CONDS);
    return r;
  }

  // ((OP_CONDS|COMP_CONDS) (SML_VARS|CONST_CONDS))*
  private static boolean conditions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditions_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditions_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditions_1", c)) break;
    }
    return true;
  }

  // (OP_CONDS|COMP_CONDS) (SML_VARS|CONST_CONDS)
  private static boolean conditions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditions_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = conditions_1_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && conditions_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // OP_CONDS|COMP_CONDS
  private static boolean conditions_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditions_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_CONDS);
    if (!r) r = consumeToken(b, COMP_CONDS);
    return r;
  }

  // SML_VARS|CONST_CONDS
  private static boolean conditions_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditions_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, SML_VARS);
    if (!r) r = consumeToken(b, CONST_CONDS);
    return r;
  }

  /* ********************************************************** */
  // CONSUME_EVENT
  public static boolean consumeEventInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consumeEventInstruction")) return false;
    if (!nextTokenIs(b, CONSUME_EVENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSUME_EVENT);
    exit_section_(b, m, CONSUME_EVENT_INSTRUCTION, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE beginBlock instructions* endBlock
  public static boolean elseBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseBlock")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ELSE_BLOCK, null);
    r = consumeToken(b, ELSE);
    p = r; // pin = 1
    r = r && report_error_(b, beginBlock(b, l + 1));
    r = p && report_error_(b, elseBlock_2(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instructions*
  private static boolean elseBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elseBlock_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ELSE_IF ifConditions beginBlock instructions* endBlock
  public static boolean elseIfBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseIfBlock")) return false;
    if (!nextTokenIs(b, ELSE_IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ELSE_IF_BLOCK, null);
    r = consumeToken(b, ELSE_IF);
    p = r; // pin = 1
    r = r && report_error_(b, ifConditions(b, l + 1));
    r = p && report_error_(b, beginBlock(b, l + 1)) && r;
    r = p && report_error_(b, elseIfBlock_3(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instructions*
  private static boolean elseIfBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseIfBlock_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elseIfBlock_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // END_BLOCK
  static boolean endBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "endBlock")) return false;
    if (!nextTokenIs(b, "<End block '}' >", END_BLOCK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<End block '}' >");
    r = consumeToken(b, END_BLOCK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENTER beginBlock instructions* endBlock
  public static boolean enterBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enterBlock")) return false;
    if (!nextTokenIs(b, ENTER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTER_BLOCK, null);
    r = consumeToken(b, ENTER);
    p = r; // pin = 1
    r = r && report_error_(b, beginBlock(b, l + 1));
    r = p && report_error_(b, enterBlock_2(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instructions*
  private static boolean enterBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enterBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enterBlock_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EVENT separator eventsDefinition beginBlock instructions* endBlock
  public static boolean eventBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eventBlock")) return false;
    if (!nextTokenIs(b, EVENT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EVENT_BLOCK, null);
    r = consumeToken(b, EVENT);
    p = r; // pin = 1
    r = r && report_error_(b, separator(b, l + 1));
    r = p && report_error_(b, eventsDefinition(b, l + 1)) && r;
    r = p && report_error_(b, beginBlock(b, l + 1)) && r;
    r = p && report_error_(b, eventBlock_4(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instructions*
  private static boolean eventBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eventBlock_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "eventBlock_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // eventsValue (EVENT_NAME_SEPARATOR eventsValue)* | ALL_EVENTS
  public static boolean eventsDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eventsDefinition")) return false;
    if (!nextTokenIs(b, "<Events definition>", ALL_EVENTS, EVENT_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EVENTS_DEFINITION, "<Events definition>");
    r = eventsDefinition_0(b, l + 1);
    if (!r) r = consumeToken(b, ALL_EVENTS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // eventsValue (EVENT_NAME_SEPARATOR eventsValue)*
  private static boolean eventsDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eventsDefinition_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = eventsValue(b, l + 1);
    p = r; // pin = 1
    r = r && eventsDefinition_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EVENT_NAME_SEPARATOR eventsValue)*
  private static boolean eventsDefinition_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eventsDefinition_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!eventsDefinition_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "eventsDefinition_0_1", c)) break;
    }
    return true;
  }

  // EVENT_NAME_SEPARATOR eventsValue
  private static boolean eventsDefinition_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eventsDefinition_0_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, EVENT_NAME_SEPARATOR);
    p = r; // pin = 1
    r = r && eventsValue(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // EVENT_NAME
  public static boolean eventsValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eventsValue")) return false;
    if (!nextTokenIs(b, "<Events Value>", EVENT_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EVENTS_VALUE, "<Events Value>");
    r = consumeToken(b, EVENT_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EXEC_END
  public static boolean execEndInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "execEndInstruction")) return false;
    if (!nextTokenIs(b, EXEC_END)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXEC_END);
    exit_section_(b, m, EXEC_END_INSTRUCTION, r);
    return r;
  }

  /* ********************************************************** */
  // EXIT beginBlock instructions* endBlock
  public static boolean exitBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exitBlock")) return false;
    if (!nextTokenIs(b, EXIT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXIT_BLOCK, null);
    r = consumeToken(b, EXIT);
    p = r; // pin = 1
    r = r && report_error_(b, beginBlock(b, l + 1));
    r = p && report_error_(b, exitBlock_2(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instructions*
  private static boolean exitBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exitBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exitBlock_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // GOTO_STATE SEPARATOR stateName (STATE_NAME_SEPARATOR stateName)*
  public static boolean gotoStateInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gotoStateInstruction")) return false;
    if (!nextTokenIs(b, GOTO_STATE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GOTO_STATE_INSTRUCTION, null);
    r = consumeTokens(b, 1, GOTO_STATE, SEPARATOR);
    p = r; // pin = 1
    r = r && report_error_(b, stateName(b, l + 1));
    r = p && gotoStateInstruction_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (STATE_NAME_SEPARATOR stateName)*
  private static boolean gotoStateInstruction_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gotoStateInstruction_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gotoStateInstruction_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gotoStateInstruction_3", c)) break;
    }
    return true;
  }

  // STATE_NAME_SEPARATOR stateName
  private static boolean gotoStateInstruction_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gotoStateInstruction_3_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, STATE_NAME_SEPARATOR);
    p = r; // pin = 1
    r = r && stateName(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IDENTIFICATION_KEY
  static boolean identificationKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identificationKey")) return false;
    if (!nextTokenIs(b, "<Identification Key>", IDENTIFICATION_KEY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<Identification Key>");
    r = consumeToken(b, IDENTIFICATION_KEY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF ifConditions beginBlock instructions* endBlock
  public static boolean ifBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifBlock")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_BLOCK, null);
    r = consumeToken(b, IF);
    p = r; // pin = 1
    r = r && report_error_(b, ifConditions(b, l + 1));
    r = p && report_error_(b, beginBlock(b, l + 1)) && r;
    r = p && report_error_(b, ifBlock_3(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instructions*
  private static boolean ifBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifBlock_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ifBlock_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BEGIN_PARENTHESE (SML_VARS|CONST_CONDS) ((OP_CONDS|COMP_CONDS) (SML_VARS|CONST_CONDS))* END_PARENTHESE
  public static boolean ifConditions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifConditions")) return false;
    if (!nextTokenIs(b, BEGIN_PARENTHESE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_CONDITIONS, null);
    r = consumeToken(b, BEGIN_PARENTHESE);
    p = r; // pin = 1
    r = r && report_error_(b, ifConditions_1(b, l + 1));
    r = p && report_error_(b, ifConditions_2(b, l + 1)) && r;
    r = p && consumeToken(b, END_PARENTHESE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SML_VARS|CONST_CONDS
  private static boolean ifConditions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifConditions_1")) return false;
    boolean r;
    r = consumeToken(b, SML_VARS);
    if (!r) r = consumeToken(b, CONST_CONDS);
    return r;
  }

  // ((OP_CONDS|COMP_CONDS) (SML_VARS|CONST_CONDS))*
  private static boolean ifConditions_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifConditions_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ifConditions_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ifConditions_2", c)) break;
    }
    return true;
  }

  // (OP_CONDS|COMP_CONDS) (SML_VARS|CONST_CONDS)
  private static boolean ifConditions_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifConditions_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ifConditions_2_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && ifConditions_2_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // OP_CONDS|COMP_CONDS
  private static boolean ifConditions_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifConditions_2_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_CONDS);
    if (!r) r = consumeToken(b, COMP_CONDS);
    return r;
  }

  // SML_VARS|CONST_CONDS
  private static boolean ifConditions_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifConditions_2_0_1")) return false;
    boolean r;
    r = consumeToken(b, SML_VARS);
    if (!r) r = consumeToken(b, CONST_CONDS);
    return r;
  }

  /* ********************************************************** */
  // ifBlock|elseIfBlock|elseBlock|conditionBlock|scriptBlock
  // |(threadStateInstruction
  // |callJavaFunctionInstruction
  // |gotoStateInstruction
  // |processStateInstruction
  // |threadEndInstruction
  // |traceInstruction
  // |execEndInstruction
  // |consumeEventInstruction
  // |setInstruction)
  static boolean instructions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instructions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<Instructions>");
    r = ifBlock(b, l + 1);
    if (!r) r = elseIfBlock(b, l + 1);
    if (!r) r = elseBlock(b, l + 1);
    if (!r) r = conditionBlock(b, l + 1);
    if (!r) r = scriptBlock(b, l + 1);
    if (!r) r = instructions_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // threadStateInstruction
  // |callJavaFunctionInstruction
  // |gotoStateInstruction
  // |processStateInstruction
  // |threadEndInstruction
  // |traceInstruction
  // |execEndInstruction
  // |consumeEventInstruction
  // |setInstruction
  private static boolean instructions_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instructions_5")) return false;
    boolean r;
    r = threadStateInstruction(b, l + 1);
    if (!r) r = callJavaFunctionInstruction(b, l + 1);
    if (!r) r = gotoStateInstruction(b, l + 1);
    if (!r) r = processStateInstruction(b, l + 1);
    if (!r) r = threadEndInstruction(b, l + 1);
    if (!r) r = traceInstruction(b, l + 1);
    if (!r) r = execEndInstruction(b, l + 1);
    if (!r) r = consumeEventInstruction(b, l + 1);
    if (!r) r = setInstruction(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // JAVASCRIPT_CODE+
  public static boolean javascript(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javascript")) return false;
    if (!nextTokenIs(b, JAVASCRIPT_CODE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, JAVASCRIPT_CODE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, JAVASCRIPT_CODE)) break;
      if (!empty_element_parsed_guard_(b, "javascript", c)) break;
    }
    exit_section_(b, m, JAVASCRIPT, r);
    return r;
  }

  /* ********************************************************** */
  // OPTION beginBlock OPTIONS* endBlock
  public static boolean optionsBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optionsBlock")) return false;
    if (!nextTokenIs(b, OPTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OPTIONS_BLOCK, null);
    r = consumeToken(b, OPTION);
    p = r; // pin = 1
    r = r && report_error_(b, beginBlock(b, l + 1));
    r = p && report_error_(b, optionsBlock_2(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // OPTIONS*
  private static boolean optionsBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optionsBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, OPTIONS)) break;
      if (!empty_element_parsed_guard_(b, "optionsBlock_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PROCESS_STATE SEPARATOR stateName identificationKey
  public static boolean processStateInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "processStateInstruction")) return false;
    if (!nextTokenIs(b, PROCESS_STATE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROCESS_STATE_INSTRUCTION, null);
    r = consumeTokens(b, 1, PROCESS_STATE, SEPARATOR);
    p = r; // pin = 1
    r = r && report_error_(b, stateName(b, l + 1));
    r = p && identificationKey(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // SCRIPT beginBlock bindingBlock javascript? endBlock
  public static boolean scriptBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBlock")) return false;
    if (!nextTokenIs(b, SCRIPT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_BLOCK, null);
    r = consumeToken(b, SCRIPT);
    p = r; // pin = 1
    r = r && report_error_(b, beginBlock(b, l + 1));
    r = p && report_error_(b, bindingBlock(b, l + 1)) && r;
    r = p && report_error_(b, scriptBlock_3(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // javascript?
  private static boolean scriptBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBlock_3")) return false;
    javascript(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SEPARATOR
  static boolean separator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "separator")) return false;
    if (!nextTokenIs(b, "<Separator ':' >", SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<Separator ':' >");
    r = consumeToken(b, SEPARATOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SET setProperty EQUALS_SEPARATOR setValue
  public static boolean setInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setInstruction")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SET_INSTRUCTION, null);
    r = consumeToken(b, SET);
    p = r; // pin = 1
    r = r && report_error_(b, setProperty(b, l + 1));
    r = p && report_error_(b, consumeToken(b, EQUALS_SEPARATOR)) && r;
    r = p && setValue(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // setVariables | ((THREAD_KEYWORD|PROCESS_KEYWORD) identificationKey DOT_SEPARATOR setVariables)
  public static boolean setProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setProperty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_PROPERTY, "<set property>");
    r = setVariables(b, l + 1);
    if (!r) r = setProperty_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (THREAD_KEYWORD|PROCESS_KEYWORD) identificationKey DOT_SEPARATOR setVariables
  private static boolean setProperty_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setProperty_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = setProperty_1_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, identificationKey(b, l + 1));
    r = p && report_error_(b, consumeToken(b, DOT_SEPARATOR)) && r;
    r = p && setVariables(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // THREAD_KEYWORD|PROCESS_KEYWORD
  private static boolean setProperty_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setProperty_1_0")) return false;
    boolean r;
    r = consumeToken(b, THREAD_KEYWORD);
    if (!r) r = consumeToken(b, PROCESS_KEYWORD);
    return r;
  }

  /* ********************************************************** */
  // setVariables|THREAD_KEYWORD|PROCESS_KEYWORD
  public static boolean setValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_VALUE, "<set value>");
    r = setVariables(b, l + 1);
    if (!r) r = consumeToken(b, THREAD_KEYWORD);
    if (!r) r = consumeToken(b, PROCESS_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SET_VARIABLES
  static boolean setVariables(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setVariables")) return false;
    if (!nextTokenIs(b, "<set Variables>", SET_VARIABLES)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<set Variables>");
    r = consumeToken(b, SET_VARIABLES);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // smlFileContent*
  static boolean smlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "smlFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!smlFileContent(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "smlFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // COMMENT|LINE_END|stateBlock|aliasBlock|alarmBlock|eventBlock|traceBlock|scriptBlock
  static boolean smlFileContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "smlFileContent")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, LINE_END);
    if (!r) r = stateBlock(b, l + 1);
    if (!r) r = aliasBlock(b, l + 1);
    if (!r) r = alarmBlock(b, l + 1);
    if (!r) r = eventBlock(b, l + 1);
    if (!r) r = traceBlock(b, l + 1);
    if (!r) r = scriptBlock(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SML_VARS
  static boolean smlVars(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "smlVars")) return false;
    if (!nextTokenIs(b, "<Variables>", SML_VARS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<Variables>");
    r = consumeToken(b, SML_VARS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STATE separator stateName beginBlock stateBody* endBlock
  public static boolean stateBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stateBlock")) return false;
    if (!nextTokenIs(b, STATE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STATE_BLOCK, null);
    r = consumeToken(b, STATE);
    p = r; // pin = 1
    r = r && report_error_(b, separator(b, l + 1));
    r = p && report_error_(b, stateName(b, l + 1)) && r;
    r = p && report_error_(b, beginBlock(b, l + 1)) && r;
    r = p && report_error_(b, stateBlock_4(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // stateBody*
  private static boolean stateBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stateBlock_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!stateBody(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stateBlock_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // stateBlock|aliasBlock|alarmBlock|eventBlock|traceBlock|enterBlock|exitBlock|optionsBlock
  static boolean stateBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stateBody")) return false;
    boolean r;
    r = stateBlock(b, l + 1);
    if (!r) r = aliasBlock(b, l + 1);
    if (!r) r = alarmBlock(b, l + 1);
    if (!r) r = eventBlock(b, l + 1);
    if (!r) r = traceBlock(b, l + 1);
    if (!r) r = enterBlock(b, l + 1);
    if (!r) r = exitBlock(b, l + 1);
    if (!r) r = optionsBlock(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STATE_NAME
  static boolean stateName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stateName")) return false;
    if (!nextTokenIs(b, "<State name>", STATE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null, "<State name>");
    r = consumeToken(b, STATE_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // THREAD_END
  public static boolean threadEndInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "threadEndInstruction")) return false;
    if (!nextTokenIs(b, THREAD_END)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THREAD_END);
    exit_section_(b, m, THREAD_END_INSTRUCTION, r);
    return r;
  }

  /* ********************************************************** */
  // THREAD_STATE SEPARATOR THREAD_NAME identificationKey
  public static boolean threadStateInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "threadStateInstruction")) return false;
    if (!nextTokenIs(b, THREAD_STATE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, THREAD_STATE_INSTRUCTION, null);
    r = consumeTokens(b, 1, THREAD_STATE, SEPARATOR, THREAD_NAME);
    p = r; // pin = 1
    r = r && identificationKey(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TRACE separator eventsDefinition beginBlock instructions* endBlock
  public static boolean traceBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceBlock")) return false;
    if (!nextTokenIs(b, TRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TRACE_BLOCK, null);
    r = consumeToken(b, TRACE);
    p = r; // pin = 1
    r = r && report_error_(b, separator(b, l + 1));
    r = p && report_error_(b, eventsDefinition(b, l + 1)) && r;
    r = p && report_error_(b, beginBlock(b, l + 1)) && r;
    r = p && report_error_(b, traceBlock_4(b, l + 1)) && r;
    r = p && endBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instructions*
  private static boolean traceBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceBlock_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "traceBlock_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (MESSAGE|WARNING|DEBUG) traceMessage?
  public static boolean traceInstruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceInstruction")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TRACE_INSTRUCTION, "<trace instruction>");
    r = traceInstruction_0(b, l + 1);
    p = r; // pin = 1
    r = r && traceInstruction_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // MESSAGE|WARNING|DEBUG
  private static boolean traceInstruction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceInstruction_0")) return false;
    boolean r;
    r = consumeToken(b, MESSAGE);
    if (!r) r = consumeToken(b, WARNING);
    if (!r) r = consumeToken(b, DEBUG);
    return r;
  }

  // traceMessage?
  private static boolean traceInstruction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceInstruction_1")) return false;
    traceMessage(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (TRACE_MESSAGE_STRING|SML_VARS) (TRACE_MESSAGE_SEPARATOR (TRACE_MESSAGE_STRING|SML_VARS))*
  public static boolean traceMessage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceMessage")) return false;
    if (!nextTokenIs(b, "<trace message>", SML_VARS, TRACE_MESSAGE_STRING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TRACE_MESSAGE, "<trace message>");
    r = traceMessage_0(b, l + 1);
    p = r; // pin = 1
    r = r && traceMessage_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TRACE_MESSAGE_STRING|SML_VARS
  private static boolean traceMessage_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceMessage_0")) return false;
    boolean r;
    r = consumeToken(b, TRACE_MESSAGE_STRING);
    if (!r) r = consumeToken(b, SML_VARS);
    return r;
  }

  // (TRACE_MESSAGE_SEPARATOR (TRACE_MESSAGE_STRING|SML_VARS))*
  private static boolean traceMessage_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceMessage_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!traceMessage_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "traceMessage_1", c)) break;
    }
    return true;
  }

  // TRACE_MESSAGE_SEPARATOR (TRACE_MESSAGE_STRING|SML_VARS)
  private static boolean traceMessage_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceMessage_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, TRACE_MESSAGE_SEPARATOR);
    p = r; // pin = 1
    r = r && traceMessage_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TRACE_MESSAGE_STRING|SML_VARS
  private static boolean traceMessage_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "traceMessage_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, TRACE_MESSAGE_STRING);
    if (!r) r = consumeToken(b, SML_VARS);
    return r;
  }

}

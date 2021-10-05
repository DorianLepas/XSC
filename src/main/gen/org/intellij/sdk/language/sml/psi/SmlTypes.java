// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.sml.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.sml.psi.impl.*;

public interface SmlTypes {

  IElementType ALARM_BLOCK = new SmlElementType("ALARM_BLOCK");
  IElementType ALIAS_BLOCK = new SmlElementType("ALIAS_BLOCK");
  IElementType BIND = new SmlElementType("BIND");
  IElementType BINDING_BLOCK = new SmlElementType("BINDING_BLOCK");
  IElementType CALL_JAVA_FUNCTION_INSTRUCTION = new SmlElementType("CALL_JAVA_FUNCTION_INSTRUCTION");
  IElementType CONDITIONS = new SmlElementType("CONDITIONS");
  IElementType CONDITION_BLOCK = new SmlElementType("CONDITION_BLOCK");
  IElementType CONSUME_EVENT_INSTRUCTION = new SmlElementType("CONSUME_EVENT_INSTRUCTION");
  IElementType ELSE_BLOCK = new SmlElementType("ELSE_BLOCK");
  IElementType ELSE_IF_BLOCK = new SmlElementType("ELSE_IF_BLOCK");
  IElementType ENTER_BLOCK = new SmlElementType("ENTER_BLOCK");
  IElementType EVENTS_DEFINITION = new SmlElementType("EVENTS_DEFINITION");
  IElementType EVENT_BLOCK = new SmlElementType("EVENT_BLOCK");
  IElementType EXEC_END_INSTRUCTION = new SmlElementType("EXEC_END_INSTRUCTION");
  IElementType EXIT_BLOCK = new SmlElementType("EXIT_BLOCK");
  IElementType GOTO_STATE_INSTRUCTION = new SmlElementType("GOTO_STATE_INSTRUCTION");
  IElementType IF_BLOCK = new SmlElementType("IF_BLOCK");
  IElementType IF_CONDITIONS = new SmlElementType("IF_CONDITIONS");
  IElementType JAVASCRIPT = new SmlElementType("JAVASCRIPT");
  IElementType OPTIONS_BLOCK = new SmlElementType("OPTIONS_BLOCK");
  IElementType PROCESS_STATE_INSTRUCTION = new SmlElementType("PROCESS_STATE_INSTRUCTION");
  IElementType SCRIPT_BLOCK = new SmlElementType("SCRIPT_BLOCK");
  IElementType STATE_BLOCK = new SmlElementType("STATE_BLOCK");
  IElementType THREAD_END_INSTRUCTION = new SmlElementType("THREAD_END_INSTRUCTION");
  IElementType THREAD_STATE_INSTRUCTION = new SmlElementType("THREAD_STATE_INSTRUCTION");
  IElementType TRACE_BLOCK = new SmlElementType("TRACE_BLOCK");
  IElementType TRACE_INSTRUCTION = new SmlElementType("TRACE_INSTRUCTION");
  IElementType TRACE_MESSAGE = new SmlElementType("TRACE_MESSAGE");

  IElementType ALARM = new SmlTokenType("ALARM");
  IElementType ALIAS = new SmlTokenType("ALIAS");
  IElementType ALIAS_NAME = new SmlTokenType("ALIAS_NAME");
  IElementType ALL_EVENTS = new SmlTokenType("ALL_EVENTS");
  IElementType BEGIN_BLOCK = new SmlTokenType("BEGIN_BLOCK");
  IElementType BEGIN_PARENTHESE = new SmlTokenType("BEGIN_PARENTHESE");
  IElementType BINDING = new SmlTokenType("BINDING");
  IElementType BINDS = new SmlTokenType("BINDS");
  IElementType BINDS_SEPARATOR = new SmlTokenType("BINDS_SEPARATOR");
  IElementType BIND_NAME = new SmlTokenType("BIND_NAME");
  IElementType CALL = new SmlTokenType("CALL");
  IElementType COMMENT = new SmlTokenType("COMMENT");
  IElementType COMP_CONDS = new SmlTokenType("COMP_CONDS");
  IElementType CONDITION = new SmlTokenType("CONDITION");
  IElementType CONST_CONDS = new SmlTokenType("CONST_CONDS");
  IElementType CONSUME_EVENT = new SmlTokenType("CONSUME_EVENT");
  IElementType DEBUG = new SmlTokenType("DEBUG");
  IElementType ELSE = new SmlTokenType("ELSE");
  IElementType ELSE_IF = new SmlTokenType("ELSE_IF");
  IElementType END_BLOCK = new SmlTokenType("END_BLOCK");
  IElementType END_PARENTHESE = new SmlTokenType("END_PARENTHESE");
  IElementType ENTER = new SmlTokenType("ENTER");
  IElementType EVENT = new SmlTokenType("EVENT");
  IElementType EVENT_NAME = new SmlTokenType("EVENT_NAME");
  IElementType EVENT_NAME_SEPARATOR = new SmlTokenType("EVENT_NAME_SEPARATOR");
  IElementType EXEC_END = new SmlTokenType("EXEC_END");
  IElementType EXIT = new SmlTokenType("EXIT");
  IElementType GOTO_STATE = new SmlTokenType("GOTO_STATE");
  IElementType IDENTIFICATION_KEY = new SmlTokenType("IDENTIFICATION_KEY");
  IElementType IF = new SmlTokenType("IF");
  IElementType JAVASCRIPT_CODE = new SmlTokenType("JAVASCRIPT_CODE");
  IElementType JAVA_FUNCTION_CALL = new SmlTokenType("JAVA_FUNCTION_CALL");
  IElementType LINE_END = new SmlTokenType("LINE_END");
  IElementType MESSAGE = new SmlTokenType("MESSAGE");
  IElementType OPTION = new SmlTokenType("OPTION");
  IElementType OPTIONS = new SmlTokenType("OPTIONS");
  IElementType OP_CONDS = new SmlTokenType("OP_CONDS");
  IElementType PROCESS_STATE = new SmlTokenType("PROCESS_STATE");
  IElementType SCRIPT = new SmlTokenType("SCRIPT");
  IElementType SEPARATOR = new SmlTokenType("SEPARATOR");
  IElementType SML_VARS = new SmlTokenType("SML_VARS");
  IElementType STATE = new SmlTokenType("STATE");
  IElementType STATE_NAME = new SmlTokenType("STATE_NAME");
  IElementType STATE_NAME_SEPARATOR = new SmlTokenType("STATE_NAME_SEPARATOR");
  IElementType THREAD_END = new SmlTokenType("THREAD_END");
  IElementType THREAD_NAME = new SmlTokenType("THREAD_NAME");
  IElementType THREAD_STATE = new SmlTokenType("THREAD_STATE");
  IElementType TRACE = new SmlTokenType("TRACE");
  IElementType TRACE_MESSAGE_SEPARATOR = new SmlTokenType("TRACE_MESSAGE_SEPARATOR");
  IElementType TRACE_MESSAGE_STRING = new SmlTokenType("TRACE_MESSAGE_STRING");
  IElementType WARNING = new SmlTokenType("WARNING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALARM_BLOCK) {
        return new SmlAlarmBlockImpl(node);
      }
      else if (type == ALIAS_BLOCK) {
        return new SmlAliasBlockImpl(node);
      }
      else if (type == BIND) {
        return new SmlBindImpl(node);
      }
      else if (type == BINDING_BLOCK) {
        return new SmlBindingBlockImpl(node);
      }
      else if (type == CALL_JAVA_FUNCTION_INSTRUCTION) {
        return new SmlCallJavaFunctionInstructionImpl(node);
      }
      else if (type == CONDITIONS) {
        return new SmlConditionsImpl(node);
      }
      else if (type == CONDITION_BLOCK) {
        return new SmlConditionBlockImpl(node);
      }
      else if (type == CONSUME_EVENT_INSTRUCTION) {
        return new SmlConsumeEventInstructionImpl(node);
      }
      else if (type == ELSE_BLOCK) {
        return new SmlElseBlockImpl(node);
      }
      else if (type == ELSE_IF_BLOCK) {
        return new SmlElseIfBlockImpl(node);
      }
      else if (type == ENTER_BLOCK) {
        return new SmlEnterBlockImpl(node);
      }
      else if (type == EVENTS_DEFINITION) {
        return new SmlEventsDefinitionImpl(node);
      }
      else if (type == EVENT_BLOCK) {
        return new SmlEventBlockImpl(node);
      }
      else if (type == EXEC_END_INSTRUCTION) {
        return new SmlExecEndInstructionImpl(node);
      }
      else if (type == EXIT_BLOCK) {
        return new SmlExitBlockImpl(node);
      }
      else if (type == GOTO_STATE_INSTRUCTION) {
        return new SmlGotoStateInstructionImpl(node);
      }
      else if (type == IF_BLOCK) {
        return new SmlIfBlockImpl(node);
      }
      else if (type == IF_CONDITIONS) {
        return new SmlIfConditionsImpl(node);
      }
      else if (type == JAVASCRIPT) {
        return new SmlJavascriptImpl(node);
      }
      else if (type == OPTIONS_BLOCK) {
        return new SmlOptionsBlockImpl(node);
      }
      else if (type == PROCESS_STATE_INSTRUCTION) {
        return new SmlProcessStateInstructionImpl(node);
      }
      else if (type == SCRIPT_BLOCK) {
        return new SmlScriptBlockImpl(node);
      }
      else if (type == STATE_BLOCK) {
        return new SmlStateBlockImpl(node);
      }
      else if (type == THREAD_END_INSTRUCTION) {
        return new SmlThreadEndInstructionImpl(node);
      }
      else if (type == THREAD_STATE_INSTRUCTION) {
        return new SmlThreadStateInstructionImpl(node);
      }
      else if (type == TRACE_BLOCK) {
        return new SmlTraceBlockImpl(node);
      }
      else if (type == TRACE_INSTRUCTION) {
        return new SmlTraceInstructionImpl(node);
      }
      else if (type == TRACE_MESSAGE) {
        return new SmlTraceMessageImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface XCSTypes {

  IElementType CE_CORE = new XCSElementType("CE_CORE");
  IElementType CE_LIST = new XCSElementType("CE_LIST");
  IElementType CE_PROPERTY = new XCSElementType("CE_PROPERTY");
  IElementType CE_PROPERTY_ = new XCSElementType("CE_PROPERTY_");
  IElementType COLLECTION_EVENT_SECTION = new XCSElementType("COLLECTION_EVENT_SECTION");
  IElementType FUNCTIONS = new XCSElementType("FUNCTIONS");
  IElementType FUNCTION_CORE = new XCSElementType("FUNCTION_CORE");
  IElementType PROPERTY = new XCSElementType("PROPERTY");
  IElementType PROPERTY_ = new XCSElementType("PROPERTY_");
  IElementType VFEI_SECS_SEQ_SECTION = new XCSElementType("VFEI_SECS_SEQ_SECTION");
  IElementType VSS_CORE = new XCSElementType("VSS_CORE");
  IElementType VSS_LIST = new XCSElementType("VSS_LIST");
  IElementType VSS_LIST_2 = new XCSElementType("VSS_LIST_2");
  IElementType VSS_PROPERTY = new XCSElementType("VSS_PROPERTY");
  IElementType VSS_PROPERTY_ = new XCSElementType("VSS_PROPERTY_");

  IElementType ASCII_TYPE = new XCSTokenType("ASCII_TYPE");
  IElementType ASCII_VALUE = new XCSTokenType("ASCII_VALUE");
  IElementType CEID = new XCSTokenType("CEID");
  IElementType COLLECTION_EVENT = new XCSTokenType("COLLECTION_EVENT");
  IElementType COLON = new XCSTokenType("COLON");
  IElementType COMMENT = new XCSTokenType("COMMENT");
  IElementType CORE_END = new XCSTokenType("CORE_END");
  IElementType CORE_START = new XCSTokenType("CORE_START");
  IElementType EQUALS = new XCSTokenType("EQUALS");
  IElementType FUNCTION_COMMENT = new XCSTokenType("FUNCTION_COMMENT");
  IElementType FUNCTION_CORE_3_0 = new XCSTokenType("FUNCTION_CORE_3_0");
  IElementType FUNCTION_END = new XCSTokenType("FUNCTION_END");
  IElementType FUNCTION_NAME = new XCSTokenType("FUNCTION_NAME");
  IElementType LIST_TYPE = new XCSTokenType("LIST_TYPE");
  IElementType PROPERTY_END = new XCSTokenType("PROPERTY_END");
  IElementType PROPERTY_NAME = new XCSTokenType("PROPERTY_NAME");
  IElementType PROPERTY_NAME_CE = new XCSTokenType("PROPERTY_NAME_CE");
  IElementType PROPERTY_NAME_VSS = new XCSTokenType("PROPERTY_NAME_VSS");
  IElementType PROPERTY_START = new XCSTokenType("PROPERTY_START");
  IElementType PROPERTY_VALUE = new XCSTokenType("PROPERTY_VALUE");
  IElementType STREAM_FUNCTION = new XCSTokenType("STREAM_FUNCTION");
  IElementType VARIABLE_NAME = new XCSTokenType("VARIABLE_NAME");
  IElementType VARIABLE_TYPE = new XCSTokenType("VARIABLE_TYPE");
  IElementType VARIABLE_VALUE = new XCSTokenType("VARIABLE_VALUE");
  IElementType VFEI_CMD_ITEM_NAME = new XCSTokenType("VFEI_CMD_ITEM_NAME");
  IElementType VFEI_SECS_SEQ = new XCSTokenType("VFEI_SECS_SEQ");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CE_CORE) {
        return new XCSCeCoreImpl(node);
      }
      else if (type == CE_LIST) {
        return new XCSCeListImpl(node);
      }
      else if (type == CE_PROPERTY) {
        return new XCSCePropertyImpl(node);
      }
      else if (type == CE_PROPERTY_) {
        return new XCSCeProperty_Impl(node);
      }
      else if (type == COLLECTION_EVENT_SECTION) {
        return new XCSCollectionEventSectionImpl(node);
      }
      else if (type == FUNCTIONS) {
        return new XCSFunctionsImpl(node);
      }
      else if (type == FUNCTION_CORE) {
        return new XCSFunctionCoreImpl(node);
      }
      else if (type == PROPERTY) {
        return new XCSPropertyImpl(node);
      }
      else if (type == PROPERTY_) {
        return new XCSProperty_Impl(node);
      }
      else if (type == VFEI_SECS_SEQ_SECTION) {
        return new XCSVfeiSecsSeqSectionImpl(node);
      }
      else if (type == VSS_CORE) {
        return new XCSVssCoreImpl(node);
      }
      else if (type == VSS_LIST) {
        return new XCSVssListImpl(node);
      }
      else if (type == VSS_LIST_2) {
        return new XCSVssList2Impl(node);
      }
      else if (type == VSS_PROPERTY) {
        return new XCSVssPropertyImpl(node);
      }
      else if (type == VSS_PROPERTY_) {
        return new XCSVssProperty_Impl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

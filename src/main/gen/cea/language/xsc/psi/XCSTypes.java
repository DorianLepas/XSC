// This is a generated file. Not intended for manual editing.
package cea.language.xsc.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import cea.language.xsc.psi.impl.*;

public interface XCSTypes {

  IElementType ASCII_VALUES_4 = new XCSElementType("ASCII_VALUES_4");
  IElementType ASCII_VALUES_5 = new XCSElementType("ASCII_VALUES_5");
  IElementType CE_CORE = new XCSElementType("CE_CORE");
  IElementType CE_LIST = new XCSElementType("CE_LIST");
  IElementType CE_PROPERTY = new XCSElementType("CE_PROPERTY");
  IElementType CE_PROPERTY_ = new XCSElementType("CE_PROPERTY_");
  IElementType COLLECTION_EVENT_SECTION = new XCSElementType("COLLECTION_EVENT_SECTION");
  IElementType DATA_VARIABLE_SECTION = new XCSElementType("DATA_VARIABLE_SECTION");
  IElementType DV_CORE = new XCSElementType("DV_CORE");
  IElementType DV_LIST = new XCSElementType("DV_LIST");
  IElementType DV_PROPERTY = new XCSElementType("DV_PROPERTY");
  IElementType DV_PROPERTY_ = new XCSElementType("DV_PROPERTY_");
  IElementType EC_CORE = new XCSElementType("EC_CORE");
  IElementType EC_LIST = new XCSElementType("EC_LIST");
  IElementType EC_PROPERTY = new XCSElementType("EC_PROPERTY");
  IElementType EC_PROPERTY_ = new XCSElementType("EC_PROPERTY_");
  IElementType EQUIPMENT_CONSTANT_SECTION = new XCSElementType("EQUIPMENT_CONSTANT_SECTION");
  IElementType EVENTS_CORE = new XCSElementType("EVENTS_CORE");
  IElementType EVENTS_SECTION = new XCSElementType("EVENTS_SECTION");
  IElementType FUNCTIONS = new XCSElementType("FUNCTIONS");
  IElementType FUNCTION_CORE = new XCSElementType("FUNCTION_CORE");
  IElementType PROPERTY = new XCSElementType("PROPERTY");
  IElementType PROPERTY_ = new XCSElementType("PROPERTY_");
  IElementType SCENARIOS_CORE = new XCSElementType("SCENARIOS_CORE");
  IElementType SCENARIOS_SECTION = new XCSElementType("SCENARIOS_SECTION");
  IElementType SECS_ITEM_TYPE_SECTION = new XCSElementType("SECS_ITEM_TYPE_SECTION");
  IElementType SIT_CORE = new XCSElementType("SIT_CORE");
  IElementType SIT_LIST = new XCSElementType("SIT_LIST");
  IElementType STANDART_SECTIONS = new XCSElementType("STANDART_SECTIONS");
  IElementType STATUS_VARIABLE_SECTION = new XCSElementType("STATUS_VARIABLE_SECTION");
  IElementType SV_CORE = new XCSElementType("SV_CORE");
  IElementType SV_LIST = new XCSElementType("SV_LIST");
  IElementType SV_PROPERTY = new XCSElementType("SV_PROPERTY");
  IElementType SV_PROPERTY_ = new XCSElementType("SV_PROPERTY_");
  IElementType VFEI_SECS_SEQ_SECTION = new XCSElementType("VFEI_SECS_SEQ_SECTION");
  IElementType VSS_CORE = new XCSElementType("VSS_CORE");
  IElementType VSS_LIST = new XCSElementType("VSS_LIST");
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
  IElementType DATA_VARIABLE = new XCSTokenType("DATA_VARIABLE");
  IElementType DVID = new XCSTokenType("DVID");
  IElementType ECID = new XCSTokenType("ECID");
  IElementType EQUALS = new XCSTokenType("EQUALS");
  IElementType EQUIPMENT_CONSTANT = new XCSTokenType("EQUIPMENT_CONSTANT");
  IElementType EVENTS = new XCSTokenType("EVENTS");
  IElementType EVENTS_CORE_2_0 = new XCSTokenType("EVENTS_CORE_2_0");
  IElementType FUNCTION_COMMENT = new XCSTokenType("FUNCTION_COMMENT");
  IElementType FUNCTION_END = new XCSTokenType("FUNCTION_END");
  IElementType FUNCTION_NAME = new XCSTokenType("FUNCTION_NAME");
  IElementType LIST_TYPE = new XCSTokenType("LIST_TYPE");
  IElementType PROPERTY_END = new XCSTokenType("PROPERTY_END");
  IElementType PROPERTY_NAME = new XCSTokenType("PROPERTY_NAME");
  IElementType PROPERTY_NAME_CE = new XCSTokenType("PROPERTY_NAME_CE");
  IElementType PROPERTY_NAME_DV = new XCSTokenType("PROPERTY_NAME_DV");
  IElementType PROPERTY_NAME_EC = new XCSTokenType("PROPERTY_NAME_EC");
  IElementType PROPERTY_NAME_SV = new XCSTokenType("PROPERTY_NAME_SV");
  IElementType PROPERTY_NAME_VSS = new XCSTokenType("PROPERTY_NAME_VSS");
  IElementType PROPERTY_START = new XCSTokenType("PROPERTY_START");
  IElementType PROPERTY_VALUE = new XCSTokenType("PROPERTY_VALUE");
  IElementType SCENARIOS = new XCSTokenType("SCENARIOS");
  IElementType SCENARIOS_CORE_2_0 = new XCSTokenType("SCENARIOS_CORE_2_0");
  IElementType SECS_ITEM_TYPE = new XCSTokenType("SECS_ITEM_TYPE");
  IElementType STANDART_SECTION = new XCSTokenType("STANDART_SECTION");
  IElementType STATUS_VARIABLE = new XCSTokenType("STATUS_VARIABLE");
  IElementType STREAM_FUNCTION = new XCSTokenType("STREAM_FUNCTION");
  IElementType SVID = new XCSTokenType("SVID");
  IElementType VARIABLE_NAME = new XCSTokenType("VARIABLE_NAME");
  IElementType VARIABLE_TYPE = new XCSTokenType("VARIABLE_TYPE");
  IElementType VARIABLE_VALUE = new XCSTokenType("VARIABLE_VALUE");
  IElementType VFEI_CMD_ITEM_NAME = new XCSTokenType("VFEI_CMD_ITEM_NAME");
  IElementType VFEI_SECS_SEQ = new XCSTokenType("VFEI_SECS_SEQ");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASCII_VALUES_4) {
        return new XCSAsciiValues4Impl(node);
      }
      else if (type == ASCII_VALUES_5) {
        return new XCSAsciiValues5Impl(node);
      }
      else if (type == CE_CORE) {
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
      else if (type == DATA_VARIABLE_SECTION) {
        return new XCSDataVariableSectionImpl(node);
      }
      else if (type == DV_CORE) {
        return new XCSDvCoreImpl(node);
      }
      else if (type == DV_LIST) {
        return new XCSDvListImpl(node);
      }
      else if (type == DV_PROPERTY) {
        return new XCSDvPropertyImpl(node);
      }
      else if (type == DV_PROPERTY_) {
        return new XCSDvProperty_Impl(node);
      }
      else if (type == EC_CORE) {
        return new XCSEcCoreImpl(node);
      }
      else if (type == EC_LIST) {
        return new XCSEcListImpl(node);
      }
      else if (type == EC_PROPERTY) {
        return new XCSEcPropertyImpl(node);
      }
      else if (type == EC_PROPERTY_) {
        return new XCSEcProperty_Impl(node);
      }
      else if (type == EQUIPMENT_CONSTANT_SECTION) {
        return new XCSEquipmentConstantSectionImpl(node);
      }
      else if (type == EVENTS_CORE) {
        return new XCSEventsCoreImpl(node);
      }
      else if (type == EVENTS_SECTION) {
        return new XCSEventsSectionImpl(node);
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
      else if (type == SCENARIOS_CORE) {
        return new XCSScenariosCoreImpl(node);
      }
      else if (type == SCENARIOS_SECTION) {
        return new XCSScenariosSectionImpl(node);
      }
      else if (type == SECS_ITEM_TYPE_SECTION) {
        return new XCSSecsItemTypeSectionImpl(node);
      }
      else if (type == SIT_CORE) {
        return new XCSSitCoreImpl(node);
      }
      else if (type == SIT_LIST) {
        return new XCSSitListImpl(node);
      }
      else if (type == STANDART_SECTIONS) {
        return new XCSStandartSectionsImpl(node);
      }
      else if (type == STATUS_VARIABLE_SECTION) {
        return new XCSStatusVariableSectionImpl(node);
      }
      else if (type == SV_CORE) {
        return new XCSSvCoreImpl(node);
      }
      else if (type == SV_LIST) {
        return new XCSSvListImpl(node);
      }
      else if (type == SV_PROPERTY) {
        return new XCSSvPropertyImpl(node);
      }
      else if (type == SV_PROPERTY_) {
        return new XCSSvProperty_Impl(node);
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

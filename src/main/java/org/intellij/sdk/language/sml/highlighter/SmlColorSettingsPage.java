package org.intellij.sdk.language.sml.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.intellij.sdk.language.sml.fileType.SmlIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;
import java.util.Map;

public class SmlColorSettingsPage implements ColorSettingsPage
{
  // Inner classes

  // Instance fields
  private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
          new AttributesDescriptor("Bad Value", SmlSyntaxHighlighter.BAD_CHARACTER),
          new AttributesDescriptor("Comments", SmlSyntaxHighlighter.COMMENT),
          new AttributesDescriptor("Condition constants", SmlSyntaxHighlighter.CONDITION_CONSTANTES),
          new AttributesDescriptor("Event definitions and event names", SmlSyntaxHighlighter.EVENT_DEFINITIONS),
          new AttributesDescriptor("State names", SmlSyntaxHighlighter.STATE_NAMES),
          new AttributesDescriptor("Variables", SmlSyntaxHighlighter.VARIABLES),
          new AttributesDescriptor("Trace messages", SmlSyntaxHighlighter.TRACE_MESSAGES)
  };

  // Static code

  // Constructors

  // Methods
  @Nullable
  @Override
  public Icon getIcon() {
    return SmlIcons.FILE;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new SmlSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return "/* File COMPLUS_4T.sml\n"+
           " * Copyright (c) CEA-LETI. All rights reserved.\n"+
            "* Unauthorized use, duplication or distribution is strictly prohibited by law.\n"+
            "*/\n"+
            "state:Initial {\n"+
            "  enter {\n"+
            "    call Equipment.initControlState(false)\n"+
            "  }\n"+
            "}\n"+
            "alarm:'^10[0-7]$' {\n"+
            "  condition {\n"+
            "    #main_process == 123 || \"test\"\n"+
            "  }\n"+
            "  WARNING \"\\n    the waffer's current position has to be WAF_ETU_WAY_IN instead of \" + #state + \" before going to WAF_LLK_IN\"\n"+
            "  call EquipmentManager.logAlarm(#event)\n"+
            "}\n"+"!";
}

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

  @NotNull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @NotNull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "Sml";
  }
}

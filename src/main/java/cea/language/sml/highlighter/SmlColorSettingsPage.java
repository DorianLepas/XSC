package cea.language.sml.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import cea.language.sml.fileType.SmlIcons;
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
          new AttributesDescriptor("Condition Constants", SmlSyntaxHighlighter.CONDITION_CONSTANTES),
          new AttributesDescriptor("Event Definitions And Event Names", SmlSyntaxHighlighter.EVENT_DEFINITIONS),
          new AttributesDescriptor("State Names", SmlSyntaxHighlighter.STATE_NAMES),
          new AttributesDescriptor("Variables", SmlSyntaxHighlighter.VARIABLES),
          new AttributesDescriptor("Trace Messages", SmlSyntaxHighlighter.TRACE_MESSAGES),
          new AttributesDescriptor("Keywords", SmlSyntaxHighlighter.KEYWORDS),
          new AttributesDescriptor("Java Function Calls", SmlSyntaxHighlighter.JAVA_FUNCTION)
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

  @Override
  public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @Override
  public ColorDescriptor @NotNull [] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "Sml";
  }
}

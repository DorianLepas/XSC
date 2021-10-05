package org.intellij.sdk.language.xsc;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class XCSColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Colon", XCSSyntaxHighLighter.COLON),
            new AttributesDescriptor("Core Borders", XCSSyntaxHighLighter.CORE_START_END),
            new AttributesDescriptor("Equals", XCSSyntaxHighLighter.PROPERTY_EQUALS),
            new AttributesDescriptor("Function Comment", XCSSyntaxHighLighter.FUNCTION_COMMENT),
            new AttributesDescriptor("Function End Dot", XCSSyntaxHighLighter.FUNCTION_END),
            new AttributesDescriptor("Function Name", XCSSyntaxHighLighter.FUNCTION_NAME),
            new AttributesDescriptor("Line Comment", XCSSyntaxHighLighter.COMMENT),
            new AttributesDescriptor("Predefined Names", XCSSyntaxHighLighter.NAMES),
            new AttributesDescriptor("Property Borders", XCSSyntaxHighLighter.PROPERTY_START_END),
            new AttributesDescriptor("Property Name", XCSSyntaxHighLighter.PROPERTY_NAME),
            new AttributesDescriptor("Property Value", XCSSyntaxHighLighter.PROPERTY_VALUE),
            new AttributesDescriptor("Section Standart", XCSSyntaxHighLighter.SECTION_STANDART),
            new AttributesDescriptor("Stream Function", XCSSyntaxHighLighter.STREAM_FUNCTION),
            new AttributesDescriptor("Variable Name", XCSSyntaxHighLighter.VARIABLE_NAME),
            new AttributesDescriptor("Variable Type", XCSSyntaxHighLighter.VARIABLE_TYPE),
            new AttributesDescriptor("Variable Value", XCSSyntaxHighLighter.VARIABLE_VALUE)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return XCSIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new XCSSyntaxHighLighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "// You are reading the demo text\n" +
                "EDER_DISABLE_ALL: S2F37 W * Disable all event report\n" +
                "<L[2] L2\n" +
                "    <Boolean CEED false> * Collection event disable code\n" +
                "    <L[0] CollectionEventIdList\n" +
                "    >\n" +
                ">\n" +
                ".\n" +
                "\n" +
                "COLLECTIONEVENT_VARIABLES:\n" +
                "<L\n" +
                "   <V CEID {VfeiName=\"GemPPChangeEvent\" EventLevel8=\"Report\"} '1' >\n" +
                "   <V CEID {VfeiName=\"GemEquipmentOFFLINE\" EventLevel8=\"Report\"} '3' >\n" +
                ">\n" +
                ".\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "XSC";
    }
}

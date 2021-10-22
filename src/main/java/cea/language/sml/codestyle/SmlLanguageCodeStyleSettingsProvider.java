package cea.language.sml.codestyle;

import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.application.options.SmartIndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import cea.language.sml.fileType.SmlLanguage;
import org.jetbrains.annotations.NotNull;

public class SmlLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    @NotNull
    @Override
    public Language getLanguage() {
        return SmlLanguage.INSTANCE;
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
    }

    @Override
    protected void customizeDefaults(@NotNull CommonCodeStyleSettings commonSettings,
                                     @NotNull CommonCodeStyleSettings.IndentOptions indentOptions) {
        commonSettings.setForceArrangeMenuAvailable(true);
        indentOptions.TAB_SIZE = 2;
        indentOptions.INDENT_SIZE = 2;
        indentOptions.CONTINUATION_INDENT_SIZE = 4;
    }

    @Override
    public IndentOptionsEditor getIndentOptionsEditor() {
        return new SmartIndentOptionsEditor();
    }

    @Override
    public String getCodeSample(@NotNull SettingsType settingsType) {
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
}

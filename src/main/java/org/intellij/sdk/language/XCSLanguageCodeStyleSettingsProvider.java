package org.intellij.sdk.language;

import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.application.options.SmartIndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import com.intellij.util.PlatformUtils;
import org.jetbrains.annotations.NotNull;

public class XCSLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    @NotNull
    @Override
    public Language getLanguage() {
        return XCSLanguage.INSTANCE;
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
    }

    @Override
    protected void customizeDefaults(@NotNull CommonCodeStyleSettings commonSettings,
                                     @NotNull CommonCodeStyleSettings.IndentOptions indentOptions) {
        commonSettings.setForceArrangeMenuAvailable(true);
        indentOptions.TAB_SIZE=2;
        indentOptions.INDENT_SIZE = 2;
        indentOptions.CONTINUATION_INDENT_SIZE=4;
    }

    @Override
    public IndentOptionsEditor getIndentOptionsEditor() {
        return new SmartIndentOptionsEditor();
    }

    @Override
    public String getCodeSample(@NotNull SettingsType settingsType) {
        return "R: S1F1 W * Are you there request\n" +
                ".\n\n" +
                "EDER_ENABLE_ALL: S2F37 W * Enable all event report\n" +
                "<L[2] L2\n" +
                "<Boolean CEED true> * Collection event enable code\n" +
                "<L[0] CollectionEventIdList\n" +
                ">\n" +
                ">\n" +
                ".\n\n" +
                "LER_INIT_LR: S2F35 W * Link Report LOCAL_REMOTE\n" +
                "<L\n" +
                "<U4 2 >\n" +
                "<L\n" +
                "<L\n" +
                "<U4 4 >\n" +
                "<L\n" +
                "<U4 10000 >\n" +
                ">\n" +
                ">\n" +
                "<L\n" +
                "<U4 5 >\n" +
                "<L\n" +
                "<U4 10000 >\n" +
                ">\n" +
                ">\n" +
                ">\n" +
                ">\n" +
                ".";
    }

}

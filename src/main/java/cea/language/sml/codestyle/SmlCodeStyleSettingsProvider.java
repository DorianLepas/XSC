package cea.language.sml.codestyle;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import cea.language.sml.fileType.SmlLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SmlCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

    @Override
    public CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
        return new SmlCodeStyleSettings(settings);
    }

    @Nullable
    @Override
    public String getConfigurableDisplayName() {
        return "Sml";
    }

    @NotNull
    public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleSettings modelSettings) {
        return new CodeStyleAbstractConfigurable(settings, modelSettings, this.getConfigurableDisplayName()) {
            @Override
            protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
                return new SmlCodeStyleSettingsProvider.SmlCodeStyleMainPanel(getCurrentSettings(), settings);
            }
        };
    }

    private static class SmlCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {

        public SmlCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
            super(SmlLanguage.INSTANCE, currentSettings, settings);
        }

    }

}

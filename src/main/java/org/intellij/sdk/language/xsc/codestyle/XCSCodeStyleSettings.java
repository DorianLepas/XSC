package org.intellij.sdk.language.xsc.codestyle;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class XCSCodeStyleSettings extends CustomCodeStyleSettings {

    public XCSCodeStyleSettings(CodeStyleSettings settings) {
        super("XCSCodeStyleSettings", settings);
    }

}
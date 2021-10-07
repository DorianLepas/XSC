package org.intellij.sdk.language.xsc.filetype;

import com.intellij.lang.Language;

public class XCSLanguage extends Language{
    public static final XCSLanguage INSTANCE = new XCSLanguage();

    private XCSLanguage() {
        super("XSC");
    }
}

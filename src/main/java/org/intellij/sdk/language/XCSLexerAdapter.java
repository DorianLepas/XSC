package org.intellij.sdk.language;

import com.intellij.lexer.FlexAdapter;

public class XCSLexerAdapter extends FlexAdapter {

    public XCSLexerAdapter() {
        super(new XCSLexer(null));
    }

}
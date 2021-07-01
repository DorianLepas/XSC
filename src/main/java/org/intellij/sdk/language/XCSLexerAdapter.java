package org.intellij.sdk.language;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class XCSLexerAdapter extends FlexAdapter {

    public XCSLexerAdapter() {
        super(new XCSLexer(null));
    }

}
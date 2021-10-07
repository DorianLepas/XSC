package org.intellij.sdk.language.xsc.lexer;

import com.intellij.lexer.FlexAdapter;
import org.intellij.sdk.language.xsc.XCSLexer;

public class XCSLexerAdapter extends FlexAdapter {

    public XCSLexerAdapter() {
        super(new XCSLexer(null));
    }

}
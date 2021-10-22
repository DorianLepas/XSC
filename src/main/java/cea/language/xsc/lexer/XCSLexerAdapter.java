package cea.language.xsc.lexer;

import com.intellij.lexer.FlexAdapter;
import cea.language.xsc.XCSLexer;

public class XCSLexerAdapter extends FlexAdapter {

    public XCSLexerAdapter() {
        super(new XCSLexer(null));
    }

}
package cea.language.xsc.psi;

import cea.language.xsc.filetype.XCSLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class XCSElementType extends IElementType {

    public XCSElementType(@NotNull @NonNls String debugName) {
        super(debugName, XCSLanguage.INSTANCE);
    }

}

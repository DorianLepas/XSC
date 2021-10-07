
package org.intellij.sdk.language.xsc.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.xsc.filetype.XCSLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class XCSTokenType extends IElementType {

    public XCSTokenType(@NotNull @NonNls String debugName) {
        super(debugName, XCSLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "XCSTokenType." + super.toString();
    }

}
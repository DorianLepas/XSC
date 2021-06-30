package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.XCSLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class XCSElementType extends IElementType {

    public XCSElementType(@NotNull @NonNls String debugName) {
        super(debugName, XCSLanguage.INSTANCE);
    }

}

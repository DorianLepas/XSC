package org.intellij.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.intellij.sdk.language.XCSFileType;
import org.intellij.sdk.language.XCSLanguage;
import org.jetbrains.annotations.NotNull;

public class XCSFile extends PsiFileBase {

    public XCSFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, XCSLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return XCSFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "XCS File";
    }

}

package org.intellij.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class XCSFileType extends LanguageFileType {

    public static final XCSFileType INSTANCE = new XCSFileType();

    private XCSFileType() {
        super(XCSLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "XSC";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "XSC language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "xsc";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return XCSIcons.FILE;
    }

}

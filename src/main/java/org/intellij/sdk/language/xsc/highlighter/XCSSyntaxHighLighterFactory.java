package org.intellij.sdk.language.xsc.highlighter;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.intellij.sdk.language.xsc.highlighter.XCSSyntaxHighLighter;
import org.jetbrains.annotations.NotNull;

public class XCSSyntaxHighLighterFactory extends SyntaxHighlighterFactory {
    @Override
    public @NotNull SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
        return new XCSSyntaxHighLighter();
    }
}
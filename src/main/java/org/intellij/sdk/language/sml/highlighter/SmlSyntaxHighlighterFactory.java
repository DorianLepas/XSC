package org.intellij.sdk.language.sml.highlighter;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class SmlSyntaxHighlighterFactory extends SyntaxHighlighterFactory
{
  // Inner classes

  // Instance fields

  // Static code

  // Constructors

  // Methods
  @NotNull
  @Override
  public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
    return new SmlSyntaxHighlighter();
  }
}

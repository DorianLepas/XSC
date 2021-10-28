package cea.language.sml.completion;

import cea.language.sml.psi.SmlTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class SmlCompletionContributor extends CompletionContributor {

    public SmlCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeafSkipping(PlatformPatterns.psiElement().whitespace(),PlatformPatterns.psiElement(SmlTypes.BEGIN_BLOCK)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        // Root and inside Block Keywords
                        resultSet.addElement(LookupElementBuilder.create("state"));
                        resultSet.addElement(LookupElementBuilder.create("alias"));
                        resultSet.addElement(LookupElementBuilder.create("alarm"));
                        resultSet.addElement(LookupElementBuilder.create("event"));
                        resultSet.addElement(LookupElementBuilder.create("trace"));
                        resultSet.addElement(LookupElementBuilder.create("script"));
                        // Only inside Block Keywords
                        resultSet.addElement(LookupElementBuilder.create("binding"));
                        resultSet.addElement(LookupElementBuilder.create("enter"));
                        resultSet.addElement(LookupElementBuilder.create("exit"));
                        resultSet.addElement(LookupElementBuilder.create("option"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeafSkipping(PlatformPatterns.psiElement().whitespace(),PlatformPatterns.psiElement(SmlTypes.END_BLOCK)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        // Root and inside Block Keywords
                        resultSet.addElement(LookupElementBuilder.create("state"));
                        resultSet.addElement(LookupElementBuilder.create("alias"));
                        resultSet.addElement(LookupElementBuilder.create("alarm"));
                        resultSet.addElement(LookupElementBuilder.create("event"));
                        resultSet.addElement(LookupElementBuilder.create("trace"));
                        resultSet.addElement(LookupElementBuilder.create("script"));
                        // Only inside Block Keywords
                        resultSet.addElement(LookupElementBuilder.create("binding"));
                        resultSet.addElement(LookupElementBuilder.create("enter"));
                        resultSet.addElement(LookupElementBuilder.create("exit"));
                        resultSet.addElement(LookupElementBuilder.create("option"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement element = parameters.getOriginalPosition();
                        // Start a new block
                        if (element.getPrevSibling() == null){
                            resultSet.addElement(LookupElementBuilder.create("state"));
                            resultSet.addElement(LookupElementBuilder.create("alias"));
                            resultSet.addElement(LookupElementBuilder.create("alarm"));
                            resultSet.addElement(LookupElementBuilder.create("event"));
                            resultSet.addElement(LookupElementBuilder.create("trace"));
                            resultSet.addElement(LookupElementBuilder.create("script"));
                        }
                    }
                }
        );
    }
}

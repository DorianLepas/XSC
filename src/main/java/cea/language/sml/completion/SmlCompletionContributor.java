package cea.language.sml.completion;

import cea.language.sml.psi.SmlEventsValue;
import cea.language.sml.psi.SmlFile;
import cea.language.sml.psi.SmlTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class SmlCompletionContributor extends CompletionContributor {

    public SmlCompletionContributor() {
        // After {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeafSkipping(PlatformPatterns.psiElement().whitespace(),PlatformPatterns.psiElement(SmlTypes.BEGIN_BLOCK)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        // Root and inside Block Keywords
                        resultSet.addElement(LookupElementBuilder.create("state")
                                .withTypeText("Block Keyword"));
                        resultSet.addElement(LookupElementBuilder.create("alias")
                                .withTypeText("Block Keyword"));
                        resultSet.addElement(LookupElementBuilder.create("alarm")
                                .withTypeText("Block Keyword"));
                        resultSet.addElement(LookupElementBuilder.create("event")
                                .withTypeText("Block Keyword"));
                        resultSet.addElement(LookupElementBuilder.create("trace")
                                .withTypeText("Block Keyword"));
                        resultSet.addElement(LookupElementBuilder.create("script")
                                .withTypeText("Block Keyword"));
                        // Only inside Block Keywords
                        resultSet.addElement(LookupElementBuilder.create("binding")
                                .withTypeText("Block Keyword"));
                        resultSet.addElement(LookupElementBuilder.create("enter")
                                .withTypeText("Block Keyword"));
                        resultSet.addElement(LookupElementBuilder.create("exit")
                                .withTypeText("Block Keyword"));
                        resultSet.addElement(LookupElementBuilder.create("option")
                                .withTypeText("Block Keyword"));
                        // Only inside Block Instructions
                        resultSet.addElement(LookupElementBuilder.create("goto state")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("process state")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("call")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("thread state")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("thread_end")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("exec_end")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("consume_event")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("MESSAGE")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("DEBUG")
                                .withTypeText("Instruction"));
                        resultSet.addElement(LookupElementBuilder.create("WARNING")
                                .withTypeText("Instruction"));
                        // Only inside Block Instruction Blocks
                        resultSet.addElement(LookupElementBuilder.create("condition")
                                .withTypeText("Instruction Block"));
                        resultSet.addElement(LookupElementBuilder.create("if ()")
                                .withPresentableText("if")
                                .withTypeText("Instruction Block"));
                        resultSet.addElement(LookupElementBuilder.create("else if ()")
                                .withPresentableText("else if")
                                .withTypeText("Instruction Block"));
                        resultSet.addElement(LookupElementBuilder.create("else")
                                .withTypeText("Instruction Block"));
                        resultSet.addElement(LookupElementBuilder.create("script")
                                .withTypeText("Instruction Block"));
                        resultSet.addElement(LookupElementBuilder.create("binding")
                                .withTypeText("Instruction Block"));
                    }
                }
        );

        // After }
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeafSkipping(PlatformPatterns.psiElement().whitespaceCommentOrError().and(PlatformPatterns.psiElement().withName("BAD_CHARACTER")),PlatformPatterns.psiElement(SmlTypes.END_BLOCK)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement element = parameters.getOriginalPosition();
                        if (element != null && !(element.getParent().getParent() instanceof SmlFile && element.getParent().getFirstChild() == element)) {
                            // Root and inside Block Keywords
                            resultSet.addElement(LookupElementBuilder.create("state")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("alias")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("alarm")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("event")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("trace")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("script")
                                    .withTypeText("Block Keyword"));
                            // Only inside Block Keywords
                            resultSet.addElement(LookupElementBuilder.create("binding")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("enter")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("exit")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("option")
                                    .withTypeText("Block Keyword"));
                            // Only inside Block Instructions
                            resultSet.addElement(LookupElementBuilder.create("goto state")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("process state")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("call")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("thread state")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("thread_end")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("exec_end")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("consume_event")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("MESSAGE")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("DEBUG")
                                    .withTypeText("Instruction"));
                            resultSet.addElement(LookupElementBuilder.create("WARNING")
                                    .withTypeText("Instruction"));
                            // Only inside Block Instruction Blocks
                            resultSet.addElement(LookupElementBuilder.create("condition")
                                    .withTypeText("Instruction Block"));
                            resultSet.addElement(LookupElementBuilder.create("if ()")
                                    .withPresentableText("if")
                                    .withTypeText("Instruction Block"));
                            resultSet.addElement(LookupElementBuilder.create("else if ()")
                                    .withPresentableText("else if")
                                    .withTypeText("Instruction Block"));
                            resultSet.addElement(LookupElementBuilder.create("else")
                                    .withTypeText("Instruction Block"));
                            resultSet.addElement(LookupElementBuilder.create("script")
                                    .withTypeText("Instruction Block"));
                            resultSet.addElement(LookupElementBuilder.create("binding")
                                    .withTypeText("Instruction Block"));
                        }
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
                        if (element != null && element.getParent().getParent() instanceof SmlFile && element.getParent().getFirstChild() == element) {
                            resultSet.addElement(LookupElementBuilder.create("state")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("alias")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("alarm")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("event")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("trace")
                                    .withTypeText("Block Keyword"));
                            resultSet.addElement(LookupElementBuilder.create("script")
                                    .withTypeText("Block Keyword"));
                        }

                        // Check if the element is an instance of SmlEventsValue
                        if ( element != null &&
                                element.getNode().getElementType().toString().equals("SmlTokenType.EVENT_NAME") &&
                                element.getNode().getTreeParent().getElementType().toString().equals("EventsDefinition")){
                            SmlEventsValue e = (SmlEventsValue) element.getNode().getTreeParent().getPsi();
                            // Search for the element to complete with
                            Object[] result = e.getReference().getVariants();
                            for (Object LUElement : result){
                                resultSet.addElement((LookupElement) LUElement);
                            }
                        }
                    }
                }
        );
    }
}

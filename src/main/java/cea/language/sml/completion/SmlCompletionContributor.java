package cea.language.sml.completion;

import cea.language.sml.psi.*;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SmlCompletionContributor extends CompletionContributor {

    public SmlCompletionContributor() {
        // After {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeafSkipping(PlatformPatterns.psiElement().whitespace(), PlatformPatterns.psiElement(SmlTypes.BEGIN_BLOCK)),
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
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeafSkipping(PlatformPatterns.psiElement().whitespace(), PlatformPatterns.psiElement(SmlTypes.END_BLOCK)),
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
                        } else {
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
                        }
                        // Check if the element is an instance of SmlEventsValue
                        if (element != null &&
                                element.getNode().getElementType() == SmlTypes.EVENT_NAME) {
                            SmlEventsValue e = (SmlEventsValue) element.getNode().getTreeParent().getPsi();
                            // Search for the element to complete with
                            Object[] result = new Object[0];
                            if (e.getReference() != null) {
                                result = e.getReference().getVariants();
                            }
                            for (Object LUElement : result) {
                                resultSet.addElement((LookupElement) LUElement);
                            }
                            List<LookupElement> variants = new ArrayList<>();
                            List<PsiLiteralExpression> eventDeclaration = SmlUtil.findPropertiesInDeclaration((SmlFile) e.getContainingFile(), e.getProject());
                            for (final PsiLiteralExpression eventDeclaration_ : eventDeclaration) {
                                variants.add(LookupElementBuilder
                                        .create(eventDeclaration_.getText().substring(1, eventDeclaration_.getText().length() - 1))
                                        .withIcon(eventDeclaration_.getContainingFile().getIcon(0))
                                        .withPresentableText(eventDeclaration_.getText().substring(1, eventDeclaration_.getText().length() - 1))
                                        .withTypeText(eventDeclaration_.getContainingFile().getName())
                                );
                            }
                            if (e.getContainingFile().getVirtualFile().getCanonicalPath() != null && e.getContainingFile().getVirtualFile().getCanonicalPath().contains("FFC")) {
                                // Create LookUpElement with element of FFC files
                                List<PsiLiteralExpression> literals = SmlUtil.findPropertiesInEventHandler((SmlFile) e.getContainingFile(), e.getProject());
                                for (final PsiLiteralExpression literals_ : literals) {
                                    variants.add(LookupElementBuilder
                                            .create(literals_.getText().substring(1, literals_.getText().length() - 1))
                                            .withIcon(literals_.getContainingFile().getIcon(0))
                                            .withPresentableText(literals_.getText().substring(1, literals_.getText().length() - 1))
                                            .withTypeText(literals_.getContainingFile().getName())
                                    );
                                }
                            }
                            variants.forEach(resultSet::addElement);
                        }
                        // Check if the element is an instance of SmlCallJavaFunctionInstruction
                        if (element != null &&
                                element.getNode().getElementType() == SmlTypes.JAVA_FUNCTION_CALL &&
                                element.getNode().getTreeParent().getPsi() instanceof SmlCallJavaFunctionInstruction) {
                            SmlCallJavaFunctionInstruction e = (SmlCallJavaFunctionInstruction) element.getNode().getTreeParent().getPsi();
                            // Search for the element to complete with
                            Object[] result = new Object[0];
                            if (e.getReference() != null) {
                                result = e.getReference().getVariants();
                            }
                            for (Object LUElement : result) {
                                resultSet.addElement((LookupElement) LUElement);
                            }
                        }
                    }
                }
        );
    }
}

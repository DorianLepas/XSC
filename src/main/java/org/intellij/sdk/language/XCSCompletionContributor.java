package org.intellij.sdk.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.XCSTypes;
import org.jetbrains.annotations.NotNull;


public class XCSCompletionContributor extends CompletionContributor {

    public XCSCompletionContributor() {

        /*
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.PROPERTY_START)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("VfeiQualifier"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueAlignment"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueWidth"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueToVfeiText"));
                        resultSet.addElement(LookupElementBuilder.create("SecsName"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiValue"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiType"));
                        resultSet.addElement(LookupElementBuilder.create("CheckAck"));
                        resultSet.addElement(LookupElementBuilder.create("AllowedSecsItemValues"));
                        resultSet.addElement(LookupElementBuilder.create("SecsItemsToCheck"));
                        resultSet.addElement(LookupElementBuilder.create("SecsType"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValue"));
                        resultSet.addElement(LookupElementBuilder.create("IsTemplate"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiNameTemplateNames"));
                        resultSet.addElement(LookupElementBuilder.create("ReuseProperties"));
                        resultSet.addElement(LookupElementBuilder.create("ReusePropertiesNoArrays"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceVfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceItems"));
                        resultSet.addElement(LookupElementBuilder.create("SendAsList"));
                        resultSet.addElement(LookupElementBuilder.create("Disabled"));
                        resultSet.addElement(LookupElementBuilder.create("ReplyMatch"));
                        resultSet.addElement(LookupElementBuilder.create("WrapInList"));
                        resultSet.addElement(LookupElementBuilder.create("EventLevel8"));
                    }
                }
        );


        extend(CompletionType.BASIC,PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.PROPERTY_START)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("SecsType"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceVfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceItems"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("EventLevel8"));
                    }
                }
        );

        extend(CompletionType.BASIC,PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.PROPERTY_START)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("VfeiName"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiType"));
                        resultSet.addElement(LookupElementBuilder.create("SecsType"));
                        resultSet.addElement(LookupElementBuilder.create("MinSecsValue"));
                        resultSet.addElement(LookupElementBuilder.create("DefaultSecsValue"));
                    }
                }
        );

        extend(CompletionType.BASIC,PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.PROPERTY_START)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("CheckAck"));
                        resultSet.addElement(LookupElementBuilder.create("SecsItemsToCheck"));
                    }
                }
        );
         */

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(XCSTypes.FUNCTION_NAME).afterSibling(PlatformPatterns.psiElement().whitespace()),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("COLLECTIONEVENT_VARIABLES"));
                        resultSet.addElement(LookupElementBuilder.create("EQUIPMENTCONSTANTS"));
                        resultSet.addElement(LookupElementBuilder.create("SECSIEM_TYPES"));
                        resultSet.addElement(LookupElementBuilder.create("STATUSVARIABLES"));
                        resultSet.addElement(LookupElementBuilder.create("VFEI_SECS_SEQUENCES"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.CORE_START)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("U1"));
                        resultSet.addElement(LookupElementBuilder.create("U2"));
                        resultSet.addElement(LookupElementBuilder.create("U4"));
                        resultSet.addElement(LookupElementBuilder.create("U8"));
                        resultSet.addElement(LookupElementBuilder.create("F4"));
                        resultSet.addElement(LookupElementBuilder.create("F8"));
                        //resultSet.addElement(LookupElementBuilder.create("Boolean"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.ASCII_TYPE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("CEID"));
                        resultSet.addElement(LookupElementBuilder.create("ECID"));
                        resultSet.addElement(LookupElementBuilder.create("SVID"));
                        resultSet.addElement(LookupElementBuilder.create("INITIALIZE"));
                    }
                }
        );

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.VARIABLE_TYPE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("CEID"));
                        resultSet.addElement(LookupElementBuilder.create("ECID"));
                        resultSet.addElement(LookupElementBuilder.create("SVID"));
                        resultSet.addElement(LookupElementBuilder.create("INITIALIZE"));
                    }
                }
        );
    }

}
package cea.language.xsc.completion;

import cea.language.xsc.filetype.XCSLanguage;
import cea.language.xsc.psi.XCSProperty_;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import cea.language.xsc.psi.XCSTypes;
import org.jetbrains.annotations.NotNull;


public class XCSCompletionContributor extends CompletionContributor {

    public XCSCompletionContributor() {
        // Property name completion after { (=first property)
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf("{"),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("AllowedSecsItemValues=\"\"")
                                .withPresentableText("AllowedSecsItemValues")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("CheckAck=\"\"")
                                .withPresentableText("CheckAck")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("Disabled=\"\"")
                                .withPresentableText("Disabled")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("EventLevel8=\"\"")
                                .withPresentableText("EventLevel8")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("IsTemplate=\"\"")
                                .withPresentableText("IsTemplate")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceItems=\"\"")
                                .withPresentableText("ReplaceItems")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceVfeiName=\"\"")
                                .withPresentableText("ReplaceVfeiName")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReplyMatch=\"\"")
                                .withPresentableText("ReplyMatch")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReuseProperties=\"\"")
                                .withPresentableText("ReuseProperties")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReusePropertiesNoArrays=\"\"")
                                .withPresentableText("ReusePropertiesNoArrays")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsItemsToCheck=\"\"")
                                .withPresentableText("SecsItemsToCheck")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsName=\"\"")
                                .withPresentableText("SecsName")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsType=\"\"")
                                .withPresentableText("SecsType")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValue=\"\"")
                                .withPresentableText("SecsValue")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueAlignment=\"\"")
                                .withPresentableText("SecsValueAlignment")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueToVfeiText=\"\"")
                                .withPresentableText("SecsValueToVfeiText")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueWidth=\"\"")
                                .withPresentableText("SecsValueWidth")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SendAsList=\"\"")
                                .withPresentableText("SendAsList")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiName=\"\"")
                                .withPresentableText("VfeiName")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiNameTemplateNames=\"\"")
                                .withPresentableText("VfeiNameTemplateNames")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiQualifier=\"\"")
                                .withPresentableText("VfeiQualifier")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiType=\"\"")
                                .withPresentableText("VfeiType")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiValue=\"\"")
                                .withPresentableText("VfeiValue")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("WrapInList=\"\"")
                                .withPresentableText("WrapInList")
                                .withTypeText("Property"));
                    }
                }
        );

        // Property name completion after an other property (!=first property)
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.PROPERTY_VALUE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("AllowedSecsItemValues=\"\"")
                                .withPresentableText("AllowedSecsItemValues")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("CheckAck=\"\"")
                                .withPresentableText("CheckAck")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("Disabled=\"\"")
                                .withPresentableText("Disabled")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("EventLevel8=\"\"")
                                .withPresentableText("EventLevel8")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("IsTemplate=\"\"")
                                .withPresentableText("IsTemplate")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceItems=\"\"")
                                .withPresentableText("ReplaceItems")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReplaceVfeiName=\"\"")
                                .withPresentableText("ReplaceVfeiName")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReplyMatch=\"\"")
                                .withPresentableText("ReplyMatch")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReuseProperties=\"\"")
                                .withPresentableText("ReuseProperties")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("ReusePropertiesNoArrays=\"\"")
                                .withPresentableText("ReusePropertiesNoArrays")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsItemsToCheck=\"\"")
                                .withPresentableText("SecsItemsToCheck")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsName=\"\"")
                                .withPresentableText("SecsName")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsType=\"\"")
                                .withPresentableText("SecsType")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValue=\"\"")
                                .withPresentableText("SecsValue")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueAlignment=\"\"")
                                .withPresentableText("SecsValueAlignment")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueToVfeiText=\"\"")
                                .withPresentableText("SecsValueToVfeiText")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SecsValueWidth=\"\"")
                                .withPresentableText("SecsValueWidth")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("SendAsList=\"\"")
                                .withPresentableText("SendAsList")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiName=\"\"")
                                .withPresentableText("VfeiName")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiNameTemplateNames=\"\"")
                                .withPresentableText("VfeiNameTemplateNames")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiQualifier=\"\"")
                                .withPresentableText("VfeiQualifier")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiType=\"\"")
                                .withPresentableText("VfeiType")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("VfeiValue=\"\"")
                                .withPresentableText("VfeiValue")
                                .withTypeText("Property"));
                        resultSet.addElement(LookupElementBuilder.create("WrapInList=\"\"")
                                .withPresentableText("WrapInList")
                                .withTypeText("Property"));
                    }
                }
        );

        // Standart section blocks completion
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(XCSTypes.FUNCTION_NAME).afterSibling(PlatformPatterns.psiElement().whitespace()),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("COLLECTIONEVENT_VARIABLES:\n<L\n>\n.")
                                .withPresentableText("COLLECTIONEVENT_VARIABLES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("EQUIPMENTCONSTANTS:\n<L\n>\n.")
                                .withPresentableText("EQUIPMENTCONSTANTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("EVENTS:\n<L\n>\n.")
                                .withPresentableText("EVENTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("FORMATTED_RECIPES:\n<L\n>\n.")
                                .withPresentableText("FORMATTED_RECIPES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("OVERWRITTEN_SECS_STANDARD_MESSAGES:\n<L\n>\n.")
                                .withPresentableText("OVERWRITTEN_SECS_STANDARD_MESSAGES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("POLLING_EVENT_DEFINITIONS:\n<L\n>\n.")
                                .withPresentableText("POLLING_EVENT_DEFINITIONS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("PREDEFINED_FORMATTED_STATUS_LISTS:\n<L\n>\n.")
                                .withPresentableText("PREDEFINED_FORMATTED_STATUS_LISTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("PREDEFINED_UNIQUE_CEID_REPORTS:\n<L\n>\n.")
                                .withPresentableText("PREDEFINED_UNIQUE_CEID_REPORTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("PREDEFINED_UNIQUE_REPORT_ID_REPORTS:\n<L\n>\n.")
                                .withPresentableText("PREDEFINED_UNIQUE_REPORT_ID_REPORTS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("REMOTE_COMMANDS:\n<L\n>\n.")
                                .withPresentableText("REMOTE_COMMANDS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("SCENARIOS:\n<L\n>\n.")
                                .withPresentableText("SCENARIOS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("SECSIEM_TYPES:\n<L\n>\n.")
                                .withPresentableText("SECSIEM_TYPES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("SECSVALUE_TO_VFEITEXTVALUE_VARIABLES:\n<L\n>\n.")
                                .withPresentableText("SECSVALUE_TO_VFEITEXTVALUE_VARIABLES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("STATUSVARIABLES:\n<L\n>\n.")
                                .withPresentableText("STATUSVARIABLES")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("TRACE_DEFINITIONS:\n<L\n>\n.")
                                .withPresentableText("TRACE_DEFINITIONS")
                                .withTypeText("Standart Section"));
                        resultSet.addElement(LookupElementBuilder.create("VFEI_SECS_SEQUENCES:\n<L\n>\n.")
                                .withPresentableText("VFEI_SECS_SEQUENCES")
                                .withTypeText("Standart Section"));
                    }
                }
        );

        // Type completion
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.CORE_START)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("L\n>")
                                .withPresentableText("L")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("V>")
                                .withPresentableText("V")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("A>")
                                .withPresentableText("A")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("B>")
                                .withPresentableText("B")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("F4>")
                                .withPresentableText("F4")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("F8>")
                                .withPresentableText("F8")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("I1>")
                                .withPresentableText("I1")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("I2>")
                                .withPresentableText("I2")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("I4>")
                                .withPresentableText("I4")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("I8>")
                                .withPresentableText("I8")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("U1>")
                                .withPresentableText("U1")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("U2>")
                                .withPresentableText("U2")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("U4>")
                                .withPresentableText("U4")
                                .withTypeText("Type"));
                        resultSet.addElement(LookupElementBuilder.create("U8>")
                                .withPresentableText("U8")
                                .withTypeText("Type"));
                    }
                }
        );

        // Predefined Names completion after ASCII Types
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.ASCII_TYPE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("CEID"));
                        resultSet.addElement(LookupElementBuilder.create("DVID"));
                        resultSet.addElement(LookupElementBuilder.create("ECID"));
                        resultSet.addElement(LookupElementBuilder.create("INITIALIZE"));
                        resultSet.addElement(LookupElementBuilder.create("SVID"));
                    }
                }
        );

        // Predefined Names completion after Types
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf(PlatformPatterns.psiElement(XCSTypes.VARIABLE_TYPE)),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("CEID"));
                        resultSet.addElement(LookupElementBuilder.create("DVID"));
                        resultSet.addElement(LookupElementBuilder.create("ECID"));
                        resultSet.addElement(LookupElementBuilder.create("INITIALIZE"));
                        resultSet.addElement(LookupElementBuilder.create("SVID"));
                    }
                }
        );

        // Property value completion with reference (with getVariants())
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().withLanguage(XCSLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement element = parameters.getOriginalPosition();
                        // Check if the element is an instance of XCSProperty_
                        if ( element != null &&
                                element.getNode().getElementType().toString().equals("XCSTokenType.PROPERTY_VALUE") &&
                                element.getNode().getTreeParent().getElementType().toString().equals("PROPERTY_")){
                            XCSProperty_ e = (XCSProperty_) element.getNode().getTreeParent().getPsi();
                            // Check if the property name is VfeiName
                            if(e.getProp().equals("VfeiName")){
                                // Search for the element to complete with
                                Object[] result = e.getReference().getVariants();
                                for (Object LUElement : result){
                                    resultSet.addElement((LookupElement) LUElement);
                                }
                            }
                        }
                    }
                }
        );
    }
}
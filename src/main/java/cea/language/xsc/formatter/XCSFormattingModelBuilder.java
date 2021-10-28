package cea.language.xsc.formatter;

import cea.language.xsc.filetype.XCSLanguage;
import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import cea.language.xsc.psi.XCSTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class XCSFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, XCSLanguage.INSTANCE)
                // Function Names
                .before(XCSTypes.FUNCTION_NAME).none()
                .between(XCSTypes.FUNCTION_NAME,XCSTypes.COLON).none()
                // Colon
                .between(XCSTypes.COLON,XCSTypes.STREAM_FUNCTION).spaces(1)
                // Comment
                .before(XCSTypes.FUNCTION_COMMENT).spaces(1)
                // Opening core character
                .between(XCSTypes.CORE_START,XCSTypes.VARIABLE_TYPE).none()
                .between(XCSTypes.CORE_START,XCSTypes.LIST_TYPE).none()
                .between(XCSTypes.CORE_START,XCSTypes.ASCII_TYPE).none()
                // Types and variable Names
                .before(XCSTypes.VARIABLE_VALUE).spaces(1)
                .after(XCSTypes.VARIABLE_TYPE).spaces(1)
                .after(XCSTypes.ASCII_TYPE).spaces(1)
                .before(XCSTypes.ASCII_VALUE).spaces(1)
                .after(XCSTypes.LIST_TYPE).spaces(1)
                .before(XCSTypes.VARIABLE_NAME).spaces(1)
                .after(XCSTypes.VARIABLE_NAME).none()
                // Properties
                .before(XCSTypes.PROPERTY_START).spaces(1)
                .after(XCSTypes.PROPERTY_START).none()
                .between(XCSTypes.PROPERTY_NAME,XCSTypes.EQUALS).none()
                .between(XCSTypes.EQUALS,XCSTypes.PROPERTY_VALUE).none()
                .before(XCSTypes.PROPERTY_END).none()
                // Closing core character
                .before(XCSTypes.CORE_END).none()
                // Collection Events
                .before(XCSTypes.COLLECTION_EVENT).none()
                .between(XCSTypes.COLLECTION_EVENT,XCSTypes.COLON).none()
                .between(XCSTypes.PROPERTY_START,XCSTypes.PROPERTY_NAME_CE).none()
                .between(XCSTypes.PROPERTY_NAME_CE,XCSTypes.EQUALS).none()
                // Data Variables
                .before(XCSTypes.DATA_VARIABLE).none()
                .between(XCSTypes.DATA_VARIABLE,XCSTypes.COLON).none()
                .between(XCSTypes.PROPERTY_START,XCSTypes.PROPERTY_NAME_DV).none()
                .between(XCSTypes.PROPERTY_NAME_DV,XCSTypes.EQUALS).none()
                // Secs Item Type
                .before(XCSTypes.SECS_ITEM_TYPE).none()
                .between(XCSTypes.SECS_ITEM_TYPE,XCSTypes.COLON).none()
                // Constants
                .before(XCSTypes.EQUIPMENT_CONSTANT).none()
                .between(XCSTypes.EQUIPMENT_CONSTANT,XCSTypes.COLON).none()
                .between(XCSTypes.PROPERTY_START,XCSTypes.PROPERTY_NAME_EC).none()
                .between(XCSTypes.PROPERTY_NAME_EC,XCSTypes.EQUALS).none()
                // Status Variable
                .before(XCSTypes.STATUS_VARIABLE).none()
                .between(XCSTypes.STATUS_VARIABLE,XCSTypes.COLON).none()
                .between(XCSTypes.PROPERTY_START,XCSTypes.PROPERTY_NAME_SV).none()
                .between(XCSTypes.PROPERTY_NAME_SV,XCSTypes.EQUALS).none()
                // Vfei Secs Sequence
                .before(XCSTypes.VFEI_SECS_SEQ).none()
                .between(XCSTypes.VFEI_SECS_SEQ,XCSTypes.COLON).none()
                .between(XCSTypes.PROPERTY_START,XCSTypes.PROPERTY_NAME_VSS).none()
                .between(XCSTypes.PROPERTY_NAME_VSS,XCSTypes.EQUALS).none()
                // Scenarios
                .before(XCSTypes.SCENARIOS).none()
                .between(XCSTypes.SCENARIOS,XCSTypes.COLON).none()
                // Events
                .before(XCSTypes.EVENTS).none()
                .between(XCSTypes.EVENTS,XCSTypes.COLON).none()
                // Standart Section
                .before(XCSTypes.STANDART_SECTION).none()
                .between(XCSTypes.STANDART_SECTION,XCSTypes.COLON).none()
                // End Dot
                .before(XCSTypes.FUNCTION_END).lineBreakInCode()
                ;
    }



    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        return FormattingModelProvider
                .createFormattingModelForPsiFile(element.getContainingFile(),
                        new XCSBlock(element.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpaceBuilder(settings)),
                        settings);
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }

}

package cea.language.xsc.annotator;

import cea.language.xsc.psi.XCSFunctionCore;
import cea.language.xsc.quickfix.XCSCreatePropertyQuickFix;
import cea.language.xsc.quickfix.XCSCreateReportQuickFix;
import com.intellij.lang.annotation.AnnotationBuilder;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import cea.language.xsc.psi.XCSProperty_;
import org.jetbrains.annotations.NotNull;


public class XCSAnnotator implements Annotator {
    AnnotationBuilder HolderCreation;

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {


        // Search for XCSFunctionCore in Functions with S2F35 stream function at depth 5
        if (element instanceof XCSFunctionCore && ((XCSFunctionCore)element).getSF().equals("S2F35") && ((XCSFunctionCore)element).getDepth() == 5 && ((XCSFunctionCore) element).getValue() != null){
            if (element.getReference().resolve() == null) {
                HolderCreation = holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING, "Undeclared report variable or Declared multiples times")
                        .withFix(new XCSCreateReportQuickFix(((XCSFunctionCore)element).getValue(),element));
                HolderCreation.create();
            }
        }

        // Ensure the Psi Element is a property
        if (!(element instanceof XCSProperty_) || !(element.getFirstChild().getText().equals("VfeiName"))) {
            return;
        }

        // Check if the element has a reference
        if (element.getReference().resolve() == null) {
            // Create a WARNING if the element has 0 or multiple references
            HolderCreation = holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING, "Undeclared property or Declared multiples times")
                    .withFix(new XCSCreatePropertyQuickFix(((XCSProperty_) element).getValue(), element));
            HolderCreation.create();
        }
    }
}

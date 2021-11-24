package cea.language.xsc.reference;

import cea.language.xsc.psi.XCSFunctionCore;
import cea.language.xsc.psi.XCSProperty_;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;


public class XCSReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(XCSProperty_.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        XCSProperty_ e = (XCSProperty_) element;
                        // Only create reference to XCSProperty_ with property names = VfeiName
                        if (!e.getProp().equals("VfeiName")){
                            return PsiReference.EMPTY_ARRAY;
                        }
                        return new PsiReference[]{new XCSPropertyReference(e,
                                new TextRange(e.getText().length()-e.getValue().length(),e.getText().length()),
                                e.getReferenceType())};
                    }
                });

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(XCSFunctionCore.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        XCSFunctionCore e = (XCSFunctionCore) element;
                        if (((XCSFunctionCore) element).getDepth() == 5 && ((XCSFunctionCore) element).getSF().equals("S2F35")) {
                            return new PsiReference[]{new XCSReportReference(e,
                                    new TextRange(e.getText().length() - e.getValue().length() - 1, e.getText().length() - 1))};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }

}

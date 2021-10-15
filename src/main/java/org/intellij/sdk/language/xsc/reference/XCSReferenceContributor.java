package org.intellij.sdk.language.xsc.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.xsc.psi.XCSFile;
import org.intellij.sdk.language.xsc.psi.XCSProperty_;
import org.intellij.sdk.language.xsc.psi.XCSTypes;
import org.jetbrains.annotations.NotNull;

public class XCSReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(XCSTypes.PROPERTY_VALUE),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
                        String value = literalExpression.getValue() instanceof String ?
                                (String) literalExpression.getValue() : null;
                        if ((value != null && value.startsWith("xsc" + ":"))) {
                            TextRange property = new TextRange("xsc".length() + ":".length() + 1,
                                    value.length() + 1);
                            //System.out.println(" value = " + value + "\n property" + property);
                            return new PsiReference[]{new XCSReference(element, property,"CEID")};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }
    /*
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        System.out.println("JE PASSE 1");
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(XCSProperty_.class),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        System.out.println("JE PASSE 2");
                        XCSProperty_ PropName = (XCSProperty_) element;
                        String value = PropName.getValue();
                        if ((value != null)) {
                            TextRange property = new TextRange(0,value.length());
                            System.out.println(" value = " + value + "\n property" + property);
                            return new PsiReference[]{new XCSReference(element, property)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }
    */
}

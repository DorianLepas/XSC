package cea.language.sml.reference;

import cea.language.sml.psi.SmlEventsValue;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class SmlReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(SmlEventsValue.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        SmlEventsValue e = (SmlEventsValue) element;
                        return new PsiReference[]{new SmlEventReference(e,
                                new TextRange(e.getText().length()-e.getValue().length(),e.getText().length()))};
                    }
                });
    }
}

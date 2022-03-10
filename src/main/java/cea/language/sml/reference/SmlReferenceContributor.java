package cea.language.sml.reference;

import cea.language.sml.psi.*;
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
                        if (element.getText().matches("'[^']+'")){
                            System.out.println(element.getText());
                            return new PsiReference[]{};
                        }
                        return new PsiReference[]{new SmlEventReference(e,
                                new TextRange(e.getText().length()-e.getValue().length(),e.getText().length()))};
                    }
                });

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(SmlCallJavaFunctionInstruction.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        SmlCallJavaFunctionInstruction e = (SmlCallJavaFunctionInstruction) element;
                        if (e.getValue() == null) {return PsiReference.EMPTY_ARRAY;}
                        return new PsiReference[]{new SmlFunctionReference(e,
                                new TextRange(e.getText().length()-e.getLastChild().getText().length(),e.getText().length()-(e.getLastChild().getText().length()-e.getValue().length())))};
                    }
                });
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(SmlStateNames.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        SmlStateNames e = (SmlStateNames) element;
                        if (e.getValue() == null || e.getParent() instanceof SmlStateBlock) {return PsiReference.EMPTY_ARRAY;}
                        return new PsiReference[]{new SmlStateReference(e,
                                new TextRange(e.getText().length()-e.getValue().length(),e.getText().length()))};
                    }
                });
    }
}

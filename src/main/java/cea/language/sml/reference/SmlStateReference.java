package cea.language.sml.reference;

import cea.language.sml.fileType.SmlIcons;
import cea.language.sml.psi.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SmlStateReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String value;

    public SmlStateReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        value = element.getText();
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        List<ResolveResult> results = new ArrayList<>();
        // Search in the project collection_events.xsc file and the sml file
            final List<SmlStateBlock> states = SmlUtil.findStates((SmlFile) myElement.getContainingFile(),value);
            for (SmlStateBlock state : states) {
                results.add(new PsiElementResolveResult(state));
            }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        List<LookupElement> variants = new ArrayList<>();
        // Create LookUpElement with element of Sml State Blocks
        List<SmlStateBlock> states = SmlUtil.findStates((SmlFile) myElement.getContainingFile());
        for (final SmlStateBlock state : states) {
            if (state.getNode().findChildByType(SmlTypes.STATE_NAMES) != null) {
                variants.add(LookupElementBuilder
                        .create(state.getNode().findChildByType(SmlTypes.STATE_NAMES).getText())
                        .withIcon(SmlIcons.FILE)
                        .withPresentableText(state.getNode().findChildByType(SmlTypes.STATE_NAMES).getText())
                        .withTypeText("State")
                );
            }
        }
        return variants.toArray();
    }
}

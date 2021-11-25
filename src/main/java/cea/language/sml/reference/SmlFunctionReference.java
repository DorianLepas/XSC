package cea.language.sml.reference;

import cea.language.sml.psi.SmlFile;
import cea.language.sml.psi.SmlUtil;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SmlFunctionReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String value;

    public SmlFunctionReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        value = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        List<ResolveResult> results = new ArrayList<>();
        // Search in the project java file
        if (!value.equals("")) {
            final List<PsiMethod> properties = SmlUtil.findFunctions((SmlFile) myElement.getContainingFile(), project, value, myElement);
            for (PsiMethod property : properties) {
                results.add(new PsiElementResolveResult(property));
            }
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
        Project project = myElement.getProject();
        List<LookupElement> variants = new ArrayList<>();
        // Create LookUpElement with element of PsiMethod
        List<PsiMethod> methods = SmlUtil.findFunctions((SmlFile) myElement.getContainingFile(), project);
        for (final PsiMethod method : methods) {
            variants.add(LookupElementBuilder
                    .create(method.getContainingFile().getName().substring(0, method.getContainingFile().getName().lastIndexOf(".")) + "." + method.getName() + "()")
                    .withIcon(method.getContainingFile().getIcon(0))
                    .withPresentableText(method.getName() + method.getParameterList().getText())
                    .withTypeText(method.getContainingFile().getName())
            );
        }
        return variants.toArray();
    }
}

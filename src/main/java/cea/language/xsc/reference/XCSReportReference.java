package cea.language.xsc.reference;

import cea.language.xsc.psi.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import cea.language.xsc.filetype.XCSIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class XCSReportReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String value;

    public XCSReportReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        value = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        // Search the reference in the same file
        final List<XCSFunctionCore> reports = XCSUtil.findReports((XCSFile) myElement.getContainingFile(), value);
        List<ResolveResult> results = new ArrayList<>();
        for (XCSFunctionCore report : reports) {
            results.add(new PsiElementResolveResult(report));
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
        // Create LookUpElement with element of XCSFunctionCore
        List<XCSFunctionCore> reports = XCSUtil.findReports((XCSFile) myElement.getContainingFile());
        for (final XCSFunctionCore report : reports) {
            if (report.getValue() != null) {
                variants.add(LookupElementBuilder
                        .create(report.getValue())
                        .withIcon(XCSIcons.FILE)
                        .withPresentableText(report.getValue())
                        .withTypeText(report.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
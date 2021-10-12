package org.intellij.sdk.language.xsc.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.xsc.filetype.XCSIcons;
import org.intellij.sdk.language.xsc.psi.XCSProperty_;
import org.intellij.sdk.language.xsc.psi.XCSUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class XCSReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String value;

    public XCSReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        value = "\"" + element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset()) + "\"";
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<XCSProperty_> properties = XCSUtil.findProperties(project, value);
        List<ResolveResult> results = new ArrayList<>();
        for (XCSProperty_ property : properties) {
            results.add(new PsiElementResolveResult(property));
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
        List<XCSProperty_> properties = XCSUtil.findProperties(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final XCSProperty_ property : properties) {
            if (property.getValue() != null && property.getValue().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(XCSIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
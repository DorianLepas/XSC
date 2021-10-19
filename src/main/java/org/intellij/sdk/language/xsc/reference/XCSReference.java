package org.intellij.sdk.language.xsc.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.xsc.filetype.XCSIcons;
import org.intellij.sdk.language.xsc.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class XCSReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String value;
    private final String type;

    public XCSReference(@NotNull PsiElement element, TextRange textRange, String type) {
        super(element, textRange);
        value = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
        this.type = type;
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        if(type.equals("CEID")) {
            final List<XCSCeProperty_> properties = XCSUtil.findPropertiesCe((XCSFile) myElement.getContainingFile(), project, value);
            List<ResolveResult> results = new ArrayList<>();
            for (XCSCeProperty_ property : properties) {
                results.add(new PsiElementResolveResult(property));
            }
            return results.toArray(new ResolveResult[results.size()]);
        }
        if(type.equals("DVID")) {
            final List<XCSDvProperty_> properties = XCSUtil.findPropertiesDv((XCSFile) myElement.getContainingFile(), project, value);
            List<ResolveResult> results = new ArrayList<>();
            for (XCSDvProperty_ property : properties) {
                results.add(new PsiElementResolveResult(property));
            }
            return results.toArray(new ResolveResult[results.size()]);
        }
        if(type.equals("ECID")) {
            final List<XCSEcProperty_> properties = XCSUtil.findPropertiesEc((XCSFile) myElement.getContainingFile(), project, value);
            List<ResolveResult> results = new ArrayList<>();
            for (XCSEcProperty_ property : properties) {
                results.add(new PsiElementResolveResult(property));
            }
            return results.toArray(new ResolveResult[results.size()]);
        }
        if(type.equals("SVID")) {
            final List<XCSSvProperty_> properties = XCSUtil.findPropertiesSv((XCSFile) myElement.getContainingFile(), project, value);
            List<ResolveResult> results = new ArrayList<>();
            for (XCSSvProperty_ property : properties) {
                results.add(new PsiElementResolveResult(property));
            }
            return results.toArray(new ResolveResult[results.size()]);
        }
        if(type.equals("")){
            List<ResolveResult> results = new ArrayList<>();

            final List<XCSCeProperty_> propertiesCe = XCSUtil.findPropertiesCe((XCSFile) myElement.getContainingFile(), project, value);
            for (XCSCeProperty_ property : propertiesCe) {
                results.add(new PsiElementResolveResult(property));
            }

            final List<XCSDvProperty_> propertiesDv = XCSUtil.findPropertiesDv((XCSFile) myElement.getContainingFile(), project, value);
            for (XCSDvProperty_ property : propertiesDv) {
                results.add(new PsiElementResolveResult(property));
            }

            final List<XCSEcProperty_> propertiesEc = XCSUtil.findPropertiesEc((XCSFile) myElement.getContainingFile(), project, value);
            for (XCSEcProperty_ property : propertiesEc) {
                results.add(new PsiElementResolveResult(property));
            }

            final List<XCSSvProperty_> propertiesSv = XCSUtil.findPropertiesSv((XCSFile) myElement.getContainingFile(), project, value);
            for (XCSSvProperty_ property : propertiesSv) {
                results.add(new PsiElementResolveResult(property));
            }

            return results.toArray(new ResolveResult[results.size()]);

        }
        return new ArrayList<>().toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        System.out.println("JE PASSSSSEEEEE DANS GETVARIANTS()");
        Project project = myElement.getProject();
        List<LookupElement> variants = new ArrayList<>();

        List<XCSCeProperty_> propertiesCe = XCSUtil.findPropertiesCe((XCSFile) myElement.getContainingFile(), project);
        for (final XCSCeProperty_ property : propertiesCe) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(XCSIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }

        List<XCSDvProperty_> propertiesDv = XCSUtil.findPropertiesDv((XCSFile) myElement.getContainingFile(), project);
        for (final XCSDvProperty_ property : propertiesDv) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(XCSIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }

        List<XCSEcProperty_> propertiesEc = XCSUtil.findPropertiesEc((XCSFile) myElement.getContainingFile(), project);
        for (final XCSEcProperty_ property : propertiesEc) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(XCSIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }

        List<XCSSvProperty_> propertiesSv = XCSUtil.findPropertiesSv((XCSFile) myElement.getContainingFile(), project);
        for (final XCSSvProperty_ property : propertiesSv) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(XCSIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }

        return variants.toArray();
    }
}
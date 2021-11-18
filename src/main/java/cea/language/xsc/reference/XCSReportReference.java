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
        Project project = myElement.getProject();
        // Search the reference in the same file
        final List<XCSFunctionCore> reports = XCSUtil.findReports((XCSFile) myElement.getContainingFile(), project, value);
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
        // Create LookUpElement with element of XCSCeProperty_
        List<XCSCeProperty_> propertiesCe = XCSUtil.findPropertiesCe((XCSFile) myElement.getContainingFile(), project);
        for (final XCSCeProperty_ property : propertiesCe) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0 && property.getFirstChild().getText().equals("VfeiName")) {
                variants.add(LookupElementBuilder
                        .create(property.getLastChild().getText().replace("\"", "") + "\"")
                        .withIcon(XCSIcons.FILE)
                        .withPresentableText(property.getLastChild().getText().replace("\"", ""))
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        // Create LookUpElement with element of XCSDvProperty_
        List<XCSDvProperty_> propertiesDv = XCSUtil.findPropertiesDv((XCSFile) myElement.getContainingFile(), project);
        for (final XCSDvProperty_ property : propertiesDv) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0 && property.getFirstChild().getText().equals("VfeiName")) {
                variants.add(LookupElementBuilder
                        .create(property.getLastChild().getText().replace("\"", "") + "\"")
                        .withIcon(XCSIcons.FILE)
                        .withPresentableText(property.getLastChild().getText().replace("\"", ""))
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        // Create LookUpElement with element of XCSEcProperty_
        List<XCSEcProperty_> propertiesEc = XCSUtil.findPropertiesEc((XCSFile) myElement.getContainingFile(), project);
        for (final XCSEcProperty_ property : propertiesEc) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0 && property.getFirstChild().getText().equals("VfeiName")) {
                variants.add(LookupElementBuilder
                        .create(property.getLastChild().getText().replace("\"", "") + "\"")
                        .withIcon(XCSIcons.FILE)
                        .withPresentableText(property.getLastChild().getText().replace("\"", ""))
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        // Create LookUpElement with element of XCSSvProperty_
        List<XCSSvProperty_> propertiesSv = XCSUtil.findPropertiesSv((XCSFile) myElement.getContainingFile(), project);
        for (final XCSSvProperty_ property : propertiesSv) {
            if (property.getLastChild().getText() != null && property.getLastChild().getText().length() > 0 && property.getFirstChild().getText().equals("VfeiName")) {
                variants.add(LookupElementBuilder
                        .create(property.getLastChild().getText().replace("\"", "") + "\"")
                        .withIcon(XCSIcons.FILE)
                        .withPresentableText(property.getLastChild().getText().replace("\"", ""))
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
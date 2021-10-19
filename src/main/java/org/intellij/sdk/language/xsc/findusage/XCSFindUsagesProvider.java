package org.intellij.sdk.language.xsc.findusage;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import org.intellij.sdk.language.xsc.lexer.XCSLexerAdapter;
import org.intellij.sdk.language.xsc.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class XCSFindUsagesProvider implements FindUsagesProvider {

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new XCSLexerAdapter(),
                TokenSet.create(XCSTypes.PROPERTY_VALUE),
                TokenSet.create(XCSTypes.COMMENT),
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return  (psiElement instanceof XCSCeProperty_ && psiElement.getFirstChild().getText().equals("VfeiName")) ||
                (psiElement instanceof XCSDvProperty_ && psiElement.getFirstChild().getText().equals("VfeiName")) ||
                (psiElement instanceof XCSEcProperty_ && psiElement.getFirstChild().getText().equals("VfeiName")) ||
                (psiElement instanceof XCSSvProperty_ && psiElement.getFirstChild().getText().equals("VfeiName"));
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof XCSCeProperty_ || element instanceof XCSDvProperty_ || element instanceof XCSEcProperty_ ||element instanceof XCSSvProperty_) {
            return "XSC property";
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof XCSCeProperty_ || element instanceof XCSDvProperty_ || element instanceof XCSEcProperty_ ||element instanceof XCSSvProperty_) {
            return ((XCSProperty_) element).getValue().replaceAll("\"","");
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if (element instanceof XCSCeProperty_ || element instanceof XCSDvProperty_ || element instanceof XCSEcProperty_ ||element instanceof XCSSvProperty_) {
            return ((XCSProperty_) element).getValue().replaceAll("\"","");
        } else {
            return "";
        }
    }

}

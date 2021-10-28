package cea.language.xsc.psi.impl;

import cea.language.xsc.psi.XCSNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import org.jetbrains.annotations.NotNull;

public abstract class XCSNamedElementImpl extends ASTWrapperPsiElement implements XCSNamedElement {

    public XCSNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference getReference() {
        PsiReference[] referencesFromProviders = ReferenceProvidersRegistry.getReferencesFromProviders(this);
        // Check if the element has exactly 1 reference
        if (referencesFromProviders.length == 1)
            return referencesFromProviders[0];
        else
            return null;
    }

    @NotNull
    @Override
    public PsiReference @NotNull [] getReferences() {
        // Get all the element references
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

}

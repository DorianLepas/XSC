package org.intellij.sdk.language;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class XCSBlock extends AbstractBlock {

    private final SpacingBuilder spacingBuilder;

    protected XCSBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment,
                          SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while (child != null) {
            if (child.getElementType() != TokenType.WHITE_SPACE) {
                Block block = new XCSBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                        spacingBuilder);
                blocks.add(block);
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        if(isLeaf() ||
                isAtRootFile() ||
                (myNode.getPsi() instanceof XCSFunctionCore && myNode.getTreeParent().getPsi() instanceof XCSFunctions) ||
                (myNode.getPsi() instanceof XCSCeList && myNode.getTreeParent().getPsi() instanceof XCSCollectionEventSection) ||
                (myNode.getPsi() instanceof XCSVssList && myNode.getTreeParent().getPsi() instanceof XCSVfeiSecsSeqSection) ||
                myNode.getPsi() instanceof  XCSProperty ||
                myNode.getPsi() instanceof XCSProperty_ ||
                myNode.getPsi() instanceof  XCSCeProperty ||
                myNode.getPsi() instanceof XCSCeProperty_ ){
            return Indent.getNoneIndent();
        }
        return Indent.getContinuationWithoutFirstIndent();
    }

    /* Retourne vrai si le noeud actuel se trouve à la racine du fichier */
    private boolean isAtRootFile() {
        return myNode.getTreeParent() != null && myNode.getTreeParent().getPsi() instanceof XCSFile;
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

}
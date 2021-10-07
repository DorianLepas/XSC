package org.intellij.sdk.language.xsc.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.intellij.sdk.language.xsc.psi.*;
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
                (myNode.getPsi() instanceof XCSFunctionCore && (myNode.getTreeParent().getPsi() instanceof XCSFunctions||myNode.getTreeParent().getPsi() instanceof XCSStandartSections)) ||
                (myNode.getPsi() instanceof XCSEventsCore && myNode.getTreeParent().getPsi() instanceof XCSEventsSection) ||
                (myNode.getPsi() instanceof XCSScenariosCore && myNode.getTreeParent().getPsi() instanceof XCSScenariosSection) ||
                (myNode.getPsi() instanceof XCSCeList) || (myNode.getPsi() instanceof XCSCeCore && myNode.getPsi().equals(myNode.getTreeNext().getFirstChildNode())) ||
                (myNode.getPsi() instanceof XCSDvList) || (myNode.getPsi() instanceof XCSDvCore && myNode.getPsi().equals(myNode.getTreeNext().getFirstChildNode())) ||
                (myNode.getPsi() instanceof XCSEcList) || (myNode.getPsi() instanceof XCSEcCore && myNode.getPsi().equals(myNode.getTreeNext().getFirstChildNode())) ||
                (myNode.getPsi() instanceof XCSSitList) || (myNode.getPsi() instanceof XCSSitCore && myNode.getPsi().equals(myNode.getTreeNext().getFirstChildNode())) ||
                (myNode.getPsi() instanceof XCSSvList) || (myNode.getPsi() instanceof XCSSvCore && myNode.getPsi().equals(myNode.getTreeNext().getFirstChildNode())) ||
                (myNode.getPsi() instanceof XCSVssList) || (myNode.getPsi() instanceof XCSVssCore && myNode.getPsi().equals(myNode.getTreeNext().getFirstChildNode())) ||
                myNode.getPsi() instanceof  XCSProperty || myNode.getPsi() instanceof XCSProperty_ ||
                myNode.getPsi() instanceof  XCSEcProperty || myNode.getPsi() instanceof XCSEcProperty_ ||
                myNode.getPsi() instanceof XCSCeProperty || myNode.getPsi() instanceof XCSCeProperty_ ||
                myNode.getPsi() instanceof  XCSDvProperty || myNode.getPsi() instanceof XCSDvProperty_ ||
                myNode.getPsi() instanceof  XCSSvProperty || myNode.getPsi() instanceof XCSSvProperty_ ||
                myNode.getPsi() instanceof  XCSVssProperty || myNode.getPsi() instanceof XCSVssProperty_
        ){
            return Indent.getNoneIndent();
        }
        return Indent.getNormalIndent();
    }

    /* Return true si le noeud actuel se trouve à la racine du fichier */
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
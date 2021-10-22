package cea.language.sml.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
//import com.intellij.psi.tree.TokenSet;
//import cucumber.api.java.ca.I;
import cea.language.sml.psi.SmlFile;
import cea.language.sml.psi.SmlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SmlBlock extends AbstractBlock
{
  // Inner classes

  // Instance fields
  private final SpacingBuilder spacingBuilder;

  // Static code

  // Constructors
  protected SmlBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment,
                     SpacingBuilder spacingBuilder) {
    super(node, wrap, alignment);
    this.spacingBuilder = spacingBuilder;
  }

  // Methods
  @Override
  protected List<Block> buildChildren() {
    List<Block> blocks = new ArrayList<>();
    ASTNode child = myNode.getFirstChildNode();
    while (child != null) {
      if (child.getElementType() != TokenType.WHITE_SPACE) {
        Block block = new SmlBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                spacingBuilder);
        blocks.add(block);
      }
      child = child.getTreeNext();
    }
    return blocks;
  }

  @Override
  public Indent getIndent() {
    if(myNode.getElementType() == SmlTypes.EVENT_NAME || myNode.getElementType() == SmlTypes.OPTIONS || (myNode.getElementType() == SmlTypes.COMMENT && !isAtRootFile())) {
      return Indent.getContinuationWithoutFirstIndent();
    } else if(isLeaf() || isAtRootFile()) {
      return Indent.getNoneIndent();
    }

    return Indent.getNormalIndent();
  }

  /* Retourne vrai si le noeud actuel se trouve à la racine du fichier */
  private boolean isAtRootFile() {
    return myNode.getTreeParent() != null && myNode.getTreeParent().getPsi() instanceof SmlFile;
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

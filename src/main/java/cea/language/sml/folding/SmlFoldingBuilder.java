package cea.language.sml.folding;

import cea.language.sml.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SmlFoldingBuilder extends FoldingBuilderEx implements DumbAware {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        // Initialize the group of folding regions that will expand/collapse together.
        // Initialize the list of folding regions
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        return descriptors.toArray(new FoldingDescriptor[0]);
/*
        // Get a collection of the SmlAlarmBlock in the document below root
        Collection<SmlAlarmBlock> AlarmBlocks = PsiTreeUtil.findChildrenOfType(root, SmlAlarmBlock.class);
        // Evaluate the collection
        for (final SmlAlarmBlock AlarmBlock : AlarmBlocks) {
            descriptors.add(new FoldingDescriptor(AlarmBlock.getNode(),
                    new TextRange(AlarmBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            AlarmBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlAliasBlock in the document below root
        Collection<SmlAliasBlock> AliasBlocks = PsiTreeUtil.findChildrenOfType(root, SmlAliasBlock.class);
        // Evaluate the collection
        for (final SmlAliasBlock AliasBlock : AliasBlocks) {
            descriptors.add(new FoldingDescriptor(AliasBlock.getNode(),
                    new TextRange(AliasBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            AliasBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlBindingBlock in the document below root
        Collection<SmlBindingBlock> BindingBlocks = PsiTreeUtil.findChildrenOfType(root, SmlBindingBlock.class);
        // Evaluate the collection
        for (final SmlBindingBlock BindingBlock : BindingBlocks) {
            descriptors.add(new FoldingDescriptor(BindingBlock.getNode(),
                    new TextRange(BindingBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            BindingBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlConditionBlock in the document below root
        Collection<SmlConditionBlock> ConditionBlocks = PsiTreeUtil.findChildrenOfType(root, SmlConditionBlock.class);
        // Evaluate the collection
        for (final SmlConditionBlock ConditionBlock : ConditionBlocks) {
            descriptors.add(new FoldingDescriptor(ConditionBlock.getNode(),
                    new TextRange(ConditionBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            ConditionBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlElseBlock in the document below root
        Collection<SmlElseBlock> ElseBlocks = PsiTreeUtil.findChildrenOfType(root, SmlElseBlock.class);
        // Evaluate the collection
        for (final SmlElseBlock ElseBlock : ElseBlocks) {
            descriptors.add(new FoldingDescriptor(ElseBlock.getNode(),
                    new TextRange(ElseBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            ElseBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlElseIfBlock in the document below root
        Collection<SmlElseIfBlock> ElseIfBlocks = PsiTreeUtil.findChildrenOfType(root, SmlElseIfBlock.class);
        // Evaluate the collection
        for (final SmlElseIfBlock ElseIfBlock : ElseIfBlocks) {
            descriptors.add(new FoldingDescriptor(ElseIfBlock.getNode(),
                    new TextRange(ElseIfBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            ElseIfBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlEnterBlock in the document below root
        Collection<SmlEnterBlock> EnterBlocks = PsiTreeUtil.findChildrenOfType(root, SmlEnterBlock.class);
        // Evaluate the collection
        for (final SmlEnterBlock EnterBlock : EnterBlocks) {
            descriptors.add(new FoldingDescriptor(EnterBlock.getNode(),
                    new TextRange(EnterBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            EnterBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlEventBlock in the document below root
        Collection<SmlEventBlock> EventBlocks = PsiTreeUtil.findChildrenOfType(root, SmlEventBlock.class);
        // Evaluate the collection
        for (final SmlEventBlock EventBlock : EventBlocks) {
            descriptors.add(new FoldingDescriptor(EventBlock.getNode(),
                    new TextRange(EventBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            EventBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlExitBlock in the document below root
        Collection<SmlExitBlock> ExitBlocks = PsiTreeUtil.findChildrenOfType(root, SmlExitBlock.class);
        // Evaluate the collection
        for (final SmlExitBlock ExitBlock : ExitBlocks) {
            descriptors.add(new FoldingDescriptor(ExitBlock.getNode(),
                    new TextRange(ExitBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            ExitBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlIfBlock in the document below root
        Collection<SmlIfBlock> IfBlocks = PsiTreeUtil.findChildrenOfType(root, SmlIfBlock.class);
        // Evaluate the collection
        for (final SmlIfBlock IfBlock : IfBlocks) {
            descriptors.add(new FoldingDescriptor(IfBlock.getNode(),
                    new TextRange(IfBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            IfBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlOptionsBlock in the document below root
        Collection<SmlOptionsBlock> OptionsBlocks = PsiTreeUtil.findChildrenOfType(root, SmlOptionsBlock.class);
        // Evaluate the collection
        for (final SmlOptionsBlock OptionsBlock : OptionsBlocks) {
            descriptors.add(new FoldingDescriptor(OptionsBlock.getNode(),
                    new TextRange(OptionsBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            OptionsBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlScriptBlock in the document below root
        Collection<SmlScriptBlock> ScriptBlocks = PsiTreeUtil.findChildrenOfType(root, SmlScriptBlock.class);
        // Evaluate the collection
        for (final SmlScriptBlock ScriptBlock : ScriptBlocks) {
            descriptors.add(new FoldingDescriptor(ScriptBlock.getNode(),
                    new TextRange(ScriptBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            ScriptBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlStateBlock in the document below root
        Collection<SmlStateBlock> StateBlocks = PsiTreeUtil.findChildrenOfType(root, SmlStateBlock.class);
        // Evaluate the collection
        for (final SmlStateBlock StateBlock : StateBlocks) {
            descriptors.add(new FoldingDescriptor(StateBlock.getNode(),
                    new TextRange(StateBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            StateBlock.getTextRange().getEndOffset() - 1)));
        }

        // Get a collection of the SmlTraceBlock in the document below root
        Collection<SmlTraceBlock> TraceBlocks = PsiTreeUtil.findChildrenOfType(root, SmlTraceBlock.class);
        // Evaluate the collection
        for (final SmlTraceBlock TraceBlock : TraceBlocks) {
            descriptors.add(new FoldingDescriptor(TraceBlock.getNode(),
                    new TextRange(TraceBlock.getNode().findChildByType(SmlTypes.BEGIN_BLOCK).getTextRange().getStartOffset() + 1,
                            TraceBlock.getTextRange().getEndOffset() - 1)));
        }

        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
 */
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        String retTxt = "...";
        return retTxt;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}


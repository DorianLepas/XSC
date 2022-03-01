package cea.language.sml.annotator;

import cea.language.sml.psi.*;
import cea.language.sml.psi.impl.SmlScriptBlockImpl;
import cea.language.sml.psi.impl.SmlStateBlockImpl;
import cea.language.sml.quickfix.SmlCreateEventQuickFix;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationBuilder;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.TokenType;
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class SmlAnnotator implements Annotator
{
  AnnotationBuilder HolderCreation;
  // Inner classes

  // Instance fields
  private PsiElement previousElement;

  // Static code

  // Constructors

  // Methods
  @Override
  public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    if(element instanceof SmlStateBlock) {
      checkState((SmlStateBlockImpl) element, holder);
    }
    else if(element instanceof SmlScriptBlock) {
      checkScript((SmlScriptBlockImpl) element, holder);
    }
    else if(element instanceof SmlConditions || element instanceof SmlIfConditions) {
      checkCondition(element, holder);
    }
    else if (element instanceof SmlIfBlock || element instanceof SmlElseIfBlock || element instanceof SmlElseBlock) {
      checkIfBlock(element, holder);
    }
    else if(element instanceof PsiWhiteSpaceImpl) {
      checkOneInstructionPerLine(element, holder);
    }
    else if(element instanceof SmlConditionBlock) {
      checkOneConditionPerLine(element, holder);
    }
    else if(element instanceof SmlBindingBlock) {
      checkOneBindPerLine(element, holder);
    }

    // Check if we're in an EventBlock
    if(element instanceof SmlEventsValue && element.getParent().getParent() instanceof SmlEventBlock && element.getProject().getName().equals("Automation")) {
      // Check if the element has a reference
      if (element.getReference().resolve() == null) {
        // Create a WARNING if the element has 0 or multiple references
        HolderCreation = holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING, "Undeclared property or Declared multiples times")
                .withFix(new SmlCreateEventQuickFix(((SmlEventsValue) element).getValue()));
      }
      else{
        PsiElement Reference =  element.getReference().resolve();
        HolderCreation = holder.newAnnotation(HighlightSeverity.INFORMATION,"")
                .tooltip(Reference.getContainingFile().getVirtualFile().getCanonicalPath().replace(Reference.getProject().getBasePath() + "/",""));
      }
      HolderCreation.create();
    }

    // Check if we're in an JavaCallBlock
    if(element instanceof SmlCallJavaFunctionInstruction && element.getProject().getName().equals("Automation")) {
      // Check if the element has a reference
      if (((SmlCallJavaFunctionInstruction)element).getValue() != null && element.getReference().resolve() == null) {
        // Create a WARNING if the element has 0 or multiple references
        HolderCreation = holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING, "Unknown function");
        HolderCreation.create();
      }
      // Check if the function has the good number of parameter
      else if(((SmlCallJavaFunctionInstruction) element).getParametersCount() != ((PsiMethod) element.getReference().resolve()).getParameterList().getParametersCount()) {
        // Too much arguments
        if(((SmlCallJavaFunctionInstruction) element).getParametersCount() > ((PsiMethod) element.getReference().resolve()).getParameterList().getParametersCount()){
          HolderCreation = holder.newAnnotation(HighlightSeverity.ERROR, "Too many parameters provided");
          HolderCreation.create();
        }
        // Missing arguments
        if(((SmlCallJavaFunctionInstruction) element).getParametersCount() < ((PsiMethod) element.getReference().resolve()).getParameterList().getParametersCount()){
          HolderCreation = holder.newAnnotation(HighlightSeverity.ERROR, "Missing parameters");
          HolderCreation.create();
        }
      }
    }

    previousElement = element;
  }


  //Vérfications pour un état
  private void checkState(@NotNull SmlStateBlockImpl state, @NotNull AnnotationHolder holder) {
    //Si l'état n'a pas de bloc enter
    //if(state.getEnterBlockList().size() == 0) {
    //  holder.createWarningAnnotation(state.getFirstChild(), "A state must have a enter bloc");
    //}
    //Si l'état a plus d'un bloc enter
    if(state.getEnterBlockList().size() > 1) {
      for(int i = 1; i < state.getEnterBlockList().size(); i++) {
        holder.createErrorAnnotation(state.getEnterBlockList().get(i), "A state can only have one enter bloc");
      }
    }
    //Si l'état a plus d'un bloc exit
    else if(state.getExitBlockList().size() > 1) {
      for(int i = 1; i < state.getExitBlockList().size(); i++) {
        holder.createErrorAnnotation(state.getExitBlockList().get(i), "A state can only have one enter bloc");
      }
    }
    //Si l'état a plus d'un bloc option
    else if(state.getOptionsBlockList().size() > 1) {
      for(int i = 1; i < state.getOptionsBlockList().size(); i++) {
        holder.createErrorAnnotation(state.getOptionsBlockList().get(i), "A state can only have one enter bloc");
      }
    }
  }

  //Vérifications pour un script
  private void checkScript(@NotNull SmlScriptBlockImpl script, @NotNull AnnotationHolder holder) {
    ASTNode code = script.getNode().findChildByType(SmlTypes.JAVASCRIPT);

    if(code == null) {
      holder.createWarningAnnotation(script, "A script without Javascript code is useless");
    }
  }

  //Vérification des bloccs if, else if et else
  private void checkIfBlock(@NotNull PsiElement block, @NotNull AnnotationHolder holder) {
      int i = 0;
      ASTNode[] nodes = block.getNode().getChildren(TokenSet.ANY);
      while(i < nodes.length && !isInstruction(nodes[i].getPsi())) {
        i++;
      }

      if(i == nodes.length) {
        holder.createWarningAnnotation(block, "Has empty body");
      }
  }

  //Vérification des conditions
  private void checkCondition(@NotNull PsiElement condition, @NotNull AnnotationHolder holder)
  {
    //Nombre de variables dans la condition
    int nbVars = 0;
    //Nombre de comparateurs dans la condition
    int nbComparators = 0;
    // Nombre de constantes dans la condition
    int nbConstants = 0;
    //ElementType précédent
    int nbFun = 0;
    ASTNode previous = null;

    for(ASTNode node : condition.getNode().getChildren(TokenSet.ANY)) {
      if(node.getElementType()== SmlTypes.SML_VARS) {
        nbVars++;
      } else if(node.getElementType() == SmlTypes.COMP_CONDS) {
        nbComparators++;
      } else if(node.getElementType() == SmlTypes.CONST_CONDS) {
        nbConstants++;
      }else if(node.getElementType() == SmlTypes.JAVA_FUNCTION_CALL) {
        nbFun++;
      }

      /* Si deux éléments consécutifs d'une conditions sont soit des variables sml soit des constantes */
      if(previous != null && (node.getElementType() == SmlTypes.SML_VARS || node.getElementType() == SmlTypes.JAVA_FUNCTION_CALL || node.getElementType() == SmlTypes.CONST_CONDS)
          && (previous.getElementType() == SmlTypes.SML_VARS || previous.getElementType() == SmlTypes.JAVA_FUNCTION_CALL || previous.getElementType() == SmlTypes.CONST_CONDS)) {
        holder.createErrorAnnotation(node.getPsi(), "Comparator or operator needed");
        holder.createErrorAnnotation(previous.getPsi(), "Comparator or operator needed");
      }

      if(node.getElementType() != TokenType.WHITE_SPACE) {
        previous = node;
      }
    }

    if(nbComparators == 0 && (nbVars > 1 || nbConstants > 0)) {
      holder.createErrorAnnotation(condition, "A complex condition must have one or more comparator");
    }
    if(nbVars == 0 && nbFun == 0) {
      holder.createErrorAnnotation(condition, "A complex condition must have one or more variable");
    }
  }

  //Créer une annotation d'erreur s'il y a deux instructions sur la même ligne
  private void checkOneInstructionPerLine(@NotNull PsiElement whiteSpace, @NotNull AnnotationHolder holder) {
    if(previousElement != null && isInstruction(previousElement) && !whiteSpace.getNode().getText().contains("\n")) {
      holder.createErrorAnnotation(previousElement, "One instruction per line");
    }
  }

  // Vérifie s'il y a une condition par ligne dans un bloc de condition
  private void checkOneConditionPerLine(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    for(ASTNode node : element.getNode().getChildren(TokenSet.ANY)) {
      if(node.getElementType() == TokenType.WHITE_SPACE && node.getTreePrev().getElementType() == SmlTypes.CONDITIONS && !node.getText().contains("\n")) {
        holder.createErrorAnnotation(node.getPsi(), "One condition per line");
      }
    }
  }

  // Vérifie s'il y a une condition par ligne dans un bloc de liens
  private void checkOneBindPerLine(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    for(ASTNode node : element.getNode().getChildren(TokenSet.ANY)) {
      if(node.getElementType() == TokenType.WHITE_SPACE && node.getTreePrev().getElementType() == SmlTypes.BIND && !node.getText().contains("\n")) {
        holder.createErrorAnnotation(node.getPsi(), "One bind per line");
      }
    }
  }

  //Vrai l'élément PSI en paramètre est une instruction
  private boolean isInstruction(@NotNull PsiElement element) {
    return element instanceof SmlGotoStateInstruction
            || element instanceof SmlCallJavaFunctionInstruction
            || element instanceof SmlProcessStateInstruction
            || element instanceof SmlThreadEndInstruction
            || element instanceof SmlThreadStateInstruction
            || element instanceof SmlTraceInstruction
            || element instanceof SmlExecEndInstruction
            || element instanceof SmlConsumeEventInstruction;
  }
}

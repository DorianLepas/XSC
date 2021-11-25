package cea.language.sml.psi.impl;

import cea.language.sml.psi.SmlCallJavaFunctionInstruction;
import cea.language.sml.psi.SmlElementFactory;
import cea.language.sml.psi.SmlEventsValue;
import cea.language.sml.psi.SmlTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;


public class SmlPsiImplUtil {

    public static String getKey(SmlEventsValue element) {
        ASTNode keyNode = element.getNode().getTreeParent().getTreeParent().getFirstChildNode();
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static String getValue(SmlEventsValue element) {
        ASTNode valueNode = element.getNode().findChildByType(SmlTypes.EVENT_NAME);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(SmlEventsValue element) {
        return getValue(element);
    }

    public static PsiElement setName(SmlEventsValue element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(SmlTypes.EVENT_NAME);
        if (keyNode != null) {

            SmlEventsValue property = SmlElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(SmlEventsValue element) {
        ASTNode keyNode = element.getNode().findChildByType(SmlTypes.EVENT_NAME);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static String getKey(SmlCallJavaFunctionInstruction element) {
        ASTNode keyNode = element.getNode().getFirstChildNode();
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static String getValue(SmlCallJavaFunctionInstruction element) {
        ASTNode valueNode = element.getNode().findChildByType(SmlTypes.JAVA_FUNCTION_CALL);
        if (valueNode != null) {
            if (!valueNode.getText().contains("(")) {return "";}
            return valueNode.getText().substring(0,valueNode.getText().lastIndexOf("("));
        } else {
            return null;
        }
    }

    public static String getName(SmlCallJavaFunctionInstruction element) {
        return getValue(element);

    }

    // Return the parameters list of the JavaCall
    public static String[] getParametersList(SmlCallJavaFunctionInstruction element){
        ASTNode valueNode = element.getNode().findChildByType(SmlTypes.JAVA_FUNCTION_CALL);
        if (valueNode != null) {
            String parameters = valueNode.getText().substring(valueNode.getText().lastIndexOf("(")+1,valueNode.getText().lastIndexOf(")"));
            parameters = parameters.replace(" ","");
            // 0 arg
            if (parameters.length() == 0){
                return new String[0];
            }
            // 1 or more arg
            return parameters.split(",");
        }
        return new String[0];
    }

    // Return the number of parameter of the JavaCall
    public static int getParametersCount(SmlCallJavaFunctionInstruction element){
        return element.getParametersList().length;
    }

    public static PsiElement setName(SmlCallJavaFunctionInstruction element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(SmlTypes.JAVA_FUNCTION_CALL);
        if (keyNode != null) {
            SmlEventsValue property = SmlElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(SmlCallJavaFunctionInstruction element) {
        ASTNode keyNode = element.getNode().findChildByType(SmlTypes.JAVA_FUNCTION_CALL);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}

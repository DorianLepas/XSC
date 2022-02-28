package cea.language.sml.psi.impl;

import cea.language.sml.psi.SmlCallJavaFunctionInstruction;
import cea.language.sml.psi.SmlElementFactory;
import cea.language.sml.psi.SmlEventsValue;
import cea.language.sml.psi.SmlTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;


public class SmlPsiImplUtil {

    /**
     * Get the value of the first child in the event section
     * @param element event section
     * @return String value
     */
    public static String getKey(SmlEventsValue element) {
        ASTNode keyNode = element.getNode().getTreeParent().getTreeParent().getFirstChildNode();
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the value of the event section
     * @param element event section
     * @return String value
     */
    public static String getValue(SmlEventsValue element) {
        ASTNode valueNode = element.getNode().findChildByType(SmlTypes.EVENT_NAME);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the value of the event section
     * @param element event section
     * @return String value
     */
    public static String getName(SmlEventsValue element) {
        return getValue(element);
    }

    /**
     * Set the value of the event section with a new value
     * @param element event section
     * @param newName new value
     * @return new event section
     */
    public static PsiElement setName(SmlEventsValue element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(SmlTypes.EVENT_NAME);
        if (keyNode != null) {

            SmlEventsValue property = SmlElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    /**
     * Get the value of the event section
     * @param element event section
     * @return PsiElement value
     */
    public static PsiElement getNameIdentifier(SmlEventsValue element) {
        ASTNode keyNode = element.getNode().findChildByType(SmlTypes.EVENT_NAME);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    /**
     * Get the call
     * @param element JavaCall section
     * @return PsiElement call
     */
    public static String getKey(SmlCallJavaFunctionInstruction element) {
        ASTNode keyNode = element.getNode().getFirstChildNode();
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the name of the called function
     * @param element element JavaCall section
     * @return String function name
     */
    public static String getValue(SmlCallJavaFunctionInstruction element) {
        ASTNode valueNode = element.getNode().findChildByType(SmlTypes.JAVA_FUNCTION_CALL);
        if (valueNode != null) {
            if (!valueNode.getText().contains("(")) {return "";}
            return valueNode.getText().substring(0,valueNode.getText().indexOf("("));
        } else {
            return null;
        }
    }

    /**
     * Get the name of the called function
     * @param element element JavaCall section
     * @return String function name
     */
    public static String getName(SmlCallJavaFunctionInstruction element) {
        return getValue(element);

    }

    /**
     * Get the parameters list of the JavaCall
     * @param element JavaCall section
     * @return the parameters list of the JavaCall
     */
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

    /**
     * Get the number of parameter of the JavaCall
     * @param element JavaCall section
     * @return the number of parameter of the JavaCall
     */
    public static int getParametersCount(SmlCallJavaFunctionInstruction element){
        return element.getParametersList().length;
    }


    /**
     * Set the value of the JavaCall section with a new value
     * @param element JavaCall section
     * @param newName new value
     * @return new JavaCall section
     */
    public static PsiElement setName(SmlCallJavaFunctionInstruction element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(SmlTypes.JAVA_FUNCTION_CALL);
        if (keyNode != null) {
            SmlEventsValue property = SmlElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    /**
     * Get the value of the JavaCall section
     * @param element JavaCall section
     * @return PsiElement value
     */
    public static PsiElement getNameIdentifier(SmlCallJavaFunctionInstruction element) {
        ASTNode keyNode = element.getNode().findChildByType(SmlTypes.JAVA_FUNCTION_CALL);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}

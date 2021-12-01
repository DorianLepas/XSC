package cea.language.xsc.psi.impl;

import cea.language.xsc.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class XCSPsiImplUtil {

    /**
     * Get the value of the property section
     * @param element property section
     * @return String value
     */
    public static String getValue(XCSProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the name before the value of the property section
     * @param element property section
     * @return String value
     */
    public static String getProp(XCSProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_NAME);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the value of the property section
     * @param element property section
     * @return String value
     */
    public static String getName(XCSProperty_ element) {
        return getValue(element);
    }

    /**
     * Set the value of the property section with a new value
     * @param element property section
     * @param newName new value
     * @return new property section
     */
    public static PsiElement setName(XCSProperty_ element, String newName) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            XCSProperty_ property = XCSElementFactory.createProperty(element.getProject(), newName);
            ASTNode newvalueNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(valueNode, newvalueNode);
        }
        return element;
    }

    /**
     * Get the value of the property section
     * @param element property section
     * @return PsiElement value
     */
    public static PsiElement getNameIdentifier(XCSProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getPsi();
        } else {
            return null;
        }
    }

    /**
     * Get the property type
     * @param element property section
     * @return String type
     */
    public static String getReferenceType(@NotNull final XCSProperty_ element) {
        PsiElement valueNode = element.getNode().getPsi().getParent();
        if (valueNode != null) {
            valueNode = valueNode.getPrevSibling();
            // Search for a Predefined name
            while (!valueNode.getText().equals("<")) {
                if (valueNode.getText().equals("CEID") || valueNode.getText().equals("DVID") || valueNode.getText().equals("ECID") || valueNode.getText().equals("SVID")) {
                    return valueNode.getText();
                }
                valueNode = valueNode.getPrevSibling();
            }
        }
        return "";
    }

    /**
     * Get the value of the function core
     * @param element function core
     * @return String value
     */
    public static String getValue(XCSFunctionCore element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.VARIABLE_VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the name of the containing function
     * @param element function core
     * @return String value
     */
    public static String getFunctionName(XCSFunctionCore element) {
        ASTNode valueNode = element.getNode();
        while (valueNode != null && !(valueNode.getPsi() instanceof XCSFunctions)) {
            valueNode = valueNode.getTreeParent();
        }
        if (valueNode == null) {
            return "";
        }
        return Objects.requireNonNull(valueNode.findChildByType(XCSTypes.FUNCTION_NAME)).getText();
    }

    /**
     * Get the stream function of the function core
     * @param element function core
     * @return String stream function
     */
    public static String getSF(XCSFunctionCore element) {
        ASTNode valueNode = element.getNode();
        while (valueNode != null && !(valueNode.getPsi() instanceof XCSFunctions)) {
            valueNode = valueNode.getTreeParent();
        }
        if (valueNode == null) {
            return "";
        }
        String SF = Objects.requireNonNull(valueNode.findChildByType(XCSTypes.STREAM_FUNCTION)).getText();
        if (SF.contains("W")) {
            SF = SF.substring(0, SF.indexOf(" W"));
        }
        return SF;
    }

    /**
     * Get the depth of the function core
     * @param element function core
     * @return Int depth
     */
    public static int getDepth(XCSFunctionCore element) {
        ASTNode valueNode = element.getNode();
        int Depth = 0;
        while (!(valueNode.getPsi() instanceof XCSFunctions)) {
            valueNode = valueNode.getTreeParent();
            Depth++;
        }
        return Depth;
    }

    /**
     * Get the comment size of the function core
     * @param element function core
     * @return Int comment size
     */
    public static int getCommentSize(XCSFunctionCore element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.FUNCTION_COMMENT);
        if (valueNode != null) {
            return valueNode.getText().length() + 1;
        } else {
            return 0;
        }
    }

    /**
     * Get the value of the function core
     * @param element function core
     * @return String value
     */
    public static String getName(XCSFunctionCore element) {
        return getValue(element);
    }

    /**
     * Set the value of the function core section with a new value
     * @param element function core section
     * @param newName new value
     * @return new function core section
     */
    public static PsiElement setName(XCSFunctionCore element, String newName) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.VARIABLE_VALUE);
        if (valueNode != null) {
            XCSProperty_ property = XCSElementFactory.createProperty(element.getProject(), newName);
            ASTNode newvalueNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(valueNode, newvalueNode);
        }
        return element;
    }

    /**
     * Get the value of the function core
     * @param element function core
     * @return String value
     */
    public static PsiElement getNameIdentifier(XCSFunctionCore element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.VARIABLE_VALUE);
        if (valueNode != null) {
            return valueNode.getPsi();
        } else {
            return null;
        }
    }
}

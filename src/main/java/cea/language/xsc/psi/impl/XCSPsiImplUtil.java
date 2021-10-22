package cea.language.xsc.psi.impl;

import cea.language.xsc.psi.XCSElementFactory;
import cea.language.xsc.psi.XCSProperty_;
import cea.language.xsc.psi.XCSTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class XCSPsiImplUtil {

    public static String getValue(XCSProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getProp(XCSProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_NAME);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(XCSProperty_ element) {
        return getValue(element);
    }

    public static PsiElement setName(XCSProperty_ element, String newName) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            XCSProperty_ property = XCSElementFactory.createProperty(element.getProject(), newName);
            ASTNode newvalueNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(valueNode, newvalueNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(XCSProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getPsi();
        } else {
            return null;
        }
    }

    public static String getReferenceType(@NotNull final XCSProperty_ element){
        PsiElement valueNode =  element.getNode().getPsi().getParent();
        if (valueNode != null) {
            valueNode = valueNode.getPrevSibling();
            while (!valueNode.getText().equals("<")) {
                if (valueNode.getText().equals("CEID") || valueNode.getText().equals("DVID") || valueNode.getText().equals("ECID") || valueNode.getText().equals("SVID")) {
                    return valueNode.getText();
                }
                valueNode = valueNode.getPrevSibling();
            }
        }
        return "";
    }


}

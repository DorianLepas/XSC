package cea.language.xsc.psi.impl;

import cea.language.xsc.filetype.XCSIcons;
import cea.language.xsc.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
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
        while (!(valueNode.getPsi() instanceof XCSFile)) {
            try{
                valueNode = valueNode.getTreeParent();
            }
            catch (NullPointerException e){
                return -1;
            }
            Depth++;
        }
        return Depth - 1;
    }

    /**
     * Get the comment size of the function core
     * @param element function core
     * @return Int comment size
     */
    public static int getCommentSize(XCSFunctionCore element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.FUNCTION_COMMENT);
        if (valueNode != null && valueNode.getStartOffset() == element.getNode().getLastChildNode().getStartOffset()) {
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

    /**
     * Create a new presentation for functions core
     * @param element functions core section
     * @return ItemPresentation new presentation
     */
    public static ItemPresentation getPresentation(XCSFunctionCore element) {
        return new ItemPresentation() {

            @Override
            public String getPresentableText() {
                return element.getValue();
            }

            @Override
            public String getLocationString() {
                return element.getFunctionName();
            }

            @Override
            public Icon getIcon(boolean open) {
                return XCSIcons.FILE;
            }

        };
    }

    /**
     * Get the value of the CE property section
     * @param element CE property section
     * @return String value
     */
    public static String getValue(XCSCeProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the value of the CE property section
     * @param element CE property section
     * @return String value
     */
    public static String getName(XCSCeProperty_ element) {
        return getValue(element);
    }

    /**
     * Set the value of the CE property section with a new value
     * @param element CE property section
     * @param newName new value
     * @return new CE property section
     */
    public static PsiElement setName(XCSCeProperty_ element, String newName) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            XCSCeProperty_ property = XCSElementFactory.createPropertyCe(element.getProject(), newName);
            ASTNode newvalueNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(valueNode, newvalueNode);
        }
        return element;
    }

    /**
     * Get the value of the CE property section
     * @param element CE property section
     * @return PsiElement value
     */
    public static PsiElement getNameIdentifier(XCSCeProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getPsi();
        } else {
            return null;
        }
    }

    /**
     * Create a new presentation for the CE property section
     * @param element CE property section
     * @return ItemPresentation new presentation
     */
    public static ItemPresentation getPresentation(XCSCeProperty_ element) {
        return new ItemPresentation() {

            @Override
            public String getPresentableText() {
                return element.getText();
            }

            @Override
            public String getLocationString() {
                return element.getContainingFile().getVirtualFile().getCanonicalPath().replace(element.getProject().getBasePath() + "/", "").replace("/",".");
            }

            @Override
            public Icon getIcon(boolean open) {
                return XCSIcons.FILE;
            }

        };
    }


    /**
     * Get the value of the EC property section
     * @param element EC property section
     * @return String value
     */
    public static String getValue(XCSEcProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the value of the EC property section
     * @param element EC property section
     * @return String value
     */
    public static String getName(XCSEcProperty_ element) {
        return getValue(element);
    }

    /**
     * Set the value of the EC property section with a new value
     * @param element EC property section
     * @param newName new value
     * @return new EC property section
     */
    public static PsiElement setName(XCSEcProperty_ element, String newName) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            XCSEcProperty_ property = XCSElementFactory.createPropertyEc(element.getProject(), newName);
            ASTNode newvalueNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(valueNode, newvalueNode);
        }
        return element;
    }

    /**
     * Get the value of the EC property section
     * @param element EC property section
     * @return PsiElement value
     */
    public static PsiElement getNameIdentifier(XCSEcProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getPsi();
        } else {
            return null;
        }
    }

    /**
     * Create a new presentation for the EC property section
     * @param element EC property section
     * @return ItemPresentation new presentation
     */
    public static ItemPresentation getPresentation(XCSEcProperty_ element) {
        return new ItemPresentation() {

            @Override
            public String getPresentableText() {
                return element.getText();
            }

            @Override
            public String getLocationString() {
                return element.getContainingFile().getVirtualFile().getCanonicalPath().replace(element.getProject().getBasePath() + "/", "").replace("/",".");
            }

            @Override
            public Icon getIcon(boolean open) {
                return XCSIcons.FILE;
            }

        };
    }

    /**
     * Get the value of the DV property section
     * @param element DV property section
     * @return String value
     */
    public static String getValue(XCSDvProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the value of the DV property section
     * @param element DV property section
     * @return String value
     */
    public static String getName(XCSDvProperty_ element) {
        return getValue(element);
    }

    /**
     * Set the value of the DV property section with a new value
     * @param element DV property section
     * @param newName new value
     * @return new DV property section
     */
    public static PsiElement setName(XCSDvProperty_ element, String newName) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            XCSDvProperty_ property = XCSElementFactory.createPropertyDv(element.getProject(), newName);
            ASTNode newvalueNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(valueNode, newvalueNode);
        }
        return element;
    }

    /**
     * Get the value of the DV property section
     * @param element DV property section
     * @return PsiElement value
     */
    public static PsiElement getNameIdentifier(XCSDvProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getPsi();
        } else {
            return null;
        }
    }

    /**
     * Create a new presentation for the DV property section
     * @param element DV property section
     * @return ItemPresentation new presentation
     */
    public static ItemPresentation getPresentation(XCSDvProperty_ element) {
        return new ItemPresentation() {

            @Override
            public String getPresentableText() {
                return element.getText();
            }

            @Override
            public String getLocationString() {
                return element.getContainingFile().getVirtualFile().getCanonicalPath().replace(element.getProject().getBasePath() + "/", "").replace("/",".");
            }

            @Override
            public Icon getIcon(boolean open) {
                return XCSIcons.FILE;
            }

        };
    }

    /**
     * Get the value of the SV property section
     * @param element SV property section
     * @return String value
     */
    public static String getValue(XCSSvProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Get the value of the SV property section
     * @param element SV property section
     * @return String value
     */
    public static String getName(XCSSvProperty_ element) {
        return getValue(element);
    }

    /**
     * Set the value of the SV property section with a new value
     * @param element SV property section
     * @param newName new value
     * @return new SV property section
     */
    public static PsiElement setName(XCSSvProperty_ element, String newName) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            XCSSvProperty_ property = XCSElementFactory.createPropertySv(element.getProject(), newName);
            ASTNode newvalueNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(valueNode, newvalueNode);
        }
        return element;
    }

    /**
     * Get the value of the SV property section
     * @param element SV property section
     * @return PsiElement value
     */
    public static PsiElement getNameIdentifier(XCSSvProperty_ element) {
        ASTNode valueNode = element.getNode().findChildByType(XCSTypes.PROPERTY_VALUE);
        if (valueNode != null) {
            return valueNode.getPsi();
        } else {
            return null;
        }
    }

    /**
     * Create a new presentation for the SV property section
     * @param element SV property section
     * @return ItemPresentation new presentation
     */
    public static ItemPresentation getPresentation(XCSSvProperty_ element) {
        return new ItemPresentation() {

            @Override
            public String getPresentableText() {
                return element.getText();
            }

            @Override
            public String getLocationString() {
                return element.getContainingFile().getVirtualFile().getCanonicalPath().replace(element.getProject().getBasePath() + "/", "").replace("/",".");
            }

            @Override
            public Icon getIcon(boolean open) {
                return XCSIcons.FILE;
            }

        };
    }
}

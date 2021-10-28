package cea.language.xsc.psi;

import cea.language.xsc.filetype.XCSFileType;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;

public class XCSElementFactory {

    public static XCSProperty_ createProperty(Project project, String name) {
        final XCSFile file = createFile(project, name);
        return file.findChildByClass(XCSProperty_.class);
    }

    public static XCSFile createFile(Project project, String text) {
        String name = "dummy.xsc";
        return (XCSFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, XCSFileType.INSTANCE, text);
    }

    public static void createPropertyCe(ASTNode node, String name, String value) {
        node.addLeaf(XCSTypes.CORE_START,"<",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.VARIABLE_TYPE,"V",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.CEID,"CEID",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_START,"{",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME,name,node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,value,node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME," EventLevel8",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,"\"Report\"",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_END,"}",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.VARIABLE_VALUE,"'-1'",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.CORE_END,">",node.getLastChildNode().getTreeNext());
    }

    public static void createPropertySv(ASTNode node, String name, String value) {
        node.addLeaf(XCSTypes.CORE_START,"<",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.VARIABLE_TYPE,"V",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.CEID,"SVID",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_START,"{",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME,"SecsValueToVfeiText",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,"\"false\" ",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME,name,node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,value,node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME," VfeiType",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,"\"V\"",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_END,"}",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.VARIABLE_VALUE,"'-1'",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.CORE_END,">",node.getLastChildNode().getTreeNext());
    }

    public static void createPropertyDv(ASTNode node, String name, String value) {
        node.addLeaf(XCSTypes.CORE_START,"<",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.VARIABLE_TYPE,"U4",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.CEID,"DVID",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_START,"{",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME,name,node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,value,node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME," VfeiType",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,"\"V\"",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_END,"}",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.VARIABLE_VALUE,"-1",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.CORE_END,">",node.getLastChildNode().getTreeNext());
    }

    public static void createPropertyEc(ASTNode node, String name, String value) {
        node.addLeaf(XCSTypes.CORE_START,"<",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.VARIABLE_TYPE,"U4",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.CEID,"ECID",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_START,"{",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME,name,node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,value,node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_NAME," VfeiType",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.EQUALS,"=",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_VALUE,"\"V\"",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.PROPERTY_END,"}",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.VARIABLE_VALUE,"-1",node.getLastChildNode().getTreeNext());
        node.addLeaf(XCSTypes.CORE_END,">",node.getLastChildNode().getTreeNext());
    }

    public static PsiElement createCRLF(Project project) {
        final XCSFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

}

package cea.language.xsc.psi;

import cea.language.xsc.filetype.XCSFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;


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

    public static PsiElement createPropertyCe(String name, String value,Project project) {
        final XCSFile file = createFile(project, "COLLECTIONEVENT_VARIABLES:\n<L\n" +
                "<V CEID {"+ name +"="+ value +" EventLevel8=\"Report\"} '-1'>" +
                "\n>\n."
        );
        return PsiTreeUtil.findChildOfType(file,XCSCeCore.class);
    }

    public static PsiElement createPropertySv(String name, String value,Project project) {
        final XCSFile file = createFile(project, "STATUSVARIABLES:\n<L\n" +
                "<V SVID {SecsValueToVfeiText=\"false\" "+ name +"="+ value +" VfeiType=\"V\"} '-1'>" +
                "\n>\n."
        );
        return PsiTreeUtil.findChildOfType(file,XCSSvCore.class);
    }

    public static PsiElement createPropertyDv(String name, String value,Project project) {
        final XCSFile file = createFile(project, "DATAVARIABLES:\n<L\n" +
                "<U4 DVID {"+ name +"="+ value +" VfeiType=\"V\"} -1>" +
                "\n>\n."
        );
        return PsiTreeUtil.findChildOfType(file,XCSDvCore.class);
    }

    public static PsiElement createPropertyEc(String name, String value,Project project) {
        final XCSFile file = createFile(project, "EQUIPMENTCONSTANTS:\n<L\n" +
                "<U4 ECID {"+ name +"="+ value +" VfeiType=\"V\"} -1>" +
                "\n>\n."
        );
        return PsiTreeUtil.findChildOfType(file,XCSEcCore.class);
    }

    public static PsiElement createReport(PsiElement element,Project project){
        final XCSFile file = createFile(project,
                "TEMPORARY: S0F0" +
                "<L\n" +
                element.getText() + "\n" +
                "<L\n" +
                ">\n" +
                ">" +
                "\n."
        );
        System.out.println(file.getText());
        return PsiTreeUtil.findChildOfType(file,XCSFunctionCore.class);
    }

    public static PsiElement createFunctionReport(PsiElement element,Project project){
        String new_name = "DR_" + ((XCSFunctionCore)element).getFunctionName().replace("LER_","");
        final XCSFile file = createFile(project,
                new_name + ": S2F33 * Define Report for " + new_name.substring(new_name.lastIndexOf("_") + 1) + "\n" +
                "<L\n" +
                "<U4 1>\n" +
                "<L\n" +
                "<L\n" +
                element.getText() + "\n" +
                "<L\n" +
                ">\n" +
                ">\n" +
                ">\n" +
                ">" +
                "\n."
        );
        return PsiTreeUtil.findChildOfType(file,XCSFunctions.class);
    }

    public static PsiElement createCRLF(Project project) {
        final XCSFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

}

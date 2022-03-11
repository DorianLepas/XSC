package cea.language.sml.psi;

import cea.language.sml.fileType.SmlFileType;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;

public class SmlElementFactory {
    public static SmlEventsValue createProperty(Project project, String name) {
        final SmlFile file = createFile(project, name);
        return (SmlEventsValue) file.getFirstChild();
    }

    public static SmlFile createFile(Project project, String text) {
        String name = "dummy.simple";
        return (SmlFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, SmlFileType.INSTANCE, text);
    }

    public static PsiElement createCRLF(Project project) {
        final SmlFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

    public static PsiElement createAliasBlock(String element,Project project){
        final SmlFile file = createFile(project, "alias :"+ element + "{\n}");
        return PsiTreeUtil.findChildOfType(file, SmlAliasBlock.class);
    }

    public static SmlAliasBlock createAlias(Project project, String newName) {
        final SmlFile file = createFile(project, newName);
        return (SmlAliasBlock) file.getFirstChild();
    }

    public static SmlStateNames createStateName(Project project, String name) {
        final SmlFile file = createFile(project, name);
        return (SmlStateNames) file.getFirstChild();
    }

    public static SmlStateBlock createState(Project project, String newName) {
        final SmlFile file = createFile(project, newName);
        return (SmlStateBlock) file.getFirstChild();
    }

    public static PsiElement createStateBlock(String element,Project project){
        final SmlFile file = createFile(project, "state :"+ element + "{\n}");
        return PsiTreeUtil.findChildOfType(file, SmlStateBlock.class);
    }

}

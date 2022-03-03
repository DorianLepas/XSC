package cea.language.sml.psi;

import cea.language.sml.fileType.SmlFileType;
import cea.language.xsc.psi.XCSDvCore;
import cea.language.xsc.psi.XCSFile;
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
}

package cea.language.xsc.psi;

import cea.language.xsc.filetype.XCSFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class XCSElementFactory {

    public static XCSProperty_ createProperty(Project project, String name) {
        final XCSFile file = createFile(project, name);
        return (XCSProperty_) file.findChildByClass(XCSProperty_.class);
    }

    public static XCSFile createFile(Project project, String text) {
        String name = "dummy.xsc";
        return (XCSFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, XCSFileType.INSTANCE, text);
    }

}

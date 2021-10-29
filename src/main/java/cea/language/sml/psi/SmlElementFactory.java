package cea.language.sml.psi;

import cea.language.sml.fileType.SmlFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;

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
}

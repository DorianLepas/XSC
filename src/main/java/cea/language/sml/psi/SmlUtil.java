package cea.language.sml.psi;

import cea.language.xsc.filetype.XCSFileType;
import cea.language.xsc.psi.*;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.*;

public class SmlUtil {
    /**
     * Searches the entire project for XSC language files with instances of the XSC property with the given value.
     *
     * @param file    current file
     * @param project current project
     * @param value   to check
     * @return matching properties
     */
    public static List<XCSCeProperty_> findProperties(SmlFile file, Project project, String value) {
        List<XCSCeProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null &&
                    (Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(xcsFile.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory() == Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory())) {
                Collection<XCSCeProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSCeProperty_.class);
                if (properties.size() != 0) {
                    for (XCSCeProperty_ property : properties) {
                        if (value.equals(Objects.requireNonNull(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE)).getText())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Searches the entire project for XSC language files with instances of the XSC properties.
     *
     * @param file    current file
     * @param project current project
     * @return all properties
     */
    public static List<XCSCeProperty_> findProperties(SmlFile file, Project project) {
        List<XCSCeProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null &&
                    (Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(xcsFile.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory() == Objects.requireNonNull(Objects.requireNonNull(file.getOriginalFile().getContainingDirectory().getParentDirectory()).getParentDirectory()).getParentDirectory())) {
                Collection<XCSCeProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSCeProperty_.class);
                if (properties.size() != 0) {
                    result.addAll(properties);
                }
            }
        }
        return result;
    }

    public static  List<PsiMethod> findFunctions(SmlFile file, Project project, String value){
        List<PsiMethod> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            PsiJavaFile javaFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (javaFile != null && javaFile.getName().equals(value.substring(0, value.lastIndexOf(".")) + ".java")){
                System.out.println(file.getContainingDirectory().getParentDirectory().getParentDirectory().getName());
                System.out.println(javaFile.getContainingDirectory().getParentDirectory().getParentDirectory().getParentDirectory().getParentDirectory().getName());
                if(file.getContainingDirectory().getParentDirectory().getParentDirectory().getName().equals("AEQC") && javaFile.getContainingDirectory().getParentDirectory().getParentDirectory().getParentDirectory().getParentDirectory().getName().equals("AEQCGenerator")) {
                    Collection<PsiMethod> properties = PsiTreeUtil.findChildrenOfType(javaFile, PsiMethod.class);
                    if (properties.size() != 0) {
                        for (PsiMethod property : properties) {
                            if (value.substring(value.lastIndexOf(".") + 1, value.length()).equals(property.getName())) {
                                result.add(property);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}
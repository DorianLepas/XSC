package cea.language.sml.psi;

import cea.language.xsc.filetype.XCSFileType;
import cea.language.xsc.psi.*;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
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

    public static List<PsiMethod> findFunctions(SmlFile file, Project project, String value) {
        List<PsiMethod> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            PsiJavaFile javaFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(virtualFile);
            String fileType = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getName();
            if (javaFile != null && javaFile.getName().equals(value.substring(0, value.lastIndexOf(".")) + ".java")) {
                PsiDirectory currentJavaFilePath = javaFile.getContainingDirectory();
                while (currentJavaFilePath != null) {
                    if (currentJavaFilePath.getName().equals("AEQCGenerator") && fileType.equals("AEQC")) {
                        AddFunctionProperties(value, javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals("FFCGenerator") && fileType.equals("FCC")) {
                        AddFunctionProperties(value, javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals("AutomationCommon") && (fileType.equals("AEQC") || fileType.equals("FCC"))) {
                        AddFunctionProperties(value, javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory()).getName())) {
                        AddFunctionProperties(value, javaFile, result);
                        SearchInExtends(value, javaFile, project, result);
                        break;
                    }
                    currentJavaFilePath = currentJavaFilePath.getParentDirectory();
                }
            }
        }
        return result;
    }

    public static List<PsiMethod> findFunctions(SmlFile file, Project project) {
        List<PsiMethod> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            PsiJavaFile javaFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(virtualFile);
            String fileType = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getName();
            if (javaFile != null) {
                PsiDirectory currentJavaFilePath = javaFile.getContainingDirectory();
                while (currentJavaFilePath != null) {
                    if (currentJavaFilePath.getName().equals("AEQCGenerator") && fileType.equals("AEQC") && !javaFile.getClass().isInterface()) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals("FFCGenerator") && fileType.equals("FCC") && !javaFile.getClass().isInterface()) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals("AutomationCommon") && (fileType.equals("AEQC") || fileType.equals("FCC")) && !javaFile.getClass().isInterface()) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory()).getName()) &&
                            !javaFile.getClass().isInterface()) {
                        AddFunctionProperties(javaFile, result);
                        SearchInExtends(javaFile, project, result);
                        break;
                    }
                    currentJavaFilePath = currentJavaFilePath.getParentDirectory();
                }
            }
        }
        return result;
    }

    private static void AddFunctionProperties(String value, PsiJavaFile javaFile, List<PsiMethod> result){
        Collection<PsiMethod> properties = PsiTreeUtil.findChildrenOfType(javaFile, PsiMethod.class);
        if (properties.size() != 0) {
            for (PsiMethod property : properties) {
                if (value.substring(value.lastIndexOf(".") + 1).equals(property.getName())) {
                    result.add(property);
                }
            }
        }
    }

    private static void AddFunctionProperties(PsiJavaFile javaFile, List<PsiMethod> result){
        Collection<PsiMethod> properties = PsiTreeUtil.findChildrenOfType(javaFile, PsiMethod.class);
        if (properties.size() != 0) {
            result.addAll(properties);
        }
    }

    private static void SearchInExtends(String value, PsiJavaFile javaFile, Project project, List<PsiMethod> result){
        Collection<PsiClass> extendsClass = PsiTreeUtil.findChildrenOfType(javaFile, PsiClass.class);
        if (extendsClass.size() != 0) {
            for (PsiClass extend : extendsClass) {
                PsiElement[] children = extend.getChildren();
                for(PsiElement child : children){
                    if(child.getOriginalElement().toString().equals("PsiReferenceList") && child.getOriginalElement().getFirstChild() != null) {
                        if (child.getOriginalElement().getFirstChild().getText().equals("extends")) {
                            PsiJavaFile extendFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(Objects.requireNonNull(((PsiJavaCodeReferenceElement) child.getOriginalElement().getLastChild()).resolve()).getContainingFile().getVirtualFile());
                            AddFunctionProperties(value, extendFile, result);
                        }
                    }
                }
            }
        }
    }

    private static void SearchInExtends(PsiJavaFile javaFile, Project project, List<PsiMethod> result){
        Collection<PsiClass> extendsClass = PsiTreeUtil.findChildrenOfType(javaFile, PsiClass.class);
        if (extendsClass.size() != 0) {
            for (PsiClass extend : extendsClass) {
                PsiElement[] children = extend.getChildren();
                for(PsiElement child : children){
                    if(child.getOriginalElement().toString().equals("PsiReferenceList") && child.getOriginalElement().getFirstChild() != null) {
                        if (child.getOriginalElement().getFirstChild().getText().equals("extends")) {
                            PsiJavaFile extendFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(Objects.requireNonNull(((PsiJavaCodeReferenceElement) child.getOriginalElement().getLastChild()).resolve()).getContainingFile().getVirtualFile());
                            AddFunctionProperties(extendFile, result);
                        }
                    }
                }
            }
        }
    }

}
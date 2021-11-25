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
        virtualFiles.removeIf(files -> !files.getParent().getName().equals("xsc"));
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
        virtualFiles.removeIf(files -> !files.getParent().getName().equals("xsc"));
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

    /**
     * Searches the entire project for Java language files with instances of the PsiMethod with the given value.
     *
     * @param file    current file
     * @param project current project
     * @param value     to check
     * @param element   to check
     * @return matching properties
     */
    public static List<PsiMethod> findFunctions(SmlFile file, Project project, String value, PsiElement element) {
        List<PsiMethod> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            PsiJavaFile javaFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(virtualFile);
            String fileType = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getName();
            if (javaFile != null && javaFile.getName().equals(value.substring(0, value.lastIndexOf(".")) + ".java")) {
                PsiDirectory currentJavaFilePath = javaFile.getContainingDirectory();
                while (currentJavaFilePath != null) {
                    String dir = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory()).getName();
                    if (!dir.equals("Automation") && currentJavaFilePath.getName().equals(dir)) {
                        AddFunctionProperties(value, element, javaFile, result);
                        SearchInExtends(value, element, javaFile, project, result);
                        break;
                    }
                    if ((result.size() == 0 && currentJavaFilePath.getName().equals("AEQCGenerator") && fileType.equals("AEQC")) ||
                            javaFile.getVirtualFile().getCanonicalPath().contains("AEQCGenerator") && fileType.equals("AEQCGenerator")) {
                        AddFunctionProperties(value, element, javaFile, result);
                        break;
                    }
                    if ((result.size() == 0 && currentJavaFilePath.getName().equals("FFCGenerator") && fileType.equals("FCC"))||
                            javaFile.getVirtualFile().getCanonicalPath().contains("AEQCGenerator") && fileType.equals("AEQCGenerator")) {
                        AddFunctionProperties(value, element, javaFile, result);
                        break;
                    }
                    if (result.size() == 0 && currentJavaFilePath.getName().equals("AutomationCommon") && (fileType.equals("AEQC") || fileType.equals("FCC"))) {
                        AddFunctionProperties(value, element, javaFile, result);
                        break;
                    }
                    currentJavaFilePath = currentJavaFilePath.getParentDirectory();
                }
            }
        }
        return result;
    }

    /**
     * Searches the entire project for Java language files with instances of the PsiMethod
     *
     * @param file    current file
     * @param project current project
     * @return all properties
     */
    public static List<PsiMethod> findFunctions(SmlFile file, Project project) {
        List<PsiMethod> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            PsiJavaFile javaFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(virtualFile);
            String fileType = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getName();
            if (javaFile != null) {
                PsiDirectory currentJavaFilePath = javaFile.getContainingDirectory();
                while (currentJavaFilePath != null) {
                    if (currentJavaFilePath.getName().equals("AEQCGenerator") && fileType.equals("AEQC")) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals("FFCGenerator") && fileType.equals("FCC")) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals("AutomationCommon") && (fileType.equals("AEQC") || fileType.equals("FCC"))) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    if (currentJavaFilePath.getName().equals(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory()).getName())) {
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

    /**
     * Add all the value matching PsiMethod in the javaFile to the result list
     *
     * @param value to check
     * @param javaFile the file where to search
     * @param result list of matching PsiMethods
     */

    private static void AddFunctionProperties(String value, PsiElement element, PsiJavaFile javaFile, List<PsiMethod> result){
        PsiMethod leastProperty = null;
        Collection<PsiMethod> properties = PsiTreeUtil.findChildrenOfType(javaFile, PsiMethod.class);
        if (properties.size() != 0) {
            for (PsiMethod property : properties) {
                if (value.substring(value.lastIndexOf(".") + 1).equals(property.getName())) {
                    result.add(property);
                    if (leastProperty == null || property.getParameterList().getParametersCount() < leastProperty.getParameterList().getParametersCount()){
                        leastProperty = property;
                    }
                }
            }
        }
        // Same function but different number of parameter
        if (result.size()>1){
            result.removeIf(property -> property.getParameterList().getParametersCount() != ((SmlCallJavaFunctionInstruction) element).getParametersCount());
            if (result.size() == 0){
                result.add(leastProperty);
            }
        }
    }

    /**
     * Add all PsiMethod in the javaFile to the result list
     *
     * @param javaFile the file where to search
     * @param result list of matching PsiMethods
     */
    private static void AddFunctionProperties(PsiJavaFile javaFile, List<PsiMethod> result){
        Collection<PsiMethod> properties = PsiTreeUtil.findChildrenOfType(javaFile, PsiMethod.class);
        if (properties.size() != 0) {
            result.addAll(properties);
        }
    }

    /**
     *  Search the value matching PsiMethod in the javaFile extends file within the project to the result list
     *
     * @param value to check
     * @param javaFile the file where to search
     * @param project current project
     * @param result list of matching PsiMethods
     */
    private static void SearchInExtends(String value, PsiElement element, PsiJavaFile javaFile, Project project, List<PsiMethod> result){
        Collection<PsiClass> extendsClass = PsiTreeUtil.findChildrenOfType(javaFile, PsiClass.class);
        if (extendsClass.size() != 0) {
            for (PsiClass extend : extendsClass) {
                PsiElement[] children = extend.getChildren();
                for(PsiElement child : children){
                    if(child.getOriginalElement().toString().equals("PsiReferenceList") && child.getOriginalElement().getFirstChild() != null) {
                        if (child.getOriginalElement().getFirstChild().getText().equals("extends")) {
                            PsiJavaFile extendFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(Objects.requireNonNull(((PsiJavaCodeReferenceElement) child.getOriginalElement().getLastChild()).resolve()).getContainingFile().getVirtualFile());
                            AddFunctionProperties(value, element, extendFile, result);
                        }
                    }
                }
            }
        }
    }

    /**
     *  Search all PsiMethod in the javaFile extends file within the project to the result list
     *
     * @param javaFile the file where to search
     * @param project current project
     * @param result list of matching PsiMethods
     */
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
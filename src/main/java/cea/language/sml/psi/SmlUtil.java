package cea.language.sml.psi;

import cea.language.xsc.filetype.XCSFileType;
import cea.language.xsc.psi.*;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
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
        // Get all xsc files
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        // Remove all non xsc/*.xsc files
        virtualFiles.removeIf(files -> !files.getParent().getName().equals("xsc"));
        // Go threw all leaving files
        for (VirtualFile virtualFile : virtualFiles) {
            // Convert to XCSFile
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            // Check if the current file is part of the same project as the sml file
            if (xcsFile != null &&
                    (Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(xcsFile.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory() == Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory())) {
                Collection<XCSCeProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSCeProperty_.class);
                if (properties.size() != 0) {
                    // Go threw all properties find in the current file
                    for (XCSCeProperty_ property : properties) {
                        // Check if they both have the same property value
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
        // Get all xsc files
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        // Remove all non xsc/*.xsc files
        virtualFiles.removeIf(files -> !files.getParent().getName().equals("xsc"));
        // Go threw all leaving files
        for (VirtualFile virtualFile : virtualFiles) {
            // Convert to XCSFile
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            // Check if the current file is part of the same project as the sml file
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
     * @param value   to check
     * @param element to check
     * @return matching properties
     */
    public static List<PsiMethod> findFunctions(SmlFile file, Project project, String value, PsiElement element) {
        List<PsiMethod> result = new ArrayList<>();
        // Get all java files
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.allScope(project));
        // Go threw all files
        for (VirtualFile virtualFile : virtualFiles) {
            // Convert to javaFile
            PsiJavaFile javaFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(virtualFile);
            String fileType = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getName();
            // Check if the java file name is the same as the first part of the JavaCall
            if (javaFile != null && javaFile.getName().equals(value.substring(0, value.lastIndexOf(".")) + ".java")) {
                PsiDirectory currentJavaFilePath = javaFile.getContainingDirectory();
                while (currentJavaFilePath != null) {
                    String dir = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory()).getName();
                    // Found the function in the same project (higher priority)
                    if (!dir.equals("Automation") && currentJavaFilePath.getName().equals(dir)) {
                        AddFunctionProperties(value, element, javaFile, result);
                        SearchInExtends(value, element, javaFile, project, result);
                        break;
                    }
                    // Found the function in the AEQC (only if the JavaCall file is in the AEQC directory) project (lower priority)
                    if ((result.size() == 0 && currentJavaFilePath.getName().equals("AEQCGenerator") && fileType.equals("AEQC")) ||
                            javaFile.getVirtualFile().getCanonicalPath().contains("AEQCGenerator") && fileType.equals("AEQCGenerator")) {
                        AddFunctionProperties(value, element, javaFile, result);
                        break;
                    }
                    // Found the function in the FFC (only if the JavaCall file is in the FFC directory) project (lower priority)
                    if ((result.size() == 0 && currentJavaFilePath.getName().equals("FFCGenerator") && fileType.equals("FCC")) ||
                            javaFile.getVirtualFile().getCanonicalPath().contains("FFCGenerator") && fileType.equals("FFCGenerator")) {
                        AddFunctionProperties(value, element, javaFile, result);
                        break;
                    }
                    // Found the function in the AutomationCommon project (lower priority)
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
        // Get all java files
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.allScope(project));
        // Go threw all files
        for (VirtualFile virtualFile : virtualFiles) {
            // Convert to javaFile
            PsiJavaFile javaFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(virtualFile);
            String fileType = Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getName();
            if (javaFile != null) {
                PsiDirectory currentJavaFilePath = javaFile.getContainingDirectory();
                while (currentJavaFilePath != null) {
                    // Get all the function the AEQCGenerator project (only in java directory)
                    if (currentJavaFilePath.getName().equals("AEQCGenerator") && fileType.equals("AEQC") && javaFile.getVirtualFile().getCanonicalPath().contains("java")) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    // Get all the function the FFCGenerator project (only in java directory)
                    if (currentJavaFilePath.getName().equals("FFCGenerator") && fileType.equals("FCC") && javaFile.getVirtualFile().getCanonicalPath().contains("java")) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    // Get all the function the AutomationCommon project (only in java directory)
                    if (currentJavaFilePath.getName().equals("AutomationCommon") && (fileType.equals("AEQC") || fileType.equals("FCC")) && javaFile.getVirtualFile().getCanonicalPath().contains("java")) {
                        AddFunctionProperties(javaFile, result);
                        break;
                    }
                    // Get all the function the same project as the java file (only in java directory)
                    if (currentJavaFilePath.getName().equals(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(file.getContainingDirectory()).getParentDirectory()).getParentDirectory()).getParentDirectory()).getName()) && javaFile.getVirtualFile().getCanonicalPath().contains("java")) {
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
     * @param value    to check
     * @param javaFile the file where to search
     * @param result   list of matching PsiMethods
     */

    private static void AddFunctionProperties(String value, PsiElement element, PsiJavaFile javaFile, List<PsiMethod> result) {
        // Check if the file is an interface
        if (javaFile.getClasses()[0].isInterface() || javaFile.getClasses()[0].isEnum()) {
            return;
        }
        PsiMethod leastProperty = null;
        // Get all the PsiMethod of the javaFile
        Collection<PsiMethod> properties = PsiTreeUtil.findChildrenOfType(javaFile, PsiMethod.class);
        // Ensure there is at least 1 PsiMethod
        if (properties.size() != 0) {
            // Go threw all PsiMethod
            for (PsiMethod property : properties) {
                // Check the PsiMethod name si the same as the second part of the JavaCall
                if (value.substring(value.lastIndexOf(".") + 1).equals(property.getName())) {
                    result.add(property);
                    // Stock the PsiMethod with the least number of parameters
                    if (leastProperty == null || property.getParameterList().getParametersCount() < leastProperty.getParameterList().getParametersCount()) {
                        leastProperty = property;
                    }
                }
            }
        }
        // Same function but different number of parameter
        if (result.size() > 1) {
            // Remove all PsiMethod not in the good file
            result.removeIf(property -> !property.getContainingFile().getVirtualFile().getCanonicalPath().equals(javaFile.getVirtualFile().getCanonicalPath()));
            // Remove all PsiMethod with a different number of parameters than the JavaCall
            result.removeIf(property -> property.getParameterList().getParametersCount() != ((SmlCallJavaFunctionInstruction) element).getParametersCount());
            // If they all have a different number of parameters, reference to the PsiMethod with the least number of parameters
            if (result.size() == 0) {
                result.add(leastProperty);
            }
        }
    }

    /**
     * Add all PsiMethod in the javaFile to the result list
     *
     * @param javaFile the file where to search
     * @param result   list of matching PsiMethods
     */
    private static void AddFunctionProperties(PsiJavaFile javaFile, List<PsiMethod> result) {
        // Check if the file is an interface
        if (javaFile.getClasses()[0].isInterface() || javaFile.getClasses()[0].isEnum()) {
            return;
        }
        // Get all the PsiMethod of the javaFile
        Collection<PsiMethod> properties = PsiTreeUtil.findChildrenOfType(javaFile, PsiMethod.class);
        if (properties.size() != 0) {
            result.addAll(properties);
        }
        //result.removeIf(property -> !property.getContainingFile().getVirtualFile().getCanonicalPath().equals(javaFile.getVirtualFile().getCanonicalPath()));
    }

    /**
     * Search the value matching PsiMethod in the javaFile extends file within the project to the result list
     *
     * @param value    to check
     * @param javaFile the file where to search
     * @param project  current project
     * @param result   list of matching PsiMethods
     */
    private static void SearchInExtends(String value, PsiElement element, PsiJavaFile javaFile, Project project, List<PsiMethod> result) {
        // Get the PsiReferenceLists of the javaFile
        Collection<PsiReferenceList> children = PsiTreeUtil.findChildrenOfType(javaFile, PsiReferenceList.class);
        // Go threw all the extended files
        for (PsiElement child : children) {
            if (child.getOriginalElement().getFirstChild() != null) {
                if (child.getOriginalElement().getFirstChild().getText().equals("extends")) {
                    PsiElement ref = ((PsiJavaCodeReferenceElement) child.getOriginalElement().getLastChild()).resolve();
                    if (ref != null) {
                        VirtualFile file = ref.getContainingFile().getVirtualFile();
                        if (file != null) {
                            PsiJavaFile extendFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(file);
                            if (extendFile != null && extendFile.getVirtualFile().getCanonicalPath().contains("java")) {
                                AddFunctionProperties(value, element, extendFile, result);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Search all PsiMethod in the javaFile extends file within the project to the result list
     *
     * @param javaFile the file where to search
     * @param project  current project
     * @param result   list of matching PsiMethods
     */
    private static void SearchInExtends(PsiJavaFile javaFile, Project project, List<PsiMethod> result) {
        // Get the PsiReferenceLists of the javaFile
        Collection<PsiReferenceList> children = PsiTreeUtil.findChildrenOfType(javaFile, PsiReferenceList.class);
        // Go threw all the extended files
        for (PsiElement child : children) {
            if (child.getOriginalElement().toString().equals("PsiReferenceList") && child.getOriginalElement().getFirstChild() != null) {
                if (child.getOriginalElement().getFirstChild().getText().equals("extends")) {
                    PsiElement ref = ((PsiJavaCodeReferenceElement) child.getOriginalElement().getLastChild()).resolve();
                    if (ref != null) {
                        VirtualFile file = ref.getContainingFile().getVirtualFile();
                        if (file != null) {
                            PsiJavaFile extendFile = (PsiJavaFile) PsiManager.getInstance(project).findFile(file);
                            if (extendFile != null && extendFile.getVirtualFile().getCanonicalPath().contains("java")) {
                                AddFunctionProperties(extendFile, result);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Searches in the sml file instances of the Sml Alias Blocks with the given value.
     *
     * @param containingFile current sml file
     * @param value          to check
     * @return matching alias
     */
    public static List<SmlAliasBlock> findPropertiesInAlias(SmlFile containingFile, String value) {
        List<SmlAliasBlock> result = new ArrayList<>();
        // Check if the current file is part of the same project as the sml file
        if (containingFile != null) {
            Collection<SmlAliasBlock> alias = PsiTreeUtil.findChildrenOfType(containingFile, SmlAliasBlock.class);
            if (alias.size() != 0) {
                // Go threw all properties find in the current file
                for (SmlAliasBlock alias_ : alias) {
                    // Check if they both have the same property value
                    if (value.equals(Objects.requireNonNull(alias_.getNode().findChildByType(SmlTypes.ALIAS_NAME)).getText())) {
                        result.add(alias_);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Searches in the sml file instances of the Sml Alias Blocks.
     *
     * @param containingFile current sml file
     * @return all alias
     */
    public static List<SmlAliasBlock> findPropertiesInAlias(SmlFile containingFile) {
        List<SmlAliasBlock> result = new ArrayList<>();
        // Check if the current file is part of the same project as the sml file
        if (containingFile != null) {
            Collection<SmlAliasBlock> alias = PsiTreeUtil.findChildrenOfType(containingFile, SmlAliasBlock.class);
            if (alias.size() != 0) {
                result.addAll(alias);
            }
        }
        return result;
    }

    /**
     * Searches in the Equipment file event declaration with the given value.
     *
     * @param containingFile current sml file
     * @param project        current project
     * @param value          to check
     * @return matching event declaration
     */
    public static List<PsiLiteralExpression> findPropertiesInDeclaration(SmlFile containingFile, Project project, String value) {
        List<PsiLiteralExpression> result = new ArrayList<>();
        // Get Equipment file
        Module module = ModuleUtilCore.findModuleForPsiElement(containingFile);
        if (module == null){
            return result;
        }
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.moduleScope(module));
        virtualFiles.removeIf(e -> !e.getName().equals("Equipment.java") || !e.getCanonicalPath().contains(containingFile.getContainingDirectory().getParentDirectory().getParentDirectory().getParentDirectory().getName()));
        if (virtualFiles.size() == 1) {
            PsiJavaFile EquipmentFile = (PsiJavaFile) PsiManager.getInstance(project).findFile((VirtualFile) virtualFiles.toArray()[0]);
            // if not find
            if (EquipmentFile != null) {
                Collection<PsiMethodCallExpression> Expr = PsiTreeUtil.findChildrenOfType(EquipmentFile, PsiMethodCallExpression.class);
                if (Expr.size() != 0) {
                    // Go threw all expression find in the current file
                    for (PsiMethodCallExpression e : Expr) {
                        // Check if they both have the same property value
                        if (e.getMethodExpression().getText().equals("fireEvent")) {
                            if (e.getArgumentList().getExpressionCount() == 1 && e.getArgumentList().getExpressions()[0].getText().equals(value) && e.getArgumentList().getExpressions()[0] instanceof PsiLiteralExpression) {
                                result.add((PsiLiteralExpression) e.getArgumentList().getExpressions()[0]);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Searches in the Equipment file event declaration.
     *
     * @param containingFile current sml file
     * @param project        current project
     * @return all event declaration
     */
    public static List<PsiLiteralExpression> findPropertiesInDeclaration(SmlFile containingFile, Project project) {
        List<PsiLiteralExpression> result = new ArrayList<>();
        // Get Equipment file
        Module module = ModuleUtilCore.findModuleForPsiElement(containingFile);
        if (module == null){
            return result;
        }
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.moduleScope(module));
        virtualFiles.removeIf(e -> !e.getName().equals("Equipment.java") || !e.getCanonicalPath().contains(containingFile.getContainingDirectory().getParentDirectory().getParentDirectory().getParentDirectory().getName()));
        if (virtualFiles.size() == 1) {
            PsiJavaFile EquipmentFile = (PsiJavaFile) PsiManager.getInstance(project).findFile((VirtualFile) virtualFiles.toArray()[0]);
            // if not find
            if (EquipmentFile != null) {
                Collection<PsiMethodCallExpression> Expr = PsiTreeUtil.findChildrenOfType(EquipmentFile, PsiMethodCallExpression.class);
                if (Expr.size() != 0) {
                    // Go threw all expression find in the current file
                    for (PsiMethodCallExpression e : Expr) {
                        // Check if they both have the same property value
                        if (e.getMethodExpression().getText().equals("fireEvent") && e.getArgumentList().getExpressions()[0] instanceof PsiLiteralExpression) {
                            result.add((PsiLiteralExpression) e.getArgumentList().getExpressions()[0]);
                        }
                    }
                }
            }
        }
        return result;
    }
}
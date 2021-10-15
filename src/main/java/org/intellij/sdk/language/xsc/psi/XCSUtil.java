package org.intellij.sdk.language.xsc.psi;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.xsc.filetype.XCSFileType;

import java.util.*;

public class XCSUtil {
    /**
     * Searches the entire project for XSC language files with instances of the XSC property with the given value.
     *
     * @param file   current file
     * @param project current project
     * @param value     to check
     * @return matching properties
     */
    public  static List<XCSCeProperty_> findPropertiesCe(XCSFile file, Project project, String value) {
        List<XCSCeProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSCeProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile,XCSCeProperty_.class);
                if (properties.size() != 0) {
                    for (XCSCeProperty_ property : properties) {
                        if (value.equals(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE).getText())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public  static List<XCSDvProperty_> findPropertiesDv(XCSFile file, Project project, String value) {
        List<XCSDvProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSDvProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile,XCSDvProperty_.class);
                if (properties.size() != 0) {
                    for (XCSDvProperty_ property : properties) {
                        if (value.equals(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE).getText())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public  static List<XCSEcProperty_> findPropertiesEc(XCSFile file, Project project, String value) {
        List<XCSEcProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSEcProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile,XCSEcProperty_.class);
                if (properties.size() != 0) {
                    for (XCSEcProperty_ property : properties) {
                        if (value.equals(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE).getText())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public  static List<XCSSvProperty_> findPropertiesSv(XCSFile file, Project project, String value) {
        List<XCSSvProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSSvProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile,XCSSvProperty_.class);
                if (properties.size() != 0) {
                    for (XCSSvProperty_ property : properties) {
                        if (value.equals(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE).getText())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }



    public static List<XCSProperty_> findProperties(Project project) {
        List<XCSProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null) {
                Collection<XCSProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile,XCSProperty_.class);
                if (properties.size() != 0) {
                    List<XCSProperty_> propertiesList = new ArrayList<>(properties);
                    Collections.addAll(result, (XCSProperty_[])propertiesList.toArray());
                }
            }
        }

        return result;
    }


}


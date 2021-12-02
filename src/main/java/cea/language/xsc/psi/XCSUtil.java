package cea.language.xsc.psi;

import cea.language.xsc.filetype.XCSFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.*;

public class XCSUtil {
    /**
     * Searches the entire project for XSC language files with instances of the XSC property with the given value.
     *
     * @param file    current file
     * @param project current project
     * @param value   to check
     * @return matching properties
     */
    public static List<XCSCeProperty_> findPropertiesCe(XCSFile file, Project project, String value) {
        List<XCSCeProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSCeProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSCeProperty_.class);
                if (properties.size() != 0) {
                    for (XCSCeProperty_ property : properties) {
                        if (value.equals(Objects.requireNonNull(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE)).getText()) && (property.getParent().getParent().getNode().findChildByType(XCSTypes.LIST_TYPE) == null)) {
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
    public static List<XCSCeProperty_> findPropertiesCe(XCSFile file, Project project) {
        List<XCSCeProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSCeProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSCeProperty_.class);
                if (properties.size() != 0) {
                    result.addAll(properties);
                }
            }
        }
        return result;
    }


    public static List<XCSDvProperty_> findPropertiesDv(XCSFile file, Project project, String value) {
        List<XCSDvProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSDvProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSDvProperty_.class);
                if (properties.size() != 0) {
                    for (XCSDvProperty_ property : properties) {
                        if (value.equals(Objects.requireNonNull(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE)).getText()) && (property.getParent().getParent().getNode().findChildByType(XCSTypes.LIST_TYPE) == null)) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<XCSDvProperty_> findPropertiesDv(XCSFile file, Project project) {
        List<XCSDvProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSDvProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSDvProperty_.class);
                if (properties.size() != 0) {
                    result.addAll(properties);
                }
            }
        }
        return result;
    }


    public static List<XCSEcProperty_> findPropertiesEc(XCSFile file, Project project, String value) {
        List<XCSEcProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSEcProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSEcProperty_.class);
                if (properties.size() != 0) {
                    for (XCSEcProperty_ property : properties) {
                        if (value.equals(Objects.requireNonNull(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE)).getText()) && (property.getParent().getParent().getNode().findChildByType(XCSTypes.LIST_TYPE) == null)) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<XCSEcProperty_> findPropertiesEc(XCSFile file, Project project) {
        List<XCSEcProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSEcProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSEcProperty_.class);
                if (properties.size() != 0) {
                    result.addAll(properties);
                }
            }
        }
        return result;
    }


    public static List<XCSSvProperty_> findPropertiesSv(XCSFile file, Project project, String value) {
        List<XCSSvProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSSvProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSSvProperty_.class);
                if (properties.size() != 0) {
                    for (XCSSvProperty_ property : properties) {
                        if (value.equals(Objects.requireNonNull(property.getNode().findChildByType(XCSTypes.PROPERTY_VALUE)).getText()) && (property.getParent().getParent().getNode().findChildByType(XCSTypes.LIST_TYPE) == null)) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<XCSSvProperty_> findPropertiesSv(XCSFile file, Project project) {
        List<XCSSvProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        virtualFiles.removeIf(filexsc -> !filexsc.getParent().getName().equals("xsc"));
        for (VirtualFile virtualFile : virtualFiles) {
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null && (xcsFile.getContainingDirectory() == file.getContainingDirectory())) {
                Collection<XCSSvProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile, XCSSvProperty_.class);
                if (properties.size() != 0) {
                    result.addAll(properties);
                }
            }
        }
        return result;
    }

    public static List<XCSFunctionCore> findReports(XCSFile file, String value) {
        List<XCSFunctionCore> result = new ArrayList<>();
        Collection<XCSFunctionCore> reports = PsiTreeUtil.findChildrenOfType(file, XCSFunctionCore.class);
        if (reports.size() != 0) {
            for (XCSFunctionCore report : reports) {
                if (value.equals(report.getValue()) && report.getSF().equals("S2F33") && (report.getDepth() == 4 || report.getDepth() == 5)) {
                    result.add(report);
                }
            }
        }
        return result;
    }

    public static List<XCSFunctionCore> findReports(XCSFile file) {
        List<XCSFunctionCore> result = new ArrayList<>();
        Collection<XCSFunctionCore> reports = PsiTreeUtil.findChildrenOfType(file, XCSFunctionCore.class);
        if (reports.size() != 0) {
            for (XCSFunctionCore report : reports) {
                if (report.getSF().equals("S2F33") && (report.getDepth() == 4 || report.getDepth() == 5)) {
                    result.add(report);
                }
            }
        }
        return result;
    }
}


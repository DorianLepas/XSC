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
     * @param project current project
     * @param value     to check
     * @return matching properties
     */
    public  static List<XCSProperty_> findProperties(Project project, String value) {
        List<XCSProperty_> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(XCSFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            System.out.println("FICHIER : " + virtualFile.getName());
            XCSFile xcsFile = (XCSFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (xcsFile != null) {
                Collection<XCSProperty_> properties = PsiTreeUtil.findChildrenOfType(xcsFile,XCSProperty_.class);
                //XCSProperty_[] properties = PsiTreeUtil.getChildrenOfType(xcsFile, XCSProperty_.class);
                if (properties.size() != 0) {
                    for (XCSProperty_ property : properties) {
                        if (value.equals(property.getValue())) {
                            System.out.println("ADD : " + property.getValue());
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<XCSProperty_> findProperties(Project project) {
        System.out.println("JE PASSE DANS XCSUtil");
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


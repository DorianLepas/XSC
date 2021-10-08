package org.intellij.sdk.language.xsc.psi;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.xsc.filetype.XCSFileType;
import org.jetbrains.annotations.NotNull;

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
                System.out.println("ELEMENTS : " );
                List<XCSProperty_> properties = getChild(xcsFile, XCSProperty_.class);
                //XCSProperty_[] properties = PsiTreeUtil.getChildrenOfType(xcsFile, XCSProperty_.class);
                System.out.println("TAILLE : ");
                if (properties != null) {
                    System.out.println("JE PASSE");
                    for (XCSProperty_ property : properties) {
                        System.out.println("VALUE : " + property);
                        if (value.equals(property.getValue())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        System.out.println("JE PASSE DANS XCSUtil(1) : " + result.size() + " & " + result);
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
                XCSProperty_[] properties = PsiTreeUtil.getChildrenOfType(xcsFile, XCSProperty_.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        System.out.println("JE PASSE DANS XCSUtil(2) : " + result.size() + " & " + result);
        return result;
    }

    public static List<XCSProperty_> getChild(PsiElement elt, @NotNull Class<? extends XCSProperty_> aClass){
        //TODO ALGO ARBRE A FAIRE
        int index = 0;
        List<XCSProperty_> prop = new ArrayList<>();
        for (PsiElement child = elt.getFirstChild(); child != null; child = child.getNextSibling()) {
            PsiElement[] inChild = child.getChildren();
            for(int i = 0 ; i < inChild.length; i++){
                if (aClass.isInstance(child)) {
                    System.out.println("JE SUIS DANS : " + child.getText());
                    prop.add(aClass.cast(child));
                }
            }
        }
        return prop;
    }

}


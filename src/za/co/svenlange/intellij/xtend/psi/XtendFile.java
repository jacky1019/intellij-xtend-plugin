package za.co.svenlange.intellij.xtend.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import za.co.svenlange.intellij.xtend.XtendFileType;

/**
 * XtendFile
 *
 * @author Sven Lange
 */
public class XtendFile extends PsiFileBase {
    
    public XtendFile(@NotNull FileViewProvider viewProvider, @NotNull Language language) {
        super(viewProvider, language);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return XtendFileType.INSTANCE;
    }
}

package za.co.svenlange.intellij.xtend;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static za.co.svenlange.intellij.xtend.XtendIcons.XTEND_FILE;

public class XtendFileType extends LanguageFileType {

    @NonNls
    public static final String DEFAULT_EXTENSION = "xtend";

    public static final LanguageFileType INSTANCE = new XtendFileType();

    private XtendFileType() {
        super(XtendLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Xtend";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Xtend files";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Override
    public Icon getIcon() {
        return XTEND_FILE;
    }
}

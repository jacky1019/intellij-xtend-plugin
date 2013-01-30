package za.co.svenlange.intellij.xtend;

import com.intellij.openapi.fileTypes.ExtensionFileNameMatcher;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

import static za.co.svenlange.intellij.xtend.XtendFileType.DEFAULT_EXTENSION;

public class XtendFileTypeFactory extends FileTypeFactory {

    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(XtendFileType.INSTANCE, new ExtensionFileNameMatcher(DEFAULT_EXTENSION));
    }

}

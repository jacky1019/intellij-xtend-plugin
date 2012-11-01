package za.co.svenlange.intellij.xtend;

import com.intellij.openapi.fileTypes.ExtensionFileNameMatcher;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

import static za.co.svenlange.intellij.xtend.XtendFileType.DEFAULT_EXTENSION;
import static za.co.svenlange.intellij.xtend.XtendFileType.INSTANCE;

public class XtendFileTypeLoader extends FileTypeFactory {

	public void createFileTypes(@NotNull FileTypeConsumer consumer) {
		consumer.consume(INSTANCE, new ExtensionFileNameMatcher(DEFAULT_EXTENSION));
	}

}

package za.co.svenlange.intellij.xtend;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import org.jetbrains.annotations.NotNull;

public class XtendLanguage extends Language {

	public static final XtendLanguage INSTANCE = new XtendLanguage();

	public XtendLanguage() {
		super("Xtend");
	}
}

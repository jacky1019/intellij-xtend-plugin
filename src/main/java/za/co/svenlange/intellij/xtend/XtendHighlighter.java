package za.co.svenlange.intellij.xtend;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * todo javadoc
 *
 * @author Sven Lange
 */
public class XtendHighlighter implements SyntaxHighlighter {

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType iElementType) {
		return new TextAttributesKey[0];  //To change body of implemented methods use File | Settings | File Templates.
	}
}

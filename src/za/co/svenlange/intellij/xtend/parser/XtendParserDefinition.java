package za.co.svenlange.intellij.xtend.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import za.co.svenlange.intellij.xtend.XtendLanguage;
import za.co.svenlange.intellij.xtend.lexer.XtendLexer;
import za.co.svenlange.intellij.xtend.psi.XtendFile;
import za.co.svenlange.intellij.xtend.psi.XtendTypes;

import java.io.Reader;

public class XtendParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);

    public static final IFileElementType FILE = new IFileElementType(Language.<XtendLanguage>findInstance(XtendLanguage.class));

    @NotNull
    public Lexer createLexer(Project project) {
        return new FlexAdapter(new XtendLexer((Reader) null));
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return TokenSet.create(XtendTypes.COMMENT);
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new XtendParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new XtendFile(viewProvider, XtendLanguage.INSTANCE);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MUST;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return XtendTypes.Factory.createElement(node);
    }
}

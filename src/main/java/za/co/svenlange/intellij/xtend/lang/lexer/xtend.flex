package za.co.svenlange.intellij.xtend.parsing;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

%%
%class XtendLexer
%implements FlexLexer, TokenType
%unicode
%type IElementType
%eof{  return;
%eof}
%%
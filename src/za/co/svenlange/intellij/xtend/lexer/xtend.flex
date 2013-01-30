package za.co.svenlange.intellij.xtend.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static za.co.svenlange.intellij.xtend.psi.XtendTypes.*;
import com.intellij.psi.TokenType;

%%

%class XtendLexer
%implements FlexLexer
%public
%final
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF= \n | \r | \r\n
WHITE_SPACE_CHAR=[\ \n\r\t\f]
VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
KEY_SEPARATOR=[\ \t]*[:=][\ \t]* | [\ \t]+
KEY_CHARACTER=[^:=\ \n\r\t\f\\] | "\\"{CRLF} | "\\".

%state IN_VALUE
%state IN_KEY_VALUE_SEPARATOR

%%

<YYINITIAL> {END_OF_LINE_COMMENT}        { yybegin(YYINITIAL); return TokenType.CODE_FRAGMENT; }

<YYINITIAL> {KEY_CHARACTER}+             { yybegin(IN_KEY_VALUE_SEPARATOR); return TokenType.CODE_FRAGMENT; }
<IN_KEY_VALUE_SEPARATOR> {KEY_SEPARATOR} { yybegin(IN_VALUE); return TokenType.CODE_FRAGMENT; }
<IN_VALUE> {VALUE_CHARACTER}+            { yybegin(YYINITIAL); return TokenType.CODE_FRAGMENT; }

<IN_KEY_VALUE_SEPARATOR> {CRLF}{WHITE_SPACE_CHAR}*  { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<IN_VALUE> {CRLF}{WHITE_SPACE_CHAR}*     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
{WHITE_SPACE_CHAR}+                      { return TokenType.WHITE_SPACE; }
.                                        { return TokenType.BAD_CHARACTER; }
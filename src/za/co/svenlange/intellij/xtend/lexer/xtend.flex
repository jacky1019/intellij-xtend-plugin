/*
 * Copyright 2013 Sven Lange
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package za.co.svenlange.intellij.xtend.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import za.co.svenlange.intellij.xtend.psi.XtendTypes;
import static za.co.svenlange.intellij.xtend.psi.XtendTypes.*;
%%

%class XtendLexer
%implements FlexLexer
%public
%final
%unicode
%function advance
%type IElementType
%debug

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

Identifier = [:jletter:] [:jletterdigit:]*

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*
DecLongLiteral    = {DecIntegerLiteral} [lL]

/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING

%%
<YYINITIAL> {
  /* keywords (Xbase) */
  "boolean"                      {return KEYWORD;}
  "break"                        {return KEYWORD;}
  "byte"                         {return KEYWORD;}
  "case"                         {return KEYWORD;}
  "catch"                        {return KEYWORD;}
  "char"                         {return KEYWORD;}
  "class"                        {return KEYWORD;}
  "const"                        {return KEYWORD;}
  "continue"                     {return KEYWORD;}
  "do"                           {return KEYWORD;}
  "double"                       {return KEYWORD;}
  "else"                         {return KEYWORD;}
  "extends"                      {return KEYWORD;}
  "finally"                      {return KEYWORD;}
  "float"                        {return KEYWORD;}
  "for"                          {return KEYWORD;}
  "default"                      {return KEYWORD;}
  "int"                          {return KEYWORD;}
  "interface"                    {return KEYWORD;}
  "long"                         {return KEYWORD;}
  "native"                       {return KEYWORD;}
  "goto"                         {return KEYWORD;}
  "if"                           {return KEYWORD;}
  "public"                       {return KEYWORD;}
  "short"                        {return KEYWORD;}
  "super"                        {return KEYWORD;}
  "switch"                       {return KEYWORD;}
  "synchronized"                 {return KEYWORD;}
  "transient"                    {return KEYWORD;}
  "void"                         {return KEYWORD;}
  "while"                        {return KEYWORD;}
  "this"                         {return KEYWORD;}
  
  /* keywords (Xtend) */
  "abstract"                     {return KEYWORD;}
  "create"                       {return KEYWORD;}
  "def"                          {return KEYWORD;}
  "dispatch"                     {return KEYWORD;}
  "extension"                    {return KEYWORD;}
  "final"                        {return KEYWORD;}
  "implements"                   {return KEYWORD;}
  "import"                       {return KEYWORD;}
  "instanceof"                   {return KEYWORD;}
  "new"                          {return KEYWORD;}
  "override"                     {return KEYWORD;}
  "package"                      {return KEYWORD;}
  "protected"                    {return KEYWORD;}
  "private"                      {return KEYWORD;}
  "return"                       {return KEYWORD;}
  "static"                       {return KEYWORD;}
  "throws"                       {return KEYWORD;}
  "val"                          {return KEYWORD;}
  "var"                          {return KEYWORD;}
  
  
  /* boolean literals */
  "true"                         {return KEYWORD;}
  "false"                        {return KEYWORD;}
  
  /* null literal */
  "null"                         {return KEYWORD;}
  
  
  /* separators */
  "("                            {return BUCHSTABEN;}
  ")"                            {return BUCHSTABEN;}
  "{"                            {return BUCHSTABEN;}
  "}"                            {return BUCHSTABEN;}
  "["                            {return BUCHSTABEN;}
  "]"                            {return BUCHSTABEN;}
  ";"                            {return BUCHSTABEN;}
  ","                            {return BUCHSTABEN;}
  "."                            {return BUCHSTABEN;}
  "::"                           {return BUCHSTABEN;}
  
  /* operators */
  "="                            {return BUCHSTABEN;}
  ">"                            {return BUCHSTABEN;}
  "<"                            {return BUCHSTABEN;}
  "!"                            {return BUCHSTABEN;}
  "~"                            {return BUCHSTABEN;}
  "?"                            {return BUCHSTABEN;}
  ":"                            {return BUCHSTABEN;}
  "=="                           {return BUCHSTABEN;}
  "<="                           {return BUCHSTABEN;}
  ">="                           {return BUCHSTABEN;}
  "!="                           {return BUCHSTABEN;}
  "&&"                           {return BUCHSTABEN;}
  "||"                           {return BUCHSTABEN;}
  "++"                           {return BUCHSTABEN;}
  "--"                           {return BUCHSTABEN;}
  "+"                            {return BUCHSTABEN;}
  "-"                            {return BUCHSTABEN;}
  "*"                            {return BUCHSTABEN;}
  "/"                            {return BUCHSTABEN;}
  "&"                            {return BUCHSTABEN;}
  "|"                            {return BUCHSTABEN;}
  "^"                            {return BUCHSTABEN;}
  "%"                            {return BUCHSTABEN;}
  "<<"                           {return BUCHSTABEN;}
  ">>"                           {return BUCHSTABEN;}
  ">>>"                          {return BUCHSTABEN;}
  "+="                           {return BUCHSTABEN;}
  "-="                           {return BUCHSTABEN;}
  "*="                           {return BUCHSTABEN;}
  "/="                           {return BUCHSTABEN;}
  "&="                           {return BUCHSTABEN;}
  "|="                           {return BUCHSTABEN;}
  "^="                           {return BUCHSTABEN;}
  "%="                           {return BUCHSTABEN;}
  "<<="                          {return BUCHSTABEN;}
  ">>="                          {return BUCHSTABEN;}
  ">>>="                         {return BUCHSTABEN;}
  
  /* string literal */
  \"                             {yybegin(STRING);}
  
  /* numeric literals */
  {DecIntegerLiteral}            {return XtendTypes.INTEGERLITERAL;}
  {DecLongLiteral}               {return XtendTypes.INTEGERLITERAL;}
  
  /* identifiers */ 
  {Identifier}                   {return BUCHSTABEN;}
 
  /* literals */
  {DecIntegerLiteral}            {return BUCHSTABEN;}
  \"                             {return BUCHSTABEN;}

  /* operators */
  "="                            {return BUCHSTABEN;}
  "=="                           {return BUCHSTABEN;}
  "+"                            {return BUCHSTABEN;}

  /* comments */
  {Comment}                      {return COMMENT;}
 
  /* whitespace */
  {WhiteSpace}+                  {return TokenType.WHITE_SPACE;}
}

<STRING> {
  \"                             {yybegin(YYINITIAL); return XtendTypes.STRING;}
  
  {StringCharacter}+             {/**/}
  
  /* escape sequences */
  "\\b"                          { return XtendTypes.STRING; }
  "\\t"                          { return XtendTypes.STRING; }
  "\\n"                          { return XtendTypes.STRING; }
  "\\f"                          { return XtendTypes.STRING; }
  "\\r"                          { return XtendTypes.STRING; }
  "\\\""                         { return XtendTypes.STRING; }
  "\\'"                          { return XtendTypes.STRING; }
  "\\\\"                         { return XtendTypes.STRING; }
  
  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
}

// Unknown symbol is using for debug goals.
.                                { return TokenType.BAD_CHARACTER; }
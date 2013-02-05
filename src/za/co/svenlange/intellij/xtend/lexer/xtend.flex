package za.co.svenlange.intellij.xtend.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import za.co.svenlange.intellij.xtend.psi.XtendTypes;
%%

%class XtendLexer
%implements FlexLexer
%public
%final
%unicode
%function advance
%type IElementType

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

DecIntegerLiteral = 0 | [1-9][0-9]*

%state STRING

%%
  /* keywords (Xbase) */
  "boolean"                      {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "break"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "byte"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "case"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "catch"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "char"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "class"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "const"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "continue"                     {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "do"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "double"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "else"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "extends"                      {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "finally"                      {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "float"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "for"                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "default"                      {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "int"                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "interface"                    {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "long"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "native"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "goto"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "if"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "public"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "short"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "super"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "switch"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "synchronized"                 {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "transient"                    {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "void"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "while"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "this"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  
  /* keywords (Xtend) */
  "abstract"                     {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "create"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "def"                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "dispatch"                     {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "extension"                    {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "final"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "implements"                   {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "import"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "instanceof"                   {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "new"                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "override"                     {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "package"                      {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "protected"                    {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "private"                      {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "return"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "static"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "throws"                       {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "val"                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "var"                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  
  
  /* boolean literals */
  "true"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "false"                        {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  
  /* null literal */
  "null"                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  
  
  /* separators */
  "("                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ")"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "{"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "}"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "["                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "]"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ";"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ","                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "."                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "::"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  
  /* operators */
  "="                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ">"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "<"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "!"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "~"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "?"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ":"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "=="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "<="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ">="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "!="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "&&"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "||"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "++"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "--"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "+"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "-"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "*"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "/"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "&"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "|"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "^"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "%"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "<<"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ">>"                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ">>>"                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "+="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "-="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "*="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "/="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "&="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "|="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "^="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "%="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "<<="                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ">>="                          {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  ">>>="                         {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  
  
<YYINITIAL> {
  /* identifiers */ 
  {Identifier}                   {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
 
  /* literals */
  {DecIntegerLiteral}            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  \"                             {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}

  /* operators */
  "="                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "=="                           {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
  "+"                            {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}

  /* comments */
  {Comment}                      {System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN;}
 
  /* whitespace */
  {WhiteSpace}+                  {System.out.println("Token: "+ yytext()); return TokenType.WHITE_SPACE;}
}

<STRING> {
  \"                             { yybegin(YYINITIAL); 
                                   System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN; }
  [^\n\r\"\\]+                   { System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN; }
  \\t                            { System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN; }
  \\n                            { System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN; }

  \\r                            { System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN; }
  \\\"                           { System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN; }
  \\                             { System.out.println("Token: "+ yytext()); return XtendTypes.BUCHSTABEN; }
}

// Unknown symbol is using for debug goals.
.                                         { return TokenType.BAD_CHARACTER; }
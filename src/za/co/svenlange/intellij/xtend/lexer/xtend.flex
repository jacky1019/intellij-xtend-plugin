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
  "boolean"                      {return XtendTypes.KEYWORD;}
  "break"                        {return XtendTypes.KEYWORD;}
  "byte"                         {return XtendTypes.KEYWORD;}
  "case"                         {return XtendTypes.KEYWORD;}
  "catch"                        {return XtendTypes.KEYWORD;}
  "char"                         {return XtendTypes.KEYWORD;}
  "class"                        {return XtendTypes.KEYWORD;}
  "const"                        {return XtendTypes.KEYWORD;}
  "continue"                     {return XtendTypes.KEYWORD;}
  "do"                           {return XtendTypes.KEYWORD;}
  "double"                       {return XtendTypes.KEYWORD;}
  "else"                         {return XtendTypes.KEYWORD;}
  "extends"                      {return XtendTypes.KEYWORD;}
  "finally"                      {return XtendTypes.KEYWORD;}
  "float"                        {return XtendTypes.KEYWORD;}
  "for"                          {return XtendTypes.KEYWORD;}
  "default"                      {return XtendTypes.KEYWORD;}
  "int"                          {return XtendTypes.KEYWORD;}
  "interface"                    {return XtendTypes.KEYWORD;}
  "long"                         {return XtendTypes.KEYWORD;}
  "native"                       {return XtendTypes.KEYWORD;}
  "goto"                         {return XtendTypes.KEYWORD;}
  "if"                           {return XtendTypes.KEYWORD;}
  "public"                       {return XtendTypes.KEYWORD;}
  "short"                        {return XtendTypes.KEYWORD;}
  "super"                        {return XtendTypes.KEYWORD;}
  "switch"                       {return XtendTypes.KEYWORD;}
  "synchronized"                 {return XtendTypes.KEYWORD;}
  "transient"                    {return XtendTypes.KEYWORD;}
  "void"                         {return XtendTypes.KEYWORD;}
  "while"                        {return XtendTypes.KEYWORD;}
  "this"                         {return XtendTypes.KEYWORD;}
  
  /* keywords (Xtend) */
  "abstract"                     {return XtendTypes.KEYWORD;}
  "create"                       {return XtendTypes.KEYWORD;}
  "def"                          {return XtendTypes.KEYWORD;}
  "dispatch"                     {return XtendTypes.KEYWORD;}
  "extension"                    {return XtendTypes.KEYWORD;}
  "final"                        {return XtendTypes.KEYWORD;}
  "implements"                   {return XtendTypes.KEYWORD;}
  "import"                       {return XtendTypes.KEYWORD;}
  "instanceof"                   {return XtendTypes.KEYWORD;}
  "new"                          {return XtendTypes.KEYWORD;}
  "override"                     {return XtendTypes.KEYWORD;}
  "package"                      {return XtendTypes.KEYWORD;}
  "protected"                    {return XtendTypes.KEYWORD;}
  "private"                      {return XtendTypes.KEYWORD;}
  "return"                       {return XtendTypes.KEYWORD;}
  "static"                       {return XtendTypes.KEYWORD;}
  "throws"                       {return XtendTypes.KEYWORD;}
  "val"                          {return XtendTypes.KEYWORD;}
  "var"                          {return XtendTypes.KEYWORD;}
  
  
  /* boolean literals */
  "true"                         {return XtendTypes.KEYWORD;}
  "false"                        {return XtendTypes.KEYWORD;}
  
  /* null literal */
  "null"                         {return XtendTypes.KEYWORD;}
  
  
  /* separators */
  "("                            {return XtendTypes.BUCHSTABEN;}
  ")"                            {return XtendTypes.BUCHSTABEN;}
  "{"                            {return XtendTypes.BUCHSTABEN;}
  "}"                            {return XtendTypes.BUCHSTABEN;}
  "["                            {return XtendTypes.BUCHSTABEN;}
  "]"                            {return XtendTypes.BUCHSTABEN;}
  ";"                            {return XtendTypes.BUCHSTABEN;}
  ","                            {return XtendTypes.BUCHSTABEN;}
  "."                            {return XtendTypes.BUCHSTABEN;}
  "::"                           {return XtendTypes.BUCHSTABEN;}
  
  /* operators */
  "="                            {return XtendTypes.BUCHSTABEN;}
  ">"                            {return XtendTypes.BUCHSTABEN;}
  "<"                            {return XtendTypes.BUCHSTABEN;}
  "!"                            {return XtendTypes.BUCHSTABEN;}
  "~"                            {return XtendTypes.BUCHSTABEN;}
  "?"                            {return XtendTypes.BUCHSTABEN;}
  ":"                            {return XtendTypes.BUCHSTABEN;}
  "=="                           {return XtendTypes.BUCHSTABEN;}
  "<="                           {return XtendTypes.BUCHSTABEN;}
  ">="                           {return XtendTypes.BUCHSTABEN;}
  "!="                           {return XtendTypes.BUCHSTABEN;}
  "&&"                           {return XtendTypes.BUCHSTABEN;}
  "||"                           {return XtendTypes.BUCHSTABEN;}
  "++"                           {return XtendTypes.BUCHSTABEN;}
  "--"                           {return XtendTypes.BUCHSTABEN;}
  "+"                            {return XtendTypes.BUCHSTABEN;}
  "-"                            {return XtendTypes.BUCHSTABEN;}
  "*"                            {return XtendTypes.BUCHSTABEN;}
  "/"                            {return XtendTypes.BUCHSTABEN;}
  "&"                            {return XtendTypes.BUCHSTABEN;}
  "|"                            {return XtendTypes.BUCHSTABEN;}
  "^"                            {return XtendTypes.BUCHSTABEN;}
  "%"                            {return XtendTypes.BUCHSTABEN;}
  "<<"                           {return XtendTypes.BUCHSTABEN;}
  ">>"                           {return XtendTypes.BUCHSTABEN;}
  ">>>"                          {return XtendTypes.BUCHSTABEN;}
  "+="                           {return XtendTypes.BUCHSTABEN;}
  "-="                           {return XtendTypes.BUCHSTABEN;}
  "*="                           {return XtendTypes.BUCHSTABEN;}
  "/="                           {return XtendTypes.BUCHSTABEN;}
  "&="                           {return XtendTypes.BUCHSTABEN;}
  "|="                           {return XtendTypes.BUCHSTABEN;}
  "^="                           {return XtendTypes.BUCHSTABEN;}
  "%="                           {return XtendTypes.BUCHSTABEN;}
  "<<="                          {return XtendTypes.BUCHSTABEN;}
  ">>="                          {return XtendTypes.BUCHSTABEN;}
  ">>>="                         {return XtendTypes.BUCHSTABEN;}
  
  /* string literal */
  \"                             {yybegin(STRING);}
  
  /* numeric literals */
  {DecIntegerLiteral}            {return XtendTypes.INTEGERLITERAL;}
  {DecLongLiteral}               {return XtendTypes.INTEGERLITERAL;}
  
  /* identifiers */ 
  {Identifier}                   {return XtendTypes.BUCHSTABEN;}
 
  /* literals */
  {DecIntegerLiteral}            {return XtendTypes.BUCHSTABEN;}
  \"                             {return XtendTypes.BUCHSTABEN;}

  /* operators */
  "="                            {return XtendTypes.BUCHSTABEN;}
  "=="                           {return XtendTypes.BUCHSTABEN;}
  "+"                            {return XtendTypes.BUCHSTABEN;}

  /* comments */
  {Comment}                      {return XtendTypes.COMMENT;}
 
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
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

// Unknown symbol is using for debug goals.
.                                { return TokenType.BAD_CHARACTER; }
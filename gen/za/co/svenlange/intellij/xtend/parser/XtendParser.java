/*
 * Copyright 2012-2013 Sven Lange
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
 
 // This is a generated file. Not intended for manual editing.
 
package za.co.svenlange.intellij.xtend.parser;

import org.jetbrains.annotations.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static za.co.svenlange.intellij.xtend.psi.XtendTypes.*;
import static za.co.svenlange.intellij.xtend.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class XtendParser implements PsiParser {

  public static Logger LOG_ = Logger.getInstance("za.co.svenlange.intellij.xtend.parser.XtendParser");

  @NotNull
  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    int level_ = 0;
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this);
    Marker marker_ = builder_.mark();
    result_ = parse_root_(root_, builder_, level_);
    while (builder_.getTokenType() != null) {
      builder_.advanceLexer();
    }
    marker_.done(root_);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return XtendFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // Buchstaben|Keyword|String|IntegerLiteral|Comment|LineTerminator
  static boolean XtendFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "XtendFile")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, BUCHSTABEN);
    if (!result_) result_ = consumeToken(builder_, KEYWORD);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, INTEGERLITERAL);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, LINETERMINATOR);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

}

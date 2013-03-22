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
 
package za.co.svenlange.intellij.xtend.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface XtendTypes {


  IElementType BUCHSTABEN = new XtendTokenType("Buchstaben");
  IElementType COMMENT = new XtendTokenType("Comment");
  IElementType KEYWORD = new XtendTokenType("Keyword");
  IElementType LINETERMINATOR = new XtendTokenType("LineTerminator");
  IElementType STRING = new XtendTokenType("String");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

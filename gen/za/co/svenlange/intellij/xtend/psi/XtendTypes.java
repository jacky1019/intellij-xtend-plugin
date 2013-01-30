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
import za.co.svenlange.intellij.xtend.psi.impl.*;

public interface XtendTypes {

  IElementType PROPERTY = new XtendElementType("PROPERTY");

  IElementType COMMENT = new XtendTokenType("COMMENT");
  IElementType CRLF = new XtendTokenType("CRLF");
  IElementType KEY = new XtendTokenType("KEY");
  IElementType SEPARATOR = new XtendTokenType("SEPARATOR");
  IElementType VALUE = new XtendTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new XtendPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

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

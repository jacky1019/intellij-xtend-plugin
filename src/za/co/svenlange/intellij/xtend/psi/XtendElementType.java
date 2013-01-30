package za.co.svenlange.intellij.xtend.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import za.co.svenlange.intellij.xtend.XtendLanguage;

public class XtendElementType extends IElementType {

    public XtendElementType(@NonNls String debugName) {
        super(debugName, XtendLanguage.INSTANCE);
    }
    
}

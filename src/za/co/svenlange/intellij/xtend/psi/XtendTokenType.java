package za.co.svenlange.intellij.xtend.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import za.co.svenlange.intellij.xtend.XtendLanguage;

public class XtendTokenType extends IElementType {
    public XtendTokenType(@NotNull @NonNls String debugName) {
        super(debugName, XtendLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "XtendTokenType." + super.toString();
    }
}
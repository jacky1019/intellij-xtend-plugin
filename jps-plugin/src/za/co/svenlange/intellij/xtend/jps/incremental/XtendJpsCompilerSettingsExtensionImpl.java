package za.co.svenlange.intellij.xtend.jps.incremental;

import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.ex.JpsElementBase;

public class XtendJpsCompilerSettingsExtensionImpl extends JpsElementBase<XtendJpsCompilerSettingsExtensionImpl> implements XtendJpsCompilerSettingsExtension {
    private final XtendJpsCompilerSettingsState myState;

    public XtendJpsCompilerSettingsExtensionImpl(XtendJpsCompilerSettingsState state) {
        myState = state;
    }

    @NotNull
    @Override
    public XtendJpsCompilerSettingsExtensionImpl createCopy() {
        return new XtendJpsCompilerSettingsExtensionImpl(XmlSerializerUtil.createCopy(myState));
    }

    @Override
    public void applyChanges(@NotNull XtendJpsCompilerSettingsExtensionImpl modified) {
    }

    public boolean isCompileXtend() {
        return myState.COMPILE_XTEND;
    }

    public boolean isXtendBefore() {
        return myState.XTEND_BEFORE;
    }

    public boolean isCopyCljSources() {
        return myState.COPY_XTEND_SOURCES;
    }
}
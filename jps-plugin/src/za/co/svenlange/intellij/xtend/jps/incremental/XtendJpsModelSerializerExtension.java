package za.co.svenlange.intellij.xtend.jps.incremental;

import com.intellij.util.xmlb.XmlSerializer;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.serialization.JpsModelSerializerExtension;
import org.jetbrains.jps.model.serialization.JpsProjectExtensionSerializer;

import java.util.Collections;
import java.util.List;

public class XtendJpsModelSerializerExtension extends JpsModelSerializerExtension {

    public static final String XTEND_COMPILER_SETTINGS_COMPONENT_NAME = "XtendCompilerSettings";
    public static final String XTEND_COMPILER_SETTINGS_FILE = "xtend_compiler.xml";

    @NotNull
    @Override
    public List<? extends JpsProjectExtensionSerializer> getProjectExtensionSerializers() {
        return Collections.singletonList(new JpsProjectExtensionSerializer(XTEND_COMPILER_SETTINGS_FILE, XTEND_COMPILER_SETTINGS_COMPONENT_NAME) {
            @Override
            public void loadExtension(@NotNull JpsProject jpsProject, @NotNull Element componentTag) {
                XtendJpsCompilerSettingsState state = XmlSerializer.deserialize(componentTag, XtendJpsCompilerSettingsState.class);
                if (state != null) {
                    XtendJpsExtensionService.setExtension(jpsProject, new XtendJpsCompilerSettingsExtensionImpl(state));
                }
            }

            @Override
            public void saveExtension(@NotNull JpsProject jpsProject, @NotNull Element componentTag) {
            }
        });
    }

}

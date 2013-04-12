package za.co.svenlange.intellij.xtend.jps.incremental;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.ex.JpsElementChildRoleBase;

public class XtendJpsExtensionService {
    public static final JpsElementChildRoleBase<XtendJpsCompilerSettingsExtension> COMPILER_SETTINGS_ROLE = JpsElementChildRoleBase.create("xtend compiler settings");

    @Nullable
    public static XtendJpsCompilerSettingsExtension getExtension(@NotNull JpsProject project) {
        return project.getContainer().getChild(COMPILER_SETTINGS_ROLE);
    }


    public static void setExtension(@NotNull JpsProject project, XtendJpsCompilerSettingsExtension extension) {
        project.getContainer().setChild(COMPILER_SETTINGS_ROLE, extension);
    }
}

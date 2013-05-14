/*
 * Copyright 2013 Sven Lange
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

package za.co.svenlange.intellij.xtend.jps.incremental;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.ex.JpsElementChildRoleBase;

/**
 * @author Sven Lange
 * @since 2013-04-12
 */
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

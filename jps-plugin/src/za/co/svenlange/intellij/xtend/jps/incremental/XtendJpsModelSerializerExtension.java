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

import com.intellij.util.xmlb.XmlSerializer;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.serialization.JpsModelSerializerExtension;
import org.jetbrains.jps.model.serialization.JpsProjectExtensionSerializer;

import java.util.Collections;
import java.util.List;

/**
 * @author Sven Lange
 * @since 2013-04-12
 */
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

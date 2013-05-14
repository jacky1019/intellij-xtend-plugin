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

import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.ex.JpsElementBase;

/**
 * @author Sven Lange
 * @since 2013-04-12
 */
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
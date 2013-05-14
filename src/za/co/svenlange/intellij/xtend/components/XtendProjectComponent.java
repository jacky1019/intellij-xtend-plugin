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

package za.co.svenlange.intellij.xtend.components;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import org.jetbrains.annotations.NotNull;

/**
 * @author Sven Lange
 * @since 2013-04-26
 */
public class XtendProjectComponent implements ProjectComponent {

    public static final String XTEND_TRACEFILE_EXTENSION = ";*._trace;";

    @Override
    public void projectOpened() {
    }

    @Override
    public void projectClosed() {
    }

    @Override
    public void initComponent() {
        final String ignoredFilesList = FileTypeManager.getInstance().getIgnoredFilesList();
        if (!ignoredFilesList.contains(XTEND_TRACEFILE_EXTENSION)) {
            FileTypeManager.getInstance().setIgnoredFilesList(ignoredFilesList + XTEND_TRACEFILE_EXTENSION);
        }
    }

    @Override
    public void disposeComponent() {
    }

    @NotNull
    @Override
    public String getComponentName() {
        return getClass().getName();
    }
}

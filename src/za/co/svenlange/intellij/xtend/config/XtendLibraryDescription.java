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

package za.co.svenlange.intellij.xtend.config;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.roots.libraries.LibraryKind;
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration;
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription;
import com.intellij.openapi.roots.ui.configuration.libraryEditor.LibraryEditor;
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainer;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.intellij.openapi.roots.libraries.LibraryPresentationProvider.EP_NAME;
import static com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainer.LibraryLevel.GLOBAL;

/**
 * @author Sven Lange
 * @since 2013-11-17
 */
public class XtendLibraryDescription extends CustomLibraryDescription {

    @NotNull
    @Override
    public Set<? extends LibraryKind> getSuitableLibraryKinds() {
        HashSet<LibraryKind> libraryKinds = new HashSet<LibraryKind>();
        for (LibraryPresentationProvider provider : EP_NAME.getExtensions()) {
            if (provider instanceof XtendLibraryPresentationProvider) {
                libraryKinds.add(provider.getKind());
            }
        }
        return libraryKinds;
    }

    @Override
    public NewLibraryConfiguration createNewLibrary(@NotNull JComponent parentComponent, VirtualFile contextDirectory) {
        final FileChooserDescriptor descriptor = new FileChooserDescriptor(false, true, false, false, false, false) {
            @Override
            public boolean isFileSelectable(VirtualFile file) {
                return super.isFileSelectable(file) && findProvider(file) != null;
            }
        };
        descriptor.setDescription("Choose a directory containing Xtend Standalone JAR.");
        final VirtualFile dir = FileChooser.chooseFile(descriptor, parentComponent, null, null);
        if (dir == null) {
            return null;
        }

        final XtendLibraryPresentationProvider provider = findProvider(dir);
        if (provider == null) {
            return null;
        }

        final String path = dir.getPath();
        final String sdkVersion = provider.getSDKVersion(path);

        return new NewLibraryConfiguration(provider.getLibraryPrefix() + "-" + sdkVersion) {
            @Override
            public void addRoots(@NotNull LibraryEditor editor) {
                provider.fillLibrary(path, editor);
            }
        };
    }

    @NotNull
    @Override
    public LibrariesContainer.LibraryLevel getDefaultLevel() {
        return GLOBAL;
    }

    @Nullable
    private static XtendLibraryPresentationProvider findProvider(@NotNull VirtualFile dir) {
        final List<XtendLibraryPresentationProvider> providers = ContainerUtil.findAll(EP_NAME.getExtensions(), XtendLibraryPresentationProvider.class);
        for (final XtendLibraryPresentationProvider provider : providers) {
            if (provider.isSDKHome(dir)) {
                return provider;
            }
        }
        return null;
    }
}

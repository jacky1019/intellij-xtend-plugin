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

import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.LibraryKind;
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.roots.ui.configuration.libraryEditor.LibraryEditor;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import za.co.svenlange.intellij.xtend.XtendIcons;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.intellij.openapi.util.text.StringUtil.toLowerCase;
import static java.util.jar.Attributes.Name.IMPLEMENTATION_VERSION;

/**
 * @author Sven Lange
 * @since 2013-11-17
 */
public class XtendLibraryPresentationProvider extends LibraryPresentationProvider<XtendLibraryProperties> {

    private static final Pattern XTEND_STANDALONE_JAR_PATTERN = Pattern.compile("org.eclipse.xtend.standalone-(.*)\\.jar");
    private static final String MANIFEST_PATH = "META-INF/MANIFEST.MF";
    private static final String UNDEFINED_VERSION = "undefined";
    private static final LibraryKind XTEND_KIND = LibraryKind.create("xtend");
    private static final String LIBRARY_CATEGORY_NAME = "Xtend";

    public XtendLibraryPresentationProvider() {
        super(XTEND_KIND);
    }

    @Override
    public String getDescription(@NotNull XtendLibraryProperties properties) {
        final String version = properties.getVersion();
        return LIBRARY_CATEGORY_NAME + " library" + (version != null ? " of version " + version : ":");
    }

    @Override
    public XtendLibraryProperties detect(@NotNull List<VirtualFile> classesRoots) {
        final VirtualFile[] libraryFiles = VfsUtilCore.toVirtualFileArray(classesRoots);
        if (managesLibrary(libraryFiles)) {
            final String version = "TBD";
            return new XtendLibraryProperties(version);
        }
        return null;
    }

    private boolean managesLibrary(final VirtualFile[] libraryFiles) {
        for (VirtualFile libraryFile : libraryFiles) {
            String canonicalPath = libraryFile.getCanonicalPath();
            if (canonicalPath != null && canonicalPath.contains("xtend-standalone")) { // TODO FIXME what about xbase and guava?
                return true;
            }
        }

        return false;
    }

    void fillLibrary(String path, LibraryEditor libraryEditor) {
        File[] jars;
        File dir = new File(path);
        if (dir.exists()) {
            jars = dir.listFiles();
            if (jars != null) {
                for (File file : jars) {
                    if (file.getName().endsWith(".jar")) {
                        libraryEditor.addRoot(VfsUtil.getUrlForLibraryRoot(file), OrderRootType.CLASSES);
                    }
                }
            }
        }
    }

    @NotNull
    public Icon getIcon() {
        return XtendIcons.XTEND_LOGO;
    }

    public boolean isSDKHome(VirtualFile file) {
        if (file != null && file.isDirectory()) {
            final String path = file.getPath();
            if (getFilesInDirectoryByPattern(path, XTEND_STANDALONE_JAR_PATTERN).length > 0) {
                return true;
            }
        }
        return false;
    }

    private static File[] getFilesInDirectoryByPattern(String dirPath, final Pattern pattern) {
        File distDir = new File(dirPath);
        File[] files = distDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        return files != null ? files : new File[0];
    }

    @NotNull
    public String getSDKVersion(@NotNull final String path) {
        String xtendJarVersion = getSDKJarVersion(path, XTEND_STANDALONE_JAR_PATTERN, MANIFEST_PATH);
        return xtendJarVersion == null ? UNDEFINED_VERSION : xtendJarVersion;
    }

    /**
     * Return value of Implementation-Version attribute in jar manifest
     * <p/>
     *
     * @param jarPath      directory containing jar file
     * @param jarPattern   filename pattern for jar file
     * @param manifestPath path to manifest file in jar file
     * @return value of Implementation-Version attribute, null if not found
     */
    @Nullable
    private static String getSDKJarVersion(String jarPath, final Pattern jarPattern, String manifestPath) {
        try {
            File[] jars = getFilesInDirectoryByPattern(jarPath, jarPattern);
            if (jars.length != 1) {
                return null;
            }
            JarFile jarFile = new JarFile(jars[0]);
            try {
                JarEntry jarEntry = jarFile.getJarEntry(manifestPath);
                if (jarEntry == null) {
                    return null;
                }
                final InputStream inputStream = jarFile.getInputStream(jarEntry);
                Manifest manifest;
                try {
                    manifest = new Manifest(inputStream);
                } finally {
                    inputStream.close();
                }
                final String version = manifest.getMainAttributes().getValue(IMPLEMENTATION_VERSION);
                if (version != null) {
                    return version;
                }

                final Matcher matcher = jarPattern.matcher(jars[0].getName());
                if (matcher.matches() && matcher.groupCount() == 1) {
                    return matcher.group(1);
                }
                return null;
            } finally {
                jarFile.close();
            }
        } catch (Exception e) {
            return null;
        }
    }

    public String getLibraryPrefix() {
        return toLowerCase(LIBRARY_CATEGORY_NAME);
    }
}


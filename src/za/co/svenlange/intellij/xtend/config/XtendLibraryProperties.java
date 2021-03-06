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

import com.intellij.openapi.roots.libraries.LibraryProperties;
import com.intellij.openapi.util.Comparing;
import org.jetbrains.annotations.Nullable;

/**
 * @author Sven Lange
 * @since 2013-11-17
 */
public class XtendLibraryProperties extends LibraryProperties<XtendLibraryProperties> {
    private String myVersion;

    public XtendLibraryProperties(String version) {
        myVersion = version;
    }

    @Nullable
    public String getVersion() {
        return myVersion;
    }

    @Override
    public XtendLibraryProperties getState() {
        return null;
    }

    @Override
    public void loadState(XtendLibraryProperties state) {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof XtendLibraryProperties && Comparing.equal(myVersion, ((XtendLibraryProperties) obj).myVersion);
    }

    @Override
    public int hashCode() {
        return myVersion != null ? myVersion.hashCode() : 0;
    }
}


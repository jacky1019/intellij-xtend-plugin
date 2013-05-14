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

package za.co.svenlange.intellij.xtend;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static za.co.svenlange.intellij.xtend.XtendIcons.XTEND_FILE;

/**
 * @author Sven Lange
 * @since 2012-12-27
 */
public class XtendFileType extends LanguageFileType {

    @NonNls
    public static final String DEFAULT_EXTENSION = "xtend";

    public static final LanguageFileType INSTANCE = new XtendFileType();

    private XtendFileType() {
        super(XtendLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Xtend";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Xtend files";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Override
    public Icon getIcon() {
        return XTEND_FILE;
    }
}

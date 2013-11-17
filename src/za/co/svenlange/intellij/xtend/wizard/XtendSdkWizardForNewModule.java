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

package za.co.svenlange.intellij.xtend.wizard;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.WizardContext;

/**
 * @author Sven Lange
 * @since 2013-11-17
 */
public class XtendSdkWizardForNewModule extends XtendSdkWizard {
    private final ModuleBuilder myModuleBuilder;

    public XtendSdkWizardForNewModule(ModuleBuilder moduleBuilder, WizardContext wizardContext) {
        super(wizardContext);
        myModuleBuilder = moduleBuilder;
        myModuleBuilder.addModuleConfigurationUpdater(createModuleConfigurationUpdater());
    }

    @Override
    protected String getBasePath() {
        return myModuleBuilder.getContentEntryPath();
    }
}

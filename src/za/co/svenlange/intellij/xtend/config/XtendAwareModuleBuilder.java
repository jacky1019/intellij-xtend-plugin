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

import com.intellij.ide.util.projectWizard.JavaModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import za.co.svenlange.intellij.xtend.XtendIcons;
import za.co.svenlange.intellij.xtend.wizard.XtendSdkWizardForNewModule;

import javax.swing.*;

/**
 * @author Sven Lange
 * @since 2013-11-17
 */
public class XtendAwareModuleBuilder extends JavaModuleBuilder {

    @Override
    public ModuleWizardStep[] createWizardSteps(WizardContext wizardContext, ModulesProvider modulesProvider) {
        return new ModuleWizardStep[]{new XtendSdkWizardForNewModule(this, wizardContext)};
    }

    @Override
    public String getBuilderId() {
        return "xtend";
    }

    @Override
    public Icon getNodeIcon() {
        return XtendIcons.XTEND_LOGO;
    }

    @Override
    public String getDescription() {
        return "Simple module with attached Xtend library";
    }

    @Override
    public String getPresentableName() {
        return "Xtend Module";
    }

    @Override
    public String getGroupName() {
        return "Xtend";
    }
}


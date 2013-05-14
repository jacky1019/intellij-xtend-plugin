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

import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import com.intellij.execution.process.BaseOSProcessHandler;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.util.ArrayUtil;
import org.eclipse.xtend.core.XtendInjectorSingleton;
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.BuildTargetType;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.builders.logging.BuildLoggingManager;
import org.jetbrains.jps.builders.logging.ProjectBuilderLogger;
import org.jetbrains.jps.cmdline.ProjectDescriptor;
import org.jetbrains.jps.incremental.*;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.jetbrains.jps.incremental.messages.CompilerMessage;
import org.jetbrains.jps.model.JpsDummyElement;
import org.jetbrains.jps.model.JpsUrlList;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;
import org.jetbrains.jps.model.java.JpsJavaModuleType;
import org.jetbrains.jps.model.java.JpsJavaSdkType;
import org.jetbrains.jps.model.java.compiler.JpsJavaCompilerConfiguration;
import org.jetbrains.jps.model.library.sdk.JpsSdk;
import org.jetbrains.jps.model.module.JpsDependenciesList;
import org.jetbrains.jps.model.module.JpsModule;
import org.jetbrains.jps.model.module.JpsModuleSourceRoot;
import org.jetbrains.jps.service.SharedThreadPool;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.Future;

import static org.jetbrains.jps.incremental.BuilderCategory.SOURCE_GENERATOR;

/**
 * @author Sven Lange
 * @since 2013-04-12
 */
public class XtendBuilder extends ModuleLevelBuilder {

    private static final Logger LOG = Logger.getInstance("#za.co.svenlange.intellij.xtend.jps.incremental.XtendBuilder");
    public static final String COMPILER_NAME = "Xtend Compiler";
    private static final String XTEND_MAIN = "xtend.main";

    protected XtendBuilder() {
        super(SOURCE_GENERATOR);
    }

    @Override
    public ExitCode build(CompileContext context, ModuleChunk chunk, DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder, OutputConsumer outputConsumer) throws ProjectBuildException, IOException {
        Injector injector = XtendInjectorSingleton.INJECTOR;
        XtendBatchCompiler xtendBatchCompiler = injector.getInstance(XtendBatchCompiler.class);

        final String blah = context.getBuilderParameter("blah");


//
//
//        final List<JpsModuleSourceRoot> sourceRoots = new ArrayList<JpsModuleSourceRoot>();
//        final List<JpsDependenciesList> dependenciesLists = new ArrayList<JpsDependenciesList>();
//        for (JpsModule module : chunk.getModules()) {
//
//            for (JpsModuleSourceRoot sourceRoot : getSourceRoots()) {
//                sourceRoots.add(sourceRoot);
//            }
//
//            dependenciesLists.add(module.getDependenciesList());
//        }

        final JpsModule first = Iterables.getFirst(chunk.getModules(), null);
        final List<String> contentRootsList = first.getContentRootsList().getUrls();
        final URL url = new URL(contentRootsList.get(0));
        final String file = url.getFile();
        final String path = url.getPath();


        xtendBatchCompiler.setOutputPath(file + "/xtend-gen");
        xtendBatchCompiler.setClassPath("/Users/lange/Projekte/opensource/jetbrains/xtend-intellij/lib/org.eclipse.xtend.standalone-2.4.1.jar");
        xtendBatchCompiler.setSourcePath(chunk.representativeTarget().getModule().getSourceRoots().get(0).getUrl());


        xtendBatchCompiler.compile();

        return ExitCode.OK;
    }

    @NotNull
    @Override
    public String getPresentableName() {
        return COMPILER_NAME;
    }
}

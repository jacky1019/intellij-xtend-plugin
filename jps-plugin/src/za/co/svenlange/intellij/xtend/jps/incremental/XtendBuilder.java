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
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import gnu.trove.THashSet;
import org.eclipse.xtend.core.XtendInjectorSingleton;
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.FileProcessor;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.ModuleBuildTarget;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;
import org.jetbrains.jps.incremental.ProjectBuildException;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.jetbrains.jps.incremental.messages.CompilerMessage;
import org.jetbrains.jps.model.module.JpsModule;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.jetbrains.jps.incremental.BuilderCategory.SOURCE_GENERATOR;

/**
 * @author Sven Lange
 * @since 2013-04-12
 */
public class XtendBuilder extends ModuleLevelBuilder {

    public static final String COMPILER_NAME = "Xtend Compiler";

    private static final String DOT_XTEND_EXTENSION = ".xtend";

    protected XtendBuilder() {
        super(SOURCE_GENERATOR);
    }

    private static final FileFilter XTEND_SOURCES_FILTER =
            SystemInfo.isFileSystemCaseSensitive ?
                    new FileFilter() {
                        public boolean accept(File file) {
                            return file.getPath().endsWith(DOT_XTEND_EXTENSION);
                        }
                    } :
                    new FileFilter() {
                        public boolean accept(File file) { return StringUtil.endsWithIgnoreCase(file.getPath(), DOT_XTEND_EXTENSION);
                        }
                    };


    @Override
    public ExitCode build(CompileContext context, ModuleChunk chunk, DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder, final OutputConsumer outputConsumer) throws ProjectBuildException, IOException {
        dirtyFilesHolder.processDirtyFiles(new FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget>() {
            public boolean apply(ModuleBuildTarget target, File file, JavaSourceRootDescriptor descriptor) throws IOException {
                if (XTEND_SOURCES_FILTER.accept(file)) {
                    outputConsumer.registerOutputFile(descriptor.target, file, Collections.<String>singleton(file.getAbsolutePath()));
                }
                return true;
            }
        });


        Injector injector = XtendInjectorSingleton.INJECTOR;
        XtendBatchCompiler xtendBatchCompiler = injector.getInstance(XtendBatchCompiler.class);

        final String outputPath = getOutputPath(chunk);
        final String classPath = "/Users/sven/projekte/intellij-xtend-plugin/lib/org.eclipse.xtend.standalone-2.4.3.jar";
        final String sourcePath = chunk.representativeTarget().getModule().getSourceRoots().get(0).getUrl();

        xtendBatchCompiler.setOutputPath(outputPath);
        xtendBatchCompiler.setClassPath(classPath);
        xtendBatchCompiler.setSourcePath(sourcePath);

        context.processMessage(new CompilerMessage(getPresentableName(), BuildMessage.Kind.INFO, "Xtend Compiler started"));
        xtendBatchCompiler.compile();



        return ExitCode.OK;
    }

    private Set<File> getXtendFilesToCompile(DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder) throws IOException {
        final Set<File> filesToCompile = new THashSet<File>(FileUtil.FILE_HASHING_STRATEGY);
        dirtyFilesHolder.processDirtyFiles(new FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget>() {
            public boolean apply(ModuleBuildTarget target, File file, JavaSourceRootDescriptor descriptor) throws IOException {
                if (XTEND_SOURCES_FILTER.accept(file)/* && ourCompilableModuleTypes.contains(target.getModule().getModuleType())*/) {
                    filesToCompile.add(file);
                }
                return true;
            }
        });
        return filesToCompile;
    }

    private String getOutputPath(ModuleChunk chunk) throws MalformedURLException {
        final JpsModule first = Iterables.getFirst(chunk.getModules(), null);
        final List<String> contentRootsList = first.getContentRootsList().getUrls();
        final URL url = new URL(contentRootsList.get(0));
        return url.getFile() + "/xtend-gen";
    }

    @NotNull
    @Override
    public String getPresentableName() {
        return COMPILER_NAME;
    }
}

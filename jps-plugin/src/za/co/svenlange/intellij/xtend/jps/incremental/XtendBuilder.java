package za.co.svenlange.intellij.xtend.jps.incremental;

import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.ModuleBuildTarget;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;
import org.jetbrains.jps.incremental.ProjectBuildException;

import java.io.IOException;

import static org.jetbrains.jps.incremental.BuilderCategory.SOURCE_GENERATOR;

public class XtendBuilder extends ModuleLevelBuilder {

    private static final Logger LOG = Logger.getInstance("#za.co.svenlange.intellij.xtend.jps.incremental.XtendBuilder");

    protected XtendBuilder() {
        super(SOURCE_GENERATOR);
        LOG.error("XtendBuilder");
    }

    @Override
    public ExitCode build(CompileContext context, ModuleChunk chunk, DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder, OutputConsumer outputConsumer) throws ProjectBuildException, IOException {
        return null;
    }

    @NotNull
    @Override
    public String getPresentableName() {
        return "Xtend Compiler";
    }
}

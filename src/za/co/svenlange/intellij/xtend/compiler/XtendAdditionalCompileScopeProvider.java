package za.co.svenlange.intellij.xtend.compiler;

import com.intellij.compiler.impl.AdditionalCompileScopeProvider;
import com.intellij.openapi.compiler.CompileScope;
import com.intellij.openapi.compiler.CompilerFilter;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class XtendAdditionalCompileScopeProvider extends AdditionalCompileScopeProvider {


    @Nullable
    @Override
    public CompileScope getAdditionalScope(@NotNull CompileScope baseScope, @NotNull CompilerFilter filter, @NotNull Project project) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

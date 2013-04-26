package za.co.svenlange.intellij.xtend.jps.incremental;

import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.incremental.BuilderService;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;

import java.util.Arrays;
import java.util.List;

public class XtendBuilderService extends BuilderService {

    private static final Logger LOG = Logger.getInstance("#za.co.svenlange.intellij.xtend.jps.incremental.XtendBuilderService");

    @NotNull
    @Override
    public List<? extends ModuleLevelBuilder> createModuleLevelBuilders() {
        return Arrays.asList(new XtendBuilder());
    }


}

package za.co.svenlange.intellij.xtend.jps.incremental;

import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.builders.BuildTargetType;
import org.jetbrains.jps.incremental.BuilderService;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;

import java.util.Arrays;
import java.util.List;

public class XtendBuilderService extends BuilderService {

    private static final Logger LOG = Logger.getInstance("#za.co.svenlange.intellij.xtend.jps.incremental.XtendBuilderService");

    @Override
    public List<? extends BuildTargetType<?>> getTargetTypes() {
        return super.getTargetTypes();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public List<? extends ModuleLevelBuilder> createModuleLevelBuilders() {
        LOG.error("XtendBuilderService");
        return Arrays.asList(new XtendBuilder());
    }


}

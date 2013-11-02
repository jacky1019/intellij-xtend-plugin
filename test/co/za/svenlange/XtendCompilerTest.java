package co.za.svenlange;


import com.google.inject.Injector;
import org.eclipse.xtend.core.XtendInjectorSingleton;
import org.eclipse.xtend.core.compiler.batch.XtendBatchCompiler;
import org.testng.annotations.Test;

public class XtendCompilerTest {

    @Test
    public void testCompile() throws Exception {
        Injector injector = XtendInjectorSingleton.INJECTOR;
        XtendBatchCompiler xtendBatchCompiler = injector.getInstance(XtendBatchCompiler.class);
        final String outputPath = "/Users/sven/projekte/intellij/intellij-xtend-plugin/test/co/za/svenlange/output";
        final String classPath = "/Users/sven/projekte/intellij/intellij-xtend-plugin/lib/org.eclipse.xtend.standalone-2.4.3.jar:/Users/sven/projekte/intellij/intellij-xtend-plugin/lib/org.eclipse.xtext.xbase.lib-2.4.3.jar";
        final String sourcePath = "/Users/sven/projekte/intellij/intellij-xtend-plugin/resources";

        xtendBatchCompiler.setOutputPath(outputPath);
        xtendBatchCompiler.setClassPath(classPath);
        xtendBatchCompiler.setSourcePath(sourcePath);

        xtendBatchCompiler.compile();

    }
}

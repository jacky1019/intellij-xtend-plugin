package co.za.svenlange;


import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.testng.annotations.Test;

public class JvmModelGeneratorTest {

    @Test
    public void tst() {
        JvmModelGenerator generator = new JvmModelGenerator();
        generator.doGenerate(null, null);
    }
}

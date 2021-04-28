package TestSuite;

import TestCases.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({CadastrarUsuario.class, CadastrarUsuarioCSV.class})

public class AllClassTests {
}

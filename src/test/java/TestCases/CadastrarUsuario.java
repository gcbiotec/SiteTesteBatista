package TestCases;

import FrameWork.BaseTest;
import Tasks.HomeTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuario extends BaseTest {

    private WebDriver driver = this.getDriver();
    private HomeTask homeTask = new HomeTask(driver);

    @Test
    public void realizarCadastro(){
        homeTask.acessarPageAutomacaoWeb();

    }
}

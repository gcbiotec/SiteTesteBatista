package TestCases;

import FrameWork.BaseTest;
import Tasks.FormularioTask;
import Tasks.HomeTask;
import Tasks.MenuFormTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuario extends BaseTest {

    private WebDriver driver = this.getDriver();
    private HomeTask homeTask = new HomeTask(driver);
    private MenuFormTask menuFormTask = new MenuFormTask(driver);
    private FormularioTask formularioTask = new FormularioTask(driver);

    @Test
    public void realizarCadastro(){
        homeTask.acessarPageAutomacaoWeb();
        menuFormTask.acessarFormulario();
        formularioTask.preencheFormulario();

    }
}

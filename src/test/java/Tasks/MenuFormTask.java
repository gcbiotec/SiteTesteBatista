package Tasks;

import FrameWork.Browser.Waits;
import PageObjects.HomePage;
import PageObjects.MenuFormPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MenuFormTask {

    private static WebDriver driver;
    private MenuFormPage menuFormPage;
    private Waits waits;

    public MenuFormTask(WebDriver driver){
        this.driver = driver;
        menuFormPage = new MenuFormPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void acessarFormulario(){
        validaPaginaForm();
        menuFormPage.getFormLink().click();
        menuFormPage.getCriarUsuarioLink().click();
        validaFormCarregado();
    }

    private void validaPaginaForm(){
        waits.loadElement(menuFormPage.getTextTitle());
            String titulo = menuFormPage.getTextTitle().getText();
            Assertions.assertEquals("Lista de Funcionalidades", titulo);

    }

    private void validaFormCarregado(){
        waits.loadElement(menuFormPage.getTextFormUsuarioTitle());
            Assertions.assertEquals("Novo Usuário!!", menuFormPage.getTextFormUsuarioTitle().getText());
    }

}

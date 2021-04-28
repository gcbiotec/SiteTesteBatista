package Tasks;

import FrameWork.Browser.Waits;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.HomePage;
import PageObjects.MenuFormPage;
import com.aventstack.extentreports.Status;
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
        try{waits.loadElement(menuFormPage.getTextTitle());
            String titulo = menuFormPage.getTextTitle().getText();
            Assertions.assertEquals("Lista de Funcionalidades", titulo);
            Report.extentTest.log(Status.PASS, "PÁGINA DE FORMULÁRIO ACESSADA COM SUCESSO!", ScreenShot.base64(driver));
        }catch(Exception e) {
            Report.extentTest.log(Status.FAIL, "NÃO FOI POSSÍVEL ACESSAR PÁGINA DE MENU!", ScreenShot.base64(driver));
        }
    }

    private void validaFormCarregado(){
       try{ waits.loadElement(menuFormPage.getTextFormUsuarioTitle());
            Assertions.assertEquals("Novo Usuário!!", menuFormPage.getTextFormUsuarioTitle().getText());
            Report.extentTest.log(Status.PASS, "FORMULÁRIO ACESSADO COM SUCESSO!",ScreenShot.base64(driver));

       }catch(Exception e){
           Report.extentTest.log(Status.FAIL, "NÃO FOI POSSÍVEL ACESSAR O FORMULARIO!", ScreenShot.base64(driver));
       }
    }


}

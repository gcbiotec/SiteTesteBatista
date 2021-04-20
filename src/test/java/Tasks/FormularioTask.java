package Tasks;

import FrameWork.Browser.Waits;
import FrameWork.Utils.FakerGeneration;
import PageObjects.FormularioPage;
import PageObjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FormularioTask {

    private static WebDriver driver;

    private static FormularioPage formularioPage;

    private static Waits waits;

    private static FakerGeneration fakerGeneration;

    public FormularioTask(WebDriver driver){
        this.driver = driver;
        formularioPage = new FormularioPage(this.driver);
        waits = new Waits(this.driver);
        fakerGeneration = new FakerGeneration(this.driver);
    }

    public void preencheFormulario(){

        formularioPage.getNomeTextField().sendKeys(fakerGeneration.getFirstName());
        formularioPage.getUltimoNomeTextField().sendKeys(fakerGeneration.getLastName());
        formularioPage.getEmailTextField().sendKeys(fakerGeneration.getEmail());
        formularioPage.getEnderecoTextField().sendKeys(fakerGeneration.getAddress());
        formularioPage.getUniversityTextField().sendKeys(fakerGeneration.getUniversity());
        formularioPage.getProfissaoTextField().sendKeys(fakerGeneration.getProfession());
        formularioPage.getGeneroTextField().sendKeys(fakerGeneration.getGenre());
        formularioPage.getIdadeTextField().sendKeys(fakerGeneration.getAge());
        formularioPage.getEnviarButton().click();
        validaCriacaoUsuario();
    }

    private void validaCriacaoUsuario(){
        waits.loadElement(formularioPage.getMensagemTitle());
        Assertions.assertEquals("Usuário Criado com sucesso", formularioPage.getMensagemTitle().getText());
    }
}

package Tasks;

import FrameWork.Browser.Waits;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import FrameWork.Utils.FakerGeneration;
import PageObjects.FormularioPage;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
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
    public void preencheFormularioCSV(String nome,String ultimoNome,String email,String endereco,
                                      String universidade,String profissao, String genero ,String idade){

        formularioPage.getNomeTextField().sendKeys(nome);
        formularioPage.getUltimoNomeTextField().sendKeys(ultimoNome);
        formularioPage.getEmailTextField().sendKeys(email);
        formularioPage.getEnderecoTextField().sendKeys(endereco);
        formularioPage.getUniversityTextField().sendKeys(universidade);
        formularioPage.getProfissaoTextField().sendKeys(profissao);
        formularioPage.getGeneroTextField().sendKeys(genero);
        formularioPage.getIdadeTextField().sendKeys(idade);
        formularioPage.getEnviarButton().click();
        validaCriacaoUsuario();
    }


    private void validaCriacaoUsuario(){
        try{waits.loadElement(formularioPage.getMensagemTitle());
            Assertions.assertEquals("Usuário Criado com sucesso", formularioPage.getMensagemTitle().getText());
            Report.extentTest.log(Status.PASS, "USUÁRIO CRIADO COM SUCESSO!", ScreenShot.base64(driver));

        }catch (Exception e){
            Report.extentTest.log(Status.FAIL, "NÃO FOI POSSÍVEL CRIAR USUÁRIO!", ScreenShot.base64(driver));
      }
   }
}

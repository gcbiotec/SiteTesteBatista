package TestCases;

import FrameWork.BaseTest;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import Tasks.FormularioTask;
import Tasks.HomeTask;
import Tasks.MenuFormTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuarioDataProvider extends BaseTest {

    private WebDriver driver = this.getDriver();
    private HomeTask homeTask = new HomeTask(driver);
    private MenuFormTask menuFormTask = new MenuFormTask(driver);
    private FormularioTask formularioTask = new FormularioTask(driver);

    @ParameterizedTest
    @MethodSource("FrameWork.Utils.DataClass#formTestData")
    public void realizarCadastroDataProvider(String nome,String ultimoNome,String email,String endereco,
                                    String universidade,String profissao, String genero, String idade){
        try{
            Report.startReport("Cadastrando novo usuário");
            homeTask.acessarPageAutomacaoWeb();
            menuFormTask.acessarFormulario();
            formularioTask.preencheFormularioCSV(nome, ultimoNome, email, endereco,
                     universidade, profissao, genero, idade);
        }catch (Exception e){
            Report.extentTest.log(Status.ERROR, e.getMessage(), ScreenShot.base64(driver));

        }
    }
}

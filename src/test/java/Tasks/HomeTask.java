package Tasks;

import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomeTask {

    private static WebDriver driver;

    private static HomePage homepage;

    public HomeTask(WebDriver driver){
        this.driver = driver;
        homepage = new HomePage(this.driver);
    }

    public void acessarPageAutomacaoWeb(){
        homeValidation();
        homepage.getStartButton().click();
    }

    private void homeValidation(){
        try{
            Assertions.assertTrue(homepage.getHomeTitle().isDisplayed());
            Report.extentTest.log(Status.PASS, "PÁGINA ACESSADA COM SUCESSO!", ScreenShot.base64(driver));

        }
        catch (Exception e){
            Report.extentTest.log(Status.FAIL, "NÃO FOI POSSÍVEL ACESSAR PÁGINA!", ScreenShot.base64(driver));

        }
    }
}

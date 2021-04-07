package Tasks;

import PageObjects.HomePage;
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
        Assertions.assertTrue(homepage.getHomeTitle().isDisplayed());
    }
}

package PageObjects;

import FrameWork.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormularioPage {

    private WebDriver driver;
    private Waits waits;

    public FormularioPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getNomeTextField() {

        return this.driver.findElement(By.id("user_name"));
    }

    public WebElement getUltimoNomeTextField() {

        return this.driver.findElement(By.id("user_lastname"));
    }

    public WebElement getEmailTextField() {

        return this.driver.findElement(By.id("user_email"));
    }

    public WebElement getEnderecoTextField(){

        return this.driver.findElement(By.id("user_address"));
    }

    public WebElement getUniversityTextField(){

        return this.driver.findElement(By.id("user_university"));
    }

    public WebElement getProfissaoTextField(){

        return this.driver.findElement(By.id("user_profile"));
    }

    public WebElement getGeneroTextField(){

        return this.driver.findElement(By.id("user_gender"));
    }

    public WebElement getIdadeTextField(){

        return this.driver.findElement(By.id("user_age"));
    }

    public WebElement getEnviarButton(){

        return this.driver.findElement(By.name("commit"));
    }

    public WebElement getMensagemTitle(){

        return this.driver.findElement(By.id("notice"));
    }
}

package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DestinationsPage extends PageObject{
    @FindBy(xpath = "//a[@href = 'mercurywelcome.php']/img")
    private WebElement backToHome;

    public DestinationsPage(WebDriver driver){
        super(driver);
    }

    @Step
    public WelcomePage backToHome(){
        this.backToHome.click();
        return new WelcomePage(driver);
    }
}

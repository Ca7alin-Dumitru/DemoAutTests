package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPage extends PageObject{
    @FindBy(name = "userName")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "login")
    private WebElement login;

    public FlightsPage(WebDriver driver){
        super(driver);
    }

    @Step
    public HomePage login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.login.click();
        return new HomePage(driver);
    }
}

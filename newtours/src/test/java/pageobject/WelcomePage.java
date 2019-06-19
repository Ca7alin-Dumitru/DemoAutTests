package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends PageObject {
    @FindBy(name = "userName")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "login")
    private WebElement login;
    @FindBy(xpath = "//a[contains(text(),'REGISTER')]")
    private WebElement register;

    public WelcomePage(WebDriver driver){
        super(driver);
    }

    @Step
    private void login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.login.click();
    }

    public FlightFinderPage loginSuccessfully(String userName, String password){
        login(userName,password);
        return new FlightFinderPage(driver);

    }

    public SignOnPage loginFailed(String userName, String password){
        login(userName,password);
        return new SignOnPage(driver);

    }

    public RegisterPage goToRegister(){
        this.register.click();
        return new RegisterPage(driver);

    }
}

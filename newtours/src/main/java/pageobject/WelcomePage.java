package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
    @FindBy(name = "passFirst0")
    private WebElement passFirst0;

    public WelcomePage(WebDriver driver){
        super(driver);
    }

    @Step
    private void login(String userName, String password){
        PageObject.waitForElementToAppear(By.name("userName"));
        PageObject.waitForElementToBeClickable(login);
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.login.click();
    }

    @Step
    public FlightFinderPage loginSuccessfully(String userName, String password){
        login(userName,password);
        return new FlightFinderPage(driver);

    }

    @Step
    public SignOnPage loginFailed(String userName, String password){
        login(userName,password);
        return new SignOnPage(driver);

    }

    @Step
    public RegisterPage goToRegister(){
        this.register.click();
        return new RegisterPage(driver);

    }
}

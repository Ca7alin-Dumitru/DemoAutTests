package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountSuccess extends PageObject{
    static final String email = "test@mail.com";
    @FindBy(xpath = "//b[contains(text(),'Note: Your user name is " + email + ".')]")
    private WebElement test;

    public CreateAccountSuccess(WebDriver driver){
        super(driver);
    }

    @Step
    public void verifyContent(){
        this.test.isDisplayed();
    }
}

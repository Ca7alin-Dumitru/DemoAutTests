package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOnPage extends PageObject{
    @FindBy(name = "userName")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "login")
    private WebElement submit;
    @FindBy(xpath = "//b[contains(text(),'Welcome back to ')]")
    private WebElement verifyText;

    public SignOnPage(WebDriver driver){
        super(driver);
    }

    public FlightFinderPage login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.submit.click();
        return new FlightFinderPage(driver);
    }

    public WebElement getVerifyText() {
        return verifyText;
    }
}

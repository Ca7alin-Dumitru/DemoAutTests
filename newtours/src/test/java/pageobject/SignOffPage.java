package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOffPage extends PageObject{
    @FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
    private WebElement signOff;

    public SignOffPage(WebDriver driver){
        super(driver);
    }

    public SignOnPage logOut(){
        this.signOff.click();
        return new SignOnPage(driver);
    }
}

package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{
    @FindBy(name = "userName")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "login")
    private WebElement signIn;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public FlightFinderPage login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.signIn.click();
        return new FlightFinderPage(driver);
    }
}

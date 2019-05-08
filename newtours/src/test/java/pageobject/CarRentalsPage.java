package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarRentalsPage extends PageObject{
    @FindBy(xpath = "//a[@href = 'mercurywelcome.php']/img")
    private WebElement backToHome;

    public CarRentalsPage(WebDriver driver){
        super(driver);
    }
    public WelcomePage backToHome(){
        this.backToHome.click();
        return new WelcomePage(driver);
    }
}

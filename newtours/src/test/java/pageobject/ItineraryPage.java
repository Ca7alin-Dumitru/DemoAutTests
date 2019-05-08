package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItineraryPage extends PageObject {
    @FindBy(xpath = "//map[@name = 'Map']/area")
    private WebElement cancelAll;

    public ItineraryPage(WebDriver driver){
        super(driver);
    }

    public WelcomePage cancelAll(){
        this.cancelAll.click();
        return new WelcomePage(driver);
    }
}

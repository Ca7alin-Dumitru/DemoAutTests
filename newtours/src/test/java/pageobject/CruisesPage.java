package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CruisesPage extends PageObject{
    @FindBy(xpath = "//a[@href = 'mercuryreservation.php']/img")
    private WebElement nowAcceptingReservations;

    public CruisesPage(WebDriver driver){
        super(driver);
    }

    public FlightFinderPage checkPage(){
        this.nowAcceptingReservations.click();
        return new FlightFinderPage(driver);
    }
}

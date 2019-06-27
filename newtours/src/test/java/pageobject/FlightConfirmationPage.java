package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightConfirmationPage extends PageObject {
    @FindBy(xpath = "//a[@href = 'mercuryreservation.php']")
    private WebElement backToFlights;
    @FindBy(xpath = "//a[@href = 'mercurywelcome.php']")
    private WebElement backToHome;
    @FindBy(xpath = "//a[@href = 'mercurysignoff.php']")
    private WebElement logOut;
    @FindBy(xpath = "//b[contains(text(),'Billed To')]")
    private WebElement checkBilledToText;

    public FlightConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Step
    public FlightFinderPage backToFlight(){

        this.backToFlights.click();
        return new FlightFinderPage(driver);
    }

    @Step
    public WelcomePage backToHome(){

        this.backToHome.click();
        return new WelcomePage(driver);
    }

    @Step
    public SignOnPage logOut(){

        this.logOut.click();
        return new SignOnPage(driver);
    }
}

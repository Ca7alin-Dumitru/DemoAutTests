package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends PageObject {
    @FindBy(xpath = "//input[@value = 'Blue Skies Airlines$360$270$5:03']")
    private WebElement blueSkies360;
    @FindBy(xpath = "//input[@value = 'Blue Skies Airlines$361$271$7:10']")
    private WebElement blueSkies361;
    @FindBy(xpath = "//input[@value = 'Pangea Airlines$362$274$9:17']")
    private WebElement pangea362;
    @FindBy(xpath = "//input[@value = 'Unified Airlines$363$281$11:24']")
    private WebElement unified363;
    @FindBy(xpath = "//input[@value = 'Blue Skies Airlines$630$270$12:23']")
    private WebElement blueSkies630;
    @FindBy(xpath = "//input[@value = 'Blue Skies Airlines$631$273$14:30']")
    private WebElement blueSkies631;
    @FindBy(xpath = "//input[@value = 'Pangea Airlines$632$282$16:37']")
    private WebElement pangea632;
    @FindBy(xpath = "//input[@value = 'Unified Airlines$633$303$18:44']")
    private WebElement unified633;
    @FindBy(name = "reserveFlights")
    private WebElement reserveFlights;
    @FindBy(xpath = "//font[@color='#FF9900'][contains(text(),'DEPART')]")
    private WebElement checkDepartText;



    public SelectFlightPage(WebDriver driver){
        super(driver);
    }

    public BookAFlightPage selectFlight(){

        this.blueSkies360.click();
        this.blueSkies361.click();
        this.pangea362.click();
        this.unified363.click();
        this.blueSkies630.click();
        this.blueSkies631.click();
        this.pangea632.click();
        this.unified633.click();
        this.reserveFlights.click();
        return new BookAFlightPage(driver);
    }
}

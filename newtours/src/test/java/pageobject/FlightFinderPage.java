package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightFinderPage extends PageObject{
    @FindBy(xpath = "//input[@value = 'roundtrip']")
    private WebElement roundTrip;
    @FindBy(xpath = "//input[@value = 'oneway']")
    private WebElement oneWay;
    @FindBy(name = "passCount")
    private WebElement passCount;
    @FindBy(name = "fromPort")
    private WebElement fromPort;
    @FindBy(name = "fromMonth")
    private WebElement fromMonth;
    @FindBy(name = "fromDay")
    private WebElement fromDay;
    @FindBy(name = "toPort")
    private WebElement toPort;
    @FindBy(name = "toMonth")
    private WebElement toMonth;
    @FindBy(name = "toDay")
    private WebElement toDay;
    @FindBy(xpath = "//input[@value ='Coach']")
    private WebElement economyClass;
    @FindBy(xpath = "//input[@value ='Business']")
    private WebElement businessClass;
    @FindBy(xpath = "//input[@value ='First']")
    private WebElement firstClass;
    @FindBy(name="airline")
    private WebElement airline;
    @FindBy(name = "findFlights")
    private WebElement continueButton;
    @FindBy(xpath = "//font[contains(text(),'Preferences')]")
    private WebElement checkPreferencesText;

    public FlightFinderPage(WebDriver driver){
        super(driver);
    }

    public SelectFlightPage flightFinder(String flightType,
                                         String passCount,
                                         String fromPort,
                                         String fromMonth,
                                         String fromDay,
                                         String toPort,
                                         String toMonth,
                                         String toDay,
                                         String preferencesClass){
        //TODO: create enums for predefine values - done (task din data 27.03.2019)
        /*String flightDecision = new String("roundtrip");
        if (flightDecision.equals(flightType)){
            this.roundTrip.click();
        }else{
            this.oneWay.click();
        }*/

        enumFlightType(flightType);
        this.passCount.sendKeys(passCount);
        this.fromPort.sendKeys(fromPort);
        this.fromMonth.sendKeys(fromMonth);
        this.fromDay.sendKeys(fromDay);
        this.toPort.sendKeys(toPort);
        this.toMonth.sendKeys(toMonth);
        this.toDay.sendKeys(toDay);
        enumFlightType(preferencesClass);
        this.airline.click();
        this.continueButton.click();
        return new SelectFlightPage(driver);
    }

    public void enumFlightType(String enumParam){
        switch (FlightType.valueOf(enumParam)){
            case ROUNDTRIP:
                this.roundTrip.click();
                break;
            case ONEWAY:
                this.oneWay.click();
                break;
            case ECONOMY:
                this.economyClass.click();
                break;
            case BUSINESS:
                this.businessClass.click();
                break;
            case FIRST:
                this.firstClass.click();
                break;
        }
    }
}

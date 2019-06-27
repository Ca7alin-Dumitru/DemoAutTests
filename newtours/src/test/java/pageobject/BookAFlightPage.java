package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookAFlightPage extends PageObject {
    @FindBy(name = "passFirst0")
    private WebElement passFirst0;
    @FindBy(name = "passLast0")
    private WebElement passLast0;
    @FindBy(name = "pass.0.meal")
    private WebElement passengersMeal;
    @FindBy(name = "creditCard")
    private WebElement creditCard;
    @FindBy(name = "creditnumber")
    private WebElement creditNumber;
    @FindBy(name = "cc_exp_dt_mn")
    private WebElement cc_exp_dt_mn;
    @FindBy(name = "cc_exp_dt_yr")
    private WebElement cc_exp_dt_yr;
    @FindBy(name = "cc_frst_name")
    private WebElement cc_frst_name;
    @FindBy(name = "cc_mid_name")
    private WebElement cc_mid_name;
    @FindBy(name = "cc_last_name")
    private WebElement cc_last_name;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input")
    private WebElement ticketLessBillingAddress;
    @FindBy(name = "billAddress1")
    private WebElement billAddress1;
    @FindBy(name = "billAddress2")
    private WebElement billAddress2;
    @FindBy(name = "billCity")
    private WebElement billCity;
    @FindBy(name = "billState")
    private WebElement billState;
    @FindBy(name = "billZip")
    private WebElement billZip;
    @FindBy(name = "billCountry")
    private WebElement billCountry;
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")
    private WebElement ticketLessDeliveryAddress;
    @FindBy(name = "delAddress1")
    private WebElement delAddress1;
    @FindBy(name = "delAddress2")
    private WebElement delAddress2;
    @FindBy(name = "delCity")
    private WebElement delCity;
    @FindBy(name = "delState")
    private WebElement delState;
    @FindBy(name = "delZip")
    private WebElement delZip;
    @FindBy(name = "delCountry")
    private WebElement delCountry;
    @FindBy(name = "buyFlights")
    private WebElement buyFlights;
    @FindBy(xpath = "//font[@face='ARIAL, HELVETICA'][contains(text(),'Passengers')]")
    private WebElement checkPassengersText;

    public BookAFlightPage(WebDriver driver){
        super(driver);
    }

    @Step
    public FlightConfirmationPage securePurchase(/*String passFirst0,
                                                 String passLast0,
                                                 String creditnumber,
                                                 String cc_frst_name,
                                                 String cc_mid_name,
                                                 String cc_last_name,
                                                 String billAddress1,
                                                 String billAddress2,
                                                 String billCity,
                                                 String billState,
                                                 String billZip,
                                                 String delAddress1,
                                                 String delAddress2,
                                                 String delCity,
                                                 String delState,
                                                 String delZip,
                                                 String delCountry*/){
        /*this.passFirst0.sendKeys(passFirst0);
        this.passLast0.sendKeys(passLast0);
        this.passengersMeal.click();
        this.creditCard.click();
        this.creditNumber.sendKeys(creditnumber);
        this.cc_exp_dt_mn.click();
        this.cc_exp_dt_yr.click();
        this.cc_frst_name.sendKeys(cc_frst_name);
        this.cc_mid_name.sendKeys(cc_mid_name);
        this.cc_last_name.sendKeys(cc_last_name);
        this.ticketLessBillingAddress.click();
        this.billAddress1.clear();
        this.billAddress1.sendKeys(billAddress1);
        this.billAddress2.sendKeys(billAddress2);
        this.billCity.clear();
        this.billCity.sendKeys(billCity);
        this.billState.clear();
        this.billState.sendKeys(billState);
        this.billZip.clear();
        this.billZip.sendKeys(billZip);
        this.billCountry.click();
        this.ticketLessDeliveryAddress.click();
        this.delAddress1.clear();
        this.delAddress1.sendKeys(delAddress1);
        this.delAddress2.sendKeys(delAddress2);
        this.delCity.clear();
        this.delCity.sendKeys(delCity);
        this.delState.clear();
        this.delState.sendKeys(delState);
        this.delZip.clear();
        this.delZip.sendKeys(delZip);
        this.delCountry.sendKeys(delCountry);*/

        this.buyFlights.click();
        return new FlightConfirmationPage(driver);
    }
}

package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject{
    @FindBy(name = "firstName")
    private WebElement firstName;
    @FindBy(name = "lastName")
    private WebElement lastName;
    @FindBy(name = "phone")
    private WebElement phone;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "address1")
    private WebElement address1;
    @FindBy(name = "address2")
    private WebElement address2;
    @FindBy(name = "city")
    private WebElement city;
    @FindBy(name = "state")
    private WebElement state;
    @FindBy(name = "postalCode")
    private WebElement postalCode;
    @FindBy(name = "country")
    private WebElement country;
    @FindBy(xpath = "//a[@href = 'mercurywelcome.php']/img")
    private WebElement submit;

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    @Step
    public WelcomePage editProfile(String firstName,
                                   String lastName,
                                   String phone,
                                   String email,
                                   String address1,
                                   String address2,
                                   String city,
                                   String state,
                                   String postalCode,
                                   String country){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.phone.sendKeys(phone);
        this.email.sendKeys(email);
        this.address1.sendKeys(address1);
        this.address2.sendKeys(address2);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.postalCode.sendKeys(postalCode);
        this.country.sendKeys(postalCode);
        this.submit.click();
        return new WelcomePage(driver);
    }
}

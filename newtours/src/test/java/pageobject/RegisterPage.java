package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends  PageObject{
    @FindBy(name = "firstName")
    private WebElement firstName;
    @FindBy(name = "lastName")
    private WebElement lastName;
    @FindBy(name = "phone")
    private WebElement phone;
    @FindBy(name = "userName")
    private WebElement userName;
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
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;
    @FindBy(name = "register")
    private WebElement submit;

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @Step
    public CreateAccountSuccess registerUser(String firstName,
                                   String lastName,
                                   String phone,
                                   String userName,
                                   String address1,
                                   String address2,
                                   String city,
                                   String state,
                                   String postalCode,
                                   String country,
                                   String email,
                                   String password,
                                   String confirmPassword){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.phone.sendKeys(phone);
        this.userName.sendKeys(userName);
        this.address1.sendKeys(address1);
        this.address2.sendKeys(address2);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.postalCode.sendKeys(postalCode);
        this.country.sendKeys(country);
        this.country.click();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        this.submit.click();
        return new CreateAccountSuccess(driver);
    }
}

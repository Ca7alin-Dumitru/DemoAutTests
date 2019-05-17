import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageobject.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DemoAutTests {

    WebDriver driver;

    @Parameters({"browserName"})
    @BeforeMethod
    public void startFlow(String browser){

        //String path = "C:/Users/gdumitru/Downloads/chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver",path);
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            System.out.println("Error! - The value of the browser parameter is not valid!");
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.newtours.demoaut.com/");
    }

    // reserveAFlight parameters
    @Parameters({ "reserveUserName", "reserveUserPass", "reserveFlightType", "reservePassCount", "reserveFromPort", "reserveFromMonth",
            "reserveFromDay", "reserveToPort", "reserveToMonth", "reserveToDay", "reserveFlightPreferences"})
    @Test(groups = {"MyValues"})
    public void reserveAFlight(String userName,
                               String userPassword,
                               @Optional ("ONEWAY") String flightType,
                               @Optional ("4") String passCount,
                               @Optional ("Zurich") String fromPort,
                               @Optional ("December") String fromMonth,
                               @Optional ("31") String fromDay,
                               @Optional ("Zurich") String toPort,
                               @Optional ("December") String toMonth,
                               @Optional ("31") String toDay,
                               @Optional ("ECONOMY") String preferencesClass){
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.loginSuccessfully(userName, userPassword)
                .flightFinder(flightType,passCount,fromPort,fromMonth, fromDay, toPort, toMonth, toDay, preferencesClass)
                .selectFlight()
                .securePurchase()
                .logOut();
    }

    //TODO: faker to read - in progress (task din data 27.03.2019)
    // reserveAFlight parameters
    @Parameters({ "reserveUserName", "reserveUserPass", "reserveFlightType",  "reserveFromPort", "reserveFromMonth",
            "reserveFromDay", "reserveToPort", "reserveToMonth", "reserveToDay", "reserveFlightPreferences"})
    @Test(groups = {"RandomValues"})
    public void reserveAFlightRandom(String userName,
                               String userPassword,
                               @Optional ("ONEWAY") String flightType,
                                /*@Optional ("4") String passCount,*/
                               @Optional ("Zurich") String fromPort,
                               @Optional ("December") String fromMonth,
                               @Optional ("31") String fromDay,
                               @Optional ("Zurich") String toPort,
                               @Optional ("December") String toMonth,
                               @Optional ("31") String toDay,
                               @Optional ("ECONOMY") String preferencesClass){
        Random rand = new Random();
        String passCount = String.valueOf(rand.nextInt(5));

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.loginSuccessfully(userName, userPassword)
                .flightFinder(flightType,passCount,fromPort,fromMonth, fromDay, toPort, toMonth, toDay, preferencesClass)
                .selectFlight()
                .securePurchase()
                .logOut();
    }

    //TODO: dataProvider class to be created - done (task din data 27.03.2019)
    @Test(groups = {"MyValues"},dataProvider="loginValues", dataProviderClass = DataProviderForLoginTests.class)
    public void verifyLogin(String userName, String userPassword){
        SignOnPage signOnPage = new WelcomePage(driver).loginFailed(userName, userPassword);
        assertEquals("Welcome back to Mercury Tours!", signOnPage.getVerifyText().getText());
    }

    // registerAnAccount parameters
    @Parameters({ "registerFirstName", "registerLastName", "registerPhone", "registerUserName", "registerAddress1"
            ,"registerAddress2", "registerCity", "registerState", "registerPostalCode", "registerCountry", "registerEmail"
            ,"registerPassword", "registerConfirmPassword" })
    @Test(groups = {"MyValues"})
    public void registerAnAccount(String firstName, String lastName, String phone, String userName, String address1, String address2
            , String city, String state, String postalCode, String country, String email, String password, String confirmPassword){
        WelcomePage registerPage = new WelcomePage(driver);
        registerPage.goToRegister()
                .registerUser(firstName,lastName,phone,userName, address1, address2, city, state, postalCode, country, email, password, confirmPassword)
                .verifyContent();
    }

    @Parameters({"registerUserName", "registerAddress1"
            ,"registerAddress2", "registerCity", "registerState", "registerPostalCode", "registerCountry", "registerEmail"
            ,"registerPassword", "registerConfirmPassword" })
    @Test(groups = {"RandomValues"})
    public void registerAnAccountRandom( String userName, String address1, String address2
            , String city, String state, String postalCode, String country, String email, String password, String confirmPassword){

        String firstName = FakeData.INSTANCE.getFake().firstName();
        String lastName = FakeData.INSTANCE.getFake().lastName();
        String phone = FakeData.INSTANCE.getFake().phoneNumber();

        WelcomePage registerPage = new WelcomePage(driver);
        registerPage.goToRegister()
                .registerUser(firstName,lastName,phone,userName, address1, address2, city, state, postalCode, country, email, password, confirmPassword)
                .verifyContent();
    }

    //TODO singletone - done -> serializare -> enum
    //todo assertthat .as .istrue - no
    //todo module (miniaplicatii, miniproiecte) - done

    //todo dataprovider excel, csv si db - no

    //todo sa citesc despre intelij - wip
    //todo git code-ul
    //todo chromedriver

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

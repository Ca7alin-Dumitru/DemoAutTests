package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected final WebDriver driver;
//    public static String test = "checksOnPage";

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}

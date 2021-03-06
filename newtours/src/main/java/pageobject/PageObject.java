package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    private static final int TIMEOUT = 10;
    private static final int POLLING = 10000;

    protected final WebDriver driver;
    private static WebDriverWait wait;

    public PageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, TIMEOUT, POLLING);
        PageFactory.initElements(this.driver, this);
    }

    protected static void waitForElementToAppear(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected static void waitForElementToDisappear(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected static void waitForTextToDisappear(By locator, String text){
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator,text)));
    }

    protected static void waitForElementToBeClickable(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForTextToBePresentInElementLocated(By locator, String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }

    protected void waitForUrlContains(String fraction){
        wait.until(ExpectedConditions.urlContains(fraction));
    }
}

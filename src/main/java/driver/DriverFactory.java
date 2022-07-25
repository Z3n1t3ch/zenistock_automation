package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    public WebDriver driver;
    private WebDriverWait waiter;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void waitForURL(String url) {
        this.waiter.until(ExpectedConditions.urlToBe(url));
    }

    public void waitForURLNotToBe(String url) {
        this.waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

    public void waitForElementToBeClickable(WebElement elem) {
       this.waiter.until(ExpectedConditions.elementToBeClickable(elem));
    }

    public void waitForElementToBeDisplayed(WebElement elem) {
        this.waiter.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElementToBeDisplayed(String cssSelector) {
        this.waiter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }
}

package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    public WebDriver driver;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForURL(String url) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(3));
        waiter.until(ExpectedConditions.urlToBe(url));
    }

    public void waitForURLNotToBe(String url) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(3));
        waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

    public void waitForElementToBeClickable(WebElement elem) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(3));
        waiter.until(ExpectedConditions.elementToBeClickable(elem));
    }

    public void waitForElementToBeDisplayed(WebElement elem) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(3));
        waiter.until(ExpectedConditions.visibilityOf(elem));
    }

    public void waitForElementToBeDisplayed(String cssSelector) {
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(3));
        w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }
}

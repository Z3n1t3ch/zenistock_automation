package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Toaster extends DriverFactory {
    public Toaster(WebDriver driver) {
        super(driver);
    }

    public WebElement getErrorToaster() {
        waitForElementToBeDisplayed("#error_toaster");
        return driver.findElement(new By.ById("error_toaster"));
    }

    public WebElement getSuccessToaster() {
        waitForElementToBeDisplayed("#success_toaster");
        return driver.findElement(new By.ById("success_toaster"));
    }

}

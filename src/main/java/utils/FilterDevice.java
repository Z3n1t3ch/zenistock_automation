package utils;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterDevice extends DriverFactory {
    public FilterDevice(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  void filterBySerialNo (String serialNo){
        driver.findElement(By.id("filter_device_button")).click();
        driver.findElement(By.id("device-filter-serialNo")).sendKeys(serialNo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device-filter-apply-button")));
        driver.findElement(By.id("device-filter-apply-button")).click();
    }
}

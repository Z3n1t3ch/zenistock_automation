package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public WebDriver driver;

    public DriverFactory(WebDriver driver) {

        this.driver = driver;
    }
}

package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver driver;

    public DriverFactory(WebDriver driver) {

        this.driver = driver;
    }
}

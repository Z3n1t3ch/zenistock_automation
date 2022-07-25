package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    public WebDriver driver;
    public WebDriverWait wait;

    public DriverFactory(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
}

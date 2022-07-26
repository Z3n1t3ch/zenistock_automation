package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.FilterDevice;

public class BaseTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static FilterDevice filterDevice;
    public static CreateDevicePage createDevicePage;

    @BeforeMethod
    public void openApplication() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        createDevicePage = new CreateDevicePage(driver);
        filterDevice = new FilterDevice(driver);
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}

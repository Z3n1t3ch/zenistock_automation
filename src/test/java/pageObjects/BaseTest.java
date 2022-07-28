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
    public static DevicePage devicePage;
    public static Permissions permissionForAllRoles;

    @BeforeMethod
    public void openApplication() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        permissionForAllRoles = new Permissions(driver);
        devicePage = new DevicePage(driver);
        filterDevice = new FilterDevice(driver);
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}

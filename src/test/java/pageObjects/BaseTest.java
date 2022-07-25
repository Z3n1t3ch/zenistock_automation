package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static TagPage tagPage;
    public static DashboardPage dashboardPage;
    public static Toaster toaster;
    @BeforeMethod
    public void openApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        tagPage = new TagPage(driver);
        dashboardPage = new DashboardPage(driver);
        toaster = new Toaster(driver);
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

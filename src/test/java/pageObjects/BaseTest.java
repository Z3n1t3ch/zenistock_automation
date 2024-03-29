package pageObjects;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static DevicePage devicePage;
    public static Permissions permissionForAllRoles;
    public static Licenses licenses;
    public static EmployeePage employeePage;
    public static Audit audit;
    public static TagsPage tagsPage;
    public static Filter filter;


    @BeforeMethod
    public void openApplication() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        permissionForAllRoles = new Permissions(driver);
        devicePage = new DevicePage(driver);
        employeePage = new EmployeePage(driver);
        licenses=new Licenses(driver);
        filter=new Filter(driver);
        audit = new Audit(driver);
        tagsPage = new TagsPage(driver);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public boolean elementExists(String actions) {
        return driver.getPageSource().contains(actions);
    }

}

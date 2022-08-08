package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @BeforeMethod
    public void openApplication() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        permissionForAllRoles = new Permissions(driver);
        devicePage = new DevicePage(driver);
        employeePage = new EmployeePage(driver);
        licenses=new Licenses(driver);
        audit = new Audit(driver);
    }
    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}

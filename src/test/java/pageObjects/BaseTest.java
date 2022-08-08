package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public  WebDriver driver;
    public  LoginPage loginPage;
    public  DevicePage devicePage;
    public  Permissions permissionForAllRoles;
    public  EmployeePage employeePage;
    public  Filter filter;
    public  Audit audit;
    public  Licenses licenses;

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
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

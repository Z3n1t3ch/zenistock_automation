package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static utils.Constants.*;

public class BaseTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static CreateDevicePage createDevicePage;
    @FindBy(id="username")
    private WebElement usernameField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="log-in-button")
    private WebElement loginButton;


    @BeforeMethod
    public void openApplication() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        createDevicePage = new CreateDevicePage(driver);
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("username")).sendKeys(ADMIN_USERNAME);
        driver.findElement(By.id("password")).sendKeys(ADMIN_PASSWORD);
        driver.findElement(By.id("log-in-button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }
}

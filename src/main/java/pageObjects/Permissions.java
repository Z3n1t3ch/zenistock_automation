package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Permissions extends DriverFactory {

    public Permissions(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private static WebElement usernameField;
    @FindBy(id = "password")
    private static WebElement passwordField;
    @FindBy(id = "log-in-button")
    private static WebElement signInButton;
    @FindBy(id = "undefined-devices-mButton")
    private static WebElement devicesButtonSidebarMenu;

    public static void checkIfUserCanPerformActionOnDevicePage() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        Thread.sleep(2000);
        devicesButtonSidebarMenu.click();
    }

    public static void checkIfAdminCanPerformActionOnDevicePage() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
        Thread.sleep(2000);
        devicesButtonSidebarMenu.click();
    }

    public static void checkIfSuperAdminCanPerformActionOnDevicePage() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(2000);
        devicesButtonSidebarMenu.click();
    }
}

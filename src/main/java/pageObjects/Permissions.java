package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;
public class Permissions extends DriverFactory {

    public Permissions(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private  WebElement usernameField;
    @FindBy(id = "password")
    private  WebElement passwordField;
    @FindBy(id = "log-in-button")
    private  WebElement signInButton;
    @FindBy(id = "undefined-devices-mButton")
    private  WebElement devicesButtonSidebarMenu;
    @FindBy(id = "undefined-assets-mButton")
    private  WebElement assetsButtonSidebarMenu;
    @FindBy(id = "undefined-employees-mButton")
    private  WebElement employeesButtonSidebarMenu;
    @FindBy(id = "undefined-licenses-mButton")
    private  WebElement licensesButtonSidebarMenu;
    public void checkIfUserCanPerformActionOnDevicePage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        devicesButtonSidebarMenu.click();
    }

    public void checkIfAdminCanPerformActionOnDevicePage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
         wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        devicesButtonSidebarMenu.click();
    }

    public  void checkIfSuperAdminCanPerformActionOnDevicePage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        devicesButtonSidebarMenu.click();
    }
    public  void checkIfUserCanPerformActionOnAssetsPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        assetsButtonSidebarMenu.click();
         wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/assets"));
        assetsButtonSidebarMenu.click();
    }
    public  void checkIfAdminCanPerformActionOnAssetsPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        assetsButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/assetshttps://zenistock.zenitech.local/users"));
        assetsButtonSidebarMenu.click();
    }
    public  void checkIfSuperAdminCanPerformActionOnAssetsPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        assetsButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/users"));
        assetsButtonSidebarMenu.click();
    }
    public  void checkIfUserCanPerformActionOnEmployeesPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        employeesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/users"));
     //   employeesButtonSidebarMenu.click();
    }
    public  void checkIfAdminCanPerformActionOnEmployeesPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        employeesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/users"));
        employeesButtonSidebarMenu.click();
    }
    public  void checkIfSuperAdminCanPerformActionOnEmployeesPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        employeesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/users"));
        employeesButtonSidebarMenu.click();
    }
    public  void checkIfUserCanPerformActionOnLicensesPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        licensesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/licenses"));
    }
    public  void checkIfAdminCanPerformActionOnLicensesPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        licensesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/licenses"));
    }
    public  void checkIfSuperAdminCanPerformActionOnLicensesPage()  {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
        licensesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/licenses"));
    }
}

package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class Permissions extends DriverFactory {

    public Permissions(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "log-in-button")
    private WebElement signInButton;
    @FindBy(id = "undefined-devices-mButton")
    private WebElement devicesButtonSidebarMenu;
    @FindBy(id = "undefined-assets-mButton")
    private WebElement assetsButtonSidebarMenu;
    @FindBy(id = "undefined-employees-mButton")
    private WebElement employeesButtonSidebarMenu;
    @FindBy(id = "undefined-licenses-mButton")
    private WebElement licensesButtonSidebarMenu;

    public void checkIfUserCanPerformActionOnDevicePage() {
        devicesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }

    public void checkIfAdminCanPerformActionOnDevicePage() {
        devicesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }

    public  void checkIfSuperAdminCanPerformActionOnDevicePage()  {
        devicesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public  void checkIfUserCanPerformActionOnAssetsPage()  {
        assetsButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.ASSETS_URL));
    }
    public  void checkIfAdminCanPerformActionOnAssetsPage()  {
        assetsButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.ASSETS_URL));
    }
    public  void checkIfSuperAdminCanPerformActionOnAssetsPage()  {
        assetsButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.ASSETS_URL));
    }
    public  void checkIfUserCanPerformActionOnEmployeesPage()  {
        employeesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.EMPLOYEES_URL));
    }
    public  void checkIfAdminCanPerformActionOnEmployeesPage()  {
        employeesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.EMPLOYEES_URL));
    }
    public  void checkIfSuperAdminCanPerformActionOnEmployeesPage()  {
        employeesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.EMPLOYEES_URL));
    }
    public  void checkIfUserCanPerformActionOnLicensesPage()  {
        licensesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
    }
    public  void checkIfAdminCanPerformActionOnLicensesPage()  {
        licensesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
    }
    public  void checkIfSuperAdminCanPerformActionOnLicensesPage()  {
        licensesButtonSidebarMenu.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
    }
}

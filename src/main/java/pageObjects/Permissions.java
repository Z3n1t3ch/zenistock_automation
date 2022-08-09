package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;

public class Permissions extends DriverFactory {

    public Permissions(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "undefined-devices-mButton")
    private WebElement devicesButtonSidebarMenu;
    @FindBy(id = "undefined-assets-mButton")
    private WebElement assetsButtonSidebarMenu;
    @FindBy(id = "undefined-employees-mButton")
    private WebElement employeesButtonSidebarMenu;
    @FindBy(id = "undefined-licenses-mButton")
    private WebElement licensesButtonSidebarMenu;
    @FindBy(id = "undefined-tags-mButton")
    private WebElement tagsButtonSidebarMenu;

    public void checkIfUserCanPerformActionOnDevicePage() {
        devicesButtonSidebarMenu.click();
        pageToLoad(Constants.DEVICES_URL);
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }

    public void checkIfAdminCanPerformActionOnDevicePage() {
        devicesButtonSidebarMenu.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void checkIfSuperAdminCanPerformActionOnDevicePage() {
        devicesButtonSidebarMenu.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void checkIfUserCanPerformActionOnAssetsPage() {
        assetsButtonSidebarMenu.click();
        pageToLoad(Constants.ASSETS_URL);
    }

    public void checkIfAdminCanPerformActionOnAssetsPage() {
        assetsButtonSidebarMenu.click();
        pageToLoad(Constants.ASSETS_URL);
    }

    public void checkIfSuperAdminCanPerformActionOnAssetsPage() {
        assetsButtonSidebarMenu.click();
        pageToLoad(Constants.ASSETS_URL);
    }

    public void checkIfUserCanPerformActionOnEmployeesPage() {
        employeesButtonSidebarMenu.click();
        pageToLoad(Constants.EMPLOYEES_URL);
    }

    public void checkIfAdminCanPerformActionOnEmployeesPage() {
        employeesButtonSidebarMenu.click();
        pageToLoad(Constants.EMPLOYEES_URL);
    }

    public void checkIfSuperAdminCanPerformActionOnEmployeesPage() {
        employeesButtonSidebarMenu.click();
        pageToLoad(Constants.EMPLOYEES_URL);
    }

    public void checkIfUserCanPerformActionOnLicensesPage() {
        licensesButtonSidebarMenu.click();
        pageToLoad(Constants.LICENSES_URL);
    }

    public void checkIfAdminCanPerformActionOnLicensesPage() {
        licensesButtonSidebarMenu.click();
        pageToLoad(Constants.LICENSES_URL);
    }

    public void checkIfSuperAdminCanPerformActionOnLicensesPage() {
        licensesButtonSidebarMenu.click();
        pageToLoad(Constants.LICENSES_URL);
    }

    public void checkIfUserCanPerformActionOnTagsPage() {
        tagsButtonSidebarMenu.click();
        pageToLoad(Constants.TAGS_URL);
    }

    public void checkIfAdminCanPerformActionOnTagsPage() {
        tagsButtonSidebarMenu.click();
        pageToLoad(Constants.TAGS_URL);
    }

    public void checkIfSuperAdminCanPerformActionOnTagsPage() {
        tagsButtonSidebarMenu.click();
        pageToLoad(Constants.TAGS_URL);
    }
}

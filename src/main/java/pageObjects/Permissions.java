package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    public void checkIfUsersCanPerformActionOnDevicePage() {
        devicesButtonSidebarMenu.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void checkIfUsersCanPerformActionOnAssetsPage() {
        assetsButtonSidebarMenu.click();
        pageToLoad(Constants.ASSETS_URL);
    }

    public void checkIfUsersCanPerformActionOnEmployeesPage() {
        employeesButtonSidebarMenu.click();
        pageToLoad(Constants.EMPLOYEES_URL);
    }

    public void checkIfUsersCanPerformActionOnLicensesPage() {
        licensesButtonSidebarMenu.click();
        pageToLoad(Constants.LICENSES_URL);
    }

    public void checkIfUsersCanPerformActionOnTagsPage() {
        tagsButtonSidebarMenu.click();
        pageToLoad(Constants.TAGS_URL);
    }
}

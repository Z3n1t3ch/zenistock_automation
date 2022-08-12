package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;
import static utils.RandomGenerator.randomName;
import static utils.RandomGenerator.randomNumber;
import utils.Credentials;

public class DriverFactory {
    public WebDriver driver;
    public WebDriverWait wait;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "log-in-button")
    private WebElement signInButton;
    @FindBy(id = "filter-button")
    private WebElement filterButtonEmployee;
    @FindBy(id = "user-filter-filter-apply-button")
    private WebElement applyFilterButtonEmployee;
    @FindBy(id = "filter_device_button")
    private WebElement filterDeviceButton;
    @FindBy(id = "device-filter-apply-button")
    private WebElement deviceFilterApplyButton;
    @FindBy(id = "device-filter-serialNo")
    private WebElement deviceFilterSerialNo;
    @FindBy(id = "device-filter-status-autocomplete")
    private WebElement deviceFilterStatusAutocomplete;
    @FindBy(id = "device-filter-status-autocomplete-option-2")
    private WebElement deviceFilterStatusAutocompleteOption2;
    @FindBy(id = "device-table-row-0")
    private WebElement deviceTableRow0;
    @FindBy(id = "undefined-table-row-0")
    private WebElement undefinedTableRow0;
    @FindBy(id = "user-filter-filter-role-selectList")
    private WebElement userFilterFilterRoleSelectList;
    @FindBy(id = "user-filter-filter-role-selectList-user")
    private WebElement userFilterFilterRoleSelectListUser;
    @FindBy(id = "user-filter-filter-role-selectList-admin")
    private WebElement userFilterFilterRoleSelectListAdmin;
    @FindBy(id = "user-filter-filter-role-selectList-super_admin")
    private WebElement userFilterFilterRoleSelectListSuperAdmin;
    @FindBy(id = "user-filter-filter-clearButton")
    private WebElement userFilterFilterClearButton;
    @FindBy(id = "user-filter-filter-email")
    private WebElement userFilterFilterEmail;
    @FindBy(id = "device-table-row-0-button-audit")
    private WebElement deviceTableRow0ButtonAudit;
    @FindBy(className = "MuiCollapse-wrapper")
    private WebElement muiCollapseWrapper;
    @FindBy(className = "MuiTableRow-root")
    private WebElement muiTableRowRoot;
    @FindBy(id = "undefined-licenses-mButton")
    private WebElement licenseButton;
    @FindBy(id = "add-license")
    private WebElement addLicenseButton;

    @FindBy(id = "undefined-devices-mButton")
    private WebElement devicePageButton;

    @FindBy(id = "add_device_button")
    private WebElement addDeviceButton;

    @FindBy(id = "device-information-name")
    private WebElement deviceNameField;

    @FindBy(id = "device-information-serialNo")
    private WebElement deviceSerialNoField;

    @FindBy(id = "device-information-inventoryNo")
    private WebElement deviceInventoryNoField;

    @FindBy(id = "device-information-invoiceNo")
    private WebElement deviceInvoiceNoField;

    @FindBy(id = "tags")
    private WebElement tagsField;

    @FindBy(id = "tags-option-0")
    private WebElement firstTagElement;

    @FindBy(id = "device-saveBtn")
    private WebElement deviceSaveButton;

    public void pageToLoad(String pageUrl) {
        wait.until(ExpectedConditions.urlToBe(pageUrl));
    }

    public void elementToLoad(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void elementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void signInAsSuperAdmin() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.usernameSuperAdminRole);
        passwordField.sendKeys(Credentials.passwordSuperAdminRole);
        signInButton.click();
        pageToLoad(Constants.dashboard);
    }
    public void signInAsAdmin() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.usernameAdminRole);
        passwordField.sendKeys(Credentials.passwordAdminRole);
        signInButton.click();
        pageToLoad(Constants.dashboard);
    }

    public void signInAsUser() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.usernameUserRole);
        passwordField.sendKeys(Credentials.passwordUserRole);
        signInButton.click();
        pageToLoad(Constants.dashboard);
    }

    public void filterBySerialNo(String serialNo) {
        filterDeviceButton.click();
        deviceFilterSerialNo.sendKeys(serialNo);
        elementToLoad(deviceFilterApplyButton);
        deviceFilterApplyButton.click();
    }

    public void filterByStatusInactive() {
        filterDeviceButton.click();
        deviceFilterStatusAutocomplete.click();
        elementToLoad(deviceFilterStatusAutocompleteOption2);
        deviceFilterStatusAutocompleteOption2.click();
        elementToLoad(deviceFilterApplyButton);
        deviceFilterApplyButton.click();
    }

    public String getDeviceName() {
        String firstRowText = deviceTableRow0.getText();
        String[] attributes = firstRowText.split("\n");
        return attributes[0];
    }

    public String getEmployeeName() {
        String firstRowText = undefinedTableRow0.getText();
        String[] attributes = firstRowText.split("\n");
        return attributes[1];
    }

    public String getEmail() {
        String firstRowText = undefinedTableRow0.getText();
        String[] attributes = firstRowText.split("\n");
        return attributes[0];
    }

    public void filterByRole(String role) {
        elementToLoad(filterButtonEmployee);
        filterButtonEmployee.click();
        userFilterFilterRoleSelectList.click();
        switch (role) {
            case "user":
                elementToLoad(userFilterFilterRoleSelectListUser);
                userFilterFilterRoleSelectListUser.click();
                break;
            case "admin":
                elementToLoad(userFilterFilterRoleSelectListAdmin);
                userFilterFilterRoleSelectListAdmin.click();
                break;
            case "super_admin":
                elementToLoad(userFilterFilterRoleSelectListSuperAdmin);
                userFilterFilterRoleSelectListSuperAdmin.click();
                break;
        }
        elementToLoad(applyFilterButtonEmployee);
        applyFilterButtonEmployee.click();
    }

    public void filterByEmail(String email) {
        filterButtonEmployee.click();
        userFilterFilterClearButton.click();
        elementToLoad(filterButtonEmployee);
        filterButtonEmployee.click();
        userFilterFilterEmail.sendKeys(email);
        elementToLoad(applyFilterButtonEmployee);
        applyFilterButtonEmployee.click();
    }

    public void waitForAuditDisplay() {
        elementToLoad(deviceTableRow0ButtonAudit);
        deviceTableRow0ButtonAudit.click();
        elementToLoad(muiCollapseWrapper);
        elementToLoad(muiTableRowRoot);
    }

    public void clearField(WebElement webElement) {
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
    }

    public void deleteTag(String webElementId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(webElementId)));
        driver.findElement(By.id(webElementId)).click();
    }

    public void createDeviceForTagPage() {
        devicePageButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        deviceNameField.sendKeys(randomName());
        deviceSerialNoField.sendKeys(randomNumber() + "");
        deviceInventoryNoField.sendKeys(randomNumber() + "");
        deviceInvoiceNoField.sendKeys(randomNumber() + "");
        tagsField.sendKeys(Constants.EDITABLE_TAG_NAME);
        firstTagElement.click();
        deviceSaveButton.click();
    }

    public String getTextFromElement(WebElement element) {

        return element.getText();
    }

    public void openAddLicensesPage() {
        signInAsAdmin();
        licenseButton.click();
        elementToLoad(addLicenseButton);
        addLicenseButton.click();
        pageToLoad(Constants.LICENSE_DETAILS_URL);
    }
}
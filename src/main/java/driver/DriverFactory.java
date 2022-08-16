package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "log-in-button")
    WebElement signInButton;
    @FindBy(id = "filter-button")
    WebElement filterButtonEmployee;
    @FindBy(id = "user-filter-filter-apply-button")
    WebElement applyFilterButtonEmployee;
    @FindBy(id = "filter_device_button")
    WebElement filterDeviceButton;
    @FindBy(id = "device-filter-apply-button")
    WebElement deviceFilterApplyButton;
    @FindBy(id = "device-filter-serialNo")
    WebElement deviceFilterSerialNo;
    @FindBy(id = "device-filter-status-autocomplete")
    WebElement deviceFilterStatusAutocomplete;
    @FindBy(id = "device-filter-status-autocomplete-option-2")
    WebElement deviceFilterStatusAutocompleteOption2;
    @FindBy(id = "device-table-row-0")
    WebElement deviceTableRow0;
    @FindBy(id = "undefined-table-row-0")
    WebElement undefinedTableRow0;
    @FindBy(id = "user-filter-filter-role-selectList")
    WebElement userFilterFilterRoleSelectList;
    @FindBy(id = "user-filter-filter-role-selectList-user")
    WebElement userFilterFilterRoleSelectListUser;
    @FindBy(id = "user-filter-filter-role-selectList-admin")
    WebElement userFilterFilterRoleSelectListAdmin;
    @FindBy(id = "user-filter-filter-role-selectList-super_admin")
    WebElement userFilterFilterRoleSelectListSuperAdmin;
    @FindBy(id = "user-filter-filter-clearButton")
    WebElement userFilterFilterClearButton;
    @FindBy(id = "user-filter-filter-email")
    WebElement userFilterFilterEmail;
    @FindBy(id = "device-table-row-0-button-audit")
    WebElement deviceTableRow0ButtonAudit;
    @FindBy(className = "MuiCollapse-wrapper")
    WebElement muiCollapseWrapper;
    @FindBy(className = "MuiTableRow-root")
    WebElement muiTableRowRoot;
    @FindBy(id = "undefined-licenses-mButton")
    WebElement licenseButton;
    @FindBy(id = "add-license")
    WebElement addLicenseButton;

    @FindBy(id = "undefined-devices-mButton")
    WebElement devicePageButton;

    @FindBy(id = "add_device_button")
    WebElement addDeviceButton;

    @FindBy(id = "device-information-name")
    WebElement deviceNameField;

    @FindBy(id = "device-information-serialNo")
    WebElement deviceSerialNoField;

    @FindBy(id = "device-information-inventoryNo")
    WebElement deviceInventoryNoField;

    @FindBy(id = "device-information-invoiceNo")
    WebElement deviceInvoiceNoField;

    @FindBy(id = "tags")
    WebElement tagsField;

    @FindBy(id = "tags-option-0")
    WebElement firstTagElement;

    @FindBy(id = "device-saveBtn")
    WebElement deviceSaveButton;
    @FindBy(xpath = "//*[text()='Columns']")
    WebElement columnsButton;
    @FindBy(id = "device-information-name")
    WebElement nameField;
    @FindBy(id = "device-information-serialNo")
    WebElement serialNoField;
    @FindBy(id = "device-information-inventoryNo")
    WebElement inventoryNoField;
    @FindBy(id = "device-information-invoiceNo")
    WebElement invoiceNoField;
    @FindBy(id = "device-information-description")
    WebElement descriptionField;
    @FindBy(id = "device-tags-subcategory-selectList")
    WebElement subcategoryList;
    @FindBy(id = "tags")
    WebElement tagsList;
    @FindBy(id = "device-locations-selectList")
    WebElement locationsList;
    @FindBy(id = "device-saveBtn")
    WebElement saveDeviceButton;
    @FindBy(id = "device-tags-subcategory-selectList-laptop")
    WebElement subcategoryLaptopListElement;
    @FindBy(id = "tags-option-0")
    WebElement tagsListElement;
    @FindBy(id = "device-locations-selectList-romania")
    WebElement locationsRomaniaListElement;

    public String deviceName;
    public int serialNo;
    public int inventoryNo;
    public int invoiceNo;
    public String deviceDropdown = "device_dropdown_";

    public String editDevice = "device_edit_";

    public String assignDevice = "device_assign_";

    public String deleteDevice = "device_delete_";

    public String message;
    String inactiveDeviceName = getDeviceName();

    public void pageToLoad(String pageUrl) {
        wait.until(ExpectedConditions.urlToBe(pageUrl));
    }

    public void elementToLoad(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void elementToLoadForComposedElements (String element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
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
    public String getTextFromTable(){
        return driver.findElement(By.id("device-table")).getText();
    }

    public boolean hasRequired(WebElement element){
        return  Boolean.parseBoolean(element.getAttribute("required"));
    }
    public void fillAllFieldsDevice(){
        deviceName = randomName();
        serialNo = randomNumber();
        inventoryNo = randomNumber();
        invoiceNo = randomNumber();
        addDeviceButton.click();
        nameField.sendKeys(deviceName);
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        descriptionField.sendKeys(Constants.DEVICE_DESCRIPTION);
        subcategoryList.click();
        subcategoryLaptopListElement.click();
        tagsList.click();
        tagsListElement.click();
        locationsList.click();
        locationsRomaniaListElement.click();
        saveDeviceButton.click();
    }
    public void fillAllMandatoryFields(WebElement field){
        deviceName = randomName();
        serialNo = randomNumber();
        inventoryNo = randomNumber();
        invoiceNo = randomNumber();
        addDeviceButton.click();
        nameField.sendKeys(deviceName);
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        clearField(field);
    }


    public void openColumns(WebElement element) {
        columnsButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        elementToLoad(element);
        element.click();
        WebElement closeColumns = driver.switchTo().activeElement();
        closeColumns.sendKeys(Keys.ESCAPE);
    }

    public void openThreeDotsOptions(String dropdown, String option){
        dropdown = deviceDropdown + deviceName;
        elementToLoadForComposedElements(dropdown);
        driver.findElement(By.id(dropdown)).click();
        option = option + deviceName;
        elementToLoadForComposedElements(option);
        driver.findElement(By.id(option)).click();
    }
    public void openThreeDotsOptionsForInactive(String dropdown, String inactive){
        dropdown = deviceDropdown + inactiveDeviceName;
        elementToLoadForComposedElements(dropdown);
        driver.findElement(By.id(dropdown)).click();
        inactive = assignDevice + inactiveDeviceName;
        elementToLoadForComposedElements(inactive);
        driver.findElement(By.id(inactive)).click();
    }
}

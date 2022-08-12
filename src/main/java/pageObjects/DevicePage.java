package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;
import java.text.ParseException;
import static utils.Constants.DEVICE_DESCRIPTION;
import static utils.RandomGenerator.randomDateBefore;
import static utils.RandomGenerator.randomName;
import static utils.RandomGenerator.randomNumber;


public class DevicePage extends DriverFactory {

    private String deviceName;
    private int serialNo;
    private int inventoryNo;
    private int invoiceNo;
    String successEdit;

    public DevicePage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "undefined-devices-mButton")
    WebElement devicesButton;
    @FindBy(id = "add_device_button")
    WebElement addDeviceButton;
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
    @FindBy(id = "assign_user")
    WebElement assignUserButton;
    @FindBy(id = "assign_user-option-0")
    WebElement firstUserInList;
    @FindBy(id = "assign_update")
    WebElement assignUpdateButton;
    @FindBy(id = "device-information-invoiceDate")
    WebElement invoiceDateField;

    @FindBy(id = "device-information-startWarranty")
    WebElement startDateWarrantyField;

    @FindBy(id = "device-information-endWarranty")
    WebElement endDateWarrantyField;

    @FindBy(xpath = "//*[text()='Columns']")
    WebElement columnsButton;

    @FindBy(xpath = "//*[text()='Inventory no']")
    WebElement inventoryNoInColumns;

    @FindBy(xpath = "//*[text()='Invoice no']")
    WebElement invoiceNoInColumns;

    @FindBy(xpath = "//*[text()='Invoice Date']")
    WebElement invoiceDateInColumns;

    @FindBy(xpath = "//*[text()='Warranty start date']")
    WebElement warrantyStartDateInColumns;

    @FindBy(xpath = "//*[text()='Warranty end date']")
    WebElement warrantyEndDateInColumns;

    @FindBy(id = "success_toaster")
    WebElement successToaster;

    @FindBy(id = "error_toaster")
    WebElement errorToaster;

    @FindBy(id = "filter_device_button")
    WebElement filterButton;
    @FindBy(id = "device-filter-clearButton")
    WebElement filterButtonClearAll;

    @FindBy(id = "device-table")
    WebElement deviceTable;

    @FindBy(id = "device-information-endWarranty")
    private WebElement endWarrantyField;

    public String fieldInTabel(){
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

    public void openColumns(WebElement element) {
        columnsButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        elementToLoad(element);
        element.click();
        WebElement element2 = driver.switchTo().activeElement();
        element2.sendKeys(Keys.ESCAPE);
    }

    public void openEdit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
    }

    public void openAssign(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_assign_" + deviceName)));
        driver.findElement(By.id("device_assign_" + deviceName)).click();
    }
    public void openInactiveDevice(){
        filterByStatusInactive();
        String inactiveDeviceName = getDeviceName();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + inactiveDeviceName)));
        driver.findElement(By.id("device_dropdown_" + inactiveDeviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_assign_" + inactiveDeviceName)));
        driver.findElement(By.id("device_assign_" + inactiveDeviceName)).click();
    }

    public void successfullyCreateDevice() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        fillAllFieldsDevice();
        elementToLoad(successToaster);
        elementToDisappear(successToaster);
        elementToLoad(filterButton);
        filterBySerialNo(serialNo + "");
    }
    public void successfullyEditADeviceName() {
        successfullyCreateDevice();
        openEdit();
        nameField.clear();
        nameField.sendKeys(Constants.name);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        successEdit = successToaster.getText();
        elementToDisappear(successToaster);
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterButtonClearAll);
        filterButtonClearAll.click();
        elementToLoad(filterButton);
        filterBySerialNo(serialNo + "");
        pageToLoad(Constants.DEVICES_URL);
    }
    public void successfullyEditADeviceSerialNo() {
        successfullyCreateDevice();
        openEdit();
        serialNoField.clear();
        serialNoField.sendKeys(Constants.number);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        successEdit = successToaster.getText();
        elementToDisappear(successToaster);
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterButtonClearAll);
        filterButtonClearAll.click();
        elementToLoad(filterButton);
        filterBySerialNo(serialNo + "");
        pageToLoad(Constants.DEVICES_URL);
    }
    public void successfullyEditADeviceInventoryNo() {
        successfullyCreateDevice();
        openEdit();
        inventoryNoField.clear();
        inventoryNoField.sendKeys(Constants.number);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        successEdit = successToaster.getText();
        elementToDisappear(successToaster);
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterButtonClearAll);
        filterButtonClearAll.click();
        elementToLoad(filterButton);
        filterBySerialNo(serialNo + "");
        pageToLoad(Constants.DEVICES_URL);
        openColumns(inventoryNoInColumns);
    }

    public void successfullyEditADeviceInvoiceNo() {
        successfullyCreateDevice();
        openEdit();
        invoiceNoField.sendKeys(Keys.CONTROL + "a");
        invoiceNoField.sendKeys(Keys.DELETE);
        invoiceNoField.sendKeys(Constants.number);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        successEdit = successToaster.getText();
        elementToDisappear(successToaster);
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterButtonClearAll);
        filterButtonClearAll.click();
        elementToLoad(filterButton);
        filterBySerialNo(serialNo + "");
        pageToLoad(Constants.DEVICES_URL);
        openColumns(invoiceNoInColumns);
        elementToLoad(deviceTable);
    }

    public void successfullyEditDescription() {
        successfullyCreateDevice();
        openEdit();
        descriptionField.clear();
        descriptionField.sendKeys(randomName());
        saveDeviceButton.click();
        elementToLoad(successToaster);
    }

    public void createDeviceWithoutName() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutName() {
        successfullyCreateDevice();
        openEdit();
        nameField.clear();
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithoutSerialNo() {
        signInAsAdmin();
        elementToLoad(devicesButton);
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutSerialNo() {
        successfullyCreateDevice();
        openEdit();
        serialNoField.clear();
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithoutInventoryNo() {
        signInAsAdmin();
        elementToLoad(devicesButton);
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutInventoryNo() {
        successfullyCreateDevice();
        openEdit();
        inventoryNoField.clear();
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithoutInvoiceNo() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutInvoiceNo() {
        successfullyCreateDevice();
        openEdit();
        invoiceNoField.clear();
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithWhiteSpacesNameField() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(Constants.DEVICE_NAME_WS);
        serialNoField.sendKeys(deviceName + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceWithWhiteSpacesNameField() {
        successfullyCreateDevice();
        openEdit();
        nameField.clear();
        nameField.sendKeys(Constants.DEVICE_NAME_WS);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithWhiteSpaceSerialNoField() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(Constants.DEVICE_SERIAL_NO_WS);
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceWithWhiteSpaceSerialNoField() {
        successfullyCreateDevice();
        openEdit();
        serialNoField.clear();
        serialNoField.sendKeys(Constants.DEVICE_SERIAL_NO_WS);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithWhiteSpaceInventoryNoField() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(Constants.DEVICE_INVENTORY_NO_WS);
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceWithWhiteSpaceInventoryNo() {
        successfullyCreateDevice();
        openEdit();
        inventoryNoField.clear();
        inventoryNoField.sendKeys(Constants.DEVICE_INVENTORY_NO_WS);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithWhiteSpaceInvoiceNoField() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(Constants.DEVICE_INVOICE_NO_WS);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceWithWhiteSpaceInvoiceNo() {
        successfullyCreateDevice();
        openEdit();
        invoiceNoField.clear();
        invoiceNoField.sendKeys(Constants.DEVICE_INVOICE_NO_WS);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithWhiteSpaceDescriptionField() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        descriptionField.sendKeys(Constants.DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceWithWhiteSpaceDescriptionField() {
        successfullyCreateDevice();
        openEdit();
        descriptionField.clear();
        descriptionField.sendKeys(Constants.DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceTooLongName() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(Constants.DEVICE_NAME_TOO_LONG);
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceTooLongName() {
        successfullyCreateDevice();
        openEdit();
        nameField.clear();
        nameField.sendKeys(Constants.DEVICE_NAME_TOO_LONG);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceTooLongSerialNo() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(Constants.DEVICE_NUMBER_OVER_30_CHAR);
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceTooLongSerialNo() {
        successfullyCreateDevice();
        openEdit();
        serialNoField.clear();
        serialNoField.sendKeys((Constants.DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
       elementToLoad(errorToaster);
    }

    public void createDeviceTooLongInventoryNo() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(Constants.DEVICE_NUMBER_OVER_30_CHAR);
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceTooLongInventoryNo() {
        successfullyCreateDevice();
        openEdit();
        inventoryNoField.clear();
        inventoryNoField.sendKeys((Constants.DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceTooLongInvoiceNo() {
        signInAsAdmin();
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(Constants.DEVICE_NUMBER_OVER_30_CHAR);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void editDeviceTooLongInvoiceNo() {
        successfullyCreateDevice();
        openEdit();
        invoiceNoField.clear();
        invoiceNoField.sendKeys((Constants.DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    // The Invoice Date Field has a bug, this method will work after repair
    public void successfullyEditInvoiceDate() {
        successfullyCreateDevice();
        openEdit();
        invoiceDateField.sendKeys(Keys.CONTROL + "a");
        invoiceNoField.sendKeys(Keys.DELETE);
        invoiceDateField.sendKeys(Constants.INVOICE_DATE);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        successEdit = successToaster.getText();
        elementToDisappear(successToaster);
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterButtonClearAll);
        filterButtonClearAll.click();
        elementToLoad(filterButton);
        filterBySerialNo(serialNo + "");
        pageToLoad(Constants.DEVICES_URL);
        openColumns(invoiceDateInColumns);
        elementToLoad(deviceTable);
    }

    // The Warranty Dates Fields have a bug, this method will work after repair
    public void successfullyEditStartDateAndEndDate() {
        successfullyCreateDevice();
        openEdit();
        startDateWarrantyField.click();
        startDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        startDateWarrantyField.sendKeys(Keys.DELETE);
        startDateWarrantyField.sendKeys(Constants.WARRANTY_START_DATE);
        endDateWarrantyField.click();
        endDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        endDateWarrantyField.sendKeys(Keys.DELETE);
        endDateWarrantyField.sendKeys(Constants.WARRANTY_END_DATE);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        successEdit = successToaster.getText();
        elementToDisappear(successToaster);
        openColumns(warrantyStartDateInColumns);
        openColumns(warrantyEndDateInColumns);
        elementToLoad(deviceTable);
    }

    public void editEndDateToBeEarlierThenStartDate() {
        successfullyCreateDevice();
        openEdit();
        endDateWarrantyField.click();
        endDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        endDateWarrantyField.sendKeys(Keys.DELETE);
        endDateWarrantyField.sendKeys(Constants.WARRANTY_END_DATE_ERROR);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void successfullyAssignDevice() {
        successfullyCreateDevice();
        openAssign();
        elementToLoad(assignUserButton);
        assignUserButton.click();
        elementToLoad(firstUserInList);
        firstUserInList.click();
        elementToLoad(assignUpdateButton);
        assignUpdateButton.click();
        elementToLoad(successToaster);
        elementToDisappear(successToaster);

    }

    public void succesfullyUnAssignDevice() {
        successfullyAssignDevice();
        openAssign();
        elementToLoad(assignUpdateButton);
        assignUpdateButton.click();
        elementToLoad(successToaster);
        elementToDisappear(successToaster);
    }

    public void assignDeviceWithoutUser() {
        successfullyCreateDevice();
        openAssign();
        elementToLoad(assignUpdateButton);
        assignUpdateButton.click();
    }

    public void assignDeviceInactiveStatus() {
        signInAsAdmin();
        elementToLoad(devicesButton);
        devicesButton.click();
        elementToLoad(filterButton);
        openInactiveDevice();
        elementToLoad(assignUserButton);
        assignUserButton.click();
        elementToLoad(firstUserInList);
        firstUserInList.click();
        elementToLoad(assignUpdateButton);
        assignUpdateButton.click();
    }

    public void deleteDevice() {
        successfullyCreateDevice();
        openAssign();
        elementToLoad(successToaster);
    }

    public void successfullyDeleteAssignedDevice() {
        successfullyAssignDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_delete_" + deviceName)));
        driver.findElement(By.id("device_delete_" + deviceName)).click();
        elementToLoad(successToaster);
        elementToDisappear(successToaster);
    }

    public void deleteInactiveDevice() {
        signInAsAdmin();
        elementToLoad(devicesButton);
        devicesButton.click();
        elementToLoad(filterButton);
        openInactiveDevice();
        elementToLoad(successToaster);
    }

    public void createDeviceInvalidWarrantyEndDate() {
        signInAsAdmin();
        deviceName = randomName();
        serialNo = randomNumber();
        inventoryNo = randomNumber();
        invoiceNo = randomNumber();
        elementToLoad(devicesButton);
        devicesButton.click();
        elementToLoad(addDeviceButton);
        addDeviceButton.click();
        nameField.sendKeys(deviceName);
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        descriptionField.sendKeys(DEVICE_DESCRIPTION);
        endWarrantyField.click();
        endWarrantyField.sendKeys(Keys.CONTROL + "a");
        endWarrantyField.sendKeys(Keys.DELETE);
        try {
            endWarrantyField.sendKeys(randomDateBefore());
        } catch (ParseException parseException){
            parseException.printStackTrace();
        }
        subcategoryList.click();
        subcategoryLaptopListElement.click();
        tagsList.click();
        tagsListElement.click();
        locationsList.click();
        locationsRomaniaListElement.click();
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

}

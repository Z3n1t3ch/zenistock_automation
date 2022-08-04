package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;

import java.util.concurrent.TimeUnit;

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


    public void successfullyCreateDevice() {
        signInAsAdmin();
        deviceName = randomName();
        serialNo = randomNumber();
        inventoryNo = randomNumber();
        invoiceNo = randomNumber();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOf(addDeviceButton));
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
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        wait.until(ExpectedConditions.invisibilityOf(successToaster));
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterBySerialNo(serialNo + "");
    }

    public void successfullyEditADeviceName() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        nameField.clear();
        nameField.sendKeys(Constants.name);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        successEdit = successToaster.getText();
        wait.until(ExpectedConditions.invisibilityOf(successToaster));
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButtonClearAll));
        filterButtonClearAll.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterBySerialNo(serialNo + "");
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }

    public void successfullyEditADeviceSerialNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        serialNoField.clear();
        serialNoField.sendKeys(Constants.number);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        successEdit = successToaster.getText();
        wait.until(ExpectedConditions.invisibilityOf(successToaster));
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButtonClearAll));
        filterButtonClearAll.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterBySerialNo(serialNo + "");
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }

    public void successfullyEditADeviceInventoryNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        inventoryNoField.clear();
        inventoryNoField.sendKeys(Constants.number);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        successEdit = successToaster.getText();
        wait.until(ExpectedConditions.invisibilityOf(successToaster));
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButtonClearAll));
        filterButtonClearAll.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterBySerialNo(serialNo + "");
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
        columnsButton.click();
        wait.until(ExpectedConditions.visibilityOf(inventoryNoInColumns));
        inventoryNoInColumns.click();
        WebElement element = driver.switchTo().activeElement();
        element.sendKeys(Keys.ESCAPE);
    }

    public void successfullyEditADeviceInvoiceNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceNoField.sendKeys(Keys.CONTROL + "a");
        invoiceNoField.sendKeys(Keys.DELETE);
        invoiceNoField.sendKeys(Constants.number);
        System.out.println(serialNo);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        successEdit = successToaster.getText();
        wait.until(ExpectedConditions.invisibilityOf(successToaster));
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButtonClearAll));
        filterButtonClearAll.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterBySerialNo(serialNo + "");
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
        columnsButton.click();
        WebElement scroll = invoiceNoInColumns;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        invoiceNoInColumns.click();
        WebElement element = driver.switchTo().activeElement();
        element.sendKeys(Keys.ESCAPE);
        wait.until(ExpectedConditions.visibilityOf(deviceTable));
    }

    public void successfullyEditDescription() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        descriptionField.clear();
        descriptionField.sendKeys(randomName());
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
    }


    public void createDeviceWithoutName() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutName() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        nameField.clear();
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceWithoutSerialNo() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOf(devicesButton));
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutSerialNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        serialNoField.clear();
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceWithoutInventoryNo() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOf(devicesButton));
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutInventoryNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        inventoryNoField.clear();
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceWithoutInvoiceNo() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutInvoiceNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceNoField.clear();
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceWithWhiteSpacesNameField() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(Constants.DEVICE_NAME_WS);
        serialNoField.sendKeys(deviceName + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceWithWhiteSpacesNameField() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        nameField.clear();
        nameField.sendKeys(Constants.DEVICE_NAME_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceWithWhiteSpaceSerialNoField() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(Constants.DEVICE_SERIAL_NO_WS);
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceWithWhiteSpaceSerialNoField() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        serialNoField.clear();
        serialNoField.sendKeys(Constants.DEVICE_SERIAL_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceWithWhiteSpaceInventoryNoField() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOf(addDeviceButton));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(Constants.DEVICE_INVENTORY_NO_WS);
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceWithWhiteSpaceInventoryNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        inventoryNoField.clear();
        inventoryNoField.sendKeys(Constants.DEVICE_INVENTORY_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceWithWhiteSpaceInvoiceNoField() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOf(addDeviceButton));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(Constants.DEVICE_INVOICE_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceWithWhiteSpaceInvoiceNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceNoField.clear();
        invoiceNoField.sendKeys(Constants.DEVICE_INVOICE_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceWithWhiteSpaceDescriptionField() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        descriptionField.sendKeys(Constants.DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceWithWhiteSpaceDescriptionField() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        descriptionField.clear();
        descriptionField.sendKeys(Constants.DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceTooLongName() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(Constants.DEVICE_NAME_TOO_LONG);
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceTooLongName() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        nameField.clear();
        nameField.sendKeys(Constants.DEVICE_NAME_TOO_LONG);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceTooLongSerialNo() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOf(addDeviceButton));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(Constants.DEVICE_NUMBER_OVER_30_CHAR);
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceTooLongSerialNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        serialNoField.clear();
        serialNoField.sendKeys((Constants.DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceTooLongInventoryNo() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(Constants.DEVICE_NUMBER_OVER_30_CHAR);
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceTooLongInventoryNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        inventoryNoField.clear();
        inventoryNoField.sendKeys((Constants.DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createDeviceTooLongInvoiceNo() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOf(addDeviceButton));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(Constants.DEVICE_NUMBER_OVER_30_CHAR);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void editDeviceTooLongInvoiceNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceNoField.clear();
        invoiceNoField.sendKeys((Constants.DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    // The Invoice Date Field has a bug, this method will work after repair
    public void successfullyEditInvoiceDate() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceDateField.sendKeys(Keys.CONTROL + "a");
        invoiceNoField.sendKeys(Keys.DELETE);
        invoiceDateField.sendKeys(Constants.INVOICE_DATE);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        successEdit = successToaster.getText();
        wait.until(ExpectedConditions.invisibilityOf(successToaster));
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButtonClearAll));
        filterButtonClearAll.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterBySerialNo(serialNo + "");
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
        columnsButton.click();
        WebElement scroll = invoiceDateInColumns;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        invoiceDateInColumns.click();
        WebElement element = driver.switchTo().activeElement();
        element.sendKeys(Keys.ESCAPE);
        wait.until(ExpectedConditions.visibilityOf(deviceTable));
    }

    // The Warranty Dates Fields have a bug, this method will work after repair
    public void successfullyEditStartDateAndEndDate() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        startDateWarrantyField.click();
        startDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        startDateWarrantyField.sendKeys(Keys.DELETE);
        startDateWarrantyField.sendKeys(Constants.WARRANTY_START_DATE);
        endDateWarrantyField.click();
        endDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        endDateWarrantyField.sendKeys(Keys.DELETE);
        endDateWarrantyField.sendKeys(Constants.WARRANTY_END_DATE);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        successEdit = successToaster.getText();
        wait.until(ExpectedConditions.invisibilityOf(successToaster));
        columnsButton.click();
        WebElement scroll = warrantyStartDateInColumns;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        wait.until(ExpectedConditions.visibilityOf(warrantyStartDateInColumns));
        warrantyStartDateInColumns.click();
        wait.until(ExpectedConditions.visibilityOf(warrantyEndDateInColumns));
        warrantyEndDateInColumns.click();
        WebElement element = driver.switchTo().activeElement();
        element.sendKeys(Keys.ESCAPE);
        wait.until(ExpectedConditions.visibilityOf(deviceTable));
    }

    public void editEndDateToBeEarlierThenStartDate() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        endDateWarrantyField.click();
        endDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        endDateWarrantyField.sendKeys(Keys.DELETE);
        endDateWarrantyField.sendKeys(Constants.WARRANTY_END_DATE_ERROR);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void successfullyAssignDevice() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_assign_" + deviceName)));
        driver.findElement(By.id("device_assign_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign_user")));
        assignUserButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign_user-option-0")));
        firstUserInList.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign_update")));
        assignUpdateButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void succesfullyUnAssignDevice() {
        successfullyAssignDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_assign_" + deviceName)));
        driver.findElement(By.id("device_assign_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOf(assignUpdateButton));
        assignUpdateButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
    }


    public void assignDeviceWithoutUser() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_assign_" + deviceName)));
        driver.findElement(By.id("device_assign_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOf(assignUpdateButton));
        assignUpdateButton.click();
    }

    public void assignDeviceInactiveStatus() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter_device_button")));
        filterByStatusInactive();
        String inactiveDeviceName = getDeviceName();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + inactiveDeviceName)));
        driver.findElement(By.id("device_dropdown_" + inactiveDeviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_assign_" + inactiveDeviceName)));
        driver.findElement(By.id("device_assign_" + inactiveDeviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign_user")));
        assignUserButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign_user-option-0")));
        firstUserInList.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign_update")));
        assignUpdateButton.click();
    }

    public void deleteDevice() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_delete_" + deviceName)));
        driver.findElement(By.id("device_delete_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
    }

    public void successfullyDeleteAssignedDevice() {
        successfullyAssignDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_delete_" + deviceName)));
        driver.findElement(By.id("device_delete_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
    }

    public void deleteInactiveDevice() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter_device_button")));
        filterByStatusInactive();
        String inactiveDeviceName = getDeviceName();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + inactiveDeviceName)));
        driver.findElement(By.id("device_dropdown_" + inactiveDeviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_delete_" + inactiveDeviceName)));
        driver.findElement(By.id("device_delete_" + inactiveDeviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }
}

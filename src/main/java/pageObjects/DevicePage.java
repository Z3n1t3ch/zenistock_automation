package pageObjects;

import driver.DriverFactory;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;
import utils.RandomGenerator;

import java.util.concurrent.TimeUnit;

import static utils.Constants.*;
import static utils.RandomGenerator.randomName;
import static utils.RandomGenerator.randomNumber;


public class DevicePage extends DriverFactory {

    private String deviceName;
    private int serialNo;
    private int inventoryNo;
    private int invoiceNo;

    public DevicePage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "undefined-devices-mButton")
    private WebElement devicesButton;
    @FindBy(id = "add_device_button")
    private WebElement addDeviceButton;
    @FindBy(id = "device-information-name")
    private WebElement nameField;
    @FindBy(id = "device-information-serialNo")
    private WebElement serialNoField;
    @FindBy(id = "device-information-inventoryNo")
    private WebElement inventoryNoField;
    @FindBy(id = "device-information-invoiceNo")
    private WebElement invoiceNoField;
    @FindBy(id = "device-information-description")
    private WebElement descriptionField;
    @FindBy(id = "device-tags-subcategory-selectList")
    private WebElement subcategoryList;
    @FindBy(id = "tags")
    private WebElement tagsList;
    @FindBy(id = "device-locations-selectList")
    private WebElement locationsList;
    @FindBy(id = "device-saveBtn")
    private WebElement saveDeviceButton;
    @FindBy(id = "device-tags-subcategory-selectList-laptop")
    private WebElement subcategoryLaptopListElement;
    @FindBy(id = "tags-option-0")
    private WebElement tagsListElement;
    @FindBy(id = "device-locations-selectList-romania")
    private WebElement locationsRomaniaListElement;
    @FindBy(id = "device_dropdown_11")
    private WebElement devicesDropdownButtonInactive;
    @FindBy(id = "device_assign_11")
    private WebElement devicesAssignButtonInactive;
    @FindBy(id = "assign_user")
    private WebElement assignUserButton;
    @FindBy(id = "assign_user-option-0")
    private WebElement firstUserInList;
    @FindBy(id = "assign_update")
    private WebElement assignUpdateButton;

    @FindBy (id = "device-information-invoiceDate")
    private WebElement invoiceDateField;

    @FindBy(id= "device-information-startWarranty")
    private WebElement startDateWarrantyField;

    @FindBy(id = "device-information-endWarranty")
    private WebElement endDateWarrantyField;


    public void successfullyCreateDevice() {
        signInAsAdmin();
        deviceName = randomName();
        serialNo = randomNumber();
        inventoryNo = randomNumber();
        invoiceNo = randomNumber();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName);
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        descriptionField.sendKeys(DEVICE_DESCRIPTION);
        subcategoryList.click();
        subcategoryLaptopListElement.click();
        tagsList.click();
        tagsListElement.click();
        locationsList.click();
        locationsRomaniaListElement.click();
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("success_toaster")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter_device_button")));
        filterBySerialNo(serialNo + "");
    }

    public void successfullyEditADeviceName(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        nameField.click();
        nameField.clear();
        nameField.sendKeys(randomNumber()+ "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }

    public void successfullyEditADeviceSerialNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        serialNoField.click();
        serialNoField.clear();
        serialNoField.sendKeys(randomNumber()+ "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }

    public void successfullyEditADeviceInventoryNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        inventoryNoField.click();
        inventoryNoField.clear();
        inventoryNoField.sendKeys(randomNumber()+ "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }

    public void successfullyEditADeviceInvoiceNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceNoField.click();
        invoiceNoField.clear();
        invoiceNoField.sendKeys(randomNumber()+ "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }
    public void successfullyEditDescription(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        descriptionField.click();
        descriptionField.clear();
        descriptionField.sendKeys(randomName());
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
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
    public void editDeviceWithoutName(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        nameField.click();
        nameField.clear();
        saveDeviceButton.click();
    }

    public void createDeviceWithoutSerialNo() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutSerialNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        serialNoField.click();
        serialNoField.clear();
        saveDeviceButton.click();
    }

    public void createDeviceWithoutInventoryNo() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void editDeviceWithoutInventoryNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        inventoryNoField.click();
        inventoryNoField.clear();
        saveDeviceButton.click();
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

    public void editDeviceWithoutInvoiceNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceNoField.click();
        invoiceNoField.clear();
        saveDeviceButton.click();
    }

    public void createDeviceWithWhiteSpacesNameField() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME_WS);
        serialNoField.sendKeys(deviceName + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceWithWhiteSpacesNameField(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        nameField.click();
        nameField.clear();
        nameField.sendKeys(DEVICE_NAME_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceSerialNoField() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(DEVICE_SERIAL_NO_WS);
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceWithWhiteSpaceSerialNoField(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        serialNoField.click();
        serialNoField.clear();
        serialNoField.sendKeys(DEVICE_SERIAL_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceInventoryNoField() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO_WS);
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceWithWhiteSpaceInventoryNo() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        inventoryNoField.click();
        inventoryNoField.clear();
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceInvoiceNoField() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceWithWhiteSpaceInvoiceNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceNoField.click();
        invoiceNoField.clear();
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceDescriptionField() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        descriptionField.sendKeys(DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceWithWhiteSpaceDescriptionField(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        descriptionField.click();
        descriptionField.clear();
        descriptionField.sendKeys(DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongName() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME_TOO_LONG);
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceTooLongName(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        nameField.click();
        nameField.clear();
        nameField.sendKeys(DEVICE_NAME_TOO_LONG);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongSerialNo() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceTooLongSerialNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        serialNoField.click();
        serialNoField.clear();
        serialNoField.sendKeys((DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongInventoryNo() {
        signInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceTooLongInventoryNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        inventoryNoField.click();
        inventoryNoField.clear();
        inventoryNoField.sendKeys((DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongInvoiceNo() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void editDeviceTooLongInvoiceNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceNoField.click();
        invoiceNoField.clear();
        invoiceNoField.sendKeys((DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void successfullyEditInvoiceDate(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        invoiceDateField.click();
        invoiceDateField.sendKeys(Keys.CONTROL + "a");
        invoiceDateField.sendKeys(Keys.DELETE);
        invoiceDateField.sendKeys(RandomGenerator.randomDate());
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }
    public void successfullyEditStartDateAndEndDate(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        startDateWarrantyField.click();
        startDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        startDateWarrantyField.sendKeys(Keys.DELETE);
        startDateWarrantyField.sendKeys(WARRANTY_START_DATE);
        endDateWarrantyField.click();
        endDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        endDateWarrantyField.sendKeys(Keys.DELETE);
        endDateWarrantyField.sendKeys(WARRANTY_END_DATE);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }
    public void editEndDateToBeEarlierThenStartDate(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe(Credentials.device_details));
        endDateWarrantyField.click();
        endDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        endDateWarrantyField.sendKeys(Keys.DELETE);
        endDateWarrantyField.sendKeys(WARRANTY_END_DATE_ERROR);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign_update")));
        assignUpdateButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }

    public void assignDeviceWithoutUser() {
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_assign_" + deviceName)));
        driver.findElement(By.id("device_assign_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign_update")));
        assignUpdateButton.click();
    }

    public void assignDeviceInactiveStatus() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter_device_button")));
        filterByStatusInactive();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_11")));
        devicesDropdownButtonInactive.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_assign_11")));
        devicesAssignButtonInactive.click();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }

    public void successfullyDeleteAssignedDevice() {
        successfullyAssignDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_delete_" + deviceName)));
        driver.findElement(By.id("device_delete_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
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

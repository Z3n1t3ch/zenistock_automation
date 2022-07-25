package pageObjects;


import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static utils.Constants.*;

public class CreateDevicePage extends DriverFactory {
    public CreateDevicePage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "log-in-button")
    private WebElement loginButton;

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

    @FindBy(id = "success_toaster")
    private WebElement successToaster;

    @FindBy(id = "error_toaster")
    private WebElement errorToaster;

    @FindBy(id = "filter_device_button")
    private WebElement filterButton;

    @FindBy(id = "device-filter-serialNo")
    private WebElement filterSerialNoField;

    @FindBy(id = "device-filter-apply-button")
    private WebElement applyButton;

    public void successfullyCreateDevice() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        descriptionField.sendKeys(DEVICE_DESCRIPTION);
        subcategoryList.click();
        subcategoryLaptopListElement.click();
        tagsList.click();
        tagsListElement.click();
        locationsList.click();
        locationsRomaniaListElement.click();
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));


    }

    public void createDeviceWithoutName() {
        devicesButton.click();
        addDeviceButton.click();
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithoutSerialNo() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithoutInventoryNo() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithoutInvoiceNo() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithWhiteSpacesNameField() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME_WS);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithWhiteSpaceSerialNoField() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO_WS);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithWhiteSpaceInventoryNoField() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO_WS);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithWhiteSpaceInvoiceNoField() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO_WS);
        saveDeviceButton.click();
    }

    public void createDeviceWithThiteSpaceDescriptionField() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        descriptionField.sendKeys(DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
    }

    public void createDeviceTooLongName() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME_TOO_LONG);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceTooLongSerialNo() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceToLongInventoryNo() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceToLongInvoiceNo() {
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        saveDeviceButton.click();
    }
}

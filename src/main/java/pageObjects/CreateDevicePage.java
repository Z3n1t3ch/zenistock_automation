package pageObjects;


import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Constants.DEVICE_DESCRIPTION;
import static utils.Constants.DEVICE_DESCRIPTION_WS;
import static utils.Constants.DEVICE_INVENTORY_NO;
import static utils.Constants.DEVICE_INVENTORY_NO_WS;
import static utils.Constants.DEVICE_INVOICE_NO;
import static utils.Constants.DEVICE_INVOICE_NO_WS;
import static utils.Constants.DEVICE_NAME;
import static utils.Constants.DEVICE_NAME_TOO_LONG;
import static utils.Constants.DEVICE_NAME_WS;
import static utils.Constants.DEVICE_NUMBER_OVER_30_CHAR;
import static utils.Constants.DEVICE_SERIAL_NO;
import static utils.Constants.DEVICE_SERIAL_NO_WS;


public class CreateDevicePage extends DriverFactory {

    private LoginPage loginPage;
    public CreateDevicePage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
        loginPage = new LoginPage(driver);

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

    public void successfullyCreateDevice() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
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
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithoutSerialNo() {
        loginPage.successfulSignInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithoutInventoryNo() {
        loginPage.successfulSignInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithoutInvoiceNo() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        saveDeviceButton.click();
    }

    public void createDeviceWithWhiteSpacesNameField() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME_WS);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceSerialNoField() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO_WS);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceInventoryNoField() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO_WS);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceInvoiceNoField() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceDescriptionField() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        descriptionField.sendKeys(DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongName() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME_TOO_LONG);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongSerialNo() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongInventoryNo() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        invoiceNoField.sendKeys(DEVICE_INVOICE_NO);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongInvoiceNo() {
        loginPage.successfulSignInAsAdmin();
        devicesButton.click();
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME);
        serialNoField.sendKeys(DEVICE_SERIAL_NO);
        inventoryNoField.sendKeys(DEVICE_INVENTORY_NO);
        invoiceNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }
}

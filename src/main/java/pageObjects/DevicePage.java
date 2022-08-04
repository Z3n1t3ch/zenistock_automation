package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static utils.Constants.DEVICE_DESCRIPTION;
import static utils.Constants.DEVICE_DESCRIPTION_WS;
import static utils.Constants.DEVICE_INVENTORY_NO_WS;
import static utils.Constants.DEVICE_INVOICE_NO_WS;
import static utils.Constants.DEVICE_NAME_TOO_LONG;
import static utils.Constants.DEVICE_NAME_WS;
import static utils.Constants.DEVICE_NUMBER_OVER_30_CHAR;
import static utils.Constants.DEVICE_SERIAL_NO_WS;
import static utils.RandomGenerator.randomDateBefore;
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

    @FindBy(id = "assign_user")
    private WebElement assignUserButton;

    @FindBy(id = "assign_user-option-0")
    private WebElement firstUserInList;

    @FindBy(id = "assign_update")
    private WebElement assignUpdateButton;

    @FindBy(id = "device-information-endWarranty")
    private WebElement endWarrantyField;

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

    public void createDeviceWithoutName() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void createDeviceWithoutSerialNo() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void createDeviceWithoutInventoryNo() {
        signInAsAdmin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
    }

    public void createDeviceWithoutInvoiceNo() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        saveDeviceButton.click();
    }

    public void createDeviceWithWhiteSpacesNameField() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME_WS);
        serialNoField.sendKeys(deviceName + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceWithWhiteSpaceSerialNoField() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(DEVICE_SERIAL_NO_WS);
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
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

    public void createDeviceWithWhiteSpaceDescriptionField() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
        descriptionField.sendKeys(DEVICE_DESCRIPTION_WS);
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void createDeviceTooLongName() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(DEVICE_NAME_TOO_LONG);
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(inventoryNo + "");
        invoiceNoField.sendKeys(invoiceNo + "");
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

    public void createDeviceTooLongInventoryNo() {
        signInAsAdmin();
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
        addDeviceButton.click();
        nameField.sendKeys(deviceName + "");
        serialNoField.sendKeys(serialNo + "");
        inventoryNoField.sendKeys(DEVICE_NUMBER_OVER_30_CHAR);
        invoiceNoField.sendKeys(invoiceNo + "");
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("success_toaster")));

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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("success_toaster")));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }

    public void successfullyDeleteAssignedDevice() {
        successfullyAssignDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_delete_" + deviceName)));
        driver.findElement(By.id("device_delete_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("success_toaster")));
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

    public void createDeviceInvalidWarrantyEndDate() {
        signInAsAdmin();
        deviceName = randomName();
        serialNo = randomNumber();
        inventoryNo = randomNumber();
        invoiceNo = randomNumber();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("undefined-devices-mButton")));
        devicesButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_device_button")));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_toaster")));
    }

    public void successfullyEditADeviceSerialNo(){
        successfullyCreateDevice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_dropdown_" + deviceName)));
        driver.findElement(By.id("device_dropdown_" + deviceName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device_edit_" + deviceName)));
        driver.findElement(By.id("device_edit_" + deviceName)).click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/device-details"));
        serialNoField.clear();
        serialNoField.sendKeys(randomNumber()+ "");
        saveDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_toaster")));
    }

}

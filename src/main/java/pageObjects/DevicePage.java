package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
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
    WebElement endWarrantyField;

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
        openThreeDotsOptions(deviceDropdown,editDevice);
        nameField.clear();
        nameField.sendKeys(Constants.name);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        message = getTextFromElement(successToaster);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
        serialNoField.clear();
        serialNoField.sendKeys(Constants.number);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        message = successToaster.getText();
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
        openThreeDotsOptions(deviceDropdown,editDevice);
        inventoryNoField.clear();
        inventoryNoField.sendKeys(Constants.number);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        message = getTextFromElement(successToaster);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
        clearField(invoiceNoField);
        invoiceNoField.sendKeys(Constants.number);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        message = getTextFromElement(successToaster);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
        descriptionField.clear();
        descriptionField.sendKeys(randomName());
        saveDeviceButton.click();
        elementToLoad(successToaster);
    }

    public void createDeviceWithoutName() {
        signInAsAdmin();
        fillAllMandatoryFields(nameField);
        saveDeviceButton.click();
    }

    public void editDeviceWithoutName() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,editDevice);
        nameField.clear();
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithoutSerialNo() {
        signInAsAdmin();
        fillAllMandatoryFields(serialNoField);
        saveDeviceButton.click();
    }

    public void editDeviceWithoutSerialNo() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,editDevice);
        serialNoField.clear();
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithoutInventoryNo() {
        signInAsAdmin();
        fillAllMandatoryFields(inventoryNoField);
        saveDeviceButton.click();
    }

    public void editDeviceWithoutInventoryNo() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,editDevice);
        inventoryNoField.clear();
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void createDeviceWithoutInvoiceNo() {
        signInAsAdmin();
        fillAllMandatoryFields(invoiceNoField);
        saveDeviceButton.click();
    }

    public void editDeviceWithoutInvoiceNo() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
        invoiceNoField.clear();
        invoiceNoField.sendKeys((Constants.DEVICE_NUMBER_OVER_30_CHAR));
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    // The Invoice Date Field has a bug, this method will work after repair
    public void successfullyEditInvoiceDate() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,editDevice);
        clearField(invoiceDateField);
        invoiceDateField.sendKeys(Constants.INVOICE_DATE);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        message = getTextFromElement(successToaster);
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
        openThreeDotsOptions(deviceDropdown,editDevice);
        startDateWarrantyField.click();
        clearField(startDateWarrantyField);
        startDateWarrantyField.sendKeys(Constants.WARRANTY_START_DATE);
        endDateWarrantyField.click();
        clearField(endWarrantyField);
        endDateWarrantyField.sendKeys(Constants.WARRANTY_END_DATE);
        saveDeviceButton.click();
        elementToLoad(successToaster);
        message = getTextFromElement(successToaster);
        elementToDisappear(successToaster);
        openColumns(warrantyStartDateInColumns);
        openColumns(warrantyEndDateInColumns);
        elementToLoad(deviceTable);
    }

    public void editEndDateToBeEarlierThenStartDate() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,editDevice);
        endDateWarrantyField.click();
        endDateWarrantyField.sendKeys(Keys.CONTROL + "a");
        endDateWarrantyField.sendKeys(Keys.DELETE);
        endDateWarrantyField.sendKeys(Constants.WARRANTY_END_DATE_ERROR);
        saveDeviceButton.click();
        elementToLoad(errorToaster);
    }

    public void successfullyAssignDevice() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,assignDevice);
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
        openThreeDotsOptions(deviceDropdown,assignDevice);
        elementToLoad(assignUpdateButton);
        assignUpdateButton.click();
        elementToLoad(successToaster);
        elementToDisappear(successToaster);
    }

    public void assignDeviceWithoutUser() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,assignDevice);
        elementToLoad(assignUpdateButton);
        assignUpdateButton.click();
    }

    public void assignDeviceInactiveStatus() {
        signInAsAdmin();
        elementToLoad(devicesButton);
        devicesButton.click();
        elementToLoad(filterButton);
        filterByStatusInactive();
        openThreeDotsOptionsForInactive(deviceDropdown, assignDevice);
        elementToLoad(assignUserButton);
        assignUserButton.click();
        elementToLoad(firstUserInList);
        firstUserInList.click();
        elementToLoad(assignUpdateButton);
        assignUpdateButton.click();
    }

    public void deleteDevice() {
        successfullyCreateDevice();
        openThreeDotsOptions(deviceDropdown,assignDevice);
        elementToLoad(successToaster);
    }

    public void successfullyDeleteAssignedDevice() {
        successfullyAssignDevice();
        openThreeDotsOptions(deviceDropdown,deleteDevice);
        elementToLoad(successToaster);
        elementToDisappear(successToaster);
    }

    public void deleteInactiveDevice() {
        signInAsAdmin();
        elementToLoad(devicesButton);
        devicesButton.click();
        elementToLoad(filterButton);
        openThreeDotsOptionsForInactive(deviceDropdown, assignDevice);
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
        clearField(endWarrantyField);
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

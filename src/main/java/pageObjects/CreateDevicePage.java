package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static utils.Constants.*;


public class CreateDevicePage extends DriverFactory {
    public CreateDevicePage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);

    }

    @FindBy(id="username")
    private WebElement usernameField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="log-in-button")
    private WebElement loginButton;

    @FindBy(id="undefined-devices-mButton")
    private WebElement devicesButton;

    @FindBy(id="add_device_button")
    private WebElement addDeviceButton;

    @FindBy(id="device-information-name")
    private WebElement nameField;

    @FindBy(id="device-information-serialNo")
    private WebElement serialNoField;

    @FindBy(id="device-information-inventoryNo")
    private WebElement inventoryNoField;

    @FindBy(id="device-information-invoiceNo")
    private WebElement invoiceNoField;

    @FindBy(id="device-information-description")
    private WebElement descriptionField;

    @FindBy(id="device-tags-subcategory-selectList")
    private WebElement subcategoryList;

    @FindBy(id="tags")
    private WebElement tagsList;

    @FindBy(id="device-locations-selectList")
    private WebElement locationsList;

    @FindBy(id="device-saveBtn")
    private WebElement saveDeviceButton;

    @FindBy(id="device-tags-subcategory-selectList-laptop")
    private WebElement subcategoryLaptopListElement;

    @FindBy(id="item-device-tags-tags-0")
    private WebElement tagsListElement;

    @FindBy(id="device-locations-selectList-romania")
    private WebElement locationsRomaniaListElement;

    @FindBy(id="success_toaster")
    private WebElement successToaster;


    public String successfullyCreateDevice(){

        driver.get(LOGIN_PAGE_URL);
        usernameField.sendKeys(ADMIN_USERNAME);
        passwordField.sendKeys(ADMIN_PASSWORD);
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //redirected to dashboard

        devicesButton.click();
        //redirected to device page

        addDeviceButton.click();
        //redirected to add device page

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
        return successToaster.getText();

    }

}

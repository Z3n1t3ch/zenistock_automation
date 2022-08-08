package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;

public class Filter extends DriverFactory {
    public Filter(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "undefined-devices-mButton")
     WebElement deviceButton;
    @FindBy(id = "filter_device_button")
     WebElement filterButton;
    @FindBy(id = "device-filter-subcategory-autocomplete")
     WebElement subcategoryList;
    @FindBy(id = "device-filter-name")
    WebElement filterName;
    @FindBy(id = "device-filter-serialNo")
    WebElement filterSerialNo;
    @FindBy(id = "device-filter-inventoryNo")
    WebElement filterInventoryNo;
    @FindBy(id = "device-filter-asignee-autocomplete")
    WebElement filterAssignee;
    @FindBy(id = "device-filter-status-autocomplete")
    WebElement filterStatus;
    @FindBy(id = "device-filter-tags-autocomplete")
    WebElement filterTags;
    @FindBy(id = "device-filter-invoiceDate")
    WebElement filterInvoiceDate;
    @FindBy(id = "device-filter-apply-button")
     WebElement applyButton;
    @FindBy(id = "device-filter-subcategory-autocomplete-option-0")
     WebElement laptopOption;
    @FindBy(id = "device-filter-asignee-autocomplete-option-0")
     WebElement assignedToOption;
    @FindBy(id = "device-filter-status-autocomplete-option-0")
     WebElement filterStatusOption;
    @FindBy(id = "device-filter-tags-autocomplete-option-0")
     WebElement filterTagsOption;
    @FindBy(id = "device-filter-clearButton")
     WebElement clearAllButton;


    public  void filterBySubcategory() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(subcategoryList));
        subcategoryList.click();
        wait.until(ExpectedConditions.visibilityOf(laptopOption));
        laptopOption.click();
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public void filterByName() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterName));
        filterName.click();
        filterName.sendKeys("0");
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public void filterBySerialNo() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterSerialNo));
        filterSerialNo.click();
        filterSerialNo.sendKeys("356");
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public void filterByInventoryNo() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(deviceButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterInventoryNo));
        filterInventoryNo.click();
        filterInventoryNo.sendKeys("11");
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public void filterByAssignTo() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterAssignee));
        filterAssignee.click();
        wait.until(ExpectedConditions.visibilityOf(assignedToOption));
        assignedToOption.click();
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public void filterByStatus() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterStatus));
        filterStatus.click();
        wait.until(ExpectedConditions.visibilityOf(filterStatusOption));
        filterStatusOption.click();
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public void filterByTags() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        WebElement scroll = driver.findElement(By.id("device-filter-status-autocomplete"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        wait.until(ExpectedConditions.visibilityOf(filterTags));
       filterTags.click();
        wait.until(ExpectedConditions.visibilityOf(filterTagsOption));
        filterTagsOption.click();
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public  void filterBySubcategoryAndName() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(subcategoryList));
        subcategoryList.click();
        wait.until(ExpectedConditions.visibilityOf(laptopOption));
        laptopOption.click();
        wait.until(ExpectedConditions.visibilityOf(filterName));
        filterName.click();
        filterName.sendKeys("0");
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.DEVICES_URL));
    }
    public  void clearAllFilterFieldsButton() {
        signInAsSuperAdmin();
        deviceButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterName));
        filterName.click();
        filterName.sendKeys(Constants.NAME);
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(clearAllButton));
        clearAllButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
    }
}

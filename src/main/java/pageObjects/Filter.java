package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    public void filterBySubcategory() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(subcategoryList);
        subcategoryList.click();
        elementToLoad(laptopOption);
        laptopOption.click();
        elementToLoad(applyButton);
        applyButton.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void filterByName() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterName);
        filterName.sendKeys("0");
        elementToLoad(applyButton);
        applyButton.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void filterBySerialNo() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterSerialNo);
        filterSerialNo.sendKeys("356");
        elementToLoad(applyButton);
        applyButton.click();
        pageToLoad(Constants.DEVICES_URL);

    }

    public void filterByInventoryNo() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(deviceButton);
        filterButton.click();
        elementToLoad(filterInventoryNo);
        filterInventoryNo.sendKeys("11");
        elementToLoad(applyButton);
        applyButton.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void filterByAssignTo() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterAssignee);
        filterAssignee.click();
        elementToLoad(assignedToOption);
        assignedToOption.click();
        elementToLoad(applyButton);
        applyButton.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void filterByStatus() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterStatus);
        filterStatus.click();
        elementToLoad(filterStatusOption);
        filterStatusOption.click();
        elementToLoad(applyButton);
        applyButton.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void filterByTags() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        WebElement scroll = filterStatus;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        elementToLoad(filterTags);
        filterTags.click();
        elementToLoad(filterTagsOption);
        filterTagsOption.click();
        elementToLoad(applyButton);
        applyButton.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void filterBySubcategoryAndName() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(subcategoryList);
        subcategoryList.click();
        elementToLoad(laptopOption);
        laptopOption.click();
        elementToLoad(filterName);
        filterName.sendKeys("0");
        elementToLoad(applyButton);
        applyButton.click();
        pageToLoad(Constants.DEVICES_URL);
    }

    public void clearAllFilterFieldsButton() {
        signInAsSuperAdmin();
        deviceButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(filterName);
        filterName.sendKeys(Constants.NAME);
        elementToLoad(applyButton);
        applyButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        elementToLoad(clearAllButton);
        clearAllButton.click();
        elementToLoad(filterButton);
        filterButton.click();
    }
}

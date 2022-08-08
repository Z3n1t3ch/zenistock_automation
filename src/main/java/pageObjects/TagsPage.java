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


import static utils.RandomGenerator.randomName;
import static utils.RandomGenerator.randomNumber;

public class TagsPage extends DriverFactory {


    public TagsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "undefined-tags-mButton")
    private WebElement tagsButtonPage;

    @FindBy(id = "tags-addTag-field")
    private WebElement addTagField;

    @FindBy(id = "tags-addTag-add")
    private WebElement addTagButton;

    @FindBy(id = "success_toaster")
    private WebElement successToaster;

    @FindBy(id = "error_toaster")
    private WebElement errorToaster;

    @FindBy(id = "tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-editInput")
    private WebElement editField;

    @FindBy(id = "tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-edit")
    private WebElement editButton;

    @FindBy(id = "tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-save")
    private WebElement saveEditButton;

    @FindBy(id = "undefined-devices-mButton")
    private WebElement devicePageButton;

    @FindBy(id = "add_device_button")
    private WebElement addDeviceButton;

    @FindBy(id = "device-information-name")
    private WebElement deviceNameField;

    @FindBy(id = "device-information-serialNo")
    private WebElement deviceSerialNoField;

    @FindBy(id = "device-information-inventoryNo")
    private WebElement deviceInventoryNoField;

    @FindBy(id = "device-information-invoiceNo")
    private WebElement deviceInvoiceNoField;

    @FindBy(id = "tags")
    private WebElement tagsField;

    @FindBy(id = "tags-option-0")
    private WebElement firstTagElement;

    @FindBy(id = "device-saveBtn")
    private WebElement deviceSaveButton;

    @FindBy(id = "filter_device_button")
    private WebElement filterButton;

    @FindBy(id = "device-filter-tags-autocomplete")
    private WebElement tagsFilterField;

    @FindBy(id = "device-filter-tags-autocomplete-option-0")
    private WebElement editedTagsOption;

    @FindBy(id = "device-filter-apply-button")
    private WebElement filterApplyButton;

    public void successfullyCreateTag(String name) {
        signInAsAdmin();
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOf(addTagField));
        addTagField.sendKeys(name);
        addTagButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
    }

    public void createTagWithWhitespaces() {
        signInAsAdmin();
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOf(addTagField));
        addTagField.sendKeys(Constants.DEVICE_NAME_WS);
        addTagButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }

    public void createTagWithEmptyField() {
        signInAsAdmin();
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOf(addTagField));
        addTagButton.click();
    }

    public void successfullyDeleteTag(String name) {
        signInAsAdmin();
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOf(addTagField));
        addTagField.sendKeys(name);
        addTagButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tags-list-tag-" + name + "-item-delete")));
        driver.findElement(By.id("tags-list-tag-" + name + "-item-delete")).click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
    }

    public void successfullyEditTag(String nameAfterEdit) {
        signInAsAdmin();
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOf(addTagField));
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        editButton.click();
        editField.sendKeys(Keys.CONTROL + "a");
        editField.sendKeys(Keys.DELETE);
        editField.sendKeys(nameAfterEdit);
        saveEditButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
    }

    public void checkDeviceWithEditedTag(String nameTagAfterEdit) {
        signInAsAdmin();
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOf(addTagField));
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        devicePageButton.click();
        wait.until(ExpectedConditions.visibilityOf(addDeviceButton));
        addDeviceButton.click();
        deviceNameField.sendKeys(randomName());
        deviceSerialNoField.sendKeys(randomNumber() + "");
        deviceInventoryNoField.sendKeys(randomNumber() + "");
        deviceInvoiceNoField.sendKeys(randomNumber() + "");
        tagsField.sendKeys(Constants.EDITABLE_TAG_NAME);
        firstTagElement.click();
        deviceSaveButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOf(editButton));
        editButton.click();
        editField.sendKeys(Keys.CONTROL + "a");
        editField.sendKeys(Keys.DELETE);
        editField.sendKeys(nameTagAfterEdit);
        saveEditButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        devicePageButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        tagsFilterField.sendKeys(nameTagAfterEdit);
        editedTagsOption.click();
        wait.until(ExpectedConditions.visibilityOf(filterApplyButton));
        filterApplyButton.click();
    }

    public void checkDeviceWithDeletedTag() {
        signInAsAdmin();
        String serialNo = randomNumber() + "";
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOf(addTagField));
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        devicePageButton.click();
        wait.until(ExpectedConditions.visibilityOf(addDeviceButton));
        addDeviceButton.click();
        deviceNameField.sendKeys(randomName());
        deviceSerialNoField.sendKeys(serialNo + "");
        deviceInventoryNoField.sendKeys(randomNumber() + "");
        deviceInvoiceNoField.sendKeys(randomNumber() + "");
        tagsField.sendKeys(Constants.EDITABLE_TAG_NAME);
        firstTagElement.click();
        deviceSaveButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        tagsButtonPage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-delete")));
        driver.findElement(By.id("tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-delete")).click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        devicePageButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
        tagsFilterField.sendKeys(serialNo + "");
        wait.until(ExpectedConditions.visibilityOf(filterApplyButton));
        filterApplyButton.click();
    }
}

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
        devicePage = new DevicePage(driver);
        filter = new Filter(driver);
        permissions = new Permissions(driver);
    }

    private DevicePage devicePage;
    private Filter filter;
    private Permissions permissions;

    @FindBy(id = "tags-addTag-field")
    private WebElement addTagField;

    @FindBy(id = "tags-addTag-add")
    private WebElement addTagButton;

    @FindBy(id = "tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-editInput")
    private WebElement editField;

    @FindBy(id = "tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-edit")
    private WebElement editButton;

    @FindBy(id = "tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-save")
    private WebElement saveEditButton;

    public void successfullyCreateTag(String name) {
        signInAsAdmin();
        permissions.tagsButtonSidebarMenu.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(name);
        addTagButton.click();
        elementToLoad(devicePage.successToaster);
    }

    public void createTagWithWhitespaces() {
        signInAsAdmin();
        permissions.tagsButtonSidebarMenu.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(Constants.DEVICE_NAME_WS);
        addTagButton.click();
        elementToLoad(devicePage.errorToaster);
    }

    public void createTagWithEmptyField() {
        signInAsAdmin();
        permissions.tagsButtonSidebarMenu.click();
        elementToLoad(addTagField);
        addTagButton.click();
    }

    public void successfullyDeleteTag(String name) {
        signInAsAdmin();
        permissions.tagsButtonSidebarMenu.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(name);
        addTagButton.click();
        elementToLoad(devicePage.successToaster);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tags-list-tag-" + name + "-item-delete")));
        driver.findElement(By.id("tags-list-tag-" + name + "-item-delete")).click();
        elementToLoad(devicePage.successToaster);
    }

    public void successfullyEditTag(String nameAfterEdit) {
        signInAsAdmin();
        permissions.tagsButtonSidebarMenu.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        wait.until(ExpectedConditions.visibilityOf(devicePage.successToaster));
        editButton.click();
        editField.sendKeys(Keys.CONTROL + "a");
        editField.sendKeys(Keys.DELETE);
        editField.sendKeys(nameAfterEdit);
        saveEditButton.click();
        elementToLoad(devicePage.successToaster);
    }

    public void checkDeviceWithEditedTag(String nameTagAfterEdit) {
        signInAsAdmin();
        permissions.tagsButtonSidebarMenu.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        elementToLoad(devicePage.successToaster);
        devicePage.devicesButton.click();
        elementToLoad(devicePage.addDeviceButton);
        devicePage.addDeviceButton.click();
        devicePage.nameField.sendKeys(randomName());
        devicePage.serialNoField.sendKeys(randomNumber() + "");
        devicePage.inventoryNoField.sendKeys(randomNumber() + "");
        devicePage.invoiceNoField.sendKeys(randomNumber() + "");
        devicePage.tagsList.sendKeys(Constants.EDITABLE_TAG_NAME);
        devicePage.tagsListElement.click();
        devicePage.saveDeviceButton.click();
        elementToLoad(devicePage.successToaster);
        permissions.tagsButtonSidebarMenu.click();
        elementToLoad(editButton);
        editButton.click();
        editField.sendKeys(Keys.CONTROL + "a");
        editField.sendKeys(Keys.DELETE);
        editField.sendKeys(nameTagAfterEdit);
        saveEditButton.click();
        elementToLoad(devicePage.successToaster);
        devicePage.devicesButton.click();
        elementToLoad(devicePage.filterButton);
        devicePage.filterButton.click();
        filter.filterTags.sendKeys(nameTagAfterEdit);
        filter.filterTagsOption.click();
        elementToLoad(filter.applyButton);
        filter.applyButton.click();
    }

    public void checkDeviceWithDeletedTag() {
        signInAsAdmin();
        String serialNo = randomNumber() + "";
        permissions.tagsButtonSidebarMenu.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        elementToLoad(devicePage.successToaster);
        devicePage.devicesButton.click();
        elementToLoad(devicePage.addDeviceButton);
        devicePage.addDeviceButton.click();
        devicePage.nameField.sendKeys(randomName());
        devicePage.serialNoField.sendKeys(serialNo + "");
        devicePage.inventoryNoField.sendKeys(randomNumber() + "");
        devicePage.invoiceNoField.sendKeys(randomNumber() + "");
        devicePage.tagsList.sendKeys(Constants.EDITABLE_TAG_NAME);
        devicePage.tagsListElement.click();
        devicePage.saveDeviceButton.click();
        elementToLoad(devicePage.successToaster);
        permissions.tagsButtonSidebarMenu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-delete")));
        driver.findElement(By.id("tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-delete")).click();
        elementToLoad(devicePage.successToaster);
        devicePage.devicesButton.click();
        elementToLoad(devicePage.filterButton);
        devicePage.filterButton.click();
        filter.filterTags.sendKeys(serialNo + "");
        elementToLoad(filter.applyButton);
        filter.applyButton.click();
    }
}

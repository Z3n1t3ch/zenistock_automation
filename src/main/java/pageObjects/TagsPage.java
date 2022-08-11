package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;


import static utils.RandomGenerator.randomNumber;

public class TagsPage extends DriverFactory {


    public TagsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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

    @FindBy(id = "success_toaster")
    private WebElement successToaster;

    @FindBy(id = "error_toaster")
    private WebElement errorToaster;

    @FindBy(id = "undefined-devices-mButton")
    private WebElement devicePageButton;

    @FindBy(id = "filter_device_button")
    private WebElement filterButton;

    @FindBy(id = "device-filter-tags-autocomplete")
    private WebElement tagsFilterField;

    @FindBy(id = "device-filter-tags-autocomplete-option-0")
    private WebElement editedTagsOption;

    @FindBy(id = "device-filter-apply-button")
    private WebElement filterApplyButton;

    @FindBy(id = "undefined-tags-mButton")
    private WebElement tagsButtonPage;

    @FindBy(id = "device-table-row-0")
    private WebElement firstTableRow;

    public static String elementText;

    public void successfullyCreateTag(String name) {
        signInAsAdmin();
        tagsButtonPage.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(name);
        addTagButton.click();
        elementToLoad(successToaster);
        elementText = getTextFromElement(successToaster);
    }

    public void createTagWithWhitespaces() {
        signInAsAdmin();
        tagsButtonPage.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(Constants.DEVICE_NAME_WS);
        addTagButton.click();
        elementToLoad(errorToaster);
        elementText = getTextFromElement(errorToaster);
    }

    public void createTagWithEmptyField() {
        signInAsAdmin();
        tagsButtonPage.click();
        elementToLoad(addTagField);
        addTagButton.click();
    }

    public void successfullyDeleteTag(String name) {
        signInAsAdmin();
        tagsButtonPage.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(name);
        addTagButton.click();
        elementToLoad(successToaster);
        deleteTag("tags-list-tag-" + name + "-item-delete");
        elementToLoad(successToaster);
        elementText = getTextFromElement(successToaster);
    }

    public void successfullyEditTag(String nameAfterEdit) {
        signInAsAdmin();
        tagsButtonPage.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        elementToLoad(successToaster);
        editButton.click();
        clearField(editField);
        editField.sendKeys(nameAfterEdit);
        saveEditButton.click();
        elementToLoad(successToaster);
        elementText = getTextFromElement(successToaster);
    }

    public void checkDeviceWithEditedTag(String nameTagAfterEdit) {
        signInAsAdmin();
        tagsButtonPage.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        elementToLoad(successToaster);
        createDeviceForTagPage();
        elementToLoad(successToaster);
        tagsButtonPage.click();
        elementToLoad(editButton);
        editButton.click();
        clearField(editField);
        editField.sendKeys(nameTagAfterEdit);
        saveEditButton.click();
        elementToLoad(successToaster);
        devicePageButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        tagsFilterField.sendKeys(nameTagAfterEdit);
        editedTagsOption.click();
        elementToLoad(filterApplyButton);
        filterApplyButton.click();
        elementToLoad(firstTableRow);
        elementText = getTextFromElement(firstTableRow);
    }

    public void checkDeviceWithDeletedTag() {
        signInAsAdmin();
        tagsButtonPage.click();
        elementToLoad(addTagField);
        addTagField.sendKeys(Constants.EDITABLE_TAG_NAME);
        addTagButton.click();
        elementToLoad(successToaster);
        createDeviceForTagPage();
        elementToLoad(successToaster);
        tagsButtonPage.click();
        deleteTag("tags-list-tag-" + Constants.EDITABLE_TAG_NAME + "-item-delete");
        elementToLoad(successToaster);
        devicePageButton.click();
        elementToLoad(filterButton);
        filterButton.click();
        tagsFilterField.sendKeys(Constants.number);
        elementToLoad(filterApplyButton);
        filterApplyButton.click();
        elementToLoad(firstTableRow);
        elementText = getTextFromElement(firstTableRow);
    }
}
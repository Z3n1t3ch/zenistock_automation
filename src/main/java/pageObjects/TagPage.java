package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TagPage extends DriverFactory {

    @FindBy(id = "tags-addTag-field")
    private WebElement tagNameField;
    @FindBy(id = "tags-addTag-add")
    private WebElement addTagButton;

    public TagPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void AddTag(String tagName) {
        waitForElementToBeDisplayed(tagNameField);
        tagNameField.sendKeys(tagName);
        addTagButton.click();
    }

    public void deleteTag(String tagName){
        WebElement button = driver.findElement(new By.ById("tags-list-tag-" + tagName + "-item-delete"));
        button.click();
    }

    public void editTag(String oldName, String newName, boolean editMode) {
        if (editMode) {
            WebElement button = driver.findElement(new By.ById("tags-list-tag-" + oldName + "-item-edit"));
            button.click();
        }

        WebElement editBox = driver.findElement(new By.ById("tags-list-tag-" + oldName + "-item-editInput"));
        waitForElementToBeClickable(editBox);
        editBox.click();
        editBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), newName);
        WebElement saveButton = driver.findElement(new By.ById("tags-list-tag-" + oldName + "-item-save"));
        saveButton.click();
    }
    public void editTag(String oldName, String newName) {
        editTag(oldName, newName, true);
    }


    public WebElement getTag(String tagName) {
        return driver.findElement(new By.ById("tags-list-tag-" + tagName + "-item"));
    }

}

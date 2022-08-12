package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;


import static pageObjects.TagsPage.elementText;
import static utils.RandomGenerator.randomName;

public class TagsPageTests extends BaseTest {

    @Test
    public void successfullyCreateTag() {
        String name = randomName();
        tagsPage.successfullyCreateTag(name);
        Assert.assertTrue(elementText.contains("Tag created successfully!"));
        Assert.assertTrue(driver.getPageSource().contains(name));
    }

    @Test
    public void createTagWithWhitespaces() {
        tagsPage.createTagWithWhitespaces();
        Assert.assertTrue(elementText.contains("The field \"name\" contains only whitespaces."));
    }

    @Test
    public void createTagWithEmptyNameField() {
        tagsPage.createTagWithEmptyField();
        Assert.assertTrue(driver.getPageSource().contains("required"));
    }

    @Test
    public void successfullyDeleteTag() {
        String name = randomName();
        tagsPage.successfullyDeleteTag(name);
        Assert.assertTrue(elementText.contains("Tag deleted successfully!"));
        Assert.assertFalse(driver.getPageSource().contains(name));
    }

    @Test
    public void successfullyEditTag() {
        String nameAfterEdit = randomName();
        tagsPage.successfullyEditTag(nameAfterEdit);
        Assert.assertTrue(elementText.contains("Tag updated successfully!"));
        Assert.assertTrue(driver.getPageSource().contains(nameAfterEdit));
    }

    @Test
    public void checkDeviceWithEditedTag() {
        String nameTagAfterEdit = randomName();
        tagsPage.checkDeviceWithEditedTag(nameTagAfterEdit);
        Assert.assertNotNull(driver.findElement(By.id("device-table-row-0")));
    }

    @Test
    public void checkDeviceWithDeletedTag() {
        tagsPage.checkDeviceWithDeletedTag();
        Assert.assertFalse(elementText.contains(Constants.EDITABLE_TAG_NAME));
    }
}

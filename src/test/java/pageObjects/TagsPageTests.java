package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import static utils.RandomGenerator.randomName;

public class TagsPageTests extends BaseTest {

    @Test
    public void successfullyCreateTag() {
        String name = randomName();
        tagsPage.successfullyCreateTag(name);
        String toaster = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertTrue(toaster.contains("Tag created successfully!"));
        Assert.assertTrue(driver.getPageSource().contains(name));
    }

    @Test
    public void createTagWithWhitespaces() {
        tagsPage.createTagWithWhitespaces();
        String toaster = driver.findElement(By.id("error_toaster")).getText();
        Assert.assertTrue(toaster.contains("The field \"name\" contains only whitespaces."));
    }

    @Test
    public void createTagWithEmptyNameField() {
        tagsPage.createTagWithEmptyField();
        boolean requiredNameField = Boolean.parseBoolean(driver.findElement(By.id("tags-addTag-field")).getAttribute("required"));
        Assert.assertTrue(requiredNameField);
    }

    @Test
    public void successfullyDeleteTag() {
        String name = randomName();
        tagsPage.successfullyDeleteTag(name);
        String toaster = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertTrue(toaster.contains("Tag deleted successfully!"));
        Assert.assertFalse(driver.getPageSource().contains(name));
    }

    @Test
    public void successfullyEditTag() {
        String nameAfterEdit = randomName();
        tagsPage.successfullyEditTag(nameAfterEdit);
        String toaster = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertTrue(toaster.contains("Tag updated successfully!"));
        Assert.assertTrue(driver.getPageSource().contains(nameAfterEdit));
    }

    @Test
    public void checkDeviceWithEditedTag() {
        String nameTagAfterEdit = randomName();
        tagsPage.checkDeviceWithEditedTag(nameTagAfterEdit);
        Assert.assertNotNull(driver.findElement(By.id("device-table-row-0")));
    }
}

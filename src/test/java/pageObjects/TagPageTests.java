package pageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.Random;

public class TagPageTests extends BaseTest {

    private String addNewTag(String newTagName) {
        if (Objects.equals(newTagName, "")) {
            Random rand = new Random();
            newTagName = "tag-test-" + rand.nextInt();
        }

        tagPage.AddTag(newTagName);
        return newTagName;
    }

    @Test
    public void successfullyCreateTag() {
        loginPage.signIn();
        dashboardPage.goToTags();

        String newTagName = this.addNewTag("");

        WebElement successToaster = toaster.getSuccessToaster();
        Assert.assertEquals(successToaster.getText(), "Tag created successfully!");

        Assert.assertNotNull(tagPage.getTag(newTagName));

    }

    @Test
    public void duplicateTagName() {
        loginPage.signIn();
        dashboardPage.goToTags();

        String previousTagName = this.addNewTag("");
        toaster.getSuccessToaster(); // this waits for the success toaster to show

        this.addNewTag(previousTagName);

        WebElement errorToaster = toaster.getErrorToaster();
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" already exist.");
    }

}

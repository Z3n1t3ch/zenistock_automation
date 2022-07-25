package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.util.HashMap;
import java.util.Map;
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

        // cleanup
        tagPage.deleteTag(newTagName);
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

        // cleanup
        tagPage.deleteTag(previousTagName);
    }
    @Test
    public void successfullyDeleteTag() {
        loginPage.signIn();
        dashboardPage.goToTags();

        String newTagName = this.addNewTag("");
        toaster.getSuccessToaster(); // this waits for the success toaster to show

        tagPage.deleteTag(newTagName);
        WebElement successToaster = toaster.getSuccessToaster();
        Assert.assertEquals(successToaster.getText(), "Tag deleted successfully!");
    }
    @Test
    public void successfullyEditTag(){
        loginPage.signIn();
        dashboardPage.goToTags();

        String oldTagName = this.addNewTag("");
        toaster.getSuccessToaster(); // this waits for the success toaster to show

        String newTagName = oldTagName + "_";
        tagPage.editTag(oldTagName, newTagName);
        WebElement successToaster = toaster.getSuccessToaster();
        Assert.assertEquals(successToaster.getText(), "Tag updated successfully!");

        // cleanup
        tagPage.deleteTag(oldTagName);
    }

    @Test
    public void errorEditTag() {
        loginPage.signIn();
        dashboardPage.goToTags();

        String newTagName = this.addNewTag("");
        toaster.getSuccessToaster(); // this waits for the success toaster to show

        Map<String, String> cases = new HashMap<>();

        cases.put(newTagName, "Unknown Error");
        cases.put(" ", "The field \"name\" contains only whitespaces.");
        cases.put(Strings.repeat("a", 50), "The field \"name\" is too long.");
        cases.put(Keys.chord(Keys.BACK_SPACE), "The \"name\" is invalid.");

        boolean editMode = true;

        for (String key : cases.keySet()) {
            tagPage.editTag(newTagName, key, editMode);

            WebElement errorToaster = toaster.getErrorToaster();
            Assert.assertEquals(errorToaster.getText(), cases.get(key));

            editMode = false;
        }

        // cleanup
        tagPage.deleteTag(newTagName);
    }
}

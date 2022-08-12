package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;

import static pageObjects.Filter.elementText;

public class FilterTest extends BaseTest {
    @Test
    public void filterBySubcategory() {
        filter.filterBySubcategory();
        Assert.assertTrue(elementText.contains("LAPTOP"));
    }

    @Test
    public void filterByName() {
        filter.filterByName();
        Assert.assertTrue(elementText.contains("0"));
    }

    @Test
    public void filterBySerialNo() {
        filter.filterBySerialNo();
        Assert.assertTrue(elementText.contains("356"));
    }

    @Test
    public void filterByInventoryNo() {
        filter.filterByInventoryNo();
        Assert.assertTrue(elementText.contains("11"));
    }

    @Test
    public void filterByAssignTo() {
        filter.filterByAssignTo();
        Assert.assertTrue(elementText.contains("Dovydas Adamonis"));
    }

    @Test
    public void filterByStatus() {
        filter.filterByStatus();
        Assert.assertTrue(elementText.contains("Assigned"));
    }

    @Test
    public void filterByTags() {
        filter.filterByTags();
        Assert.assertTrue(elementText.contains("pls_dnt_dell_test"));
    }

    @Test
    public void filterBySubcategoryAndName() {
        filter.filterBySubcategoryAndName();
        Assert.assertTrue(elementText.contains("LAPTOP"));
        Assert.assertTrue(elementText.contains("0"));
    }

    @Test
    public void clearAllFilterFieldsButton() {
        filter.clearAllFilterFieldsButton();
        Assert.assertFalse(elementText.contains(Constants.NAME));
    }
}

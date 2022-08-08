package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;

public class FilterTest extends BaseTest {
    @Test
    public void filterBySubcategory() {
        filter.filterBySubcategory();
        String table = driver.findElement(By.id("device-table")).getText();
        Assert.assertTrue(table.contains("LAPTOP"));
    }
    @Test
    public void filterByName() {
        filter.filterByName();
        String table = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(table.contains("0"));
    }
    @Test
    public void filterBySerialNo() {
        filter.filterBySerialNo();
        String table = driver.findElement(By.id("device-table")).getText();
        Assert.assertTrue(table.contains("356"));
    }
    @Test
    public void filterByInventoryNo() {
        filter.filterByInventoryNo();
        String table = driver.findElement(By.id("device-table")).getText();
        Assert.assertTrue(table.contains("11"));
    }
    @Test
    public void filterByAssignTo() {
        filter.filterByAssignTo();
        String table = driver.findElement(By.id("device-table")).getText();
        Assert.assertTrue(table.contains("Dovydas Adamonis"));
    }
    @Test
    public void filterByStatus() {
        filter.filterByStatus();
        String table = driver.findElement(By.id("device-table")).getText();
        Assert.assertTrue(table.contains("Assigned"));
    }
    @Test
    public void filterByTags() {
        filter.filterByTags();
        String table = driver.findElement(By.id("device-table")).getText();
        Assert.assertTrue(table.contains("pls_dnt_dell_test"));
    }
    @Test
    public void filterBySubcategoryAndName() {
        filter.filterBySubcategoryAndName();
        String table = driver.findElement(By.id("device-table")).getText();
        Assert.assertTrue(table.contains("LAPTOP"));
        Assert.assertTrue(table.contains("0"));
    }
    @Test
    public void clearAllFilterFieldsButton() {
        filter.clearAllFilterFieldsButton();
        String verifyFields = driver.findElement(By.id("device-filter-name")).getText();
        Assert.assertFalse(verifyFields.contains(Constants.NAME));
    }
}

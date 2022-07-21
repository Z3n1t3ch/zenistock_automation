package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PermissionTests extends BaseTest {

    @Test
    public void PermissionUser() throws InterruptedException {
        //User
        Permissions.checkIfUserCanPerformActionOnDevicePage();
        String URL = driver.getCurrentUrl();
//        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
//        Assert.assertFalse(AddDeviceButton);
//
//        boolean ExportButton = driver.getPageSource().contains("Export");
//        Assert.assertFalse(ExportButton);
//
//        boolean ImportButton = driver.getPageSource().contains("Import");
//        Assert.assertFalse(ImportButton);





    }
    @Test
    //Admin
        public void PermissionAdmin() throws InterruptedException {
        Permissions.checkIfAdminCanPerformActionOnDevicePage();
        String URL = driver.getCurrentUrl();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);

        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);

        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);

        WebElement Actions = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[9]/div/div/button/svg"));

        }

    @Test
    public void PermissionSuperAdmin() throws InterruptedException {
        Permissions.checkIfSuperAdminCanPerformActionOnDevicePage();
        String URL = driver.getCurrentUrl();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);

        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);

        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);

        boolean Actions = driver.getPageSource().contains("/html/body/div[1]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[9]/div/div/button/svg");
        Assert.assertTrue(Actions);


    }

}

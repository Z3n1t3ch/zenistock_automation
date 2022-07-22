package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PermissionTests extends BaseTest {
    @Test
    public void checkIfUserCanAddDevice() throws InterruptedException {
        Permissions.checkIfUserCanPerformActionOnDevicePage();
        boolean addDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertFalse(addDeviceButton);
    }

    @Test
    public void checkIfUserCanExport() throws InterruptedException {
        Permissions.checkIfUserCanPerformActionOnDevicePage();
        boolean exportButton = driver.getPageSource().contains("Export");
        Assert.assertFalse(exportButton);
    }

    @Test
    public void checkIfUserCanImport() throws InterruptedException {
        Permissions.checkIfUserCanPerformActionOnDevicePage();
        boolean importButton = driver.getPageSource().contains("Import");
        Assert.assertFalse(importButton);
    }

    @Test
    public void checkIfUserCanPerformActionsOnDevice() throws InterruptedException {
        Permissions.checkIfUserCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfAdminCanAddDevice() throws InterruptedException {
        Permissions.checkIfAdminCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);
    }

    @Test
    public void checkIfAdminCanExport() throws InterruptedException {
        Permissions.checkIfAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    //Admin
    public void checkIfAdminCanImport() throws InterruptedException {
        Permissions.checkIfAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    //Admin
    public void checkIfAdminCanPerformActionsOnDevice() throws InterruptedException {
        Permissions.checkIfAdminCanPerformActionOnDevicePage();
        boolean ThreeDotsButton = driver.findElement(By.id("device_dropdown_123weq")).isDisplayed();
        Assert.assertTrue(ThreeDotsButton);
    }

    @Test
    public void checkIfSuperAdminCanAddDevice() throws InterruptedException {
        Permissions.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);
    }

    @Test
    public void checkIfSuperAdminCanExport() throws InterruptedException {
        Permissions.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    //Admin
    public void checkIfSuperAdminCanImport() throws InterruptedException {
        Permissions.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    //Admin
    public void checkIfSuperAdminCanPerformActionsOnDevice() throws InterruptedException {
        Permissions.checkIfAdminCanPerformActionOnDevicePage();
        boolean ThreeDotsButton = driver.findElement(By.id("device_dropdown_123weq")).isDisplayed();
        Assert.assertTrue(ThreeDotsButton);

    }
}


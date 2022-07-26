package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PermissionsTest extends BaseTest {
    @Test
    public void checkIfUserCanAddDevice() {
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        boolean addDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertFalse(addDeviceButton);
    }

    @Test
    public void checkIfUserCanExport() {
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        boolean exportButton = driver.getPageSource().contains("Export");
        Assert.assertFalse(exportButton);
    }

    @Test
    public void checkIfUserCanImport() {
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        boolean importButton = driver.getPageSource().contains("Import");
        Assert.assertFalse(importButton);
    }

    @Test
    public void checkIfUserCanPerformActionsOnDevice() {
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfUserCanFilter() {
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfAdminCanAddDevice() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);
    }

    @Test
    public void checkIfAdminCanExport() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    public void checkIfAdminCanImport() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnDevice() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfAdminCanFilter() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }


    @Test
    public void checkIfSuperAdminCanAddDevice() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);
    }

    @Test
    public void checkIfSuperAdminCanExport() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    public void checkIfSuperAdminCanImport() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnDevice() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfSuperAdminCanFilter() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfUserCanAddAsset() {
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        boolean addAssetButton = driver.getPageSource().contains("Add asset");
        Assert.assertFalse(addAssetButton);
    }

    @Test
    public void checkIfUserCanExportOnAssetsPage() {
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        boolean exportButton = driver.getPageSource().contains("Export");
        Assert.assertFalse(exportButton);
    }

    @Test
    public void checkIfUserCanImportOnAssetsPage() {
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        boolean importButton = driver.getPageSource().contains("Import");
        Assert.assertFalse(importButton);
    }

    @Test
    public void checkIfUserCanPerformActionsOnAssets() {
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'asset_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfUserCanFilterOnAssetsPage() {
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfAdminCanAddAsset() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean AddAssetsButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddAssetsButton);
    }

    @Test
    public void checkIfAdminCanExportOnAssetsPage() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    public void checkIfAdminCanImportOnAssetsPage() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnAssets() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'assert_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfAdminCanFilterOnAssetsPage() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfSuperAdminCanAddAsset() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean AddAssetsButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddAssetsButton);
    }

    @Test
    public void checkIfSuperAdminCanExportOnAssetsPage() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    public void checkIfSuperAdminCanImportOnAssetsPage() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnAssets() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'assert_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfSuperAdminCanFilterOnAssetsPage() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfUserCanFilterOnEmployeesPage() {
        permissionForAllRoles.checkIfUserCanPerformActionOnEmployeesPage();
        driver.findElement(By.id("filter-button"));
    }

    @Test
    public void checkIfUserCanPerformActionsOnEmployeesPage() {
        permissionForAllRoles.checkIfUserCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfAdminCanFilterOnEmployeesPage() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnEmployeesPage() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfSuperAdminCanFilterOnEmployeesPage() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnEmployeesPage() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void checkIfUserCanFilterOnLicensesPage() {
        permissionForAllRoles.checkIfUserCanPerformActionOnLicensesPage();
        driver.findElement(By.id("filter-button"));
    }

    @Test
    public void checkIfUserCanPerformActionsOnLicensesPage() {
        permissionForAllRoles.checkIfUserCanPerformActionOnLicensesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfAdminCanFilterOnLicensesPage() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnLicensesPage() {
        permissionForAllRoles.checkIfAdminCanPerformActionOnLicensesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfSuperAdminCanFilterOnLicensesPage() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnLicensesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnLicensesPage() {
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }
}

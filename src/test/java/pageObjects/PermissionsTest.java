package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PermissionsTest extends BaseTest {
    @Test
    public void checkIfUserCanAddDevice() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        boolean addDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertFalse(addDeviceButton);
    }
    @Test
    public void checkIfUserCanExport() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        boolean exportButton = driver.getPageSource().contains("Export");
        Assert.assertFalse(exportButton);
    }
    @Test
    public void checkIfUserCanImport() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        boolean importButton = driver.getPageSource().contains("Import");
        Assert.assertFalse(importButton);
    }
    @Test
    public void checkIfUserCanPerformActionsOnDevice() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void checkIfUserCanFilter() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(true);
    }
    @Test
    public void checkIfAdminCanAddDevice() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);
    }
    @Test
    public void checkIfAdminCanExport() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }
    @Test
    public void checkIfAdminCanImport() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }
    @Test
    public void checkIfAdminCanPerformActionsOnDevice() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
    @Test
    public void checkIfAdminCanFilter() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }
    @Test
    public void checkIfSuperAdminCanAddDevice() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);
    }
    @Test
    public void checkIfSuperAdminCanExport() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }
    @Test
    public void checkIfSuperAdminCanImport() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }
    @Test
    public void checkIfSuperAdminCanPerformActionsOnDevice() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
    @Test
    public void checkIfSuperAdminCanFilter() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }
    @Test
    public void checkIfUserCanAddAsset() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        boolean addAssetButton = driver.getPageSource().contains("Add asset");
        Assert.assertFalse(addAssetButton);
    }
    @Test
    public void checkIfUserCanExportOnAssetsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        boolean exportButton = driver.getPageSource().contains("Export");
        Assert.assertFalse(exportButton);
    }
    @Test
    public void checkIfUserCanImportOnAssetsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        boolean importButton = driver.getPageSource().contains("Import");
        Assert.assertFalse(importButton);
    }
    @Test
    public void checkIfUserCanPerformActionsOnAssets() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'asset_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void checkIfUserCanFilterOnAssetsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }
    @Test
    public void checkIfAdminCanAddAsset() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean AddAssetsButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddAssetsButton);
    }
    @Test
    public void checkIfAdminCanExportOnAssetsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }
    @Test
    public void checkIfAdminCanImportOnAssetsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }
    @Test
    public void checkIfAdminCanPerformActionsOnAssets() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnAssetsPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'asset_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
    @Test
    public void checkIfAdminCanFilterOnAssetsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }
    @Test
    public void checkIfSuperAdminCanAddAsset() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean AddAssetsButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddAssetsButton);
    }
    @Test
    public void checkIfSuperAdminCanExportOnAssetsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }
    @Test
    public void checkIfSuperAdminCanImportOnAssetsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }
    @Test
    public void checkIfSuperAdminCanPerformActionsOnAssets() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'assert_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
    @Test
    public void checkIfSuperAdminCanFilterOnAssetsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }
    @Test
    public void checkIfUserCanFilterOnEmployeesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnEmployeesPage();
        driver.findElement(By.id("filter-button"));
    }
    @Test
    public void checkIfUserCanPerformActionsOnEmployeesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void checkIfAdminCanFilterOnEmployeesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnEmployeesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//*[contains(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void checkIfSuperAdminCanFilterOnEmployeesPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnEmployeesPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//*[contains(@id,'user_edit_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
    @Test
    public void checkIfUserCanFilterOnLicensesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnLicensesPage();
        driver.findElement(By.id("filter-button"));
    }
    @Test
    public void checkIfUserCanPerformActionsOnLicensesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUserCanPerformActionOnLicensesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'license_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void checkIfAdminCanFilterOnLicensesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }
    @Test
    public void checkIfAdminCanPerformActionsOnLicensesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfAdminCanPerformActionOnLicensesPage();
        boolean addLicenseButton = driver.getPageSource().contains("Add license");
        Assert.assertTrue(addLicenseButton);
        if (driver.findElements(By.xpath("//button[starts-with(@id,'license_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
    @Test
    public void checkIfSuperAdminCanFilterOnLicensesPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnLicensesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }
    @Test
    public void checkIfSuperAdminCanPerformActionsOnLicensesPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfSuperAdminCanPerformActionOnEmployeesPage();
        boolean addLicenseButton = driver.getPageSource().contains("Add license");
        Assert.assertTrue(addLicenseButton);
        if (driver.findElements(By.xpath("//button[starts-with(@id,'license_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
}

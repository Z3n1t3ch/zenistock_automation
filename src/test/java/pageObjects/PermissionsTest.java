package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PermissionsTest extends BaseTest {
    @Test
    public void checkIfUserCanAddDevice() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean addDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertFalse(addDeviceButton);
    }

    @Test
    public void checkIfUserCanExport() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean exportButton = driver.getPageSource().contains("Export");
        Assert.assertFalse(exportButton);
    }

    @Test
    public void checkIfUserCanImport() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean importButton = driver.getPageSource().contains("Import");
        Assert.assertFalse(importButton);
    }

    @Test
    public void checkIfUserCanPerformActionsOnDevice() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfUserCanFilter() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfAdminCanAddDevice() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);
    }

    @Test
    public void checkIfAdminCanExport() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    public void checkIfAdminCanImport() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnDevice() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void checkIfAdminCanFilter() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfSuperAdminCanAddDevice() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);
    }

    @Test
    public void checkIfSuperAdminCanExport() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    public void checkIfSuperAdminCanImport() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnDevice() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void checkIfSuperAdminCanFilter() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfUserCanAddAsset() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean addAssetButton = driver.getPageSource().contains("Add asset");
        Assert.assertFalse(addAssetButton);
    }

    @Test
    public void checkIfUserCanExportOnAssetsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean exportButton = driver.getPageSource().contains("Export");
        Assert.assertFalse(exportButton);
    }

    @Test
    public void checkIfUserCanImportOnAssetsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean importButton = driver.getPageSource().contains("Import");
        Assert.assertFalse(importButton);
    }

    @Test
    public void checkIfUserCanPerformActionsOnAssets() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'asset_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfUserCanFilterOnAssetsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfAdminCanAddAsset() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean AddAssetsButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddAssetsButton);
    }

    @Test
    public void checkIfAdminCanExportOnAssetsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    public void checkIfAdminCanImportOnAssetsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnAssets() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'asset_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void checkIfAdminCanFilterOnAssetsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfSuperAdminCanAddAsset() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean AddAssetsButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddAssetsButton);
    }

    @Test
    public void checkIfSuperAdminCanExportOnAssetsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);
    }

    @Test
    public void checkIfSuperAdminCanImportOnAssetsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnAssets() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'asset_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void checkIfSuperAdminCanFilterOnAssetsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfUserCanFilterOnEmployeesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfUserCanPerformActionsOnEmployeesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfAdminCanFilterOnEmployeesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnEmployeesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//*[contains(@id,'user_edit_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfSuperAdminCanFilterOnEmployeesPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnEmployeesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnEmployeesPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnEmployeesPage();
        if (driver.findElements(By.xpath("//*[contains(@id,'user_edit_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void checkIfUserCanFilterOnLicensesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnLicensesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfUserCanPerformActionsOnLicensesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnLicensesPage();
        if (driver.findElements(By.xpath("//button[starts-with(@id,'license_dropdown_')]")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfAdminCanFilterOnLicensesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnLicensesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfAdminCanPerformActionsOnLicensesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnLicensesPage();
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
        permissionForAllRoles.checkIfUsersCanPerformActionOnLicensesPage();
        boolean filterButton = driver.getPageSource().contains("Filter");
        Assert.assertTrue(filterButton);
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnLicensesPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnLicensesPage();
        boolean addLicenseButton = driver.getPageSource().contains("Add license");
        Assert.assertTrue(addLicenseButton);
        if (driver.findElements(By.xpath("//button[starts-with(@id,'license_dropdown_')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void checkIfUserCanDoActionsOnTagsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnTagsPage();
        if (driver.findElements(By.id("tags_edit_laptop")).size() != 0 || driver.findElements(By.id("tags_delete_laptop")).size() != 0) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIfAdminCanDoActionsOnTagsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnTagsPage();
        if (driver.findElements(By.xpath("//*[contains(@id,'item-edit')]")).size() != 0 || driver.findElements(By.xpath("//*[contains(@id,'item-delete')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void checkIfSuperAdminCanDoActionsOnTagsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnTagsPage();
        if (driver.findElements(By.xpath("//*[contains(@id,'item-edit')]")).size() != 0 || driver.findElements(By.xpath("//*[contains(@id,'item-delete')]")).size() != 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
}

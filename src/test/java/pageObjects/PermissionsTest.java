package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PermissionsTest extends BaseTest {
    @Test
    public void checkIfUserCanAddDevice() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertFalse(elementExists("Add device"));
    }

    @Test
    public void checkIfUserCanExport() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertFalse(elementExists("Export"));
    }

    @Test
    public void checkIfUserCanImport() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertFalse(elementExists("Import"));
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
        Assert.assertTrue(elementExists("Filter"));
    }

    @Test
    public void checkIfAdminCanAddDevice() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertTrue(elementExists("Add device"));
    }

    @Test
    public void checkIfAdminCanExport() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertTrue(elementExists("Export"));
    }

    @Test
    public void checkIfAdminCanImport() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertTrue(elementExists("Import"));
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
        Assert.assertTrue(elementExists("Filter"));
    }

    @Test
    public void checkIfSuperAdminCanAddDevice() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertTrue(elementExists("Add device"));
    }

    @Test
    public void checkIfSuperAdminCanExport() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertTrue(elementExists("Export"));
    }

    @Test
    public void checkIfSuperAdminCanImport() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnDevicePage();
        Assert.assertTrue(elementExists("Import"));
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
        Assert.assertTrue(elementExists("Filter"));
    }

    @Test
    public void checkIfUserCanAddAsset() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertFalse(elementExists("Add asset"));
    }

    @Test
    public void checkIfUserCanExportOnAssetsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertFalse(elementExists("Export"));
    }

    @Test
    public void checkIfUserCanImportOnAssetsPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertFalse(elementExists("Import"));
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
        Assert.assertTrue(elementExists("Filter"));
    }

    @Test
    public void checkIfAdminCanAddAsset() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertTrue(elementExists("Add asset"));
    }

    @Test
    public void checkIfAdminCanExportOnAssetsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertTrue(elementExists("Export"));
    }

    @Test
    public void checkIfAdminCanImportOnAssetsPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertTrue(elementExists("Import"));
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
        Assert.assertTrue(elementExists("Filter"));
    }

    @Test
    public void checkIfSuperAdminCanAddAsset() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertTrue(elementExists("Add asset"));
    }

    @Test
    public void checkIfSuperAdminCanExportOnAssetsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertTrue(elementExists("Export"));
    }

    @Test
    public void checkIfSuperAdminCanImportOnAssetsPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnAssetsPage();
        Assert.assertTrue(elementExists("Import"));
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
        Assert.assertTrue(elementExists("Filter"));
    }

    @Test
    public void checkIfUserCanFilterOnEmployeesPage() {
        loginPage.successfulSignInAsUser();
        permissionForAllRoles.checkIfUsersCanPerformActionOnEmployeesPage();
        Assert.assertTrue(elementExists("Filter"));
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
        Assert.assertTrue(elementExists("Filter"));
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
        Assert.assertTrue(elementExists("Filter"));
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
        Assert.assertTrue(elementExists("Filter"));
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
        Assert.assertTrue(elementExists("Filter"));
    }

    @Test
    public void checkIfAdminCanPerformActionsOnLicensesPage() {
        loginPage.successfulSignInAsAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnLicensesPage();
        Assert.assertTrue(elementExists("Add license"));
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
        Assert.assertTrue(elementExists("Filter"));
    }

    @Test
    public void checkIfSuperAdminCanPerformActionsOnLicensesPage() {
        loginPage.successfulSignInAsSuperAdmin();
        permissionForAllRoles.checkIfUsersCanPerformActionOnLicensesPage();
        Assert.assertTrue(elementExists("Add license"));
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

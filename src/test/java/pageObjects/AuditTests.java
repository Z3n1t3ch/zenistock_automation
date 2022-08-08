package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuditTests extends BaseTest {

    @Test
    public void successfullyAuditForCreateDevice() {
        audit.successfullyCreateDeviceAudit();
        String tableText = driver.findElement(By.className("MuiCollapse-wrapper")).getText();
        Assert.assertTrue(tableText.contains("CREATE"));
    }

    @Test
    public void successfullyAuditForAssignDevice() {
        audit.successfullyAssignDeviceAudit();
        String deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(deviceRowText.contains("assigned"));
        deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(deviceRowText.contains("Dovydas Adamonis"));
        String tableText = driver.findElement(By.className("MuiCollapse-wrapper")).getText();
        Assert.assertTrue(tableText.contains("ASSIGN"));
    }

    @Test
    public void successfullyAuditForDeleteDevice() {
        audit.successfullyDeleteDeviceAudit();
        String tableText = driver.findElement(By.className("MuiCollapse-wrapper")).getText();
        Assert.assertTrue(tableText.contains("DEACTIVATE"));
    }

    @Test
    public void successfullyAuditForUnAssignDevice() {
        audit.successfullyUnAssignDeviceAudit();
        String tableText = driver.findElement(By.className("MuiCollapse-wrapper")).getText();
        Assert.assertTrue(tableText.contains("UNASSIGN"));
    }

    @Test
    public void successfullyAuditForEditDevice() {
        audit.successfullyEditDeviceAudit();
        String tableText = driver.findElement(By.className("MuiCollapse-wrapper")).getText();
        Assert.assertTrue(tableText.contains("EDIT"));
    }

}

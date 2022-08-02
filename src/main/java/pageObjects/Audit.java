package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Audit extends DriverFactory {

    public Audit(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        devicePage = new DevicePage(driver);
    }

    private DevicePage devicePage;

    @FindBy(id = "device-table-row-0-button-audit")
    private WebElement auditButton;

    public void successfullyCreateDeviceAudit() {
        devicePage.successfullyCreateDevice();
        waitAuditTableOpen();
    }

    public void successfullyAssignDeviceAudit() {
        devicePage.successfullyAssignDevice();
        waitAuditTableOpen();

    }

    public void successfullyDeleteDeviceAudit() {
        devicePage.deleteDevice();
        waitAuditTableOpen();
    }

    public void successfullyUnAssignDeviceAudit() {
        devicePage.succesfullyUnAssignDevice();
        waitAuditTableOpen();

    }

    public void successfullyEdicDeviceAudit() {
        devicePage.successfullyEditADeviceSerialNo();
        waitAuditTableOpen();
    }

    private void waitAuditTableOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device-table-row-0-button-audit")));
        auditButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiTableRow-root")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiCollapse-wrapper")));

    }
}

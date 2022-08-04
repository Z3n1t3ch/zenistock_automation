package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        waitForAuditDisplay();
    }

    public void successfullyAssignDeviceAudit() {
        devicePage.successfullyAssignDevice();
        waitForAuditDisplay();

    }

    public void successfullyDeleteDeviceAudit() {
        devicePage.deleteDevice();
        waitForAuditDisplay();
    }

    public void successfullyUnAssignDeviceAudit() {
        devicePage.succesfullyUnAssignDevice();
        waitForAuditDisplay();

    }

    public void successfullyEditDeviceAudit() {
        devicePage.successfullyEditADeviceSerialNo();
        waitForAuditDisplay();
    }

}

package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Credentials;

public class DriverFactory {
    public WebDriver driver;
    public WebDriverWait wait;
    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "log-in-button")
    WebElement signInButton;
    @FindBy (id = "filter-button")
    WebElement filterButtonEmployee;
    @FindBy (id = "user-filter-filter-apply-button")
    WebElement applyFilterButtonEmployee;
    @FindBy (id = "filter_device_button")
    WebElement filterDeviceButton;
    @FindBy (id = "device-filter-apply-button")
    WebElement deviceFilterApplyButton;
    @FindBy(id = "device-filter-serialNo")
    WebElement filterSerialNo;
    @FindBy(id = "device-filter-status-autocomplete")
    WebElement filterStatus;
    public void signInAsSuperAdmin() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameSuperAdminRole);
        passwordField.sendKeys(Credentials.passwordSuperAdminRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
    }
    public void signInAsAdmin() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameAdminRole);
        passwordField.sendKeys(Credentials.passwordAdminRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
    }
    public void signInAsUser() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameUserRole);
        passwordField.sendKeys(Credentials.passwordUserRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
    }
    public void filterBySerialNo(String serialNo) {
        filterDeviceButton.click();
        filterSerialNo.sendKeys(serialNo);
        wait.until(ExpectedConditions.visibilityOf(deviceFilterApplyButton));
        deviceFilterApplyButton.click();
    }
    public void filterByStatusInactive() {
        filterDeviceButton.click();
        filterStatus.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device-filter-status-autocomplete-option-2")));
        driver.findElement(By.id("device-filter-status-autocomplete-option-2")).click();
        wait.until(ExpectedConditions.visibilityOf(deviceFilterApplyButton));
        deviceFilterApplyButton.click();
    }
    public String getDeviceName() {
        String firstRowText = driver.findElement(By.id("device-table-row-0")).getText();
        String[] attributes = firstRowText.split("\n");
        return attributes[0];
    }

    public String getEmployeeName() {
        String firstRowText = driver.findElement(By.id("undefined-table-row-0")).getText();
        String[] attributes = firstRowText.split("\n");
        return attributes[1];
    }


    public String getEmail() {
        String firstRowText = driver.findElement(By.id("undefined-table-row-0")).getText();
        String[] attributes = firstRowText.split("\n");
        return attributes[0];
    }
    public void filterByRole(String role) {
        wait.until(ExpectedConditions.visibilityOf(filterButtonEmployee));
        filterButtonEmployee.click();
        driver.findElement(By.id("user-filter-filter-role-selectList")).click();
        if (role.equals("user")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-filter-filter-role-selectList-user")));
            driver.findElement(By.id("user-filter-filter-role-selectList-user")).click();
        } else if (role.equals("admin")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-filter-filter-role-selectList-admin")));
            driver.findElement(By.id("user-filter-filter-role-selectList-admin")).click();
        } else if (role.equals("super_admin")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-filter-filter-role-selectList-super_admin")));
            driver.findElement(By.id("user-filter-filter-role-selectList-super_admin")).click();
        }
        wait.until(ExpectedConditions.visibilityOf(applyFilterButtonEmployee));
        applyFilterButtonEmployee.click();
    }
    public void filterByEmail(String email) {
        filterButtonEmployee.click();
        driver.findElement(By.id("user-filter-filter-clearButton")).click();
        wait.until(ExpectedConditions.visibilityOf(filterButtonEmployee));
        filterButtonEmployee.click();
        driver.findElement(By.id("user-filter-filter-email")).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(applyFilterButtonEmployee));
        applyFilterButtonEmployee.click();
    }
    public void waitForAuditDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device-table-row-0-button-audit")));
        driver.findElement(By.id("device-table-row-0-button-audit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiCollapse-wrapper")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiTableRow-root")));
    }

}

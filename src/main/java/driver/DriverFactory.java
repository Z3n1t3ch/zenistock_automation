package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Credentials;

public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(id = "username")
    private static WebElement usernameField;

    @FindBy(id = "password")
    private static WebElement passwordField;

    @FindBy(id = "log-in-button")
    private static WebElement signInButton;

    public static void signInAsSuperAdmin() {
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
        driver.findElement(By.id("filter_device_button")).click();
        driver.findElement(By.id("device-filter-serialNo")).sendKeys(serialNo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device-filter-apply-button")));
        driver.findElement(By.id("device-filter-apply-button")).click();
    }

    public void filterByStatusInactive() {
        driver.findElement(By.id("filter_device_button")).click();
        driver.findElement(By.id("device-filter-status-autocomplete")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device-filter-status-autocomplete-option-2")));
        driver.findElement(By.id("device-filter-status-autocomplete-option-2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("device-filter-apply-button")));
        driver.findElement(By.id("device-filter-apply-button")).click();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter-button")));
        driver.findElement(By.id("filter-button")).click();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-filter-filter-apply-button")));
        driver.findElement(By.id("user-filter-filter-apply-button")).click();
    }
    public void filterByEmail(String email){
        driver.findElement(By.id("filter-button")).click();
        driver.findElement(By.id("user-filter-filter-clearButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter-button")));
        driver.findElement(By.id("filter-button")).click();
        driver.findElement(By.id("user-filter-filter-email")).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-filter-filter-apply-button")));
        driver.findElement(By.id("user-filter-filter-apply-button")).click();
    }
}

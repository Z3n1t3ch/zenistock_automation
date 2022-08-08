package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class EmployeePage extends DriverFactory {


    public EmployeePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "undefined-employees-mButton")
    WebElement employeesButton;

    @FindBy(id = "user-role-selectList")
    WebElement userRoleSelectList;

    @FindBy(id = "user-role-selectList-user")
    WebElement userRoleButton;

    @FindBy(id = "user-role-selectList-admin")
    WebElement adminRoleButton;

    @FindBy(id = "user-role-selectList-super_admin")
    WebElement superAdminRoleButton;

    @FindBy(id = "user-saveBtn")
    WebElement saveButton;

    @FindBy (id="undefined-table")
    WebElement table;

    @FindBy(id = "success_toaster")
    WebElement successToaster;

    public void successfulSuperAdminToUserRoleChange() {
        signInAsSuperAdmin();
        employeesButton.click();
        filterByRole("super_admin");
        wait.until(ExpectedConditions.visibilityOf(employeesButton));
        String userName = getEmployeeName();
        String email = getEmail();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_edit_" + userName)));
        driver.findElement(By.id("user_edit_" + userName)).click();
        wait.until(ExpectedConditions.visibilityOf(userRoleSelectList));
        userRoleSelectList.click();
        wait.until(ExpectedConditions.visibilityOf(userRoleButton));
        userRoleButton.click();
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        filterByEmail(email);
    }

    public void successfulAdminToSuperAdminRoleChange() {
        signInAsSuperAdmin();
        employeesButton.click();
        filterByRole("admin");
        wait.until(ExpectedConditions.visibilityOf(table));
        String userName = getEmployeeName();
        String email = getEmail();
        wait.until(ExpectedConditions.visibilityOf(table));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_edit_" + userName)));
        driver.findElement(By.id("user_edit_" + userName)).click();
        wait.until(ExpectedConditions.visibilityOf(userRoleSelectList));
        userRoleSelectList.click();
        wait.until(ExpectedConditions.visibilityOf(superAdminRoleButton));
        superAdminRoleButton.click();
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        filterByEmail(email);
    }

    public void successfulUserToAdminRoleChange() {
        signInAsSuperAdmin();
        employeesButton.click();
        filterByRole("user");
        wait.until(ExpectedConditions.visibilityOf(table));
        String userName = getEmployeeName();
        String email = getEmail();
        wait.until(ExpectedConditions.visibilityOf(table));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_edit_" + userName)));
        driver.findElement(By.id("user_edit_" + userName)).click();
        wait.until(ExpectedConditions.visibilityOf(userRoleSelectList));
        userRoleSelectList.click();
        wait.until(ExpectedConditions.visibilityOf(adminRoleButton));
        adminRoleButton.click();
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
        filterByEmail(email);
    }
}

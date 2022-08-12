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

    @FindBy(id = "undefined-table")
    WebElement table;

    @FindBy(id = "success_toaster")
    WebElement successToaster;

    @FindBy(id = "undefined-table-row-0")
    WebElement firstTableRow;

    public static String elementText;

    public void successfulSuperAdminToUserRoleChange() {
        changeEmployeeRole("super_admin", "user");
        elementText=getTextFromElement(firstTableRow);
    }

    public void successfulAdminToSuperAdminRoleChange() {
        changeEmployeeRole("admin", "super_admin");
        elementText=getTextFromElement(firstTableRow);
    }

    public void successfulUserToAdminRoleChange() {
        changeEmployeeRole("user", "admin");
        elementText=getTextFromElement(firstTableRow);
    }
}

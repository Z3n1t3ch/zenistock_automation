package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmployeePage extends DriverFactory {


    public EmployeePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "undefined-table-row-0")
    WebElement firstTableRow;

    public static String elementText;

    public void successfulSuperAdminToUserRoleChange() {
        signInAsSuperAdmin();
        changeEmployeeRole("super_admin", "user");
        elementText = getTextFromElement(firstTableRow);
    }

    public void successfulAdminToSuperAdminRoleChange() {
        signInAsSuperAdmin();
        changeEmployeeRole("admin", "super_admin");
        elementText = getTextFromElement(firstTableRow);
    }

    public void successfulUserToAdminRoleChange() {
        signInAsSuperAdmin();
        changeEmployeeRole("user", "admin");
        elementText = getTextFromElement(firstTableRow);
    }
}

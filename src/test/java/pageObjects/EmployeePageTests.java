package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pageObjects.EmployeePage.elementText;

public class EmployeePageTests extends BaseTest {

    @Test
    public void successfulSuperAdminToUserRoleChange() {
        employeePage.successfulSuperAdminToUserRoleChange();
        Assert.assertTrue(elementText.contains("USER"));

    }

    @Test
    public void successfulAdminToSuperAdminRoleChange() {
        employeePage.successfulAdminToSuperAdminRoleChange();
        Assert.assertTrue(elementText.contains("SUPER_ADMIN"));
    }

    @Test
    public void successfulUserToAdminRoleChange() {
        employeePage.successfulUserToAdminRoleChange();
        Assert.assertTrue(elementText.contains("ADMIN"));
    }
}

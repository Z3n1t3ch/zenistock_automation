package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeePageTests extends BaseTest{

    @Test
    public void successfulSuperAdminToUserRoleChange(){
        employeePage.successfulSuperAdminToUserRoleChange();
        String employeeRowText = driver.findElement(By.id("undefined-table-row-0")).getText();
        Assert.assertTrue(employeeRowText.contains("USER"));

    }

    @Test
    public void successfulAdminToSuperAdminRoleChange(){
        employeePage.successfulAdminToSuperAdminRoleChange();
        String employeeRowText = driver.findElement(By.id("undefined-table-row-0")).getText();
        Assert.assertTrue(employeeRowText.contains("SUPER_ADMIN"));
    }

    @Test
    public void successfulUserToAdminRoleChange(){
        employeePage.successfulUserToAdminRoleChange();
        String employeeRowText = driver.findElement(By.id("undefined-table-row-0")).getText();
        Assert.assertTrue(employeeRowText.contains("ADMIN"));
    }
}

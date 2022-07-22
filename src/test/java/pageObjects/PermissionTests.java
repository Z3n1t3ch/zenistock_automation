package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;

public class PermissionTests extends BaseTest {

    @Test
    public void PermissionUser() throws InterruptedException {
        //User
        Permissions.checkIfUserCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertFalse(AddDeviceButton);
        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertFalse(ExportButton);
        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertFalse(ImportButton);
    }
    @Test
    public void Check()
    {
        Permissions.checkIfUserCanPerformActionOnDevicePage();
        if (driver.findElement(By.xpath("//button[starts-with(@id,'device_dropdown_')]")).getSize() !=0)
        {
            Assert.fail();
        }
        else {
            Assert.assertTrue(true);
        }
    }


    @Test
    //Admin
        public void PermissionAdmin() throws InterruptedException {
        Permissions.checkIfAdminCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);

        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);

        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);


      //  boolean ThreeDotsButton = driver.findElement(By.id("device_dropdown_123weq")).isDisplayed();
       // Assert.assertTrue(ThreeDotsButton);

       WebElement threeDotsButton = driver.findElement(By.xpath("//button[@id='device_dropdown_123weq']"));
       Assert.assertTrue(threeDotsButton.isDisplayed());


      //  driver.findElements(By.xpath("//button[@id='device_dropdown_123weq')]"));

        //Assert.assertTrue(driver);
    }

    @Test
    public void PermissionSuperAdmin() throws InterruptedException {
        Permissions.checkIfSuperAdminCanPerformActionOnDevicePage();
        boolean AddDeviceButton = driver.getPageSource().contains("Add device");
        Assert.assertTrue(AddDeviceButton);

        boolean ExportButton = driver.getPageSource().contains("Export");
        Assert.assertTrue(ExportButton);

        boolean ImportButton = driver.getPageSource().contains("Import");
        Assert.assertTrue(ImportButton);

      //  boolean ThreeDotsButton = driver.findElement(By.id("device_dropdown_123weq")).isDisplayed();
     //   Assert.assertTrue(ThreeDotsButton);

        WebElement threeDotsButton = driver.findElement(By.xpath("//button[@id='device_dropdown_123weq']"));
        Assert.assertTrue(threeDotsButton.isDisplayed());
    }

}

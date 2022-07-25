package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static utils.Constants.DEVICE_NAME;
import static utils.Constants.DEVICE_SERIAL_NO;

public class CreateDevicePageTests extends BaseTest {

    @Test
    public void successfulCreateDevice() {
        createDevicePage.successfullyCreateDevice();
        WebElement successToaster = driver.findElement(By.id("success_toaster"));
        Assert.assertEquals(successToaster.getText(), "Item created successfully!");
        filterDevice.filterBySerialNo(DEVICE_SERIAL_NO);
        Assert.assertTrue(driver.findElement(By.id("device-table")).getText().contains(DEVICE_NAME));

    }

    @Test
    public void createDeviceEmptyName() {
        createDevicePage.createDeviceWithoutName();
        boolean requiredNameField = Boolean.parseBoolean(driver.findElement(By.id("device-information-name")).getAttribute("required"));
        Assert.assertTrue(requiredNameField);
    }

    @Test
    public void createDeviceEmptySerialNo() {
        createDevicePage.createDeviceWithoutSerialNo();
        boolean requireSerialNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-serialNo")).getAttribute("required"));
        Assert.assertTrue(requireSerialNoField);
    }

    @Test
    public void createDeviceEmptyInventoryNo() {
        createDevicePage.createDeviceWithoutInventoryNo();
        boolean requireInventoryNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-inventoryNo")).getAttribute("required"));
        Assert.assertTrue(requireInventoryNoField);
    }

    @Test
    public void createDeviceEmptyInvoiceNo() {

        createDevicePage.createDeviceWithoutInvoiceNo();
        boolean requireInvoiceNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-invoiceNo")).getAttribute("required"));
        Assert.assertTrue(requireInvoiceNoField);
    }

    @Test
    public void createDeviceWhiteSpaceNameField() {
        createDevicePage.createDeviceWithWhiteSpacesNameField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWhiteSpaceSerialNoField() {
        createDevicePage.createDeviceWithWhiteSpaceSerialNoField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"serialNumber\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWhiteSpaceInventoryNoField() {
        createDevicePage.createDeviceWithWhiteSpaceInventoryNoField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"inventoryNumber\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWhiteSpaceInvoiceNoField() {
        createDevicePage.createDeviceWithWhiteSpaceInvoiceNoField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"invoiceNumber\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWhitSpaceDescriptionField() {
        createDevicePage.createDeviceWithThiteSpaceDescriptionField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"description\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWithTooLongName() {
        createDevicePage.createDeviceTooLongName();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" is too long.");
    }

    @Test
    public void createDeviceWithTooLongSerialNo() {
        createDevicePage.createDeviceTooLongSerialNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"serialNumber\" is too long.");

    }

    @Test
    public void createDeviceWithTooLongInventoryNo() {
        createDevicePage.createDeviceToLongInventoryNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"inventoryNumber\" is too long.");
    }

    @Test
    public void createDeviceWithTooLongInvoiceNo() {
        createDevicePage.createDeviceToLongInvoiceNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"invoiceNumber\" is too long.");
    }
}

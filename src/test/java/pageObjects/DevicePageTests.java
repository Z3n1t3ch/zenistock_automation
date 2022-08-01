package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DevicePageTests extends BaseTest {

    @Test
    public void successfullyCreateDevice() {
        devicePage.successfullyCreateDevice();
        Assert.assertTrue(driver.findElement(By.id("device-table-row-0")).isDisplayed());
    }

    @Test
    public void successfullyEditADeviceName() {
        devicePage.successfullyEditADeviceName();
        String successEdit = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(successEdit, "Item updated successfully!");
    }
    @Test
    public void successfullyEditADeviceSerialNo(){
        devicePage.successfullyEditADeviceSerialNo();
        String successEdit = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(successEdit, "Item updated successfully!");
    }
    @Test
    public void successfullyEditADeviceInventoryNo(){
        devicePage.successfullyEditADeviceInventoryNo();
        String successEdit = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(successEdit, "Item updated successfully!");
    }

    @Test
    public void successfullyEditADeviceInvoiceNo(){
        devicePage.successfullyEditADeviceInvoiceNo();
        String successEdit = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(successEdit, "Item updated successfully!");
    }
    @Test
    public void successfullyEditDescription(){
        devicePage.successfullyEditDescription();
        String successEdit = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(successEdit, "Item updated successfully!");
    }

    @Test
    public void createDeviceEmptyName() {
        devicePage.createDeviceWithoutName();
        boolean requiredNameField = Boolean.parseBoolean(driver.findElement(By.id("device-information-name")).getAttribute("required"));
        Assert.assertTrue(requiredNameField);
    }
    @Test
    public void editDeviceWithoutName(){
        devicePage.editDeviceWithoutName();
        boolean requiredNameField = Boolean.parseBoolean(driver.findElement(By.id("device-information-name")).getAttribute("required"));
        Assert.assertTrue(requiredNameField);
    }
    @Test
    public void createDeviceEmptySerialNo() {
        devicePage.createDeviceWithoutSerialNo();
        boolean requireSerialNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-serialNo")).getAttribute("required"));
        Assert.assertTrue(requireSerialNoField);
    }
    @Test
    public void editDeviceWithoutSerialNo(){
        devicePage.editDeviceWithoutSerialNo();
        boolean requireSerialNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-serialNo")).getAttribute("required"));
        Assert.assertTrue(requireSerialNoField);
    }

    @Test
    public void createDeviceEmptyInventoryNo() {
        devicePage.createDeviceWithoutInventoryNo();
        boolean requireInventoryNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-inventoryNo")).getAttribute("required"));
        Assert.assertTrue(requireInventoryNoField);
    }

    @Test public void editDeviceWithoutInventoryNo(){
        devicePage.editDeviceWithoutInventoryNo();
        boolean requireInventoryNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-inventoryNo")).getAttribute("required"));
        Assert.assertTrue(requireInventoryNoField);
    }

    @Test
    public void createDeviceEmptyInvoiceNo() {
        devicePage.createDeviceWithoutInvoiceNo();
        boolean requireInvoiceNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-invoiceNo")).getAttribute("required"));
        Assert.assertTrue(requireInvoiceNoField);
    }
    @Test
    public void editDeviceWithoutInvoiceNo(){
        devicePage.editDeviceWithoutInvoiceNo();
        boolean requireInvoiceNoField = Boolean.parseBoolean(driver.findElement(By.id("device-information-invoiceNo")).getAttribute("required"));
        Assert.assertTrue(requireInvoiceNoField);
    }

    @Test
    public void createDeviceWhiteSpaceNameField() {
        devicePage.createDeviceWithWhiteSpacesNameField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" contains only whitespaces.");
    }

    @Test
    public void editDeviceWithWhiteSpacesNameField() {
        devicePage.editDeviceWithWhiteSpacesNameField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWhiteSpaceSerialNoField() {
        devicePage.createDeviceWithWhiteSpaceSerialNoField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"serialNumber\" contains only whitespaces.");
    }
    @Test
    public void editDeviceWithWhiteSpaceSerialNoField(){
        devicePage.editDeviceWithWhiteSpaceSerialNoField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"serialNumber\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWhiteSpaceInventoryNoField() {
        devicePage.createDeviceWithWhiteSpaceInventoryNoField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"inventoryNumber\" contains only whitespaces.");
    }
    @Test
    public void editDeviceWithWhiteSpaceInventoryNo(){
        devicePage.editDeviceWithWhiteSpaceInventoryNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"inventoryNumber\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWhiteSpaceInvoiceNoField() {
        devicePage.createDeviceWithWhiteSpaceInvoiceNoField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"invoiceNumber\" contains only whitespaces.");
    }

    @Test
    public void editDeviceWithWhiteSpaceInvoiceNo(){
        devicePage.editDeviceWithWhiteSpaceInvoiceNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"invoiceNumber\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWhiteSpaceDescriptionField() {
        devicePage.createDeviceWithWhiteSpaceDescriptionField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"description\" contains only whitespaces.");
    }

    @Test
    public void editDeviceWithWhiteSpaceDescriptionField(){
        devicePage.editDeviceWithWhiteSpaceDescriptionField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"description\" contains only whitespaces.");
    }

    @Test
    public void createDeviceWithTooLongName() {
        devicePage.createDeviceTooLongName();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" is too long.");
    }

    @Test
    public void editDeviceTooLongName(){
        devicePage.editDeviceTooLongName();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" is too long.");
    }

    @Test
    public void createDeviceWithTooLongSerialNo() {
        devicePage.createDeviceTooLongSerialNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"serialNumber\" is too long.");
    }

    @Test
    public void editDeviceTooLongSerialNo(){
        devicePage.editDeviceTooLongSerialNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"serialNumber\" is too long.");
    }

    @Test
    public void createDeviceWithTooLongInventoryNo() {
        devicePage.createDeviceTooLongInventoryNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"inventoryNumber\" is too long.");
    }

    @Test
    public void editDeviceTooLongInventoryNo() {
        devicePage.editDeviceTooLongInventoryNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"inventoryNumber\" is too long.");
    }

    @Test
    public void createDeviceWithTooLongInvoiceNo() {
        devicePage.createDeviceTooLongInvoiceNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"invoiceNumber\" is too long.");
    }

    @Test
    public void editDeviceTooLongInvoiceNo(){
        devicePage.editDeviceTooLongInvoiceNo();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"invoiceNumber\" is too long.");
    }

    @Test
    public void successfullyEditInvoiceDate(){
        devicePage.successfullyEditInvoiceDate();
        String successEdit = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(successEdit, "Item updated successfully!");
    }

    @Test
    public void successfullyEditStartDateAndEndDate(){
        devicePage.successfullyEditStartDateAndEndDate();
        String successEdit = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(successEdit, "Item updated successfully!");
    }

    @Test
    public void editEndDateToBeEarlierThenStartDate(){
        devicePage.editEndDateToBeEarlierThenStartDate();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(),"The field \"warrantyEndDate\" is inconsistent.");
    }


    @Test
    public void succesfulAssignDevice() {
        devicePage.successfullyAssignDevice();
        WebElement succesToaster = driver.findElement(By.id("success_toaster"));
        Assert.assertEquals(succesToaster.getText(), "Item updated successfully!");
        String statusField = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(statusField.contains("assigned"));
        String deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(deviceRowText.contains("USER1 USER1"));
    }

    @Test
    public void succesfullyUnAssignDevice() {
        devicePage.succesfullyUnAssignDevice();
        WebElement succesToaster = driver.findElement(By.id("success_toaster"));
        Assert.assertEquals(succesToaster.getText(), "Item updated successfully!");
        String statusField = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(statusField.contains("available"));
        String deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertFalse(deviceRowText.contains("USER1 USER1"));
    }

    @Test
    public void assignDeviceEmptyUserField() {
        devicePage.assignDeviceWithoutUser();
        String deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(deviceRowText.contains("available"));
    }

    @Test
    public void assignDeviceStatusInactive() {
        devicePage.assignDeviceInactiveStatus();
        String deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(deviceRowText.contains("inactive"));
    }

    @Test
    public void successfullyDeleteDevice() {
        devicePage.deleteDevice();
        String text = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(text, "Item deleted successfully!");
        String deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(deviceRowText.contains("inactive"));
    }

    @Test
    public void successfullyDeleteAssignedDevice() {
        devicePage.successfullyDeleteAssignedDevice();
        String text = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(text, "Item deleted successfully!");
        String deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(deviceRowText.contains("inactive"));
    }

    @Test
    public void deleteInactiveDevice(){
        devicePage.deleteInactiveDevice();
        String text = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(text, "Item deleted successfully!");
        String deviceRowText = driver.findElement(By.id("device-table-row-0")).getText();
        Assert.assertTrue(deviceRowText.contains("inactive"));

    }
}

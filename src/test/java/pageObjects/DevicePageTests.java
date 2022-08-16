package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;

public class DevicePageTests extends BaseTest {

    @Test
    public void successfullyCreateDevice() {
        devicePage.successfullyCreateDevice();
        Assert.assertTrue(driver.findElement(By.id("device-table-row-0")).isDisplayed());
    }
    @Test
    public void successfullyEditADeviceName() {
        devicePage.successfullyEditADeviceName();
        Assert.assertEquals(devicePage.message, "Item updated successfully!");
        Assert.assertTrue(devicePage.getTextFromTable().contains(devicePage.serialNoField + ""));
    }
    @Test
    public void successfullyEditADeviceSerialNo() {
        devicePage.successfullyEditADeviceSerialNo();
        Assert.assertEquals(devicePage.message, "Item updated successfully!");
        Assert.assertTrue(devicePage.getTextFromTable().contains(devicePage.serialNoField + ""));
    }
    @Test
    public void successfullyEditADeviceInventoryNo() {
        devicePage.successfullyEditADeviceInventoryNo();
        Assert.assertEquals(devicePage.message, "Item updated successfully!");
        Assert.assertTrue(devicePage.getTextFromTable().contains(devicePage.serialNoField + ""));
    }
    @Test
    public void successfullyEditADeviceInvoiceNo() {
        devicePage.successfullyEditADeviceInvoiceNo();
        Assert.assertEquals(devicePage.message, "Item updated successfully!");
        Assert.assertTrue(devicePage.getTextFromTable().contains(devicePage.serialNoField + ""));
    }
    @Test
    public void successfullyEditDescription() {
        devicePage.successfullyEditDescription();
        Assert.assertEquals(devicePage.message, "Item updated successfully!");
    }
    @Test
    public void createDeviceEmptyName() {
        devicePage.createDeviceWithoutName();
        Assert.assertTrue(devicePage.hasRequired(devicePage.nameField));
    }
    @Test
    public void editDeviceWithoutName() {
        devicePage.editDeviceWithoutName();
        Assert.assertTrue(devicePage.hasRequired(devicePage.nameField));
    }
    @Test
    public void createDeviceEmptySerialNo() {
        devicePage.createDeviceWithoutSerialNo();
        Assert.assertTrue(devicePage.hasRequired(devicePage.serialNoField));
    }
    @Test
    public void editDeviceWithoutSerialNo() {
        devicePage.editDeviceWithoutSerialNo();
        Assert.assertTrue(devicePage.hasRequired(devicePage.serialNoField));
    }
    @Test
    public void createDeviceEmptyInventoryNo() {
        devicePage.createDeviceWithoutInventoryNo();
        Assert.assertTrue(devicePage.hasRequired(devicePage.inventoryNoField));
    }
    @Test
    public void editDeviceWithoutInventoryNo() {
        devicePage.editDeviceWithoutInventoryNo();
        Assert.assertTrue(devicePage.hasRequired(devicePage.inventoryNoField));
    }
    @Test
    public void createDeviceEmptyInvoiceNo() {
        devicePage.createDeviceWithoutInvoiceNo();
        Assert.assertTrue(devicePage.hasRequired(devicePage.invoiceNoField));
    }
    @Test
    public void editDeviceWithoutInvoiceNo() {
        devicePage.editDeviceWithoutInvoiceNo();
        Assert.assertTrue(devicePage.hasRequired(devicePage.invoiceNoField));
    }
    @Test
    public void createDeviceWhiteSpaceNameField() {
        devicePage.createDeviceWithWhiteSpacesNameField();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"name\" contains only whitespaces.");
    }
    @Test
    public void editDeviceWithWhiteSpacesNameField() {
        devicePage.editDeviceWithWhiteSpacesNameField();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"name\" contains only whitespaces.");
    }
    @Test
    public void createDeviceWhiteSpaceSerialNoField() {
        devicePage.createDeviceWithWhiteSpaceSerialNoField();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"serialNumber\" contains only whitespaces.");
    }
    @Test
    public void editDeviceWithWhiteSpaceSerialNoField() {
        devicePage.editDeviceWithWhiteSpaceSerialNoField();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"serialNumber\" contains only whitespaces.");
    }
    @Test
    public void createDeviceWhiteSpaceInventoryNoField() {
        devicePage.createDeviceWithWhiteSpaceInventoryNoField();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"inventoryNumber\" contains only whitespaces.");
    }
    @Test
    public void editDeviceWithWhiteSpaceInventoryNo() {
        devicePage.editDeviceWithWhiteSpaceInventoryNo();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"inventoryNumber\" contains only whitespaces.");
    }
    @Test
    public void createDeviceWhiteSpaceInvoiceNoField() {
        devicePage.createDeviceWithWhiteSpaceInvoiceNoField();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"invoiceNumber\" contains only whitespaces.");
    }
    @Test
    public void editDeviceWithWhiteSpaceInvoiceNo() {
        devicePage.editDeviceWithWhiteSpaceInvoiceNo();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"invoiceNumber\" contains only whitespaces.");
    }
    @Test
    public void createDeviceWhiteSpaceDescriptionField() {
        devicePage.createDeviceWithWhiteSpaceDescriptionField();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"description\" contains only whitespaces.");
    }
    @Test
    public void editDeviceWithWhiteSpaceDescriptionField() {
        devicePage.editDeviceWithWhiteSpaceDescriptionField();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"description\" contains only whitespaces.");
    }
    @Test
    public void createDeviceWithTooLongName() {
        devicePage.createDeviceTooLongName();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" is too long.");
    }
    @Test
    public void editDeviceTooLongName() {
        devicePage.editDeviceTooLongName();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"name\" is too long.");
    }
    @Test
    public void createDeviceWithTooLongSerialNo() {
        devicePage.createDeviceTooLongSerialNo();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"serialNumber\" is too long.");
    }
    @Test
    public void editDeviceTooLongSerialNo() {
        devicePage.editDeviceTooLongSerialNo();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"serialNumber\" is too long.");
    }
    @Test
    public void createDeviceWithTooLongInventoryNo() {
        devicePage.createDeviceTooLongInventoryNo();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"inventoryNumber\" is too long.");
    }
    @Test
    public void editDeviceTooLongInventoryNo() {
        devicePage.editDeviceTooLongInventoryNo();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"inventoryNumber\" is too long.");
    }
    @Test
    public void createDeviceWithTooLongInvoiceNo() {
        devicePage.createDeviceTooLongInvoiceNo();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"invoiceNumber\" is too long.");
    }
    @Test
    public void editDeviceTooLongInvoiceNo() {
        devicePage.editDeviceTooLongInvoiceNo();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"invoiceNumber\" is too long.");
    }
    //    @Test
    public void successfullyEditInvoiceDate() {
        devicePage.successfullyEditInvoiceDate();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.successToaster), "Item updated successfully!");
        String field = driver.findElement(By.id("device-table")).getText();
        Assert.assertTrue(field.contains(Constants.INVOICE_DATE));
    }
    //    @Test
    public void successfullyEditStartDateAndEndDate() {
        devicePage.successfullyEditStartDateAndEndDate();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.successToaster), "Item updated successfully!");
        String editedDevice = driver.findElement(By.id("device-table")).getText();
    }
    @Test
    public void editEndDateToBeEarlierThenStartDate() {
        devicePage.editEndDateToBeEarlierThenStartDate();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"warrantyEndDate\" is inconsistent.");
    }
    @Test
    public void succesfulAssignDevice() {
        devicePage.successfullyAssignDevice();
        Assert.assertTrue(devicePage.getDeviceName().contains("assigned"));
        Assert.assertTrue(devicePage.getDeviceName().contains("Dovydas Adamonis"));
    }
    @Test
    public void succesfullyUnAssignDevice() {
        devicePage.succesfullyUnAssignDevice();
        Assert.assertTrue(devicePage.getDeviceName().contains("available"));
        Assert.assertFalse(devicePage.getDeviceName().contains("Dovydas Adamonis"));
    }
    @Test
    public void assignDeviceEmptyUserField() {
        devicePage.assignDeviceWithoutUser();
        Assert.assertTrue(devicePage.getDeviceName().contains("available"));
    }
    @Test
    public void assignDeviceStatusInactive() {
        devicePage.assignDeviceInactiveStatus();
        Assert.assertTrue(devicePage.getDeviceName().contains("inactive"));
    }
    @Test
    public void successfullyDeleteDevice() {
        devicePage.deleteDevice();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.successToaster), "Item deleted successfully!");
        Assert.assertTrue(devicePage.getDeviceName().contains("inactive"));
    }
    @Test
    public void successfullyDeleteAssignedDevice() {
        devicePage.successfullyDeleteAssignedDevice();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.successToaster), "Item deleted successfully!");
        Assert.assertTrue(devicePage.getDeviceName().contains("inactive"));
    }
    @Test
    public void deleteInactiveDevice() {
        devicePage.deleteInactiveDevice();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.successToaster), "Item deleted successfully!");
        Assert.assertTrue(devicePage.getDeviceName().contains("inactive"));
    }
    @Test
    public void createDeviceInvalidWarrantyEndDate() {
        devicePage.createDeviceInvalidWarrantyEndDate();
        Assert.assertEquals(devicePage.getTextFromElement(devicePage.errorToaster), "The field \"warrantyEndDate\" is inconsistent.");
    }
}

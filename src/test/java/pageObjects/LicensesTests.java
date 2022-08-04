package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;

public class LicensesTests extends BaseTest {
    @Test
    public void successfulCreateLicense() {
        licenses.successfulCreateLicense();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Constants.LICENSES_URL);
    }
    @Test
    public void createDeviceWithTooLongName() {
        licenses.addLicenseTooLongName();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" is too long.");
    }
    @Test
    public void saveLicenseWhiteSpaceNameField() {
        licenses.createLicenseWithWhiteSpacesNameField();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"name\" contains only whitespaces.");
    }
    @Test
    public void createLicenseWithIndividualType() {
        licenses.createLicenseWithIndividualType();
        String URL = driver.getCurrentUrl();
        String success = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(URL, Constants.LICENSES_URL);
        Assert.assertEquals(success, "License created successfully!");
    }
    @Test
    public void createLicenseWithPackType() {
        licenses.createLicenseWithPackType();
        String URL = driver.getCurrentUrl();
        String success = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(URL, Constants.LICENSES_URL);
        Assert.assertEquals(success, "License created successfully!");
    }
    @Test
    public void createLicenseWithLocation() {
        licenses.createLicenseWithLocation();
        String URL = driver.getCurrentUrl();
        String success = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(URL, Constants.LICENSES_URL);
        Assert.assertEquals(success, "License created successfully!");
    }
    @Test
    public void createLicenseWithEmptyNameField() {
        licenses.createLicenseWithEmptyNameField();
        String URL = driver.getCurrentUrl();
        String errorToaster = driver.findElement(By.id("license_name")).getAttribute("required");
        boolean errorMessage = driver.getPageSource().contains(errorToaster);
        Assert.assertEquals(URL, Constants.LICENSE_DETAILS_URL);
        Assert.assertTrue(errorMessage);
    }
    @Test
    public void createLicenseWithExpirationDateEarlierThanPurchaseDate() {
        licenses.createLicenseWithExpirationDateEarlierThanPurchaseDate();
        WebElement errorToaster = driver.findElement(By.id("error_toaster"));
        Assert.assertEquals(errorToaster.getText(), "The field \"expirationDate\" is inconsistent.");
    }
    @Test
    public void createLicenseWithEmptyExpirationDate() {
        licenses.createLicenseWithEmptyExpirationDate();
        String errorToaster = driver.findElement(By.id("license_expiration_date_picker")).getAttribute("required");
        boolean errorMessage = driver.getPageSource().contains(errorToaster);
        Assert.assertTrue(errorMessage);
    }
    @Test
    public void createLicenseWithEmptyPurchaseDate() {
        licenses.createLicenseWithEmptyPurchaseDate();
        String errorToaster = driver.findElement(By.id("license_purchase_date_picker")).getAttribute("required");
        boolean errorMessage = driver.getPageSource().contains(errorToaster);
        Assert.assertTrue(errorMessage);
    }
    @Test
    public void successfulEditLicenseName() {
        licenses.successfulEditLicenseName();
        String URL = driver.getCurrentUrl();
        String success = driver.findElement(By.id("success_toaster")).getText();
        Assert.assertEquals(URL, Constants.LICENSES_URL);
        Assert.assertEquals(success, "License updated successfully!");
    }
}

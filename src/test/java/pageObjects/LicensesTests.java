package pageObjects;


import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;

import static pageObjects.Licenses.elementText;

public class LicensesTests extends BaseTest {
    @Test
    public void successfulCreateLicense() {
        licenses.successfulCreateLicense();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.LICENSES_URL);
        Assert.assertTrue(elementText.contains("License created successfully!"));
    }

    @Test
    public void createDeviceWithTooLongName() {
        licenses.addLicenseTooLongName();
        Assert.assertTrue(elementText.contains("The field \"name\" is too long."));
    }

    @Test
    public void saveLicenseWhiteSpaceNameField() {
        licenses.createLicenseWithWhiteSpacesNameField();
        Assert.assertTrue(elementText.contains("The field \"name\" contains only whitespaces."));
    }

    @Test
    public void createLicenseWithIndividualType() {
        licenses.createLicenseWithIndividualType();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.LICENSES_URL);
        Assert.assertTrue(elementText.contains("License created successfully!"));
    }

    @Test
    public void createLicenseWithPackType() {
        licenses.createLicenseWithPackType();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.LICENSES_URL);
        Assert.assertTrue(elementText.contains("License created successfully!"));
    }

    @Test
    public void createLicenseWithLocation() {
        licenses.createLicenseWithLocation();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.LICENSES_URL);
        Assert.assertTrue(elementText.contains("License created successfully!"));
    }

    @Test
    public void createLicenseWithEmptyNameField() {
        licenses.createLicenseWithEmptyNameField();
        Assert.assertEquals(elementText, "true");
        Assert.assertEquals(driver.getCurrentUrl(), Constants.LICENSE_DETAILS_URL);
    }

    @Test
    public void createLicenseWithExpirationDateEarlierThanPurchaseDate() {
        licenses.createLicenseWithExpirationDateEarlierThanPurchaseDate();
        Assert.assertTrue(elementText.contains("The field \"expirationDate\" is inconsistent."));
    }

    @Test
    public void createLicenseWithEmptyExpirationDate() {
        licenses.createLicenseWithEmptyExpirationDate();
        Assert.assertEquals(elementText, "true");
    }

    @Test
    public void createLicenseWithEmptyPurchaseDate() {
        licenses.createLicenseWithEmptyPurchaseDate();
        Assert.assertEquals(elementText, "true");
    }

    @Test
    public void successfulEditLicenseName() {
        licenses.successfulEditLicenseName();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.LICENSES_URL);
        Assert.assertTrue(elementText.contains("License updated successfully!"));
    }
}

package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;
public class Licenses extends DriverFactory {
    public Licenses(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "undefined-licenses-mButton")
    private WebElement licenseButton;
    @FindBy(id = "add-license")
    private WebElement addLicenseButton;
    @FindBy(id = "license_name")
    private WebElement nameField;
    @FindBy(id = "item_save")
    private WebElement saveLicense;
    @FindBy(id = "license_purchase_date_picker")
    private WebElement purchaseDate;
    @FindBy(id = "license_expiration_date_picker")
    private WebElement expirationDate;
    @FindBy(id = "license_type-selectList")
    private WebElement licenseTypeList;
    @FindBy(id = "license_type-selectList-pack")
    private WebElement selectPackOption;
    @FindBy(id = "license_type-selectList-individual")
    private WebElement selectIndividualOption;
    @FindBy(id = "license-locations-selectList")
    private WebElement licenseLocationList;
    @FindBy(id = "license-locations-selectList-romania")
    private WebElement RomaniaList;
    @FindBy(id = "license_dropdown_1111")
    private WebElement licenceDropdown;
    @FindBy(id = "license_edit_1111")
    private WebElement licenceEditDropdown;
    @FindBy(id = "success_toaster")
    private WebElement successToaster;
    @FindBy(id = "error_toaster")
    private WebElement errorToaster;

    public void successfulCreateLicense() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLicenseButton));
        addLicenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
    }
    public void createLicenseWithWhiteSpacesNameField() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
        addLicenseButton.click();
        nameField.sendKeys(Constants.WHITE_SPACE_NAME_WS);
        purchaseDate.sendKeys(Constants.PURCHASE_DATE_WS);
        expirationDate.sendKeys(Constants.EXPIRATION_DATE_WS);
        saveLicense.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }
    public void addLicenseTooLongName() {
        signInAsAdmin();
        licenseButton.click();
        addLicenseButton.click();
        nameField.sendKeys(Constants.LICENSE_NAME_IS_TOO_LONG);
        saveLicense.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }
    public void createLicenseWithPackType() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLicenseButton));
        addLicenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        licenseTypeList.click();
        wait.until(ExpectedConditions.visibilityOf(selectPackOption));
        selectPackOption.click();
        purchaseDate.sendKeys(Keys.CONTROL + "a");
        purchaseDate.sendKeys(Keys.DELETE);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        expirationDate.sendKeys(Keys.CONTROL + "a");
        expirationDate.sendKeys(Keys.DELETE);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
    }
    public void createLicenseWithIndividualType() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLicenseButton));
        addLicenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        licenseTypeList.click();
        wait.until(ExpectedConditions.visibilityOf(selectIndividualOption));
        selectIndividualOption.click();
        purchaseDate.sendKeys(Keys.CONTROL + "a");
        purchaseDate.sendKeys(Keys.DELETE);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        expirationDate.sendKeys(Keys.CONTROL + "a");
        expirationDate.sendKeys(Keys.DELETE);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
    }
    public void createLicenseWithLocation() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLicenseButton));
        addLicenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        licenseLocationList.click();
        wait.until(ExpectedConditions.visibilityOf(RomaniaList));
        RomaniaList.click();
        purchaseDate.sendKeys(Keys.CONTROL + "a");
        purchaseDate.sendKeys(Keys.DELETE);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        expirationDate.sendKeys(Keys.CONTROL + "a");
        expirationDate.sendKeys(Keys.DELETE);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
    }
    public void createLicenseWithEmptyNameField() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLicenseButton));
        addLicenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        purchaseDate.sendKeys(Keys.CONTROL + "a");
        purchaseDate.sendKeys(Keys.DELETE);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        expirationDate.sendKeys(Keys.CONTROL + "a");
        expirationDate.sendKeys(Keys.DELETE);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
    }
    public void createLicenseWithExpirationDateEarlierThanPurchaseDate() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLicenseButton));
        addLicenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        nameField.sendKeys(Constants.LICENSE_NAME_WS);;
        expirationDate.sendKeys(Keys.CONTROL + "a");
        expirationDate.sendKeys(Keys.DELETE);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        wait.until(ExpectedConditions.visibilityOf(errorToaster));
    }
    public void createLicenseWithEmptyExpirationDate() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLicenseButton));
        addLicenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        purchaseDate.sendKeys(Keys.CONTROL + "a");
        purchaseDate.sendKeys(Keys.DELETE);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        expirationDate.sendKeys(Keys.CONTROL + "a");
        expirationDate.sendKeys(Keys.DELETE);
        saveLicense.click();
    }
    public void createLicenseWithEmptyPurchaseDate() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLicenseButton));
        addLicenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        purchaseDate.sendKeys(Keys.CONTROL + "a");
        purchaseDate.sendKeys(Keys.DELETE);
        expirationDate.click();
        expirationDate.sendKeys(Keys.CONTROL + "a");
        expirationDate.sendKeys(Keys.DELETE);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
    }
    public void successfulEditLicenseName() {
        signInAsAdmin();
        licenseButton.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSES_URL));
        wait.until(ExpectedConditions.visibilityOf(licenceDropdown));
        licenceDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(licenceEditDropdown));
        licenceEditDropdown.click();
        wait.until(ExpectedConditions.urlToBe(Constants.LICENSE_DETAILS_URL));
        nameField.sendKeys(Keys.CONTROL + "a");
        nameField.sendKeys(Keys.DELETE);
        nameField.sendKeys(Constants.LICENSE_NAME_edit);
        saveLicense.click();
        wait.until(ExpectedConditions.visibilityOf(successToaster));
    }
}
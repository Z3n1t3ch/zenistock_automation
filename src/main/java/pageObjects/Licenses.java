package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;

public class Licenses extends DriverFactory {
    public Licenses(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "undefined-licenses-mButton")
    private WebElement licenseButton;
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
    @FindBy(id = "license_dropdown_135")
    private WebElement licenceDropdown;
    @FindBy(id = "license_edit_135")
    private WebElement licenceEditDropdown;
    @FindBy(id = "success_toaster")
    private WebElement successToaster;
    @FindBy(id = "error_toaster")
    private WebElement errorToaster;

    public static String elementText;

    public void successfulCreateLicense() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        elementToLoad(successToaster);
        elementText = getTextFromElement(successToaster);
        pageToLoad(Constants.LICENSES_URL);
    }

    public void createLicenseWithWhiteSpacesNameField() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.WHITE_SPACE_NAME_WS);
        purchaseDate.sendKeys(Constants.PURCHASE_DATE_WS);
        expirationDate.sendKeys(Constants.EXPIRATION_DATE_WS);
        saveLicense.click();
        elementToLoad(errorToaster);
        elementText = getTextFromElement(errorToaster);
    }

    public void addLicenseTooLongName() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.LICENSE_NAME_IS_TOO_LONG);
        saveLicense.click();
        elementToLoad(errorToaster);
        elementText = getTextFromElement(errorToaster);
    }

    public void createLicenseWithPackType() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        licenseTypeList.click();
        elementToLoad(selectPackOption);
        selectPackOption.click();
        clearField(purchaseDate);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        clearField(expirationDate);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        elementToLoad(successToaster);
        elementText = getTextFromElement(successToaster);
        pageToLoad(Constants.LICENSES_URL);
    }

    public void createLicenseWithIndividualType() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        licenseTypeList.click();
        elementToLoad(selectIndividualOption);
        selectIndividualOption.click();
        clearField(purchaseDate);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        clearField(expirationDate);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        elementToLoad(successToaster);
        elementText = getTextFromElement(successToaster);
        pageToLoad(Constants.LICENSES_URL);
    }

    public void createLicenseWithLocation() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        licenseLocationList.click();
        elementToLoad(RomaniaList);
        RomaniaList.click();
        clearField(purchaseDate);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        clearField(expirationDate);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        elementToLoad(successToaster);
        elementText = getTextFromElement(successToaster);
        pageToLoad(Constants.LICENSES_URL);
    }

    public void createLicenseWithEmptyNameField() {
        openAddLicensesPage();
        clearField(purchaseDate);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        clearField(expirationDate);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        elementText = nameField.getAttribute("required");
        pageToLoad(Constants.LICENSE_DETAILS_URL);
    }

    public void createLicenseWithExpirationDateEarlierThanPurchaseDate() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        clearField(expirationDate);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        elementToLoad(errorToaster);
        elementText = getTextFromElement(errorToaster);
    }

    public void createLicenseWithEmptyExpirationDate() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        clearField(purchaseDate);
        purchaseDate.sendKeys((Constants.PURCHASE_DATE_WS));
        clearField(expirationDate);
        saveLicense.click();
        elementText = expirationDate.getAttribute("required");
    }

    public void createLicenseWithEmptyPurchaseDate() {
        openAddLicensesPage();
        nameField.sendKeys(Constants.LICENSE_NAME_WS);
        clearField(purchaseDate);
        expirationDate.click();
        clearField(expirationDate);
        expirationDate.sendKeys((Constants.EXPIRATION_DATE_WS));
        saveLicense.click();
        elementText = purchaseDate.getAttribute("required");
    }

    public void successfulEditLicenseName() {
        signInAsAdmin();
        licenseButton.click();
        pageToLoad(Constants.LICENSES_URL);
        elementToLoad(licenceDropdown);
        licenceDropdown.click();
        elementToLoad(licenceEditDropdown);
        licenceEditDropdown.click();
        pageToLoad(Constants.LICENSE_DETAILS_URL);
        clearField(nameField);
        nameField.sendKeys(Constants.LICENSE_NAME_edit);
        saveLicense.click();
        elementToLoad(successToaster);
        elementText = getTextFromElement(successToaster);
    }
}

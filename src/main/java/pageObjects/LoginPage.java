package pageObjects;


import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Constants;
import utils.Credentials;


public class LoginPage extends DriverFactory {

    public LoginPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "log-in-button")
    private WebElement signInButton;

    @FindBy(id = "log-out")
    private WebElement logOutButton;

    public void successfulSignInAsSuperAdmin() {
        signInAsSuperAdmin();
    }

    public void successfulSignInAsAdmin() {
        signInAsAdmin();
    }

    public void successfulSignInAsUser() {
        signInAsUser();
    }

    public void logInWithEmptyUsername() {
        driver.get(Constants.login);
        passwordField.sendKeys(Credentials.passwordSuperAdminRole);
        signInButton.click();
    }

    public void logInWithEmptyPassword() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.usernameSuperAdminRole);
        signInButton.click();
    }

    public void logInWithEmptyCredentials() {
        driver.get(Constants.login);
        signInButton.click();
    }

    public void logInWithInvalidUsername() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.invalidUsername);
        passwordField.sendKeys(Credentials.passwordUserRole);
        signInButton.click();
    }

    public void logInWithInvalidPassword() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.usernameUserRole);
        passwordField.sendKeys(Credentials.invalidUsername);
        signInButton.click();
    }

    public void successfulLogOutAsSuperAdmin() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.usernameSuperAdminRole);
        passwordField.sendKeys(Credentials.passwordSuperAdminRole);
        signInButton.click();
        pageToLoad(Constants.dashboard);
        logOutButton.click();
    }
    public void successfulLogOutAsAdmin() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.usernameAdminRole);
        passwordField.sendKeys(Credentials.passwordAdminRole);
        signInButton.click();
        pageToLoad(Constants.dashboard);
        logOutButton.click();
    }
    public void successfulLogOutAsUser() {
        driver.get(Constants.login);
        usernameField.sendKeys(Credentials.usernameUserRole);
        passwordField.sendKeys(Credentials.passwordUserRole);
        signInButton.click();
        pageToLoad(Constants.dashboard);
        logOutButton.click();
    }
}

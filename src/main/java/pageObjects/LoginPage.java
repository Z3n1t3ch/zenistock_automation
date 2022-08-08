package pageObjects;


import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
        driver.get(Credentials.login);
        passwordField.sendKeys(Credentials.passwordSuperAdminRole);
        signInButton.click();
    }

    public void logInWithEmptyPassword() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameSuperAdminRole);
        signInButton.click();
    }

    public void logInWithEmptyCredentials() {
        driver.get(Credentials.login);
        signInButton.click();
    }

    public void logInWithInvalidUsername() {
        driver.get(Credentials.login);
        usernameField.sendKeys("asdasdadads");
        passwordField.sendKeys(Credentials.passwordUserRole);
        signInButton.click();
    }

    public void logInWithInvalidPassword() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameUserRole);
        passwordField.sendKeys("asdasdadads");
        signInButton.click();
    }

    public void successfulLogOutAsSuperAdmin() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameSuperAdminRole);
        passwordField.sendKeys(Credentials.passwordSuperAdminRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
        logOutButton.click();
    }
    public void successfulLogOutAsAdmin() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameAdminRole);
        passwordField.sendKeys(Credentials.passwordAdminRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
        logOutButton.click();
    }
    public void successfulLogOutAsUser() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameUserRole);
        passwordField.sendKeys(Credentials.passwordUserRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
        logOutButton.click();
    }
}

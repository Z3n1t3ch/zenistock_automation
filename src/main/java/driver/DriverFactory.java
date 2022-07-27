package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Credentials;

public class DriverFactory {

    public WebDriver driver;
    public WebDriverWait wait;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "log-in-button")
    private WebElement signInButton;

    public void signInAsSuperAdmin() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameSuperAdminRole);
        passwordField.sendKeys(Credentials.passwordSuperAdminRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
    }

    public void signInAsAdmin() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameAdminRole);
        passwordField.sendKeys(Credentials.passwordAdminRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
    }

    public void signInAsUser() {
        driver.get(Credentials.login);
        usernameField.sendKeys(Credentials.usernameUserRole);
        passwordField.sendKeys(Credentials.passwordUserRole);
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe(Credentials.dashboard));
    }

}

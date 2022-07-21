package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends DriverFactory {
    public static String URL = "https://zenistock.zenitech.local/login";
    private String username = "super_admin";
    private String password = "qwer3#qazxsw09*";

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "log-in-button")
    private WebElement button;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void signIn() {
        driver.get(URL);
        this.usernameField.sendKeys(this.username);
        this.passwordField.sendKeys(this.password);
        this.button.click();

        waitForURLNotToBe(URL);
    }
}

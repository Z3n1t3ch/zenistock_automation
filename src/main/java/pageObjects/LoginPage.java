package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends DriverFactory {

    public LoginPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "username")
    private static WebElement usernameField;

    @FindBy(id = "password")
    private static WebElement passwordField;

    @FindBy (id = "log-in-button")
    private static WebElement signInButton;

    @FindBy(id="log-out")
    private static WebElement logOut;




    public static void successfulSignInAsSuperAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(3000);
    }
    public static void successfulSignInAsAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
        Thread.sleep(3000);
    }
    public static void successfulSignInAsUser() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        Thread.sleep(3000);
    }
    public static void logInNoUsername(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
    }
    public static void logInNoPassword(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("");
        signInButton.click();
    }
    public static void logInNoPasswordNoUsername(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        signInButton.click();
    }
    public static void logInWithInvalidUsername(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("asdasdadads");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
    }
    public static void logInWithInvalidPassword(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("asdasdadads");
        signInButton.click();
    }
    public static void successfulLogOutAsSuperAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(5000);
        logOut.click();
    }
    public static void successfulLogOutAsAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(5000);
        logOut.click();
    }
    public static void successfulLogOutAsUser() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(5000);
        logOut.click();
    }

}

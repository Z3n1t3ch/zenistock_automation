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
    private  WebElement usernameField;

    @FindBy(id = "password")
    private  WebElement passwordField;

    @FindBy (id = "log-in-button")
    private  WebElement signInButton;

    @FindBy(id="log-out")
    private  WebElement logOut;




    public void successfulSignInAsSuperAdmin() {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
    }
    public void successfulSignInAsAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
        Thread.sleep(3000);
    }
    public void successfulSignInAsUser() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        Thread.sleep(3000);
    }
    public void logInNoUsername(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
    }
    public void logInNoPassword(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("");
        signInButton.click();
    }
    public void logInNoPasswordNoUsername(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        signInButton.click();
    }
    public void logInWithInvalidUsername(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("asdasdadads");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
    }
    public void logInWithInvalidPassword(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("asdasdadads");
        signInButton.click();
    }
    public void successfulLogOutAsSuperAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(5000);
        logOut.click();
    }
    public void successfulLogOutAsAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(5000);
        logOut.click();
    }
    public void successfulLogOutAsUser() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(5000);
        logOut.click();
    }

}

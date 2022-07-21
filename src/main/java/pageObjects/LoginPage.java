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




    public static void successfulSignIn() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(3000);
    }
    public static void invalidLogInNoUsername(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();


    }
    public static void invalidLogInNoPassword(){
        driver.get("https://zenistock.zenitech.local/login");
        usernameField.sendKeys("super_admin");
        passwordField.sendKeys("");
        signInButton.click();
    }


}

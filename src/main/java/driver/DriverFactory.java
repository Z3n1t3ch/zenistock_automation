package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DriverFactory {

    public WebDriver driver;

    public DriverFactory(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private  WebElement passwordField;

    @FindBy (id = "log-in-button")
    private  WebElement signInButton;
    public void signInAsSuperAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("super_admin");
        passwordField.sendKeys("qwer3#qazxsw09*");
        signInButton.click();
        Thread.sleep(2000);
    }
    public void signInAsAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
        Thread.sleep(3000);
    }
    public void signInAsUser() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        Thread.sleep(3000);
    }
}

package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    public WebDriver driver;
    public WebDriverWait wait;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
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
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
    }



    public void signInAsAdmin() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("admin");
        passwordField.sendKeys("qazqwer1@d.");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
    }
    public void signInAsUser() throws InterruptedException {
        driver.get("https://zenistock.zenitech.local/login");
        usernameField. sendKeys("user");
        passwordField.sendKeys("oiuhbvc5%r");
        signInButton.click();
        wait.until(ExpectedConditions.urlToBe("https://zenistock.zenitech.local/dashboard"));
    }

}

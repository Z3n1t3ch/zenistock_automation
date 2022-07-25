package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
    @Test
    public void successfulSignInAsSuperAdmin() {
        loginPage.successfulSignInAsSuperAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Credentials.dashboard);
    }

    @Test
    public void successfulSignInAsAdmin() {
        loginPage.successfulSignInAsAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Credentials.dashboard);
    }

    @Test
    public void successfulSignInAsUser() {
        loginPage.successfulSignInAsUser();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Credentials.dashboard);
    }

    @Test
    public void logInWithEmptyUsername() {
        loginPage.logInWithEmptyUsername();
        String URL = driver.getCurrentUrl();
        String hasRequired = driver.findElement(By.id("username")).getAttribute("required");
        boolean errorMessage = driver.getPageSource().contains(hasRequired);
        Assert.assertEquals(URL, Credentials.login);
        Assert.assertTrue(errorMessage);
    }

    @Test
    public void logInWithEmptyPassword() {
        loginPage.logInWithEmptyPassword();
        String URL = driver.getCurrentUrl();
        String invalidCredentials = driver.findElement(By.id("password-helper-text")).getText();
        Assert.assertEquals(URL, Credentials.login);
        Assert.assertEquals(invalidCredentials, Errors.invalidCredentials);
    }

    @Test
    public void logInWithEmptyCredentials() {
        loginPage.logInWithEmptyCredentials();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Credentials.login);
    }

    @Test
    public void logInWithInvalidUsername() {
        loginPage.logInWithInvalidUsername();
        String URL = driver.getCurrentUrl();
        String invalidCredentials = driver.findElement(By.id("password-helper-text")).getText();
        Assert.assertEquals(URL, Credentials.login);
        Assert.assertEquals(invalidCredentials, Errors.invalidCredentials);
    }

    @Test
    public void logInWithInvalidPassword() {
        loginPage.logInWithInvalidPassword();
        String URL = driver.getCurrentUrl();
        String invalidCredentials = driver.findElement(By.id("password-helper-text")).getText();
        Assert.assertEquals(URL, Credentials.login);
        Assert.assertEquals(invalidCredentials, Errors.invalidCredentials);
    }

    @Test
    public void successfulLogOutAsSuperAdmin() {
        loginPage.successfulLogOutAsSuperAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Credentials.login);
    }

    @Test
    public void successfulLogOutAsAdmin() {
        loginPage.successfulLogOutAsAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Credentials.login);
    }

    @Test
    public void successfulLogOutAsUser() {
        loginPage.successfulLogOutAsUser();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, Credentials.login);
    }
}

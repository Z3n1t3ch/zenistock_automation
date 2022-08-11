package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;
import utils.Errors;

public class LoginPageTests extends BaseTest {
    @Test
    public void successfulSignInAsSuperAdmin() {
        loginPage.successfulSignInAsSuperAdmin();
        Assert.assertEquals(loginPage.getURL(), Constants.dashboard);
    }

    @Test
    public void successfulSignInAsAdmin() {
        loginPage.successfulSignInAsAdmin();
        Assert.assertEquals(loginPage.getURL(), Constants.dashboard);
    }

    @Test
    public void successfulSignInAsUser() {
        loginPage.successfulSignInAsUser();
        Assert.assertEquals(loginPage.getURL(), Constants.dashboard);
    }

    @Test
    public void logInWithEmptyUsername() {
        loginPage.logInWithEmptyUsername();
        Assert.assertEquals(loginPage.getURL(), Constants.login);
        Assert.assertTrue(loginPage.hasRequired());
    }

    @Test
    public void logInWithEmptyPassword() {
        loginPage.logInWithEmptyPassword();
        Assert.assertEquals(loginPage.getURL(), Constants.login);
        Assert.assertEquals(loginPage.invalidCredentials(), Errors.errorInvalidCredentials);
    }

    @Test
    public void logInWithEmptyCredentials() {
        loginPage.logInWithEmptyCredentials();
        Assert.assertEquals(loginPage.getURL(), Constants.login);
    }

    @Test
    public void logInWithInvalidUsername() {
        loginPage.logInWithInvalidUsername();
        Assert.assertEquals(loginPage.getURL(), Constants.login);
        Assert.assertEquals(loginPage.invalidCredentials(), Errors.errorInvalidCredentials);
    }

    @Test
    public void logInWithInvalidPassword() {
        loginPage.logInWithInvalidPassword();
        Assert.assertEquals(loginPage.getURL(), Constants.login);
        Assert.assertEquals(loginPage.invalidCredentials(), Errors.errorInvalidCredentials);
    }

    @Test
    public void successfulLogOutAsSuperAdmin() {
        loginPage.successfulLogOutAsSuperAdmin();
        Assert.assertEquals(loginPage.getURL(), Constants.login);
    }

    @Test
    public void successfulLogOutAsAdmin() {
        loginPage.successfulLogOutAsAdmin();
        Assert.assertEquals(loginPage.getURL(), Constants.login);
    }

    @Test
    public void successfulLogOutAsUser() {
        loginPage.successfulLogOutAsUser();
        Assert.assertEquals(loginPage.getURL(), Constants.login);
    }
}

package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
    @Test
    public void successfulSignInAsSuperAdmin() throws InterruptedException {
        loginPage.successfulSignInAsSuperAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/dashboard" );
    }
    @Test
    public void successfulSignInAsAdmin() throws InterruptedException {
        loginPage.successfulSignInAsAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/dashboard" );
    }
    @Test
    public void successfulSignInAsUser() throws InterruptedException {
        loginPage.successfulSignInAsUser();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/dashboard" );
    }
    @Test
    public void logInNoUsername(){
        loginPage.logInNoUsername();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://zenistock.zenitech.local/login");
    }
    @Test
    public void logInNoPassword(){
        loginPage.logInNoPassword();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void logInNoPasswordNoUsername(){
        loginPage.logInNoPasswordNoUsername();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://zenistock.zenitech.local/login");
    }
    @Test
    public void logInWithInvalidUsername(){
        loginPage.logInWithInvalidUsername();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void logInWithInvalidPassword(){
        loginPage.logInWithInvalidPassword();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void successfulLogOutAsSuperAdmin() throws InterruptedException {
        loginPage.successfulLogOutAsSuperAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void successfulLogOutAsAdmin() throws InterruptedException {
        loginPage.successfulLogOutAsAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void successfulLogOutAsUser() throws InterruptedException {
        loginPage.successfulLogOutAsUser();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
}

package pageObjects;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
    @Test
    public void successfulSignInAsSuperAdmin() {
        LoginPage.successfulSignInAsSuperAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/dashboard" );
    }
    @Test
    public void successfulSignInAsAdmin() throws InterruptedException {
        LoginPage.successfulSignInAsAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/dashboard" );
    }
    @Test
    public void successfulSignInAsUser() throws InterruptedException {
        LoginPage.successfulSignInAsUser();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/dashboard" );
    }
    @Test
    public void logInNoUsername(){
        LoginPage.logInNoUsername();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://zenistock.zenitech.local/login");
    }
    @Test
    public void logInNoPassword(){
        LoginPage.logInNoPassword();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void logInNoPasswordNoUsername(){
        LoginPage.logInNoPasswordNoUsername();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://zenistock.zenitech.local/login");
    }
    @Test
    public void logInWithInvalidUsername(){
        LoginPage.logInWithInvalidUsername();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void logInWithInvalidPassword(){
        LoginPage.logInWithInvalidPassword();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void successfulLogOutAsSuperAdmin() throws InterruptedException {
        LoginPage.successfulLogOutAsSuperAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void successfulLogOutAsAdmin() throws InterruptedException {
        LoginPage.successfulLogOutAsAdmin();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
    @Test
    public void successfulLogOutAsUser() throws InterruptedException {
        LoginPage.successfulLogOutAsUser();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }
}

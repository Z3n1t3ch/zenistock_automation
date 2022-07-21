package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
    @Test
    public void successfulSignIn() throws InterruptedException {
        LoginPage.successfulSignIn();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/dashboard" );
    }
    @Test
    public void logInInvalidUsername(){
        LoginPage.invalidLogInNoUsername();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://zenistock.zenitech.local/login");

    }
    @Test
    public void logInInvalidPassword(){
        LoginPage.invalidLogInNoPassword();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://zenistock.zenitech.local/login");
    }

}

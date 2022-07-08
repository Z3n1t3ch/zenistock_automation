package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    @Test
    public void signIn() {
        loginPage.signIn();
        String URL = driver.getCurrentUrl();

        Assert.assertEquals(URL, "https://www.google.com/" );
        System.out.println("PASSED");
    }
}

package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
    @Test
    public void signInSuccessfully() {
        loginPage.signIn();
        Assert.assertEquals(driver.getCurrentUrl(), DashboardPage.URL);
    }
}

package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDevicePageTests extends BaseTest {


    @Test
    public void successfulCreateDevice(){

        String successMessage = createDevicePage.successfullyCreateDevice();

        Assert.assertEquals(successMessage, "Item created successfully!");

    }



}

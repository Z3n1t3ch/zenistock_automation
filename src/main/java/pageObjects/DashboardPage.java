package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends DriverFactory {
    public static String URL = "https://zenistock.zenitech.local/dashboard";
    public static String TagsURL = "https://zenistock.zenitech.local/tags";

    @FindBy(id = "undefined-tags-mButton")
    private WebElement tagsMenu;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void goToDashboard() {
        PageFactory.initElements(driver, this);
        driver.get(URL);
        waitForURL(URL);
    }

    public void goToTags() {
        goToDashboard();
        waitForElementToBeClickable(tagsMenu);
        tagsMenu.click();
        waitForURL(TagsURL);
    }
}

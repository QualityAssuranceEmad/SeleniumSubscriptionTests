package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    private SHAFT.GUI.WebDriver driver;
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private final By LogeOutButton = By.xpath("(//span[contains(@data-pc-section,'icon')])[2]");
    private final By ProfilePage = By.xpath("//a[@href='/main/profile']");

    @Step("LogeOut")
    public void NavigateToLogOutPage() {
        driver.element().click(LogeOutButton);


    }
    @Step("go to Profile Page")
    public ProfilePage NavigateToProfilePage() {
        driver.element()
                .click(ProfilePage);
        return  new ProfilePage(driver);

    }
}

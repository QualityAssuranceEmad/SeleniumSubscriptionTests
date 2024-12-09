package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
   private SHAFT.GUI.WebDriver driver;
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By SignUpButton = By.xpath("//a[@id='pn_id_3_header_action']");

    @Step("go to Sign Up Page")
    public LoginPage NavigateToSignupPage() {
        driver.element()
                .click(SignUpButton).and().browser().captureScreenshot();

        return this;
    }
}

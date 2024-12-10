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
    private final By Email_address = By.id("email-in");
    private final By Password = By.id("password");
    private final By Login_button = By.xpath("//button[contains(.,'Login')]");


    @Step("go to Sign Up Page")
    public SignupPage NavigateToSignupPage() {
        driver.element()
                .click(SignUpButton).and().browser().captureScreenshot();
        return  new SignupPage(driver);

    }
    @Step("Login To Subscription")
    public HomePage  LoginToSubscription(String email,String pass) {
        driver.element().type(Email_address,email).and().type(Password,pass).and().click(Login_button);
        return new HomePage(driver);

    }
}

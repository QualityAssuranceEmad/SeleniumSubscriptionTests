package pages;

import com.shaft.driver.SHAFT;
import io.cucumber.java.an.E;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignupPage {
    private SHAFT.GUI.WebDriver driver;

    public SignupPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By First_Name = By.id("firstName");
    private final By Last_Name = By.id("lastName");
    private final By Email = By.id("email");
    private final By Phone = By.id("phone");
    private final By Password = By.id("password1");
    private final By Confirm_Password = By.id("password2");
    private final By CheckBox = By.xpath("(//div[@class='p-checkbox-box'])[2]");
    private final By Sin_Up = By.xpath("(//button[@type='submit' and @data-pc-section])[2]");
    private final By Existing_Email = By.xpath("//div[contains(@class,'p-toast-detail') and @data-pc-section='detail']");
    private final By Existing_Phone = By.xpath("//div[contains(@class,'p-toast-detail') and @data-pc-section='detail']");

    @Step("Enter Account Information")
    public LoginPage enterAccountInformation(String firstName, String LastName, String Email_Address
            , String Mobile, String Pass, String Confirm_Pass) {

        driver.element().type(First_Name, firstName)
                .type(Last_Name, LastName)
                .type(Email, Email_Address)
                .type(Phone, Mobile)
                .type(Password, Pass)
                .type(Confirm_Password, Confirm_Pass).
                and().click(CheckBox).
                and().click(Sin_Up);
        return new LoginPage(driver);
    }

    @Step("Validate On Existing Email Error Message Visibility")
    public void validateOnErrorMessageVisibilityOfExistingEmail() {
        driver.verifyThat().element(Existing_Email).text().isEqualTo("Error in registration: The email already exists");
        System.out.println(driver.element().getText(Existing_Email));

    }

    @Step("Validate On Existing Email Error Message Visibility")
    public SignupPage validateOnErrorMessageVisibilityOfExistingPhone() {
        driver.verifyThat().element(Existing_Phone).text().isEqualTo("Error in registration: Phone number already exists");
        System.out.println(driver.element().getText(Existing_Phone));
        return this;
    }
}

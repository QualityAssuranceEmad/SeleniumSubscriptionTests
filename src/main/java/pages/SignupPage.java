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
    private final By Validation=By.cssSelector(".p-toast-detail[data-pc-section='detail']");
    private final By EmailValidation = By.xpath(".p-toast-detail[data-pc-section='detail']");
    private final By FirstNameAndLastNameSpaceValidation = By.xpath("///div[@class='p-toast-detail ng-tns-c3069176158-15']");
    private final By PhoneSpaceValidation = By.xpath("//div[@class='p-toast-detail ng-tns-c3069176158-11']");

    @Step("Enter Account Information")
    public LoginPage enterAccountInformation(String firstName, String LastName, String Email_Address
            , String Mobile, String Pass, String Confirm_Pass) throws InterruptedException {

        driver.element().type(First_Name, firstName)
                .type(Last_Name, LastName)
                .type(Email, Email_Address)
                .type(Phone, Mobile)
                .type(Password, Pass)
                .type(Confirm_Password, Confirm_Pass).
                and().click(CheckBox).
                and().click(Sin_Up);
        //Thread.sleep(2000);
        return new LoginPage(driver);
    }

    @Step("Validate On Existing Email Error Message Visibility")
    public void validateOnErrorMessageVisibilityOfExistingEmail() {
        driver.verifyThat().element(Existing_Email).text().isEqualTo("Error in registration: The email already exists");
        //System.out.println(driver.element().getText(Existing_Email));

    }

    @Step("Validate On Existing Email Error Message Visibility")
    public void validateOnErrorMessageVisibilityOfExistingPhone() {
        driver.verifyThat().element(Existing_Phone).text().isEqualTo("Error in registration: Phone number already exists");


    }

    @Step("Validate On FirstName And lastName")
    public SignupPage SpaceValidateOnFirstAndLastName() {
        driver.verifyThat().element(Validation).text().isEqualTo("Error in registration: First name cannot contain spaces" + " between characters, must be between 2 and 50 characters, and contain only letters.");
        return this;
    }

    @Step("Validate On Email")
    public SignupPage EmailValidation() {
        driver.verifyThat().element(Validation).text().isEqualTo("Error in registration: Please enter a valid email address to complete the sign-up process successfully.");
        return this;
    }

    @Step("Validate On Phone Space")
    public SignupPage SpaceValidateOnPhone() {
        driver.verifyThat().element(Validation).text().isEqualTo("Error in registration: Please don't leave spaces" +
                " between the digits in the phone number.");
        return this;
    }
}

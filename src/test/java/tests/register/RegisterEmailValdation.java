package tests.register;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;

public class RegisterEmailValdation {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    SHAFT.TestData.EXCEL excelData;
    @Link(name = "Subscription Page", url = "http://dev.advintic.com:9191/main")
    @Epic("Registration")
    @Feature("User Registration")
    @Story("Verify Navigation to Signup Page and Verify Email is used before")
    @Description("Given I open Subscription main Page, " +
            "When I click on the 'Sign Up' button  and fill all the data correct with email used before" +
            "Then I verify that the Error message of 'Error in registration: The email already exists' ")
    @Test(priority = 1)
    public void EmailValidation () {
        new LoginPage(driver).NavigateToSignupPage().enterAccountInformation(testData.getTestData("FirstName"),
                testData.getTestData("LastName"),
                testData.getTestData("Email"),testData.getTestData("Phone"),
                testData.getTestData("Pass"),testData.getTestData("Confirm_pass"));
        new SignupPage(driver).validateOnErrorMessageVisibilityOfExistingEmail();

    }
}

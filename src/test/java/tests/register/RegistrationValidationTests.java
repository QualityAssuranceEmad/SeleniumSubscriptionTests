package tests.register;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;

public class RegistrationValidationTests {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    SHAFT.TestData.EXCEL excelData;

    @Link(name = "Subscription Page", url = "http://dev.advintic.com:9191/main")
    @Epic("Registration Validation")
    @Feature("User Registration Validation")

    @Story("Verify Navigation to Signup Page and Verify Phone is used before")
    @Description("Given I open Subscription main Page, " +
            "When I click on the 'Sign Up' button  and fill all the data correct with Phone used before " +
            "Then I verify that the Error message of 'Error in registration: Phone number already exists' ")
    @Test(priority = 1)
    public void firstAndLastNameSpaceValidation () throws InterruptedException {
        new LoginPage(driver).NavigateToSignupPage().enterAccountInformation(testData.getTestData("FirstNamespace"),
                testData.getTestData("LastName"),
                testData.getTestData("Email"),testData.getTestData("Phone"),
                testData.getTestData("Pass"),testData.getTestData("Confirm_pass"));
        new SignupPage(driver).SpaceValidateOnFirstAndLastName();

    }
    @Test(priority = 2)
    public void EmailValidation () throws InterruptedException {
        driver.browser().refreshCurrentPage();
        new LoginPage(driver).NavigateToSignupPage().enterAccountInformation(testData.getTestData("FirstName"),
                testData.getTestData("LastName"),
                testData.getTestData("EmailValid"),testData.getTestData("Phone"),
                testData.getTestData("Pass"),testData.getTestData("Confirm_pass"));
        new SignupPage(driver).EmailValidation();
    }
    @Test(priority = 3)
    public void PhoneValidation () throws InterruptedException {
        driver.browser().refreshCurrentPage();
        new LoginPage(driver).NavigateToSignupPage().enterAccountInformation(testData.getTestData("FirstName"),
                testData.getTestData("LastName"),
                testData.getTestData("Email"),testData.getTestData("PhoneSpace"),
                testData.getTestData("Pass"),testData.getTestData("Confirm_pass"));
        new SignupPage(driver).SpaceValidateOnPhone();
    }
    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("http://dev.advintic.com:9191/main");
        testData = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "registrationVlidation.json");
        excelData = new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData() + "testExcel.xlsx");


    }


    @AfterMethod
    public void afterMethod() {
        // driver.quit();
    }
}

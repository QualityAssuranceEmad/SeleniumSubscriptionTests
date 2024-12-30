package tests.register;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

public class RegisterUserTests {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    SHAFT.TestData.EXCEL excelData;
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("TC-002")
    @Step("Navigate to Signup Page")
    @Link(name = "Subscription Page", url = "http://dev.advintic.com:9191/main")
    @Epic("Registration Validation")
    @Feature("User Registration Validation")
    @Story("Verify Navigation to Signup Page and Successfully Sign Up")
    @Description("Given I open Subscription main Page, " +
            "When I click on the 'Sign Up' button and fill all the data correct " +
            "Then I verify that the user is  Register  successfully")
    @Test(priority = 1)
    public void goToSignUp() throws InterruptedException {
        new LoginPage(driver).NavigateToSignupPage().enterAccountInformation(testData.getTestData("FirstName"),testData.getTestData("LastName"),
                testData.getTestData("Email"),testData.getTestData("Phone"),
                testData.getTestData("Pass"),testData.getTestData("Confirm_pass")).
                LoginToSubscription(testData.getTestData("Email"),
                testData.getTestData("Pass")).NavigateToLogOutPage();
       // new HomePage(driver)
    }
    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
       driver.browser().navigateToURL("http://dev.advintic.com:9191/main");
        testData = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "registrationForm.json");
        excelData = new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData() + "testExcel.xlsx");


    }


    @AfterMethod
    public void afterMethod() {
       // driver.quit();
    }
}

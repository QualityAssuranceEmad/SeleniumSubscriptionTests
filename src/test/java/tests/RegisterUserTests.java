package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class RegisterUserTests {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    @Link(name = "Subscription Page", url = "http://dev.advintic.com:9191/main")
    @Epic("Registration")
    @Feature("User Registration")
    @Story("Verify Navigation to Signup Page")
    @Description("Given I open Subscription main Page, " +
            "When I click on the 'Sign Up' button, " +
            "Then I verify that the user is navigated to the Sign Up page successfully")
    @Test
    public void goToSignUp() {
        new LoginPage(driver).NavigateToSignupPage();
    }
    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
       driver.browser().navigateToURL("http://dev.advintic.com:9191/main");
        //   testData = new SHAFT.TestData.JSON("RegisterWhileCheckoutTestsTestData.json");
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}

package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("TC-005")
    @Step("Navigate to Login Page and login")
    @Link(name = "Subscription Page", url = "http://dev.advintic.com:9191/main")
    @Epic("Login")
    @Feature("User Login ")
    @Story("Verify Navigation to Login Page and Successfully Login")
    @Description("Given I open Subscription main Page, " +
            "When  fill all the data correct " +
            "Then I verify that the user is  Login  successfully")
    @Test(priority = 1)
    public void Login() {
        new LoginPage(driver).
                LoginToSubscription(testData.getTestData("Email"),
                        testData.getTestData("Password")).NavigateToLogOutPage();

    }
    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("http://dev.advintic.com:9191/main");
        testData = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "loginForm.json");


    }


    @AfterMethod
    public void afterMethod() {
        // driver.quit();
    }
}

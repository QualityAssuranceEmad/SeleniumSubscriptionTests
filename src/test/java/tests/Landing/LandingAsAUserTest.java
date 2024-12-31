package tests.Landing;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingAsAGuestPage;
import pages.LoginPage;

public class LandingAsAUserTest {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    @Severity(SeverityLevel.CRITICAL)
    @Step("Navigate to landingPage")
    @Link(name = "Subscription Page", url = "http://dev.advintic.com:9191/main")
    @Epic("Landing")
    @Feature("Gust visit")
    @Story("Verify Navigation to Landing Page")
    @Description("Given I open Subscription main Page, " +
            "When  click on landing page " +
            "Then I verify that the user is  see the feature as a gust")
    @Test(priority = 1)
    public void LandingPageFullTest() throws InterruptedException {
        new LoginPage(driver).
                LoginToSubscription(testData.getTestData("Email"),
                        testData.getTestData("Password"));
        Thread.sleep(4000);
        new LandingAsAGuestPage(driver).landingPageVisit();
        new LandingAsAGuestPage(driver).listAllProducts();
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

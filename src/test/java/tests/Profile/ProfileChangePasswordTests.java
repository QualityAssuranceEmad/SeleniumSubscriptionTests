package tests.Profile;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileChangePasswordTests {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    private SHAFT.TestData.JSON testData1;

    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("TC-001")
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
                LoginToSubscription(testData1.getTestData("Email"),
                        testData1.getTestData("Password"));

    }
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("TC-002")
    @Step("Navigate to Login Page and edit Profile")
    @Link(name = "Subscription Page", url = "http://dev.advintic.com:9191/main")
    @Epic("Profile")
    @Feature("User change password  ")
    @Story("Verify Navigation to Login Page and Successfully Edit change password")
    @Description("Given I open Subscription main Page and login, " +
            "When  go to profile page and edit it " +
            "Then I verify that the password is changed  successfully")
      @Test(priority =2)
    public void ChangePasswordInProfile() throws InterruptedException {
        new HomePage(driver).NavigateToProfilePage();
        new ProfilePage(driver).ChangePassword(testData.getTestData("CurrentPass"),testData.getTestData("NewPass"),
                testData.getTestData("ConfirmPass"));

        new LoginPage(driver).
                LoginToSubscription(testData1.getTestData("Email"),
                        testData.getTestData("NewPass"));
    }
  /* @Test(priority = 3)
    public void PasswordUsedBefore() throws InterruptedException {
        new HomePage(driver).NavigateToProfilePage();
        new ProfilePage(driver).ChangePasswordAleardyUsed(testData.getTestData("CurrentPass"),
                testData.getTestData("NewPass"),
                testData.getTestData("ConfirmPass"));

    }*/

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("http://dev.advintic.com:9191/main");
        testData = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "ProfileData.json");
        testData1 = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "loginForm.json");


    }


    @AfterMethod
    public void afterMethod() {
        // driver.quit();
    }
}

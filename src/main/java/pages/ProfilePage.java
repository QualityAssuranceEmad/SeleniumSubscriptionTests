package pages;

import com.shaft.driver.SHAFT;
import groovy.lang.GString;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private SHAFT.GUI.WebDriver driver;

    public ProfilePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By EditIcon = By.xpath("//span[@class='pi pi-pencil cursor-pointer']");
    private final By FirstName = By.xpath("//span[text()='First Name']/following-sibling::div//input");
    private final By LastName = By.xpath("//span[text()='Last Name']/following-sibling::div//input");
    private final By Institution = By.xpath("//span[text()='Institution']/following-sibling::div//input");
    private final By JopTitle = By.xpath("//span[text()='Job Title']/following-sibling::div//input");
    private final By PhoneNumber = By.xpath("//span[text()='Phone Number']/following-sibling::div//input");
    private final By Country = By.xpath("//span[text()='Country']/following-sibling::div//input");
    private final By City = By.xpath("//span[text()='City']/following-sibling::div//input");
    private final By PostalCode = By.xpath("//span[text()='Postal Code']/following-sibling::div//input");
    private final By Save = By.xpath("(//button[@class='p-ripple p-element action-btn p-button p-component'])[1]");
    private final By ClickYes = By.xpath("//button[@type='button' and contains(@class, 'p-confirm-dialog-accept')]");
    // private final By ClickNo=By.xpath("//button[@type='button' and contains(@class, 'p-confirm-dialog-reject')]");
    //  private final By ClickOnClosePopUp=By.xpath("//button[@role='button' and contains(@class, 'p-dialog-header-close')]");
    // private final By CheckFirstNameAndLastNameSpaceValidation=By.xpath("//div[@class='p-toast-detail ng-tns-c3069176158-9' and contains(text(), 'Error in updating profile: Please enter a valid name without leading, trailing, or middle spaces.')]");
    //  private final By CheckPostalCodeValidation=By.xpath("//div[@class='p-toast-detail ng-tns-c3069176158-13' and contains(text(), 'Error in updating profile: Invalid Postal Code')]");
    private final By CurrentPass = By.xpath("//span[text()='Current Password']/following-sibling::div//input");
    private final By NewPass = By.xpath("//span[text()='New Password']/following-sibling::div//input");
    private final By ConfirmPass = By.xpath("//span[text()='Confirm Password']/following-sibling::div//input");
    private final By ChangePass = By.xpath("(//button[@class='p-ripple p-element action-btn p-button p-component'])[2]");
    private final By ClickYesChangePass = By.xpath("//button[@type='button' and contains(@class, 'p-confirm-dialog-accept')]");
    private final By changeProfilePhoto = By.xpath("//img[@alt='User_Image' and contains(@class, 'ng-star-inserted')]");
    By fileInputLocator = By.xpath("//input[@type='file']");
    private final By Validation=By.cssSelector(".p-toast-detail[data-pc-section='detail']");
    private final By clcikClose=By.xpath("(//button[@type='button'])[4]");
    @Step("Edit Profile Page")
    public ProfilePage EditProfilePage(String firstName, String lastName, String institution, String jop,
                                       String phone, String country, String city, String postal) throws InterruptedException {
        Thread.sleep(2000);
        String imagePath = "D:\\Advintic Project\\automationsLessons\\SubscriptionTestFramework\\src\\test\\resources\\images\\emad.jpg";
        driver.element().click(EditIcon);
        Thread.sleep(2000);
        driver.element().typeFileLocationForUpload(fileInputLocator, imagePath);
        driver.element().type(FirstName, firstName).and().type(LastName, lastName).and().type(Institution, institution).
                and().type(JopTitle, jop).and().type(PhoneNumber, phone).and().type(Country, country).and().type(City, city).and().type(PostalCode, postal).
                click(Save).click(ClickYes);
        return new ProfilePage(driver);


    }

    @Step("Change Password")
    public ProfilePage ChangePassword(String currentPassword, String newPassword, String confirmPassword) throws InterruptedException {
        Thread.sleep(8000);
        driver.element().click(EditIcon).and().type(CurrentPass, currentPassword).and().type(NewPass, newPassword).and().type(ConfirmPass, confirmPassword).
                click(ChangePass).click(ClickYesChangePass);
        return new ProfilePage(driver);


    }
    @Step("used  Password used before")
    public ProfilePage ChangePasswordAleardyUsed(String currentPassword, String newPassword, String confirmPassword) throws InterruptedException {
        Thread.sleep(4000);
        driver.element().click(EditIcon).and().type(CurrentPass, currentPassword).and().type(NewPass, newPassword).and().type(ConfirmPass, confirmPassword).
                click(ChangePass).click(ClickYesChangePass);
        driver.element().assertThat(Validation).text().isEqualTo("Please enter a new password to complete the password-changing process successfully").perform();

        return new ProfilePage(driver);


    }

/*    @Step("Change Profile Image")
    public ProfilePage ChangeProfileImage() throws InterruptedException {

        Thread.sleep(3000);
        String imagePath = "D:\\Advintic Project\\automationsLessons\\SubscriptionTestFramework\\src\\test\\resources\\images\\emad.jpg";
        //driver.element().click(EditIcon);
        driver.element().typeFileLocationForUpload(fileInputLocator, imagePath)
                .and().click(Save).and().click(ClickYes);
        return new ProfilePage(driver);
    }*/
}

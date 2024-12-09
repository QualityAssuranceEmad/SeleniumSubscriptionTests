package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignupPage {
    private SHAFT.GUI.WebDriver driver;
    public SignupPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    By First_Name = By.id("firstName");
    By Last_Name = By.id("lastName");
    By Email = By.id("email");
    By Phone = By.id("phone");
    By Password = By.id("password1");
    By Confirm_Password = By.id("password2");
    By CheckBox=By.xpath("(//div[@class='p-checkbox-box'])[2]");
    By Sin_Up=By

}

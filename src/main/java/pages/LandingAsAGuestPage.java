package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingAsAGuestPage {
    private SHAFT.GUI.WebDriver driver;
    String product="Referral application";
    public LandingAsAGuestPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private final By LandingPage = By.xpath("//img[@alt=\"Advintic Logo\" and @src=\"./../../assets/images/logo.jpg\"]");
    // Locator for all elements with dynamic IDs
    private final By Products = By.xpath("//*[starts-with(@id, 'pn_id_') and contains(@id, '_header_action')]");
    // Locator for a specific element with text "Referral application"
    private final By ProductDetails = By.xpath("//*[starts-with(@id, 'pn_id_') and contains(@id, '_header_action')]/div/span[text()='ITAC']");
    private final By clickSubscribe =By.xpath("(//button[contains(@class,'p-element p-ripple btn-cart align-self-center p-button p-component ng-star-inserted')])[13]");
    private final By assertLoginPageRedirection=By.xpath("//div[@class='header-tab ng-star-inserted']");
    private  final By assertSignUpRedirection=By.xpath("//div[@class='header-tab-clicked ng-star-inserted'][contains(.,'Sign up')]");
    @Step("List all products on the landing page")
    public void listAllProducts() {
        // Find all matching elements

    }


    @Step("go to landing page and check the products")
    public void landingPageVisit() throws InterruptedException {

        driver.element().click(LandingPage);
        Thread.sleep(4000);
        List<WebElement> elements = driver.getDriver().findElements(Products);

        // Loop through the list and log each product to Allure
        for (WebElement element : elements) {
            String productText = element.getText();
            // Log each product name in the Allure report
            System.out.println("Product: " + productText);
            Allure.step("Product: " + productText);  // This logs each product to Allure
        }
        driver.element().click(ProductDetails).and().click(clickSubscribe);
        Thread.sleep(4000);
        driver.verifyThat().element(assertLoginPageRedirection).text().isEqualTo("Login");
        driver.verifyThat().element(assertSignUpRedirection).text().isEqualTo("Sign up");

    }
}

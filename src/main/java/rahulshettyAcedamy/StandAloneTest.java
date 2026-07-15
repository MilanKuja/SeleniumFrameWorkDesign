package rahulshettyAcedamy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import rahulshettyacademy.pageObject.*;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String productName = "ZARA COAT 3";
        Actions action = new Actions(driver);

        LandingPage landingPage = new LandingPage(driver);
        landingPage.gotTo();
        ProductCatlog productCatlog = landingPage.logInApplication("ilmilan@gmail.com", "8vPQ9*9*FTBC7qh");

        List<WebElement> products = productCatlog.getProductList();
        productCatlog.addProductToCart(productName);
        CartPage cartPage = productCatlog.gotToCartPage();

        boolean match = cartPage.VerifyProductDisplayed(productName);
        Assert.assertTrue(match);
        CheckOutPage checkOutPage = cartPage.goToCheckOut();
        checkOutPage.selectCountry("India");
        ConfirmationPage confirmationPage = checkOutPage.submitOrder();
        String confirmationMassage = confirmationPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMassage, "THANKYOU FOR THE ORDER.");
        driver.close();




































    }


}

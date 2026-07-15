package rahulshettyAcedamy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.pageObject.CartPage;
import rahulshettyacademy.pageObject.LandingPage;

import java.time.Duration;

public class StandAloneTest extends LandingPage{



        @BeforeEach
        public void startUp() {
                openUrl("https://rahulshettyacademy.com/client");
        }

        @Test
                public void testing() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        String productName = "ZARA COAT 3";
        Actions action = new Actions(getDriver());

        LandingPage landingPage = new LandingPage();
        landingPage.gotTo().
        logInApplication("ilmilan@gmail.com", "8vPQ9*9*FTBC7qh")
        .addProductToCart(productName)
        .gotToCartPage().verifyProductDisplayed(productName);


        CartPage cartPage = new CartPage();
        cartPage.goToCheckOut().selectCountry("India").submitOrder()
                .getConfirmationMessage();

        }

        @AfterEach
        public void tareDown() {
            quitDriver();
        }


}

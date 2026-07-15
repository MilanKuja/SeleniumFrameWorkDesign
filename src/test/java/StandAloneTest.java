import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import rahulshettyacademy.pageObject.CartPage;
import rahulshettyacademy.pageObject.LandingPage;

public class StandAloneTest extends LandingPage{



        @BeforeEach
        public void startUp() {
                openUrl("https://rahulshettyacademy.com/client");
        }

        @Test
                public void testingEndToEnd() {
        String productName = "ZARA COAT 3";


        LandingPage landingPage = new LandingPage();
        landingPage.gotTo().
        logInApplication("ilmilan@gmail.com", "8vPQ9*9*FTBC7qh")
        .addProductToCart(productName)
        .gotToCartPage().verifyProductDisplayed(productName);


        CartPage cartPage = new CartPage();
        cartPage.goToCheckOut().selectCountry("India").submitOrder()
                .getConfirmationMessage();

        }

        @Test
        public void LogInErrorValidation() {
                LandingPage landingPage = new LandingPage();
                landingPage.logInApplication("ilmilan@gmail.com", "8vPQ9*9*FTBC7q");
                Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
        }

        @AfterEach
        public void tareDown() {
            quitDriver();
        }


}

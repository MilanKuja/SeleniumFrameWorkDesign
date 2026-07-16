package rahulshettyacademy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulshettyacademy.pageObject.CartPage;
import rahulshettyacademy.pageObject.LandingPage;

public class StandAloneTest extends LandingPage{



        @BeforeMethod(alwaysRun = true)
        public void startUp() {
                openUrl("https://rahulshettyacademy.com/client");
        }

        @org.testng.annotations.Test
                public void testingEndToEnd() {
        String productName = "ZARA COAT 3";


        LandingPage landingPage = new LandingPage();
        landingPage.
        logInApplication("ilmilan@gmail.com", "8vPQ9*9*FTBC7qh")
        .addProductToCart(productName)
        .gotToCartPage().verifyProductDisplayed(productName);


        CartPage cartPage = new CartPage();
        cartPage.goToCheckOut().selectCountry("India").submitOrder()
                .getConfirmationMessage();

        }

        @org.testng.annotations.Test(dependsOnMethods = {"testingEndToEnd"})
        public void OrderHistoryTest() {
                String productName = "ZARA COAT 3";
                LandingPage landingPage = new LandingPage();
                landingPage.logInApplication("ilmilan@gmail.com", "8vPQ9*9*FTBC7qh")
                        .goToOrdersPage().verifyOrderDisplay(productName);
        }





        @AfterMethod(alwaysRun = true)
        public void tareDown() {
            quitDriver();
        }


}

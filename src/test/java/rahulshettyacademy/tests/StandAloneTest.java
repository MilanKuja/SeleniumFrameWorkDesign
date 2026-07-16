package rahulshettyacademy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import rahulshettyacademy.pageObject.CartPage;
import rahulshettyacademy.pageObject.LandingPage;

public class StandAloneTest extends LandingPage{



        @BeforeMethod(alwaysRun = true)
        public void startUp() {
                openUrl("https://rahulshettyacademy.com/client");
        }

        @org.testng.annotations.Test(dataProvider = "getData", groups = {"Purchase"})
                public void submitOrder(String email, String password, String productName) {


        LandingPage landingPage = new LandingPage();
        landingPage.
        logInApplication(email, password)
        .addProductToCart(productName)
        .gotToCartPage().verifyProductDisplayed(productName);


        CartPage cartPage = new CartPage();
        cartPage.goToCheckOut().selectCountry("India").submitOrder()
                .getConfirmationMessage();

        }

        @org.testng.annotations.Test(dependsOnMethods = {"submitOrder"})
        public void OrderHistoryTest() {
                String productName = "ZARA COAT 3";
                LandingPage landingPage = new LandingPage();
                landingPage.logInApplication("ilmilan@gmail.com", "8vPQ9*9*FTBC7qh")
                        .goToOrdersPage().verifyOrderDisplay(productName);
        }

        @DataProvider
        public Object[][] getData() {
                return new Object[] [] {{"ilmilan@gmail.com","8vPQ9*9*FTBC7qh", "ZARA COAT 3"} , {"ilnikola@gmail.com", "8vPQ9*9*FTBC7qh", "ADIDAS ORIGINAL"}};
        }





        @AfterMethod(alwaysRun = true)
        public void tareDown() {
            quitDriver();
        }


}

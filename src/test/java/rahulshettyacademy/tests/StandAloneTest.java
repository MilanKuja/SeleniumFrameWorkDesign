package rahulshettyacademy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import rahulshettyacademy.pageObject.CartPage;
import rahulshettyacademy.pageObject.LandingPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class StandAloneTest extends LandingPage{



        @BeforeMethod(alwaysRun = true)
        public void startUp() {
                openUrl("https://rahulshettyacademy.com/client");
        }

        @org.testng.annotations.Test(dataProvider = "getData", groups = {"Purchase"})
                public void submitOrder(HashMap<String, String> input) {


        LandingPage landingPage = new LandingPage();
        landingPage.
        logInApplication(input.get("email"), input.get("password"))
        .addProductToCart(input.get("product"))
        .gotToCartPage().verifyProductDisplayed(input.get("product"));


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
        public Object[][] getData() throws IOException {

                List<HashMap<String, String>> data = getJsaonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacademy\\date\\PurchaseOrder.json");
                return new Object[][] {{data.get(0)}, {data.get(1)}};
        }





        @AfterMethod(alwaysRun = true)
        public void tareDown() {
            quitDriver();
        }


}

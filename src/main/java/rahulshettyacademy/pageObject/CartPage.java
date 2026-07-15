package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {

    String checkOutButton = "//li[@class = 'totalRow']//button";


    By cartProdutBy = By.xpath("//div[@class='cartSection']/h3");

    List<WebElement> cartProducts = getDriver().findElements(By.xpath("//div[@class='cartSection']/h3"));





    public boolean verifyProductDisplayed(String productName) {

        waitForElementToAppear(cartProdutBy);
        boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckOutPage goToCheckOut() {
        getDriver().findElement(By.xpath(checkOutButton)).click();
        return new CheckOutPage();
    }
}

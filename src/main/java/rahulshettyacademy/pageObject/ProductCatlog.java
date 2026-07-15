package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatlog extends AbstractComponent {

    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMassage = By.xpath("//div[@id='toast-container']");


    public WebElement getProductByName(String productName) {
        WebElement product = getProductList(productsBy).stream().filter(prod -> prod.findElement(By.cssSelector("b"))
                .getText().equals(productName)).findFirst().orElse(null);
        return product;
    }

    public CartPage addProductToCart(String productName) {
        WebElement product = getProductByName(productName);
        product.findElement(addToCart).click();
        waitForElementToAppear(toastMassage);
        waitForElementToDisappear(toastMassage);
        return new CartPage();

    }




}

package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class ProductCatlog extends AbstractComponent {

    WebDriver driver;

    public ProductCatlog(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMassage = By.xpath("//div[@id='toast-container']");

    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        WebElement product = getProductList().stream().filter(prod -> prod.findElement(By.cssSelector("b"))
                .getText().equals(productName)).findFirst().orElse(null);
        return product;
    }

    public void addProductToCart(String productName) {
        WebElement product = getProductByName(productName).findElement(addToCart);
        product.findElement(addToCart).click();
        waitForElementToAppear(toastMassage);
        waitForElementToDisappear(toastMassage);

    }


}

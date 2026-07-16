package rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyAcedamy.TestComponents.Driver;
import rahulshettyacademy.pageObject.CartPage;
import rahulshettyacademy.pageObject.OrderPage;

import java.time.Duration;
import java.util.List;

public class AbstractComponent extends Driver {


    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) getDriver();


    String cartHeader = "//*[contains(@routerlink, 'cart')]";


    public void openUrl(String url) {
        createDriver();
        getDriver().navigate().to(url);
    }

    public void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToDisappear(By findBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public CartPage gotToCartPage() {
        getDriver().findElement(By.xpath(cartHeader)).click();
        return new CartPage();
    }


    public List<WebElement> getProductList(By findBy) {
        waitForElementToAppear(findBy);
        return getDriver().findElements(findBy);
    }

    public OrderPage goToOrdersPage() {
        waitForElementToAppear(By.xpath("//button[@routerlink='/dashboard/myorders']"));
        getDriver().findElement(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();
        return new OrderPage();

    }



}

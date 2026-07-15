package rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.pageObject.CartPage;

import java.time.Duration;

public class AbstractComponent {


    WebDriverWait wait;
    WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @FindBy(xpath = "//*[contains(@routerlink, 'cart')]")
    WebElement cartHeader;




    public void waitForElementToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToDisappear(By findBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public CartPage gotToCartPage() {
        cartHeader.click();
        return new CartPage(driver);
    }

}

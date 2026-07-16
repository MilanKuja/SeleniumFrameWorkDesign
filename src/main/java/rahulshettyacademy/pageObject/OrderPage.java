package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class OrderPage extends AbstractComponent {
    String nameColumnValues = "//tbody/tr/td[2]";

    public boolean verifyOrderDisplay(String productName) {
        waitForElementToAppear(By.xpath(nameColumnValues));
        List<WebElement> productNames = getDriver().findElements(By.xpath(nameColumnValues));
        return productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));

    }


}

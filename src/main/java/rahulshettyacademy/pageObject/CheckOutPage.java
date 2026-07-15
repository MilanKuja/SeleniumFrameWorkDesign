package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

    String submit = "//a[@class = 'btnn action__submit ng-star-inserted']";

    String country = "//input[@placeholder='Select Country']";

    String selectCountry = "(//button[contains(@class, 'ta-item')])[2]";

    By results = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");


    public CheckOutPage selectCountry(String countryName) {
        Actions action = new Actions(getDriver());
        action.sendKeys(getDriver().findElement(By.xpath(country)), countryName).perform();
        waitForElementToAppear(results);
        getDriver().findElement(By.xpath(selectCountry)).click();
        return this;

    }

    public ConfirmationPage submitOrder() {
        getDriver().findElement(By.xpath(submit)).click();
        return new ConfirmationPage();
    }


}

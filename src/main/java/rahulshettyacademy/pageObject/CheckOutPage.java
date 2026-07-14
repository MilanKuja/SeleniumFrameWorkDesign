package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class = 'btnn action__submit ng-star-inserted']")
    WebElement submit;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath  = "(//button[contains(@class, 'ta-item')])[2]")
    WebElement selectCountry;

    By results = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");


    public void selectCountry(String countryName) {
        Actions action = new Actions(driver);
        action.sendKeys(country, countryName).perform();
        waitForElementToAppear(results);
        selectCountry.click();

    }

    public ConfirmationPage submitOrder() {
        submit.click();
        return new ConfirmationPage(driver);
    }


}

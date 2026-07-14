package rahulshettyacademy.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        @FindBy(id = "userEmail")
        WebElement userEmail;

        @FindBy(xpath = "//input[@id = 'userPassword']")
        WebElement userPassword;

        @FindBy(xpath = "//input[@id='login']")
        WebElement logInButton;

        public ProductCatlog logInApplication(String email, String password) {
            userEmail.sendKeys(email);
            userPassword.sendKeys(password);
            logInButton.click();
            return new ProductCatlog(driver);
        }

        public void gotTo() {
            driver.get("https://rahulshettyacademy.com/client");
        }

}

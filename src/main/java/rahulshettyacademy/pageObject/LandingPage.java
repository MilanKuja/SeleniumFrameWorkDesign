package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {




        String userEmail = "//input[@id = 'userEmail']";

        String userPassword = "//input[@id = 'userPassword']";

        String loginButton = "//input[@id='login']";

        String errorMessage = "//div[contains (@aria-label, 'Incorrect email')]";

        public ProductCatlog logInApplication(String email, String password) {
            getDriver().findElement(By.xpath(userEmail)).sendKeys(email);
            getDriver().findElement(By.xpath(userPassword)).sendKeys(password);
            getDriver().findElement(By.xpath(loginButton)).click();
            return new ProductCatlog();
        }

        public LandingPage gotTo() {
            getDriver().get("https://rahulshettyacademy.com/client");
            return this;
        }

        public String getErrorMessage() {
            waitForElementToAppear(By.xpath(errorMessage));
            return getDriver().findElement(By.xpath(errorMessage)).getText();

        }

}

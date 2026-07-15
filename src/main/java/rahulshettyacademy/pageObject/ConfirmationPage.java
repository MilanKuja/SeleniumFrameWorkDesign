package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

    String confirmationMessage  = ".hero-primary";


    public String getConfirmationMessage() {
        waitForElementToAppear(By.cssSelector(confirmationMessage));
        return getDriver().findElement(By.cssSelector(confirmationMessage)).getText();
    }
}

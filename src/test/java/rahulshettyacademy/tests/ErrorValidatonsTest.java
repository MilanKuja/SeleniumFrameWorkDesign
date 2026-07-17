package rahulshettyacademy.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulshettyAcedamy.TestComponents.Retry;
import rahulshettyacademy.pageObject.LandingPage;

public class ErrorValidatonsTest extends LandingPage {

    @BeforeMethod(alwaysRun = true)
    public void startUp() {
        openUrl("https://rahulshettyacademy.com/client");
    }




    @org.testng.annotations.Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void LogInErrorValidation() {
        LandingPage landingPage = new LandingPage();
        landingPage.logInApplication("ilmilan@gmail.com", "8vPQ9*9*FTBC7q");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect emaipassword.");
    }

    @AfterMethod(alwaysRun = true)
    public void tareDown() {
        quitDriver();
    }
}

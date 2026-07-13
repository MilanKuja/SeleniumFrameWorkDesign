import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String productName1 = "ZARA COAT 3";
        String productName2 = "iphone 13 pro";

        driver.findElement(By.xpath("//input[@id = 'userEmail']")).sendKeys("ilmilan@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'userPassword']")).sendKeys("8vPQ9*9*FTBC7qh");
        driver.findElement(By.xpath("//input[@id='login']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement product = products.stream().filter(prod -> prod.findElement(By.cssSelector("b"))
                .getText().equals(productName1)).findFirst().orElse(null);

        product.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        WebElement confirmMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
        if (confirmMessage.isDisplayed()) {
            System.out.println("Message is true");
        } else  {
            System.out.println("Messege is not displayed");
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));



        driver.findElement(By.xpath("//*[contains(@routerlink, 'cart')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']/h3")));

        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
        boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName1));
        Assert.assertTrue(match);

        driver.findElement(By.xpath("//li[@class = 'totalRow']//button")).click();


        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
        List<WebElement> dropDown = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']"));
        WebElement elements = dropDown.stream().filter(element -> element.findElement(By.xpath("//span")).getText().equals("India")).findFirst().orElse(null);
        elements.findElement(By.xpath("//button")).click();







    }


}

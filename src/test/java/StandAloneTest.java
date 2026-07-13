import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.xpath("//input[@id = 'userEmail']")).sendKeys("ilmilan@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'userPassword']")).sendKeys("8vPQ9*9*FTBC7qh");
        driver.findElement(By.xpath("//input[@id='login']")).click();

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement product = products.stream().filter(prod -> prod.findElement(By.cssSelector("b"))
                .getText().equals("ZARA COAT 3")).findFirst().orElse(null);

        product.findElement(By.cssSelector(".card-body button:last-of-type")).click();





    }


}

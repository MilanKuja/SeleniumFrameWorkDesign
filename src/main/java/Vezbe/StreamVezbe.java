package Vezbe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;
import java.util.stream.IntStream;

public class StreamVezbe extends AbstractComponent {

    String tablePrice = "//*[@class = 'table-display']//tr//td[3]";


    public List<WebElement> filterPrices(String priceValue) {
        List<WebElement> prices = getDriver().findElements(By.xpath(tablePrice));
        return prices.stream()
                .filter(price->price.getText().contains(priceValue))
                .toList();
    }

    public List<String> getPricesValues(String priceValues) {
        List<WebElement> prices = getDriver().findElements(By.xpath(tablePrice));
        return prices.stream()
                .map(WebElement::getText)
                .filter(text -> text.contains(priceValues))
                .toList();

    }

    public void filterCoursesByPrice() {
        List<WebElement> courses = getDriver().findElements(By.xpath("//table[@name='courses']//tr/td[2]"));
        List<WebElement> prices = getDriver().findElements(By.xpath("//table[@name='courses']//tr/td[3]"));

        IntStream.range(0, prices.size()).filter(i -> Integer.parseInt(prices.get(i).getText()) == 30)
                .mapToObj(i -> courses.get(i).getText()).toList();


    }




    }



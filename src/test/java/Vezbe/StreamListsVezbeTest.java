package Vezbe;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StreamListsVezbeTest extends StreamVezbe{
        @BeforeMethod
    public void startUp() {
        openUrl("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void filterPricesValues() {
        StreamVezbe streamVezbe = new StreamVezbe();
        streamVezbe.filterPrices("25")
                .forEach(price-> System.out.println(price.getText()));


    }

    @Test
    public void getPricesValues() {
        StreamVezbe streamVezbe = new StreamVezbe();
        streamVezbe.getPricesValues("25")
                .forEach(System.out::println);
    }

    @AfterMethod
    public void tareDown() {
        quitDriver();
    }






}

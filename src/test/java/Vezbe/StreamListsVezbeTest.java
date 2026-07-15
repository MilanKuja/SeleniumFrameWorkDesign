package Vezbe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamListsVezbeTest extends StreamVezbe{
    @BeforeEach
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

    @AfterEach
    public void tareDown() {
        quitDriver();
    }






}

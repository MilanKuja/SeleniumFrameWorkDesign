package rahulshettyAcedamy.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static  WebDriver getDriver() {
        return driver.get();

    }

    public static WebDriver createDriver() {
        if (getDriver()==null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
//            options.addArguments("--incognito"); --- pokretanje u incognito mode-u
//            options.addArguments("--headless=new"); --- pokretanje bez header-a
//            options.addArguments("--disable-extensions"); --- Iskljucuje sve chrome ekstenzije
//            options.addArguments("--disable-popup-blocking");  --- Iskljucivanje popup-ova
//            options.setAcceptInsecureCerts(true); --- Koristi se kada se testira development server
//            options.addArguments("--guest"); --- Pokrece se kao Guest korisnik
//            options.addArguments("--lang=sr"); --- za testiranje lokalizacija

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default-directory", System.getProperty("user.dir") + "/downloads");
            prefs.put("download.prompt_for_download", false);
            prefs.put("safebrowsing.enabled", true);


            options.setExperimentalOption("prefs", prefs);
//          prefs.put("credentials_enable_service", false); --- gasi servis za upravljanje kredencijalima.
//          prefs.put("profile.password_manager_enabled", false); --- gasi prikaz Password Manager funkcionalnosti u profilu.
//          prefs.put("profile.default_content_setting_values.geolocation", 2); -- gasenje lokacija
//          prefs.put("profile.default_content_setting_values.media_stream_camera", 2); -- gasenje kamere
//          prefs.put("profile.default_content_setting_values.media_stream_mic", 2); -- gasenje mikrofona

            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContetnt = FileUtils.readFileToString(new File(filePath),
                StandardCharsets.UTF_8);
        //String to HashMap Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContetnt, new TypeReference<>() {
        });
    }

    public File getScreenshot(String testCase) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCase +".pgn");
        FileUtils.copyFile(source, file);
        return file;

    }

    public static void quitDriver() {
        if (driver.get()!=null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

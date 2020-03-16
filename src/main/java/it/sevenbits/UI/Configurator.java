package it.sevenbits.UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Driver configurator class
 */
public final class Configurator {
    private static String baseUrl = "http://diploma-courses.7bits.it/api/";
    private static String endpoint = "login";
    private static WebDriver driver;
    private Configurator() {
    }

    /**
     * Driver initialization method
     */
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    /**
     * Driver shut down
     */
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Get driver method
     *
     * @return return statement
     */
    public static WebDriver getDriver() {
        return driver;
    }

}

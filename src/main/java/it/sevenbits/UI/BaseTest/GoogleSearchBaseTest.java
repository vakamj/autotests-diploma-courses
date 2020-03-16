package it.sevenbits.UI.BaseTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Tests for google search query
 */
public class GoogleSearchBaseTest {
    private static WebDriver driver;

    /**
     * Before tests actions
     */
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    /**
     * After all tests actions
     */
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    /**
     * Test for google search query
     */
    @Test
    public void googleSearch() {
        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.xpath("//input[@type='text']"));
        searchInput.sendKeys("mouse");
        searchInput.submit();
        List<WebElement> linkList = driver.findElements(By.className("g"));
        Assert.assertTrue(linkList.get(0).getText().contains("mouse"));
        driver.quit();
    }

}

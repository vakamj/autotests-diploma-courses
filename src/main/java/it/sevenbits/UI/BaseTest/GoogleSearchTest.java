package it.sevenbits.UI.BaseTest;

import it.sevenbits.Page.GoogleSearchPage;
import it.sevenbits.UI.Configurator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for google search query
 */
public class GoogleSearchTest {
    /**
     * Before tests actions
     */
    @BeforeClass
    public static void setup() {
        Configurator.setup();

    }

    /**
     * After all tests actions
     */
    @AfterClass
    public static void tearDown() {
        Configurator.tearDown();
    }

    /**
     * Test for google search query
     */
    @Test
    public void googleSearch() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.find("mouse");
        Assert.assertTrue(googleSearchPage.getSearchResult().get(0).getText().contains("mouse"));
    }
}

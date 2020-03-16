package it.sevenbits.Page;

import it.sevenbits.UI.Configurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Google search page description class
 */
public class GoogleSearchPage {
    @FindBy(xpath = "//input[@title='Поиск']")
    private WebElement searchInput;
    @FindBy(xpath = "//input[@value='Поиск в Google']")
    private WebElement findButton;
    @FindBy(xpath = "//input[@value='Мне повезёт!']")
    private WebElement searchButtonIAmFeelingLucky;
    @FindBy(xpath = "//span[@class='MiYK0e']")
    private WebElement searchButtonScreemKeyboard;

    @FindAll({
            @FindBy(xpath = "//div[@class='g']")
    })
    private List<WebElement> searchResults;

    /**
     * Open page doodle search
     */
    public GoogleSearchPage() {
        Configurator.getDriver().get("https://www.google.com");
        PageFactory.initElements(Configurator.getDriver(), this);

    }

    /**
     * Search query method
     * @param request input body
     */
    public void find(final String request) {
        searchInput.clear();
        searchInput.sendKeys(request);
        findButton.click();
    }

    /**
     * Get result list method
     * @return result list
     */
    public List<WebElement> getSearchResult() {
        return searchResults;
    }
}

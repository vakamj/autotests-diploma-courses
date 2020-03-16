package it.sevenbits.Page;

import it.sevenbits.UI.Configurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Login page description class
 */

public class LoginPage {
    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;


    /**
     * Open page login
     */

    public LoginPage() {
        Configurator.getDriver().get("http://diploma-courses.7bits.it/login");
        PageFactory.initElements(Configurator.getDriver(), this);
    }

    /**
     * Authorization method
     *
     * @param login    login details
     * @param password login details
     */

    public void loginAs(final String login, final String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}

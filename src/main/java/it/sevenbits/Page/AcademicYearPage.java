package it.sevenbits.Page;

import it.sevenbits.UI.Configurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Academic year page description class
 */

public class AcademicYearPage {
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement buttonAddYear;
    @FindBy(xpath = "//button[contains(text(),'Следующий год')]")
    private WebElement buttonAddNextYear;
    @FindBy(xpath = "//input[@placeholder='XXXX/YYYY']")
    private WebElement inputField;
    @FindBy(xpath = "//tbody[@class='table__body']//tr[1]/td[2]")
    private WebElement firstYear;
    @FindAll({
            @FindBy(xpath = "//div[@class='cell__delete-button']")
    })
    private List<WebElement> deleteButton;
    @FindAll({
            @FindBy(xpath = "//tbody[@class='table__body']//td[2]")
    })
    private List<WebElement> listYears;
    @FindBy(xpath = "//div[@class='error__header']")
    private WebElement statusCode;

    /**
     * Open page academic year
     */
    public AcademicYearPage() {
        Configurator.getDriver().get("http://diploma-courses.7bits.it/app/academicYears");
        PageFactory.initElements(Configurator.getDriver(), this);
    }

    /**
     * Get first year method
     *
     * @return first year
     */
    public String getLastYear() {
        return firstYear.getText();
    }

    /**
     * Add arbitrary academic year method
     *
     * @param request academic year
     */
    public void addYear(final String request) {
        inputField.sendKeys(request);
        buttonAddYear.click();
    }

    /**
     * Add next academic year method
     */
    public void addNextYear() {
        buttonAddNextYear.click();
    }

    public List<WebElement> getListYears() {
        return listYears;
    }

    /**
     * Delete academic year
     */
    public void deleteYear(final String academicYear) {
        for (int i = 0; i < getListYears().size(); i++) {
            if (listYears.get(i).getText().contains(academicYear)) {
                deleteButton.get(i).click();
                break;
            }
        }
    }

    /**
     * Change last year
     *
     * @param lastYear put last Year
     * @return new year
     */
    public String changeYear(final String lastYear) {
        return String.valueOf(Integer.parseInt(lastYear.substring(0, 4)) + 1) + "/" +
                String.valueOf(Integer.parseInt(lastYear.substring(0, 4)) + 2);
    }

    /**
     * Find academic year method
     *
     * @param academicYear academic year
     * @return year Exist
     */
    public boolean findYear(final String academicYear) {
        boolean yearExist = true;
        for (int i = 0; i < getListYears().size(); i++) {
            if (listYears.get(i).getText().contains(academicYear)) {
                yearExist = false;
                break;
            }
        }
        return yearExist;
    }

    /**
     * Get error message method
     *
     * @return status message code
     */
    public String errorMessage() {
        return statusCode.getText();
    }
}

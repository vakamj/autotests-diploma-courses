package it.sevenbits.UI.HomeTest;

import it.sevenbits.Page.AcademicYearPage;
import it.sevenbits.Page.LoginPage;
import it.sevenbits.UI.Configurator;
import org.junit.*;

/**
 * Add academic year tests
 */
public class AddAcademicYearTest {
    private static AcademicYearPage academicYearPage;

    /**
     * Before tests actions
     */

    @BeforeClass
    public static void setup() {
        Configurator.setup();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("admin", "admin");
    }

    /**
     * After all tests actions
     */
    @AfterClass
    public static void tearDown() {
        Configurator.tearDown();
    }

    /**
     * Before the test open page
     */
    @Before
    public void openPage() {
        academicYearPage = new AcademicYearPage();
    }

    /**
     * Test for add a valid academic year
     */

    @Test
    public void addAcademicYearTest() {
        String newAcademicYear = academicYearPage.changeYear(academicYearPage.getLastYear());
        academicYearPage.addYear(newAcademicYear);
        Assert.assertEquals(academicYearPage.getLastYear(), newAcademicYear);
    }

    /**
     * Test for add next academic year
     */

    @Test
    public void addNextAcademicYearTest() {
        academicYearPage.addNextYear();
        Assert.assertEquals(academicYearPage.changeYear(academicYearPage.getLastYear()), academicYearPage.getLastYear());
    }

    /**
     * Test for add a existing academic year
     */

    @Test
    public void addExistingAcademicYearTest() {
        String lastYear = academicYearPage.getLastYear();
        academicYearPage.addYear(lastYear);
        Assert.assertEquals("500", academicYearPage.errorMessage());
    }

}

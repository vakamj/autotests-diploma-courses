package it.sevenbits.UI.HomeTest;

import it.sevenbits.Page.AcademicYearPage;
import it.sevenbits.Page.LoginPage;
import it.sevenbits.UI.Configurator;
import org.junit.*;

/**
 * Tests for delete year
 */
public class DeleteAcademicYearTest {
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
     * Test for delete academic year
     */

    @Test
    public void deleteAcademicYearTest() {
        String newAcademicYear = academicYearPage.changeYear(academicYearPage.getLastYear());
        academicYearPage.addYear(newAcademicYear);
        academicYearPage.deleteYear(newAcademicYear);
        Assert.assertTrue(academicYearPage.findYear(newAcademicYear));

    }

    /**
     * Test for delete academic year with dependencies
     */

    @Test
    public void deleteDependentAcademicYear() {
        String dependentAcademicYear = "3020/3021";
        academicYearPage.deleteYear(dependentAcademicYear);
        Assert.assertEquals("424", academicYearPage.errorMessage());
    }

}


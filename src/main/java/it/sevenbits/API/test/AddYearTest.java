package it.sevenbits.API.test;

import it.sevenbits.API.RequestBuilder;
import it.sevenbits.API.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * tests for post-requests to add a academic year
 */
public class AddYearTest {

    private static String token;
    private String baseUrl = "http://diploma-courses.7bits.it/api/";

    /**
     * authentication data
     */
    @BeforeClass
    public static void login() {
        token = Utils.login("admin", "admin");
    }

    /**
     * test for add a valid academic year
     */
    @Test
    public void addAcademicYearTest() {

        String academicYear = new RequestBuilder(baseUrl).getRequest(token, "academic-years/lastYear")
                .jsonPath().getString("data.academicYear");
        String newAcademicYear = String.valueOf(Integer.parseInt(academicYear.substring(0, 4)) + 1) + "/" +
                String.valueOf(Integer.parseInt(academicYear.substring(0, 4)) + 2);
        Assert.assertEquals("true", new RequestBuilder(baseUrl)
                .postRequest(token, "academic-years", "{\"academicYear\":\"" + newAcademicYear + "\"}")
                .jsonPath().getString("result.success"));
    }

    /**
     * test for add a existing academic year
     */
    @Test
    public void addExistingAcademicYearTest() {
        String academicYear = new RequestBuilder(baseUrl).getRequest(token, "academic-years/lastYear")
                .jsonPath().getString("data.academicYear");
        Assert.assertEquals("true", new RequestBuilder(baseUrl)
                .postRequest(token, "academic-years", "{\"academicYear\":\"" + academicYear + "\"}")
                .jsonPath().getString("result.success"));
    }

    /**
     * test for add a invalid academic year
     */
    @Test
    public void addInvalidAcademicYearTest() {
        Assert.assertEquals("false", new RequestBuilder(baseUrl).postRequest(token, "academic-years", "{\"academicYear\":\"20512052\"}")
                .jsonPath().getString("result.success"));
    }

    /**
     * test for add a empty academic year
     */
    @Test
    public void addEmptyAcademicYearTest() {
        Assert.assertEquals("false", new RequestBuilder(baseUrl).postRequest(token, "academic-years", "{\"academicYear\":\"\"}")
                .jsonPath().getString("result.success"));

    }
}

package it.sevenbits.API.test;

import io.restassured.response.Response;
import it.sevenbits.API.RequestBuilder;
import it.sevenbits.API.Utils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for delete year
 */
public class DelYearTest {
    private static String token;
    private String baseUrl = "http://diploma-courses.7bits.it/api/";
    private Boolean expectedResult;
    private Response response;

    /**
     * Authentication data
     */
    @BeforeClass
    public static void login() {
        token = Utils.login("admin", "admin");
    }

    /**
     * Test for delete academic year
     */
    @Test
    public void deleteAcademicYear() {
        String academicYear = new RequestBuilder(baseUrl).getRequest(token, "academic-years/lastYear")
                .jsonPath().getString("data.academicYear");
        Response newAcademicYear = new RequestBuilder(baseUrl).postRequest(token, "academic-years", "{\"academicYear\":\"" +
                String.valueOf(Integer.parseInt(academicYear.substring(0, 4)) + 1) + "/" +
                String.valueOf(Integer.parseInt(academicYear.substring(0, 4)) + 2) + "\"}");
        System.out.println(new RequestBuilder(baseUrl).getRequest(token, "academic-years?pageSize=10&offset=0&search=")
                .jsonPath().getString("data"));
        Assert.assertEquals("false", new RequestBuilder(baseUrl).deleteRequest(token, "academic-years/", new RequestBuilder(baseUrl)
                .getRequest(token, "academic-years?pageSize=10&offset=0&search=").jsonPath().getString("data.id"))
                .jsonPath().getString("result.success"));

    }

    /**
     * Test for delete academic year with dependencies
     */
    @Test
    public void deleteDependentAcademicYear() {
        Assert.assertEquals("false", new RequestBuilder(baseUrl).deleteRequest(token, "academic-years/", "158")
                .jsonPath().getString("result.success"));
    }

}


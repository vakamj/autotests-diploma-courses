package it.sevenbits.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

/**
 * class Utils
 */
public final class Utils {
    private static final String baseURL = "http://diploma-courses.7bits.it/api/";
    private static final String endpoint = "login";

    private Utils() {
    }

    /**
     * @param login    login details
     * @param password login details
     * @return token
     */
    public static String login(final String login, final String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("login", login);
        requestBody.put("password", password);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());

        Response response = request.post(baseURL + endpoint);
        String token = response.jsonPath().getString("token");
        return token;
    }

}

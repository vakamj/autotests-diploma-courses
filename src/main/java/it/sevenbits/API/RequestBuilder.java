package it.sevenbits.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * class RequestBuilder
 */
public final class RequestBuilder {
    private String baseUrl;

    /**
     * @param baseUrl address to API
     */
    public RequestBuilder(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response getRequest(final String token, final String endpoint) {
        RequestSpecification request = RestAssured.given();
        request.header("authorization", " Bearer " + token);
        request.contentType("application/json");
        Response response = request.get(baseUrl + endpoint);
        return response;
    }

    /**
     * @param token    for successful authorization
     * @param endpoint end point address
     * @param body     request content
     * @return server response
     */
    public Response postRequest(final String token, final String endpoint, final String body) {
        RequestSpecification request = RestAssured.given();
        request.header("authorization", " Bearer " + token);
        request.contentType("application/json");
        Response response = request.body(body).post(baseUrl + endpoint);
        return response;
    }

    /**
     * @param token    for successful authorization
     * @param endpoint end point address
     * @param id       unique identification number
     * @return server response
     */
    public Response deleteRequest(final String token, final String endpoint, final String id) {
        RequestSpecification request = RestAssured.given();
        request.header("authorization", " Bearer " + token);
        Response response = request.delete(baseUrl + endpoint + id);
        return response;
    }

}

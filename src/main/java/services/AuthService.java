package services;

import static io.restassured.RestAssured.given;

import config.ConfigReader;
import constants.EndPoints;
import io.restassured.response.Response;
import specifications.RequestSpec;

public class AuthService {

    public String getToken() {

        ConfigReader config = new ConfigReader();

        String body = "{"
                + "\"username\":\"" + config.getProperty("username") + "\","
                + "\"password\":\"" + config.getProperty("password") + "\""
                + "}";

       Response response = given()

                .spec(RequestSpec.getRequestSpecification())

                .body(body)

                .when()

                .post(EndPoints.AUTH);

        return response.jsonPath().getString("token");

    }

}
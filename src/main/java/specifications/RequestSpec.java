package specifications;

import static io.restassured.RestAssured.given;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    private static RequestSpecification requestSpecification;

    public static RequestSpecification getRequestSpecification() {

        ConfigReader config = new ConfigReader();

        System.out.println("Base URL = " + config.getProperty("baseURL"));

        return new RequestSpecBuilder()
                .setBaseUri(config.getProperty("baseURL").trim())
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();
    }
}
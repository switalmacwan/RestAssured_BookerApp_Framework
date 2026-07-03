package base;

import org.testng.annotations.BeforeClass;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specifications.RequestSpec;
import specifications.ResponseSpec;

public class BaseTest {

    protected RequestSpecification requestSpec;

    protected ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {

        requestSpec = RequestSpec.getRequestSpecification();

        responseSpec = ResponseSpec.getResponseSpecification();

    }

}
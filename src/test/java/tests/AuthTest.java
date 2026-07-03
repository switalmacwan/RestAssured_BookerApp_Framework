package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import services.AuthService;

public class AuthTest extends BaseTest {

	@Test(dependsOnMethods = "verifyCreateBooking")
    public void verifyAuthToken() {

        AuthService auth = new AuthService();

        String token = auth.getToken();

        System.out.println("Token : " + token);

        Assert.assertNotNull(token);
    }
}
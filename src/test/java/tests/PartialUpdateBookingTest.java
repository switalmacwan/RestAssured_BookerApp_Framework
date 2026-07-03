package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;
import payload.Booking;
import payload.BookingDates;
import services.AuthService;
import services.BookingService;

public class PartialUpdateBookingTest extends BaseTest {

	@Test(dependsOnMethods = "verifyGetBooking")
    public void verifyPartialUpdate() {

        BookingService service = new BookingService();

        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-08-20");
        dates.setCheckout("2026-08-25");

        Booking booking = new Booking();
        booking.setFirstname("John");
        booking.setLastname("Smith");
        booking.setTotalprice(1200);
        booking.setDepositpaid(true);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Breakfast");

        int bookingId = service.createBooking(booking).jsonPath().getInt("bookingid");

        String token = new AuthService().getToken();

        String body = "{ \"firstname\" : \"Virat\" }";

        Response response = service.partialUpdateBooking(bookingId, body, token);

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertEquals(response.jsonPath().getString("firstname"), "Virat");
    }
}
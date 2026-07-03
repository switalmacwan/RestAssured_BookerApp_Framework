package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;
import payload.Booking;
import payload.BookingDates;
import services.BookingService;

public class GetBookingTest extends BaseTest {

    
	@Test(dependsOnMethods = "verifyAuthToken")
    public void verifyGetBooking() {

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

        BookingService service = new BookingService();

        Response createResponse = service.createBooking(booking);

        int bookingId = createResponse.jsonPath().getInt("bookingid");

        Response getResponse = service.getBooking(bookingId);

        Assert.assertEquals(getResponse.getStatusCode(), 200);

        Assert.assertEquals(getResponse.jsonPath().getString("firstname"), "John");
    }
}
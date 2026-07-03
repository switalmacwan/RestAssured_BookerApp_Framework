package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;
import payload.Booking;
import payload.BookingDates;
import services.BookingService;

public class CreateBookingTest extends BaseTest {

    @Test
    public void verifyCreateBooking() {

        // Create Booking Dates
        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-08-20");
        dates.setCheckout("2026-08-25");

        // Create Booking Payload
        Booking booking = new Booking();
        booking.setFirstname("John");
        booking.setLastname("Smith");
        booking.setTotalprice(1200);
        booking.setDepositpaid(true);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Breakfast");

        // Call Service
        BookingService bookingService = new BookingService();

        Response response = bookingService.createBooking(booking);

        // Validations
        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertEquals(
                response.jsonPath().getString("booking.firstname"),
                "John");

        response.prettyPrint();
    }
}
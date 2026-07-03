package services;

import static io.restassured.RestAssured.given;

import endpoints.Routes;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Booking;
import specifications.RequestSpec;

public class BookingService {

    // Create Booking
    public static Response createBooking(Booking booking) {

        RequestSpecification spec = RequestSpec.getRequestSpecification();

        return given()
                .spec(spec)
                .body(booking)

        .when()
                .post(Routes.CREATE_BOOKING);
    }

    // Get Booking
    public Response getBooking(int bookingId) {

        RequestSpecification spec = RequestSpec.getRequestSpecification();

        return given()
                .spec(spec)
                .pathParam("id", bookingId)

        .when()
                .get(Routes.GET_BOOKING);
    }

    // Update Booking
    public Response updateBooking(int bookingId, Booking booking, String token) {

        RequestSpecification spec = RequestSpec.getRequestSpecification();

        return given()
                .spec(spec)
                .header("Cookie", "token=" + token)
                .pathParam("id", bookingId)
                .body(booking)

        .when()
                .put(Routes.UPDATE_BOOKING);
        
    }

    // Partial Update
    public Response partialUpdateBooking(int bookingId, String jsonBody, String token) {

        RequestSpecification spec = RequestSpec.getRequestSpecification();

        return given()
                .spec(spec)
                .header("Cookie", "token=" + token)
                .pathParam("id", bookingId)
                .body(jsonBody)

        .when()
                .patch(Routes.UPDATE_BOOKING);
    }

    // Delete Booking
    public Response deleteBooking(int bookingId, String token) {

        RequestSpecification spec = RequestSpec.getRequestSpecification();

        return given()
                .spec(spec)
                .header("Cookie", "token=" + token)
                .pathParam("id", bookingId)

        .when()
                .delete(Routes.DELETE_BOOKING);
    }
}
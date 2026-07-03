package endpoints;

import constants.EndPoints;

public class Routes {

    // Authentication
    public static String AUTH =
    		EndPoints.BASE_URL +
            EndPoints.AUTH;

    // Create Booking
    public static String CREATE_BOOKING =
    		EndPoints.BASE_URL +
            EndPoints.BOOKING;

    // Get Booking
    public static String GET_BOOKING =
    		EndPoints.BASE_URL +
            EndPoints.BOOKING + "/{id}";

    // Update Booking
    public static String UPDATE_BOOKING =
    		EndPoints.BASE_URL +
            EndPoints.BOOKING + "/{id}";

    // Delete Booking
    public static String DELETE_BOOKING =
    		EndPoints.BASE_URL +
            EndPoints.BOOKING + "/{id}";
}
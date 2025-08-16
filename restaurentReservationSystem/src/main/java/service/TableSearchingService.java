package restaurentReservationSystem.src.main.java.service;

public interface TableSearchingService {
    /**
     * Searches for available tables in a restaurant based on the given criteria.
     *
     * @param restaurentId The ID of the restaurant to search in.
     * @param bookingDate The date for which to check table availability.
     * @param bookingStartTime The start time for the booking.
     * @param seatsRequired The number of seats required for the booking.
     * @return A list of available tables that match the criteria.
     */
    java.util.List<restaurentReservationSystem.src.main.java.model.Table> searchAvailableTables(
            String restaurentId, String bookingDate, String bookingStartTime, int seatsRequired);
}

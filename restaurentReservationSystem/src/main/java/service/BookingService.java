package restaurentReservationSystem.src.main.java.service;

import restaurentReservationSystem.src.main.java.model.Booking;

public interface BookingService {
    void createBooking(String bookingId, String restaurentId, String tableId, String customerId, String bookingStartTime, String bookingDate, int seatsRequired);
    
    void updateBooking(String bookingId, String restaurentId, String tableId, String customerId, String bookingStartTime, String bookingDate, int seatsRequired);
    
    void deleteBooking(String bookingId);
    
    Booking getBookingById(String bookingId);
    
    java.util.List<Booking> getAllBookings();
    
    java.util.List<Booking> getBookingsByRestaurent(String restaurentId);
    
    java.util.List<Booking> getBookingsByCustomer(String customerId);

    void completeBooking(String bookingId, String restaurentId);
}

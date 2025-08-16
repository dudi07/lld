package restaurentReservationSystem.src.main.java.repo;

import restaurentReservationSystem.src.main.java.model.Booking;

public interface BookingRepository {

    void createBooking(Booking booking);
    
    void updateBooking(Booking booking);
    
    void deleteBooking(String bookingId);
    
    Booking getBookingById(String bookingId);
    
    java.util.List<Booking> getAllBookings();
    
    java.util.List<Booking> getBookingsByRestaurent(String restaurentId);
    
    java.util.List<Booking> getBookingsByCustomer(String customerId);

    java.util.List<Booking> getBookingsByRestaurentAndDate(String restaurentId, String bookingDate);
    void completeBooking(String bookingId, String restaurentId);
}
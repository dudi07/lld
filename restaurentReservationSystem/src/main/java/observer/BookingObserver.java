package restaurentReservationSystem.src.main.java.observer;

import restaurentReservationSystem.src.main.java.model.Booking;

public interface BookingObserver {
    void onBookingStatusChanged(Booking booking);
}

package restaurentReservationSystem.src.main.java.observer;

import restaurentReservationSystem.src.main.java.model.Booking;

public class EmailNotificationObserver implements BookingObserver {
    @Override
    public void onBookingStatusChanged(Booking booking) {
        System.out.println("[EMAIL] Booking " + booking.getBookingId() + " status changed to " + booking.getStatus());
    }
}

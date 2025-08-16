package restaurentReservationSystem.src.main.java.repo.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import restaurentReservationSystem.src.main.java.model.Booking;
import restaurentReservationSystem.src.main.java.repo.BookingRepository;
import restaurentReservationSystem.src.main.java.observer.BookingObserver;

public class BookingRepositoryImpl implements BookingRepository {
    private ConcurrentHashMap<String, Booking> restaurentIdBookingMap ;
    private ConcurrentHashMap<String, Booking> bookingIdBookingMap;
    private static BookingRepositoryImpl instance;
    private List<BookingObserver> observers = new ArrayList<>();

    private BookingRepositoryImpl() {
        restaurentIdBookingMap = new ConcurrentHashMap<>();
        bookingIdBookingMap = new ConcurrentHashMap<>();
    }

    public static synchronized BookingRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BookingRepositoryImpl();
        }
        return instance;
    }

    public void addObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookingObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Booking booking) {
        for (BookingObserver observer : observers) {
            observer.onBookingStatusChanged(booking);
        }
    }

    @Override
    public void createBooking(Booking booking) {
        restaurentIdBookingMap.put(booking.getRestaurentId(), booking);
        bookingIdBookingMap.put(booking.getBookingId(), booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        restaurentIdBookingMap.put(booking.getRestaurentId(), booking);
        bookingIdBookingMap.put(booking.getBookingId(), booking);
        notifyObservers(booking);
    }

    @Override
    public void deleteBooking(String bookingId) {
        // Remove from active bookings
        bookingIdBookingMap.remove(bookingId);
        restaurentIdBookingMap.values().removeIf(b -> b.getBookingId().equals(bookingId));
        // Optionally, add to booking history or mark as cancelled
        // bookingHistoryMap.put(bookingId, ...);
    }

    @Override
    public Booking getBookingById(String bookingId) {
        return bookingIdBookingMap.get(bookingId);
    }

    @Override
    public java.util.List<Booking> getAllBookings() {
        // Implementation here
        return null;
    }

    @Override
    public java.util.List<Booking> getBookingsByRestaurent(String restaurentId) {
        // Implementation here
        return null;
    }

    @Override
    public java.util.List<Booking> getBookingsByCustomer(String customerId) {
        // Implementation here
        return null;
    }

    @Override
    public java.util.List<Booking> getBookingsByRestaurentAndDate(String restaurentId, String bookingDate) {
        java.util.List<Booking> result = new java.util.ArrayList<>();
        for (Booking booking : restaurentIdBookingMap.values()) {
            if (booking.getRestaurentId().equals(restaurentId) && booking.getBookingDate().equals(bookingDate)) {
                result.add(booking);
            }
        }
        return result;
    }

    @Override
    public void completeBooking(String bookingId, String restaurentId) {
        Booking booking = bookingIdBookingMap.get(bookingId);
        if (booking != null) {
            Booking completedBooking = new Booking.BookingBuilder()
                .setBookingId(booking.getBookingId())
                .setRestaurentId(booking.getRestaurentId())
                .setTableId(booking.getTableId())
                .setCustomerId(booking.getCustomerId())
                .setBookingStartTime(booking.getBookingStartTime())
                .setBookingDate(booking.getBookingDate())
                .setStatus(restaurentReservationSystem.src.main.java.model.BookingStatus.COMPLETED)
                .build();
            bookingIdBookingMap.put(bookingId, completedBooking);
            restaurentIdBookingMap.remove(restaurentId);
            notifyObservers(completedBooking);
        }
    }
    
}

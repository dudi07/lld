package restaurentReservationSystem.src.main.java.service.impl;

import java.util.List;

import restaurentReservationSystem.src.main.java.model.Booking;
import restaurentReservationSystem.src.main.java.model.BookingStatus;
import restaurentReservationSystem.src.main.java.model.Table;
import restaurentReservationSystem.src.main.java.repo.BookingRepository;
import restaurentReservationSystem.src.main.java.repo.impl.BookingRepositoryImpl;
import restaurentReservationSystem.src.main.java.service.BookingService;
import restaurentReservationSystem.src.main.java.service.TableSearchingService;

public class BookingServiceImpl implements BookingService {
    private TableSearchingService tableSearchingService;
    private BookingRepository bookingRepository; // Assuming you have a BookingRepository injected

    public BookingServiceImpl(TableSearchingServiceImpl1 tableSearchingService, BookingRepositoryImpl bookingRepository) {
        this.tableSearchingService = tableSearchingService;
        this.bookingRepository = bookingRepository;
    }
    @Override
    public void createBooking(String bookingId, String restaurentId, String tableId, String customerId, String bookingStartTime, String bookingDate, int seatsRequired) {
        Booking booking = new Booking.BookingBuilder()
                .setBookingId(bookingId)
                .setRestaurentId(restaurentId)
                .setTableId(tableId)
                .setCustomerId(customerId)
                .setBookingStartTime(bookingStartTime)
                .setBookingDate(bookingDate)
                .setStatus(BookingStatus.PENDING) // Assuming a default status
                .build();
        
        // Call repository to save the booking
        // bookingRepository.createBooking(booking);
        List<Table> tables = tableSearchingService.searchAvailableTables(restaurentId, bookingDate, bookingStartTime, seatsRequired);

        if(tables.isEmpty()){
            throw new RuntimeException("No tables available for the given criteria");
        }
        bookingRepository.createBooking(booking);
    }

    @Override
    public void updateBooking(String bookingId, String restaurentId, String tableId, String customerId, String bookingStartTime, String bookingDate, int seatsRequired) {
        // Check if the booking exists
        Booking existingBooking = bookingRepository.getBookingById(bookingId);
        if (existingBooking == null) {
            throw new IllegalArgumentException("Booking with ID " + bookingId + " does not exist.");
        }

        // Validate the new table availability
    List<Table> availableTables = tableSearchingService.searchAvailableTables(restaurentId, bookingDate, bookingStartTime, seatsRequired);
    boolean tableAvailable = availableTables.stream().anyMatch(t -> t.getTableId().equals(tableId));
    if (!tableAvailable) {
        throw new IllegalStateException("Requested table is not available at the given time and for the required number of guests.");
    }

    Booking booking = new Booking.BookingBuilder()
            .setBookingId(bookingId)
            .setRestaurentId(restaurentId)
            .setTableId(tableId)
            .setCustomerId(customerId)
            .setBookingStartTime(bookingStartTime)
            .setBookingDate(bookingDate)
            .setStatus(BookingStatus.CONFIRMED) // Assuming a status for updated bookings
            .build();

        bookingRepository.updateBooking(booking);


    }

    @Override
    public void deleteBooking(String bookingId) {
        // Implementation here
        Booking booking = bookingRepository.getBookingById(bookingId);
        if (booking != null) {
            bookingRepository.deleteBooking(bookingId);
        } else {
            throw new IllegalArgumentException("Booking with ID " + bookingId + " does not exist.");
        }
    }

    @Override
    public Booking getBookingById(String bookingId) {
        // Implementation here
        return bookingRepository.getBookingById(bookingId);
    }

    @Override
    public java.util.List<Booking> getAllBookings() {
        // Implementation here
        return bookingRepository.getAllBookings();
    }

    @Override
    public java.util.List<Booking> getBookingsByRestaurent(String restaurentId) {
       return bookingRepository.getBookingsByRestaurent(restaurentId);
    }

    @Override
    public java.util.List<Booking> getBookingsByCustomer(String customerId) {
        return bookingRepository.getBookingsByCustomer(customerId);
    }
    
}

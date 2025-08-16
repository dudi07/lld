package restaurentReservationSystem.src.main.java.service.impl;

import java.util.List;

import restaurentReservationSystem.src.main.java.model.Booking;
import restaurentReservationSystem.src.main.java.repo.BookingRepository;
import restaurentReservationSystem.src.main.java.repo.RestaurentRepository;
import restaurentReservationSystem.src.main.java.service.TableSearchingService;

public class TableSearchingServiceImpl1 implements TableSearchingService {

    
    BookingRepository bookingRepository;
    RestaurentRepository restaurentRepository;

    public TableSearchingServiceImpl1(BookingRepository bookingRepository, RestaurentRepository restaurentRepository) {
        this.bookingRepository = bookingRepository;
        this.restaurentRepository = restaurentRepository;
    }
    /**
     * Searches for tables based on the given criteria.
     *
     * @param restaurentId The ID of the restaurant.
     * @param bookingDate The date of the booking.
     * @param bookingStartTime The start time of the booking.
     * @param seatsRequired The number of seats required.
     * @return A list of tables that match the search criteria.
     */
    @Override
    public java.util.List<restaurentReservationSystem.src.main.java.model.Table> searchAvailableTables(
            String restaurentId, String bookingDate, String bookingStartTime, int seatsRequired) {

            List<Booking>allBookings = bookingRepository.getBookingsByRestaurentAndDate(restaurentId, bookingDate);
            List<restaurentReservationSystem.src.main.java.model.Table> allTables = restaurentRepository.getRestaurentById(restaurentId).getTables();


            List<restaurentReservationSystem.src.main.java.model.Table> availableTables = new java.util.ArrayList<>();
            for (restaurentReservationSystem.src.main.java.model.Table table : allTables) {
                int tableCapacity = Integer.parseInt(table.getCapacity());
                if (tableCapacity >= seatsRequired) {
                    boolean isBooked = false;
                    for (Booking booking : allBookings) {
                        if (booking.getTableId().equals(table.getTableId())) {
                            isBooked = true;
                            break;
                        }
                    }
                    if (!isBooked) {
                        availableTables.add(table);
                    }
                }
            }
            return availableTables;
    }
    
}

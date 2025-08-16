package restaurentReservationSystem.src.main.java;

import restaurentReservationSystem.src.main.java.model.*;
import restaurentReservationSystem.src.main.java.service.impl.RestaurentServiceImpl;
import restaurentReservationSystem.src.main.java.repo.impl.RestaurentRepositoryImpl;
import restaurentReservationSystem.src.main.java.service.impl.BookingServiceImpl;
import restaurentReservationSystem.src.main.java.repo.impl.BookingRepositoryImpl;
import restaurentReservationSystem.src.main.java.service.impl.TableSearchingServiceImpl1;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        // Dependency Injection setup
        RestaurentRepositoryImpl restaurentRepo = RestaurentRepositoryImpl.getInstance();
        BookingRepositoryImpl bookingRepo = BookingRepositoryImpl.getInstance();
        TableSearchingServiceImpl1 tableSearchingService = new TableSearchingServiceImpl1(bookingRepo, restaurentRepo);
        RestaurentServiceImpl restaurentService = new RestaurentServiceImpl(restaurentRepo);
        BookingServiceImpl bookingService = new BookingServiceImpl(tableSearchingService, bookingRepo);

        System.out.println("Restaurant Reservation System - Project Structure Created Successfully!");
        System.out.println("Classes available:");
        System.out.println("- User");
        System.out.println("- Table");
        System.out.println("- Address");
        System.out.println("- Restaurant");

        // Create 3 customers
        Customer customer1 = new Customer("C1", "c1@email.com", "Alice", "1234567890");
        Customer customer2 = new Customer("C2", "c2@email.com", "Bob", "2345678901");
        Customer customer3 = new Customer("C3", "c3@email.com", "Charlie", "3456789012");

        // Add 10 restaurants
        for (int i = 1; i <= 10; i++) {
            String id = "R" + i;
            String name = "Restaurent" + i;
            String address = "Address" + i;
            String rating = String.valueOf(3 + (i % 3));
            List<Table> tables = new ArrayList<>();
            for (int t = 1; t <= 5; t++) {
                tables.add(new Table("T" + i + t, String.valueOf(2 + t)));
            }
            Restaurent restaurent = new Restaurent.RestaurentBuilder()
                .setRestaurentId(id)
                .setRestaurentName(name)
                .setRestaurentAddress(address)
                .setRestaurentRating(rating)
                .setTables(tables)
                .build();
            restaurentRepo.addRestaurent(restaurent);
        }

        // Show all restaurants
        List<Restaurent> allRestaurents = restaurentService.getAllRestaurents();
        System.out.println("Available Restaurants:");
        for (Restaurent r : allRestaurents) {
            System.out.println(r.getRestaurentId() + ": " + r.getRestaurentName() + " (Rating: " + r.getRestaurentRating() + ")");
        }

        // Simulate bookings for 3 users
        Scanner scanner = new Scanner(System.in);
        Customer[] customers = {customer1, customer2, customer3};
        for (Customer customer : customers) {
            System.out.println("\n" + customer.getName() + ", choose a restaurant by ID to book:");
            String chosenId = scanner.nextLine();
            Restaurent chosenRestaurent = restaurentService.getRestaurentById(chosenId);
            System.out.println("Available tables:");
            for (Table t : chosenRestaurent.getTables()) {
                System.out.println(t.getTableId() + " (Capacity: " + t.getCapacity() + ")");
            }
            System.out.print("Enter table ID to book: ");
            String tableId = scanner.nextLine();
            System.out.print("Enter booking date (YYYY-MM-DD): ");
            String date = scanner.nextLine();
            System.out.print("Enter booking start time (HH:MM): ");
            String time = scanner.nextLine();
            System.out.print("Enter number of seats required: ");
            int seats = Integer.parseInt(scanner.nextLine());
            String bookingId = UUID.randomUUID().toString();
            try {
                bookingService.createBooking(bookingId, chosenId, tableId, customer.getUserId(), time, date, seats);
                System.out.println("Booking successful for " + customer.getName() + " at " + chosenRestaurent.getRestaurentName());
            } catch (Exception e) {
                System.out.println("Booking failed: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

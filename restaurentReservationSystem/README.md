# Restaurant Reservation System

This is a low-level design (LLD) project for a Restaurant Reservation System implemented in Java. It demonstrates best practices in OOP, design patterns, and modular architecture.

## Features
- Add, update, and delete restaurants
- Add tables to restaurants
- Create, update, cancel, and complete bookings
- Search for available tables by date, time, and capacity
- Booking notifications using the Observer pattern
- Singleton pattern for repositories
- Dependency injection for services and repositories

## Design Patterns Used
- **Builder Pattern:** For constructing complex objects like Booking and Restaurant
- **Singleton Pattern:** For repository classes to ensure a single instance
- **Observer Pattern:** For booking status notifications (e.g., email notifications)
- **Repository Pattern:** For data access abstraction
- **Dependency Injection:** For wiring services and repositories

## Main Components
- `model/` - Domain models (Booking, Restaurant, Table, Customer, etc.)
- `repo/` - Repository interfaces and implementations for data storage
- `service/` - Service interfaces and implementations for business logic
- `observer/` - Observer interfaces and implementations for notifications
- `Runner.java` - Main entry point for running and testing the system

## How to Run
1. **Compile:**
   ```sh
   javac -d out $(find src/main/java -name "*.java")
   ```
2. **Run:**
   ```sh
   java -cp out restaurentReservationSystem.src.main.java.Runner
   ```

## Example Usage
- The system creates sample customers and restaurants.
- Users can interactively choose a restaurant, select a table, and make a booking.
- Booking status changes trigger notifications via the Observer pattern.

## Extensibility
- Easily add new notification types (e.g., SMS) by implementing `BookingObserver`.
- Add new booking strategies using the Strategy pattern.
- Integrate with real databases or external APIs by updating repository implementations.

## Notes
- This project is for educational/demo purposes and uses in-memory data structures.
- For production, add persistence, authentication, and robust error handling.

---

**Author:**
- Designed for LLD interviews and OOP practice.

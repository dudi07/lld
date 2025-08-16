package restaurentReservationSystem.src.main.java.model;

public enum BookingStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    COMPLETED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
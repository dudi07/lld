package restaurentReservationSystem.src.main.java.model;

public class Booking {
    private final String bookingId;
    private final String restaurentId;
    private final String tableId;
    private final String customerId;
    private final String bookingStartTime;
    private final String bookingDate;
    private final BookingStatus status;

    public Booking(String bookingId, String restaurentId, String tableId, String customerId, String bookingStartTime, String bookingDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.restaurentId = restaurentId;
        this.tableId = tableId;
        this.customerId = customerId;
        this.bookingStartTime = bookingStartTime;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public String getBookingId() { return bookingId; }
    public String getRestaurentId() { return restaurentId; }
    public String getTableId() { return tableId; }
    public String getCustomerId() { return customerId; }
    public String getBookingStartTime() { return bookingStartTime; }
    public String getBookingDate() { return bookingDate; }
    public BookingStatus getStatus() { return status; }

    public static class BookingBuilder {
        private String bookingId;
        private String restaurentId;
        private String tableId;
        private String customerId;
        private String bookingStartTime;
        private String bookingDate;
        private BookingStatus status;

        public BookingBuilder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }
        public BookingBuilder setRestaurentId(String restaurentId) {
            this.restaurentId = restaurentId;
            return this;
        }
        public BookingBuilder setTableId(String tableId) {
            this.tableId = tableId;
            return this;
        }
        public BookingBuilder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }
        public BookingBuilder setBookingStartTime(String bookingStartTime) {
            this.bookingStartTime = bookingStartTime;
            return this;
        }
        public BookingBuilder setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }
        public BookingBuilder setStatus(BookingStatus status) {
            this.status = status;
            return this;
        }
        public Booking build() {
            return new Booking(bookingId, restaurentId, tableId, customerId, bookingStartTime, bookingDate, status);
        }
    }
}

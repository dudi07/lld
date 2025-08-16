package restaurentReservationSystem.src.main.java.model;

public class Restaurent {
    private final String restaurentId;
    private final String restaurentName;
    private final String restaurentAddress;
    private final String restaurentPhone;
    private final String restaurentEmail;
    private final String restaurentWebsite;
    private final String restaurentDescription;
    private final String restaurentImage;
    private final String restaurentRating;
    private final java.util.List<Table> tables;

    private Restaurent(RestaurentBuilder builder) {
        this.restaurentId = builder.restaurentId;
        this.restaurentName = builder.restaurentName;
        this.restaurentAddress = builder.restaurentAddress;
        this.restaurentPhone = builder.restaurentPhone;
        this.restaurentEmail = builder.restaurentEmail;
        this.restaurentWebsite = builder.restaurentWebsite;
        this.restaurentDescription = builder.restaurentDescription;
        this.restaurentImage = builder.restaurentImage;
        this.restaurentRating = builder.restaurentRating;
        this.tables = builder.tables;
    }

    // Getter methods only
    public String getRestaurentId() { return restaurentId; }
    public String getRestaurentName() { return restaurentName; }
    public String getRestaurentAddress() { return restaurentAddress; }
    public String getRestaurentPhone() { return restaurentPhone; }
    public String getRestaurentEmail() { return restaurentEmail; }
    public String getRestaurentWebsite() { return restaurentWebsite; }
    public String getRestaurentDescription() { return restaurentDescription; }
    public String getRestaurentImage() { return restaurentImage; }
    public String getRestaurentRating() { return restaurentRating; }
    public java.util.List<Table> getTables() { return tables; }

    @Override
    public String toString() {
        return "Restaurent{" +
                "restaurentId='" + restaurentId + '\'' +
                ", restaurentName='" + restaurentName + '\'' +
                ", restaurentAddress='" + restaurentAddress + '\'' +
                ", restaurentPhone='" + restaurentPhone + '\'' +
                ", restaurentEmail='" + restaurentEmail + '\'' +
                ", restaurentWebsite='" + restaurentWebsite + '\'' +
                ", restaurentDescription='" + restaurentDescription + '\'' +
                ", restaurentImage='" + restaurentImage + '\'' +
                ", restaurentRating='" + restaurentRating + '\'' +
                ", tables=" + tables +
                '}';
    }

    public static class RestaurentBuilder {
        private String restaurentId;
        private String restaurentName;
        private String restaurentAddress;
        private String restaurentPhone;
        private String restaurentEmail;
        private String restaurentWebsite;
        private String restaurentDescription;
        private String restaurentImage;
        private String restaurentRating;
        private java.util.List<Table> tables;

        public RestaurentBuilder setRestaurentId(String restaurentId) {
            this.restaurentId = restaurentId;
            return this;
        }
        public RestaurentBuilder setRestaurentName(String restaurentName) {
            this.restaurentName = restaurentName;
            return this;
        }
        public RestaurentBuilder setRestaurentAddress(String restaurentAddress) {
            this.restaurentAddress = restaurentAddress;
            return this;
        }
        public RestaurentBuilder setRestaurentPhone(String restaurentPhone) {
            this.restaurentPhone = restaurentPhone;
            return this;
        }
        public RestaurentBuilder setRestaurentEmail(String restaurentEmail) {
            this.restaurentEmail = restaurentEmail;
            return this;
        }
        public RestaurentBuilder setRestaurentWebsite(String restaurentWebsite) {
            this.restaurentWebsite = restaurentWebsite;
            return this;
        }
        public RestaurentBuilder setRestaurentDescription(String restaurentDescription) {
            this.restaurentDescription = restaurentDescription;
            return this;
        }
        public RestaurentBuilder setRestaurentImage(String restaurentImage) {
            this.restaurentImage = restaurentImage;
            return this;
        }
        public RestaurentBuilder setRestaurentRating(String restaurentRating) {
            this.restaurentRating = restaurentRating;
            return this;
        }
        public RestaurentBuilder setTables(java.util.List<Table> tables) {
            this.tables = tables;
            return this;
        }
        public Restaurent build() {
            return new Restaurent(this);
        }
    }
}
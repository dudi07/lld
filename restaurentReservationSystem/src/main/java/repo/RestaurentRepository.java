package restaurentReservationSystem.src.main.java.repo;

import restaurentReservationSystem.src.main.java.model.Restaurent;

public interface RestaurentRepository {
    
    void addRestaurent(Restaurent restaurent);
    Restaurent getRestaurentById(String restaurentId);
    void updateRestaurent(Restaurent restaurent);
    void deleteRestaurent(String restaurentId);
    java.util.List<Restaurent> getAllRestaurents();
    java.util.List<Restaurent> searchRestaurentsByName(String name);
    java.util.List<Restaurent> searchRestaurentsByRating(String rating);
    java.util.List<Restaurent> searchRestaurentsByAddress(String address);
}

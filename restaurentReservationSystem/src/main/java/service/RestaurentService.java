package restaurentReservationSystem.src.main.java.service;

import restaurentReservationSystem.src.main.java.model.Restaurent;

public interface RestaurentService {

    void addRestaurent(String restaurentId, String restaurentName, String restaurentRating, String restaurentAddress);
    
    void updateRestaurent(String restaurentId, String restaurentName, String restaurentRating, String restaurentAddress);
    
    void deleteRestaurent(String restaurentId);
    
    Restaurent getRestaurentById(String restaurentId);
    
    java.util.List<Restaurent> getAllRestaurents();
    
    java.util.List<Restaurent> searchRestaurentsByName(String name);
    
    java.util.List<Restaurent> searchRestaurentsByRating(String rating);
    
    java.util.List<Restaurent> searchRestaurentsByAddress(String address);
    
}

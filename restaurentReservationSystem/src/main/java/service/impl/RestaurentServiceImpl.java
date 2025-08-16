package restaurentReservationSystem.src.main.java.service.impl;

import restaurentReservationSystem.src.main.java.model.Restaurent;

public class RestaurentServiceImpl implements restaurentReservationSystem.src.main.java.service.RestaurentService {

    private final restaurentReservationSystem.src.main.java.repo.RestaurentRepository restaurentRepository;

    public RestaurentServiceImpl(restaurentReservationSystem.src.main.java.repo.RestaurentRepository restaurentRepository) {
        this.restaurentRepository = restaurentRepository;
    }

    @Override
    public void addRestaurent(String restaurentId, String restaurentName, String restaurentRating, String restaurentAddress) {
        if (restaurentId == null || restaurentName == null || restaurentRating == null || restaurentAddress == null) {
            throw new IllegalArgumentException("Restaurent details cannot be null");
        }
        Restaurent restaurent = new Restaurent.RestaurentBuilder()
            .setRestaurentId(restaurentId)
            .setRestaurentName(restaurentName)
            .setRestaurentRating(restaurentRating)
            .setRestaurentAddress(restaurentAddress)
            .build();
        restaurentRepository.addRestaurent(restaurent);
    }

    @Override
    public void updateRestaurent(String restaurentId, String restaurentName, String restaurentRating, String restaurentAddress) {
        if (restaurentId == null || restaurentName == null || restaurentRating == null || restaurentAddress == null) {
            throw new IllegalArgumentException("Restaurent details cannot be null");
        }
        Restaurent restaurent = new Restaurent.RestaurentBuilder()
            .setRestaurentId(restaurentId)
            .setRestaurentName(restaurentName)
            .setRestaurentRating(restaurentRating)
            .setRestaurentAddress(restaurentAddress)
            .build();
        restaurentRepository.updateRestaurent(restaurent);
    }

    @Override
    public void deleteRestaurent(String restaurentId) {
        if (restaurentId == null) {
            throw new IllegalArgumentException("Restaurent ID cannot be null");
        }
        restaurentRepository.deleteRestaurent(restaurentId);
    }

    @Override
    public Restaurent getRestaurentById(String restaurentId) {
        if (restaurentId == null) {
            throw new IllegalArgumentException("Restaurent ID cannot be null");
        }
        return restaurentRepository.getRestaurentById(restaurentId);
    }

    @Override
    public java.util.List<Restaurent> getAllRestaurents() {
        return restaurentRepository.getAllRestaurents();
    }

    @Override
    public java.util.List<Restaurent> searchRestaurentsByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return restaurentRepository.searchRestaurentsByName(name);
    }

    @Override
    public java.util.List<Restaurent> searchRestaurentsByRating(String rating) {
        if (rating == null || rating.isEmpty()) {
            throw new IllegalArgumentException("Rating cannot be null or empty");
        }
        return restaurentRepository.searchRestaurentsByRating(rating);
    }

    @Override
    public java.util.List<Restaurent> searchRestaurentsByAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        return restaurentRepository.searchRestaurentsByAddress(address);
    }
    
}

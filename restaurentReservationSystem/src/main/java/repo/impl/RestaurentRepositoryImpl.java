package restaurentReservationSystem.src.main.java.repo.impl;

import java.util.List;
import java.util.Map;

import restaurentReservationSystem.src.main.java.model.Restaurent;
import restaurentReservationSystem.src.main.java.repo.RestaurentRepository;

public class RestaurentRepositoryImpl implements RestaurentRepository {
    private static RestaurentRepositoryImpl instance;
    Map<String, Restaurent> restaurentMap;

    private RestaurentRepositoryImpl() {
        restaurentMap = new java.util.HashMap<>();
    }

    public static synchronized RestaurentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RestaurentRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void addRestaurent(Restaurent restaurent) {
        if (restaurent != null && restaurent.getRestaurentId() != null) {
            if (restaurentMap.containsKey(restaurent.getRestaurentId())) {
                throw new IllegalArgumentException("Restaurent with this ID already exists");
                
            }
            restaurentMap.put(restaurent.getRestaurentId(), restaurent);
        } else {
            throw new IllegalArgumentException("Restaurent or Restaurent ID cannot be null");
        }
    }

    @Override
    public Restaurent getRestaurentById(String restaurentId) {
        if (restaurentId == null || !restaurentMap.containsKey(restaurentId)) {
            throw new IllegalArgumentException("Restaurent with this ID does not exist");
        }
        return restaurentMap.get(restaurentId);
    }

    @Override
    public void updateRestaurent(Restaurent restaurent) {
        if (restaurent == null || restaurent.getRestaurentId() == null) {
            throw new IllegalArgumentException("Restaurent or Restaurent ID cannot be null");
        }
        if (!restaurentMap.containsKey(restaurent.getRestaurentId())) {
            throw new IllegalArgumentException("Restaurent with this ID does not exist");
        }
        restaurentMap.put(restaurent.getRestaurentId(), restaurent);
    }

    @Override
    public void deleteRestaurent(String restaurentId) {
        if (restaurentId == null || !restaurentMap.containsKey(restaurentId)) {
            throw new IllegalArgumentException("Restaurent with this ID does not exist");
        }
        restaurentMap.remove(restaurentId);
    }

    @Override
    public List<Restaurent> getAllRestaurents() {
        return new java.util.ArrayList<>(restaurentMap.values());
    }

    @Override
    public List<Restaurent> searchRestaurentsByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return restaurentMap.values().stream()
                .filter(r -> r.getRestaurentName() != null && r.getRestaurentName().contains(name))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<Restaurent> searchRestaurentsByRating(String rating) {
        if (rating == null || rating.isEmpty()) {
            throw new IllegalArgumentException("Rating cannot be null or empty");
        }
        return restaurentMap.values().stream()
                .filter(r -> r.getRestaurentRating() != null && r.getRestaurentRating().equals(rating))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<Restaurent> searchRestaurentsByAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        return restaurentMap.values().stream()
                .filter(r -> r.getRestaurentAddress() != null && r.getRestaurentAddress().contains(address))
                .collect(java.util.stream.Collectors.toList());
    }
}

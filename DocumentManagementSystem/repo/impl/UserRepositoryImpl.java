package DocumentManagementSystem.repo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DocumentManagementSystem.User;
import DocumentManagementSystem.repo.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    
    // Implementation of UserRepository methods would go here
    // For example, methods to add, remove, or find users in the repository
    Map<String, User> userMap = new HashMap<>();
    @Override
    public void addUser(User user) {
        if (userMap.containsKey(user.getUserId())) {
            throw new IllegalArgumentException("User already exists");
        }
        userMap.put(user.getUserId(), user);
    }

    @Override
    public void removeUser(String userId) {
        if (!userMap.containsKey(userId)) {
            throw new IllegalArgumentException("User does not exist");
        }
        userMap.remove(userId);
    }

    @Override
    public User getUserById(String userId) {
        if (!userMap.containsKey(userId)) {
            throw new IllegalArgumentException("User does not exist");
        }
        return userMap.get(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return List.copyOf(userMap.values());
    }

    @Override
    public boolean userExists(String userId) {
        return userMap.containsKey(userId);
    }

    @Override
    public void updateUser(User user) {
        if (!userMap.containsKey(user.getUserId())) {
            throw new IllegalArgumentException("User does not exist");
        }
        userMap.put(user.getUserId(), user);
    }
}

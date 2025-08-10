package DocumentManagementSystem.service;

import DocumentManagementSystem.User;
import DocumentManagementSystem.repo.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public User getUserById(String userId) {
        return userRepository.getUserById(userId);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}

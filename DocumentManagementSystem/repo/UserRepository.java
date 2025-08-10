package DocumentManagementSystem.repo;

import java.util.List;

import DocumentManagementSystem.User;

public interface UserRepository {
    void addUser(User user);
    void removeUser(String userId);
    User getUserById(String userId);
    List<User> getAllUsers();
    boolean userExists(String userId);
    void updateUser(User user);
}

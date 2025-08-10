package DocumentManagementSystem;

import java.util.UUID;

import DocumentManagementSystem.repo.UserRepository;
import DocumentManagementSystem.repo.impl.UserRepositoryImpl;
import DocumentManagementSystem.service.UserService;


public class DocumentManagementSystem {
    public static void main(String[] args) {
    
        // Initialize the document management system
        System.out.println("Document Management System initialized.");
        
        // Example usage of the system can be added here
        // For instance, creating users, documents, and managing access
        // User user = new User(UUID.randomUUID().toString(), "John Doe", "johndoe@gmail.com");
        // Document document = new Document("doc1", "Sample Document");

        User user = new User(UUID.randomUUID().toString(), "John Doe", "johndoe@gmail.com");
        System.out.println("User created: " + user.getName() + " with ID: " + user.getUserId());
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);

        userService.addUser(user);
        System.out.println("User added to the repository." + userService.getUserById(user.getUserId()).getName());

    }
}

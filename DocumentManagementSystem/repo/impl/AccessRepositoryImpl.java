package DocumentManagementSystem.repo.impl;

import java.util.List;

import DocumentManagementSystem.repo.AccessRepository;

public class AccessRepositoryImpl implements AccessRepository {
    
    @Override
    public void grantAccess(String userId, String documentId) {
        // Implementation for granting access to a document for a user
    }

    @Override
    public void revokeAccess(String userId, String documentId) {
        // Implementation for revoking access to a document for a user
    }

    @Override
    public boolean hasAccess(String userId, String documentId) {
        // Implementation to check if a user has access to a document
        return false; // Placeholder return value
    }

    @Override
    public List<String> getAccessibleDocuments(String userId) {
        // Implementation to get all documents accessible by a user
        return null; // Placeholder return value
    }
    
}

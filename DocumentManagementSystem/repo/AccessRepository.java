package DocumentManagementSystem.repo;

import java.util.List;

public interface AccessRepository {
    void grantAccess(String userId, String documentId);
    
    void revokeAccess(String userId, String documentId);
    
    boolean hasAccess(String userId, String documentId);
    
    List<String> getAccessibleDocuments(String userId);
     
}
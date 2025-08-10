package DocumentManagementSystem.service;


import java.util.List;

import DocumentManagementSystem.repo.AccessRepository;


public class DocumentAccessService {

    private AccessRepository accessRepository;
    public DocumentAccessService(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    public void grantAccess(String userId, String documentId) {
        accessRepository.grantAccess(userId, documentId);
    }

    public void revokeAccess(String userId, String documentId) {
        accessRepository.revokeAccess(userId, documentId);
    }
    public boolean hasAccess(String userId, String documentId) {
        return accessRepository.hasAccess(userId, documentId);
    }
    public List<String> getAccessibleDocuments(String userId) {
        return accessRepository.getAccessibleDocuments(userId);
    }
}

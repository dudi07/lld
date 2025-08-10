package DocumentManagementSystem.repo;

import java.util.List;

import DocumentManagementSystem.Document;

public interface DocumentRepository {
    void addElement(Document element);
    List<Document> getElements();
    Document getElementById(String documentId);    
    void deleteElement(String documentId);
}

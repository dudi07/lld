package DocumentManagementSystem.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import DocumentManagementSystem.Document;
import DocumentManagementSystem.TextElement;
import DocumentManagementSystem.repo.impl.DocumentRepositoryImpl;

public class DocumentCrudService {
    private DocumentRepositoryImpl documentRepository;
    public void createDocument(String title, String content, String authorId) {
        Document document = new Document(UUID.randomUUID().toString(), title, List.of(new TextElement(content)), authorId, LocalDateTime.now().toString(),LocalDateTime.now().toString()) ;
        documentRepository.addElement(document);
    }

    public void deleteDocument(String documentId) {
        documentRepository.deleteElement(documentId);
    }

    public void updateDocument(String documentId, String newContent, String authorId) {
        Document document = documentRepository.getElementById(documentId);
        if (document != null) {
            document.setElements(List.of(new TextElement(newContent)));
            document.setModifiedDate(LocalDateTime.now().toString());
            documentRepository.addElement(document);
        }
    }
}

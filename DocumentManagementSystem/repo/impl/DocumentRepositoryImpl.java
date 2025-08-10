package DocumentManagementSystem.repo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DocumentManagementSystem.Document;
import DocumentManagementSystem.repo.DocumentRepository;

public class DocumentRepositoryImpl implements DocumentRepository{
    Map<String, List<Document>>documentMap = new HashMap<>();

    public DocumentRepositoryImpl() {
        
    }
    public void addElement(Document element) {
        if(documentMap.containsKey(element.getDocumentId())) {
            documentMap.get(element.getDocumentId()).add(element);
        } else {
            List<Document> newList = new ArrayList<>();
            newList.add(element);
            documentMap.put(element.getDocumentId(), newList);
        }
    }

    public List<Document> getElements() {
        return new ArrayList<>(documentMap.values().stream().flatMap(List::stream).toList());
    }

    public Document getElementById(String documentId) {
        return documentMap.getOrDefault(documentId, new ArrayList<>()).stream()
                .findFirst()
                .orElse(null);
    } 
    public void deleteElement(String documentId) {
        documentMap.remove(documentId);
    }
}

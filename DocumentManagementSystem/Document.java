package DocumentManagementSystem;

import java.util.List;

public class Document {
    private String documentId;
    private String title;
    private List<DocumentElement> elements;
    private String authorId;
    private String createdDate;
    private String modifiedDate;

    public Document(String documentId, String title, List<DocumentElement> elements, String authorId, String createdDate, String modifiedDate) {
        this.documentId = documentId;
        this.title = title;
        this.elements = elements;
        this.authorId = authorId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;   
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public List<DocumentElement> getElements() {
        return elements;
    }           
    public void setElements(List<DocumentElement> elements) {
        this.elements = elements;
    }
    public String getAuthorId() {
        return authorId;
    }
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }   
    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;     
    }
    public String getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;  
    }
    public void render() {
        System.out.println("Rendering document: " + title);
        for (DocumentElement element : elements) {
            element.render();
        }
    }
}

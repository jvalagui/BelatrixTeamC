package java.lab.listing.model;

/**
 * Created by daniel on 5/21/16.
 */
public class DocumentType {
    private int documentId;
    private String name;
    private String numbers;

    public DocumentType(int documentId, String name, String numbers) {
        this.documentId = documentId;
        this.name = name;
        this.numbers = numbers;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}

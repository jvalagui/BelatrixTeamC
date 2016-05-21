package main.java.com.lab.examen.beans;

public class DocumentType {


	private int id;
	private String documentTypeName;
	public DocumentType(int id, String documentTypeName) {
		this.id = id;
		this.documentTypeName = documentTypeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocumentTypeName() {
		return documentTypeName;
	}
	public void setDocumentTypeName(String documentTypeName) {
		this.documentTypeName = documentTypeName;
	}
	
	@Override
	public String toString() {
		return "DocumentType [id=" + id + ", documentTypeName="
				+ documentTypeName + "]";
	}
}

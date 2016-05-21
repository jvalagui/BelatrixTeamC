package model;

import java.util.ArrayList;

public class Person {
	private int personId;
	private String personName;
	private int documentType;
	
	

	public Person(int personId, String personName, int documentType) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.documentType = documentType;
	}

	public Person(){
		
	}
	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public int getDocumentType() {
		return documentType;
	}


	public void setDocumentType(int documentType) {
		this.documentType = documentType;
	}


	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", documentType=" + documentType + "]";
	}
	
	
	
	
	
	
}

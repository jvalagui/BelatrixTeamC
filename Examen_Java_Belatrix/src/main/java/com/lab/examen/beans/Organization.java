package main.java.com.lab.examen.beans;

import java.util.Arrays;

public class Organization {

	private int id;
	private String organizationName;
	private String[] personIds;
	
	
	
	public Organization(int id, String organizationName, String[] personIds) {
		this.id = id;
		this.organizationName = organizationName;
		this.personIds = personIds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String[] getPersonIds() {
		return personIds;
	}
	public void setPersonIds(String[] personIds) {
		this.personIds = personIds;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", organizationName="
				+ organizationName + ", personIds="
				+ Arrays.toString(personIds) + "]";
	}
	
	
}

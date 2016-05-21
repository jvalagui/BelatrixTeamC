package model;

import java.util.ArrayList;

public class Organization {
	private int organizationId;
	private String organizationName;
	public Organization(int organizationId, String organizationName) {
		super();
		this.organizationId = organizationId;
		this.organizationName = organizationName;
	}
	public Organization(){
		
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	
	
}

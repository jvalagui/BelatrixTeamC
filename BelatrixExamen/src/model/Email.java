package model;

public class Email {
	private int emailId;
	private String emailName;
	private int personId;
	private int organizationId;
	public Email(int emailId, String emailName, int personId, int organizationId) {
		super();
		this.emailId = emailId;
		this.emailName = emailName;
		this.personId = personId;
		this.organizationId = organizationId;
	}
	public int getEmailId() {
		return emailId;
	}
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	public String getEmailName() {
		return emailName;
	}
	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public Email(){
		
	}
	@Override
	public String toString() {
		return "Email [emailId=" + emailId + ", emailName=" + emailName + ", personId=" + personId + ", organizationId="
				+ organizationId + "]";
	}
	
	
}

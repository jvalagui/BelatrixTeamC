package model;

public class Phone {
	private int phoneId;
	private String phoneNumber;
	private int personId;
	private int operatorId;
	private int organizationId;
	
	public Phone(){
		
	}

	public Phone(int phoneId, String phoneNumber, int personId, int operatorId, int organizationId) {
		super();
		this.phoneId = phoneId;
		this.phoneNumber = phoneNumber;
		this.personId = personId;
		this.operatorId = operatorId;
		this.organizationId = organizationId;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneNumber=" + phoneNumber + ", personId=" + personId + ", operatorId="
				+ operatorId + ", organizationId=" + organizationId + "]";
	}
	
	
	
	
}

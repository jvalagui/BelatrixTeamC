package main.java.com.lab.examen.beans;

public class PhoneOperator {

	private int id;
	private String phoneOperatorName;
	
	
	
	
	public PhoneOperator(int id, String phoneOperatorName) {
		this.id = id;
		this.phoneOperatorName = phoneOperatorName;
	}

	
		
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getPhoneOperatorName() {
		return phoneOperatorName;
	}
	public void setPhoneOperatorName(String phoneOperatorName) {
		this.phoneOperatorName = phoneOperatorName;
	}




	@Override
	public String toString() {
		return "PhoneOperator [id=" + id + ", phoneOperatorName="
				+ phoneOperatorName + "]";
	}
	
	
}

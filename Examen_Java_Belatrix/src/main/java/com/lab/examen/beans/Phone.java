package main.java.com.lab.examen.beans;

import main.java.com.lab.examen.transaction.crudimpl.PhoneOperatorCrud;

public class Phone {

	private int id;
	private String phone;
	private int idPhoneOperator;
	
	private Phone phoneOperator;
	private static PhoneOperatorCrud phoneOperatorService = new PhoneOperatorCrud();


	public Phone(int id, String phone, int idPhoneOperator) {
		this.id = id;
		this.phone = phone;
		this.idPhoneOperator = idPhoneOperator;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIdPhoneOperator() {
		return idPhoneOperator;
	}

	public void setIdPhoneOperator(int idPhoneOperator) {
		this.idPhoneOperator = idPhoneOperator;
	}



	public Phone getPhoneOperator() {
		if(phoneOperator == null){
			phoneOperatorService.read(idPhoneOperator);
		}
		return phoneOperator;
	}



	@Override
	public String toString() {
		return "Phone [id=" + id + ", phone=" + phone + ", idPhoneOperator="
				+ idPhoneOperator +  "]";
	}
	
	
	
	
	
}

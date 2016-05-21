package model;

public class PersonCountry {
	private int idPerson;
	private int idCountry;
	
	
	public PersonCountry(){
		
	}
	public PersonCountry(int idPerson, int idCountry) {
		super();
		this.idPerson = idPerson;
		this.idCountry = idCountry;
	}
	public int getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	public int getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
	
	
}

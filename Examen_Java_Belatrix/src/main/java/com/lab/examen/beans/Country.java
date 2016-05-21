package main.java.com.lab.examen.beans;

public class Country {

	private int id;
	private String countryName;
	
	public Country(int id, String countryName) {
		this.id = id;
		this.countryName = countryName;
	}

	public int getId() {
		return id;
	}

	public void setIdCountry(int idCountry) {
		this.id = idCountry;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + "]";
	}
	
	
	
}

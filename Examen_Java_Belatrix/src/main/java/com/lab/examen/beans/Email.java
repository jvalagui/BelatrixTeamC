package main.java.com.lab.examen.beans;

public class Email {

	private int id;
	private String email;
	

	public Email(int id, String email) {
		this.id = id;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Email [id=" + id + ", email=" + email + "]";
	}
	
	
	
}

package main.java.com.lab.examen.beans;

import java.util.Arrays;
import java.util.List;

import main.java.com.lab.examen.transaction.crudimpl.CountryCrud;
import main.java.com.lab.examen.transaction.crudimpl.DocumentTypeCrud;
import main.java.com.lab.examen.transaction.crudimpl.EmailCrud;
import main.java.com.lab.examen.transaction.crudimpl.PhoneCrud;

public class Person {

	private String dni;
	private String nombre;
	private String apellido;
	private int[] emailIds;
	private int[] phoneIds;
	private int idCountry;
	private int idDocumentType;

	private List<Email> emails;
	private List<Phone> phones;
	private Country country;
	private DocumentType documentType;

	// Servicios
	private static EmailCrud emailService = new EmailCrud();
	private static PhoneCrud phoneService = new PhoneCrud();
	private static CountryCrud countryService = new CountryCrud();
	private static DocumentTypeCrud documentTypeService = new DocumentTypeCrud();

	public Person(String dni, String nombre, String apellido, int[] emailIds,
			int[] phoneIds, int idCountry, int idDocumentType) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.emailIds = emailIds;
		this.phoneIds = phoneIds;
		this.idCountry = idCountry;
		this.idDocumentType = idDocumentType;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int[] getEmailIds() {
		return emailIds;
	}

	public void setEmailIds(int[] emailIds) {
		this.emailIds = emailIds;
	}

	public int[] getPhoneIds() {
		return phoneIds;
	}

	public void setPhoneIds(int[] phoneIds) {
		this.phoneIds = phoneIds;
	}

	public int getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public int getIdDocumentType() {
		return idDocumentType;
	}

	public void setIdDocumentType(int idDocumentType) {
		this.idDocumentType = idDocumentType;
	}

	public List<Email> getEmails() {

		emails = emailService.emailsPerPerson(dni);

		return emails;
	}

	public List<Phone> getPhones() {
		phones = phoneService.emailsPerPerson(dni);
		return phones;
	}

	public Country getCountry() {
		country = countryService.read(idCountry);

		return country;
	}

	public DocumentType getDocumentType() {
		documentType = documentTypeService.read(idDocumentType);

		return documentType;
	}

	@Override
	public String toString() {
		return "Person [dni=" + dni + ", nombre=" + nombre + ", apellido="
				+ apellido + ", emailIds=" + Arrays.toString(emailIds)
				+ ", phoneIds=" + Arrays.toString(phoneIds) + ", idCountry="
				+ idCountry + ", idDocumentType=" + idDocumentType + "]";
	}

}

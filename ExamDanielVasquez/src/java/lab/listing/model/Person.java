package java.lab.listing.model;

/**
 * Created by daniel on 5/21/16.
 */
public class Person {
    private int personId;
    private String name;
    private String apellido;
    private int countryId;
    private int documentId;
    private int phoneId;
    private int emailId;

    public Person(int personId, String name, String apellido, int countryId, int documentId, int phoneId, int emailId) {
        this.personId = personId;
        this.name = name;
        this.apellido = apellido;
        this.countryId = countryId;
        this.documentId = documentId;
        this.phoneId = phoneId;
        this.emailId = emailId;

    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }
}

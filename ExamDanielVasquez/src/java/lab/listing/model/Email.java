package java.lab.listing.model;

/**
 * Created by daniel on 5/21/16.
 */
public class Email {
    private int emailId;
    private String emailName;
    private int personId;

    public Email(int emailId, String emailName, int personId) {
        this.emailId = emailId;
        this.emailName = emailName;
        this.personId = personId;

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
}

package java.lab.listing.model;

/**
 * Created by daniel on 5/21/16.
 */
public class Phone {
    private int phoneId;
    private String name;
    private int personId;
    private int operatorId;

    public Phone(int phoneId, String name, int personId, int operatorId) {
        this.phoneId = phoneId;
        this.name = name;
        this.personId = personId;
        this.operatorId = operatorId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

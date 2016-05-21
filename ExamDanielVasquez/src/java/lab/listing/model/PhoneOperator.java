package java.lab.listing.model;

/**
 * Created by daniel on 5/21/16.
 */
public class PhoneOperator {
    private int operatorId;
    private String name;
    private int phoneId;

    public PhoneOperator(int operatorId, String name, int phoneId) {
        this.operatorId = operatorId;
        this.name = name;
        this.phoneId = phoneId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }
}

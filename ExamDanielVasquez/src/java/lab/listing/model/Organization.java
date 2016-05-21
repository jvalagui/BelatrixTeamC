package java.lab.listing.model;

/**
 * Created by daniel on 5/21/16.
 */
public class Organization {
    private int organizationId;
    private String name;
    private int phoneId;
    private int emailId;

    public Organization(int organizationId, String name, int phoneId, int emailId) {
        this.organizationId = organizationId;
        this.name = name;
        this.phoneId = phoneId;
        this.emailId = emailId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
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

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }
}

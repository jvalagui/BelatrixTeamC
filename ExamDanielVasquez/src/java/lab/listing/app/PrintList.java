package java.lab.listing.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lab.listing.model.Email;
import java.lab.listing.model.Organization;
import java.lab.listing.model.Person;
import java.lab.listing.transaction.daoImpli.EmailDao;
import java.lab.listing.transaction.daoImpli.OrganizationDao;
import java.lab.listing.transaction.daoImpli.PersonDao;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 5/21/16.
 */
public class PrintList {
    List<Person> listPerson = new ArrayList<Person>();
    List<Email> listEmail = new ArrayList<Email>();
    List<Organization> listOrg  = new ArrayList<Organization>();
    OrganizationDao orgDao = new OrganizationDao();
    EmailDao emailDao = new EmailDao();
    PersonDao personDao = new PersonDao();


    public static void main(String[] args) {
        PrintList printList = new PrintList();
        printList.createPersons();
        printList.createEmail();
        printList.createOrg();
        try {

            System.out.println("Want to see the list of organizations");
            System.out.println("Ingrese si o no");
            BufferedReader bufferRead = new BufferedReader(
                    new InputStreamReader(System.in));

            String line = bufferRead.readLine();
            line = line.toUpperCase();

            switch(line){
                case "SI":
                    listarOrganization(printList, bufferRead);
                    break;
                case "NO":
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
                default:
                    System.out.print("Command not recognized");
            }
        }
        catch(Exception e){

        }
    }

    public void createPersons(){
        Person person1 = new Person(1,"Daniel","Vasquez",1,1,1,1);
        Person person2 = new Person(2,"John","Mark",1,1,2,2);

        listPerson.add(person1);
        listPerson.add(person2);
    }

    public void createEmail(){
        Email email1 = new Email(1,"dvasquez@yahoo.com", 1);
        Email email2 = new Email(1,"something@mail.com", 2);

        listEmail.add(email1);
        listEmail.add(email2);
    }

    public void createOrg(){
        Organization organization1 = new Organization(1,"Bela",1,1);
        Organization organization2 = new Organization(1,"Bela",2,2);

        listOrg.add(organization1);
        listOrg.add(organization2);
    }

    public static void listarOrganization(PrintList printList, BufferedReader br){
        printList.orgDao.read().forEach(organization -> System.out.print(organization));
        Email email= null;
        Person person = null;
        try {

            System.out.println("Enter the email id to see more detail");

            String line = br.readLine();

            int id = Integer.valueOf(line);

            printList.emailDao.readIf(id);

            System.out.println(email);

            System.out.println("Enter the person id to see more detail");
            String line2 = br.readLine();
            int id1 = Integer.valueOf(line2);
            printList.personDao.readIf(id1);

            System.out.println(person);
        }
        catch(Exception e){

        }
    }
}

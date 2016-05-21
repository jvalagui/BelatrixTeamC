package main.resources;

import java.util.List;

import main.java.com.lab.examen.beans.Country;
import main.java.com.lab.examen.beans.DocumentType;
import main.java.com.lab.examen.beans.Email;
import main.java.com.lab.examen.beans.Organization;
import main.java.com.lab.examen.beans.Person;
import main.java.com.lab.examen.beans.Phone;
import main.java.com.lab.examen.beans.PhoneOperator;
import main.java.com.lab.examen.transaction.crudimpl.CountryCrud;
import main.java.com.lab.examen.transaction.crudimpl.DocumentTypeCrud;
import main.java.com.lab.examen.transaction.crudimpl.EmailCrud;
import main.java.com.lab.examen.transaction.crudimpl.OrganizationCrud;
import main.java.com.lab.examen.transaction.crudimpl.PersonCrud;
import main.java.com.lab.examen.transaction.crudimpl.PhoneCrud;
import main.java.com.lab.examen.transaction.crudimpl.PhoneOperatorCrud;

public class Initializer {

	PersonCrud personService = new PersonCrud();
	CountryCrud countryService = new CountryCrud();
	DocumentTypeCrud documentTypeService = new DocumentTypeCrud();
	EmailCrud emailService = new EmailCrud();
	OrganizationCrud organizationService = new OrganizationCrud();
	PhoneCrud phoneService = new PhoneCrud();
	PhoneOperatorCrud phoneOperatorService = new PhoneOperatorCrud();
	
	
	public void Initialize(){
		
		documentTypeService.create(new DocumentType(1, "DNI"));
		documentTypeService.create(new DocumentType(2, "Carné de extranjería"));
		documentTypeService.create(new DocumentType(3, "PASSPORT"));
		

		phoneOperatorService.create(new PhoneOperator(1, "MOVISTAR"));
		phoneOperatorService.create(new PhoneOperator(2, "CLARO"));
		phoneOperatorService.create(new PhoneOperator(3, "ENTEL"));
		
		countryService.create(new Country(1, "PERU"));
		countryService.create(new Country(2, "RUSIA"));
		countryService.create(new Country(3, "EEUU"));
		int emailIdIdentity=1, phoneIdIdentity=1;
		for(int i = 0; i<15; i++){
			
			
			
			int[] emailIds = new int[10];
			int[] phoneIds = new int[10];
			
			int length = 0;
			length = (int)((Math.random()*3)+1);
			emailIds = new int[length];
			for(int j=0; j<length;j++){
				emailService.create(new Email(emailIdIdentity, "email."+String.format("%03d", emailIdIdentity)+"@gmail.com"));
				emailIds[j] = emailIdIdentity;
				emailIdIdentity++;
			}
			
			length = (int)((Math.random()*5)+1);
			phoneIds = new int[length];

			for(int j=0;j<length;j++){
				phoneService.create(new Phone(phoneIdIdentity, String.valueOf((long)(Math.random()*90000000)+1000000), (int)(Math.random()*3+1)));
				phoneIds[j]=phoneIdIdentity;
				phoneIdIdentity++;
			}
			
			personService.create(new Person(String.format("%08d", (long)(Math.random()*90000000)+10000000), String.format("%02d", i), String.format("%02d", i), emailIds, phoneIds, (int)(Math.random()*3+1), (int)(Math.random()*3+1)));
			
		}
		
		List<Person> persons = personService.read();
		String[] personIds = new String[persons.size()];
		
		for(int i = 0; i<personIds.length;i++){
			personIds[i] = persons.get(i).getDni();
		}
		
		organizationService.create(new Organization(1, "Organization Examen", personIds));
		
	}
}

package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Country;
import model.DataFiller;
import model.Email;
import model.Organization;
import model.Person;
import model.PersonCountry;
import model.Phone;
import transaction.CountryBehavior;
import transaction.EmailBehavior;
import transaction.OperatorBehavior;
import transaction.OrganizationBehavior;
import transaction.PersonBehavior;
import transaction.PersonCountryBehavior;
import transaction.PhoneBehavior;

public class ExamenApp {
	static EmailBehavior emailBehavior = new EmailBehavior();
	static OrganizationBehavior organizationBehavior = new OrganizationBehavior();
	static PersonBehavior personBehavior = new PersonBehavior();
	static OperatorBehavior operatorBehavior = new OperatorBehavior();
	static PhoneBehavior phoneBehavior = new PhoneBehavior();
	static PersonCountryBehavior personCountryBehavior = new PersonCountryBehavior();
	static CountryBehavior CountryBehavior = new CountryBehavior();
	
	static DataFiller dataFiller = new DataFiller();
	
	public static void main(String[] args) {
		dataFiller.FillData();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("TYPE A COMMAND: PEOPLE BY ORGANIZATION / COUNTRIES BY PHONE OPERATOR / EMAILS BY PHONE OPERATOR");
		String line;
		try {
			line = br.readLine().trim().toUpperCase();
			
			while(true){
				switch (line) {
				case "PEOPLE BY ORGANIZATION":
					System.out.println("TYPE THE ORGANIZATION ID");
					int organizationId = Integer.parseInt(br.readLine().trim());
					System.out.println(peopleByOrganizationId(organizationId));
					break;
				case "COUNTRIES BY PHONE OPERATOR":
					System.out.println("TYPE THE OPERATOR ID");
					int operatorId = Integer.parseInt(br.readLine().trim());
					System.out.println(countriesByOperator(operatorId));
					break;
				case "EMAILS BY PHONE OPERATOR":
					System.out.println("TYPE THE OPERATOR ID");
					int operatorId2 = Integer.parseInt(br.readLine().trim());
					System.out.println(emailsByOperator(operatorId2));
					break;
				default:
					System.out.println("OPERACIÓN DESCONOCIDA");
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR WHILE READING INPUT DATA");
		}
		
	}
	
	public static List<Person> peopleByOrganizationId(int organizationId){
		List<Person> personList = new ArrayList<Person>();
		List<Email> emailList = emailBehavior.read();
		List<Email> filteredEmailList = new ArrayList<Email>();
		
		for(Email emailItem : emailList){
			if(emailItem.getOrganizationId() == organizationId){
				filteredEmailList.add(emailItem);
			}
		}
		for(Email emailItem : filteredEmailList){
			Person person = personBehavior.read(emailItem.getPersonId()-1);
			personList.add(person);
		}
		return personList;
	}
	
	public static List<Country> countriesByOperator(int operatorId){
		List<PersonCountry> personCountryList = new ArrayList<PersonCountry>();
		List<Country> countryList = new ArrayList<Country>();
		List<Person> personList = new ArrayList<Person>();
		List<Phone> phoneList = phoneBehavior.read();
		List<Phone> filteredPhoneList = new ArrayList<Phone>();
		
		for(Phone phoneItem : phoneList){
			if(phoneItem.getOperatorId() == operatorId){
				filteredPhoneList.add(phoneItem);
			}
		}
		
		for(Phone phoneItem : filteredPhoneList){
			Person person = personBehavior.read(phoneItem.getPersonId()-1);
			personList.add(person);
		}
		
		for(Person personItem:personList){
			for(PersonCountry personCountryItem : personCountryBehavior.read()){
				if(personCountryItem.getIdPerson() == personItem.getPersonId()){
					personCountryList.add(personCountryItem);
				}
			}
		}
		
		for(PersonCountry personCountryItem : personCountryList){
			Country country = CountryBehavior.read(personCountryItem.getIdCountry()-1);
			if(!countryList.contains(country)){
				countryList.add(country);
			}
		}
		
		return countryList;
	}
	
	public static List<Email> emailsByOperator(int operatorId){
		List<Email> emailList = new ArrayList<Email>();
		List<Organization> organizationList = new ArrayList<Organization>();
		List<Phone> phoneList = phoneBehavior.read();
		List<Phone> filteredPhoneList = new ArrayList<Phone>();
		
		for(Phone phoneItem : phoneList){
			if(phoneItem.getOperatorId() == operatorId){
				filteredPhoneList.add(phoneItem);
				
			}
		}
		for(Phone phoneItem : filteredPhoneList){
			Organization organization = organizationBehavior.read(phoneItem.getOrganizationId()-1);
			organizationList.add(organization);
		}
		
		for(Organization organizationItem:organizationList){
			for(Email emailItem : emailBehavior.read()){
				if(emailItem.getOrganizationId() == organizationItem.getOrganizationId()){
					emailList.add(emailItem);
				}
			}
		}
		return emailList;
	}
}

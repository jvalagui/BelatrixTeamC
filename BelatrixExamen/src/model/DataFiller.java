package model;

import transaction.CountryBehavior;
import transaction.EmailBehavior;
import transaction.OperatorBehavior;
import transaction.OrganizationBehavior;
import transaction.PersonBehavior;
import transaction.PersonCountryBehavior;
import transaction.PhoneBehavior;

public class DataFiller {

	OrganizationBehavior organizationBehavior = new OrganizationBehavior();
	PersonBehavior personBehavior = new PersonBehavior();
	EmailBehavior emailBehavior = new EmailBehavior();
	OperatorBehavior operatorBehavior = new OperatorBehavior();
	CountryBehavior countryBehavior = new CountryBehavior();
	PersonCountryBehavior personCountryBehavior = new PersonCountryBehavior();
	PhoneBehavior phoneBehavior = new PhoneBehavior();
	
	public  void FillData(){
		organizationBehavior.create(new Organization(1, "Cibertec SA"));
		personBehavior.create(new Person(1, "Juan", 1));
		emailBehavior.create(new Email(1, "juan@hotmail.com", 1, 1));
		countryBehavior.create(new Country(1, "Perú"));
		personCountryBehavior.create(new PersonCountry(1, 1));
		phoneBehavior.create(new Phone(1, "987774444", 1, 1, 1));
	}
	
	
	
}

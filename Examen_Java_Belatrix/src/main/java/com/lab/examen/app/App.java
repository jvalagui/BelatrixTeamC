package main.java.com.lab.examen.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.java.com.lab.examen.transaction.crudimpl.CountryCrud;
import main.java.com.lab.examen.transaction.crudimpl.DocumentTypeCrud;
import main.java.com.lab.examen.transaction.crudimpl.EmailCrud;
import main.java.com.lab.examen.transaction.crudimpl.OrganizationCrud;
import main.java.com.lab.examen.transaction.crudimpl.PersonCrud;
import main.java.com.lab.examen.transaction.crudimpl.PhoneCrud;
import main.java.com.lab.examen.transaction.crudimpl.PhoneOperatorCrud;
import main.resources.Initializer;

public class App {

	PersonCrud personService = new PersonCrud();
	CountryCrud countryService = new CountryCrud();
	DocumentTypeCrud documentTypeService = new DocumentTypeCrud();
	EmailCrud emailService = new EmailCrud();
	OrganizationCrud organizationService = new OrganizationCrud();
	PhoneCrud phoneService = new PhoneCrud();
	PhoneOperatorCrud phoneOperatorService = new PhoneOperatorCrud();
	
	public static void main(String[] args){
		
		App app = new App();
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(System.in));
		
		
		
		try{
			while(true){
				System.out.println("COUNTRY / DOCTYPE / EMAIL / ORG / PERSON / PHONE / PHONEOPERATOR");
				String line = in.readLine();
				line = line.toUpperCase();
				switch(line){
				case"COUNTRY":
					app.countryService.read().forEach(System.out::println);
					break;
				case"DOCTYPE":
					app.documentTypeService.read().forEach(System.out::println);
					break;
				case"EMAIL":
					System.out.println("LIST / PERSON");
					line = in.readLine();
					line = line.toUpperCase();
					switch(line){
					case"LIST":
						app.emailService.read().forEach(System.out::println);
						break;
					case"PERSON":
						System.out.println("INGRESE EL EMAIL");
						line = in.readLine();
						System.out.println(app.personService.readByEmail(line));
						break;
					default:
					}
					
					break;
				case"ORG":
					System.out.println(app.organizationService.read().get(0));
					break;
				case"PERSON":
					System.out.println("LIST / PHONES");
					line = in.readLine();
					line = line.toUpperCase();
					switch(line){
					case"LIST": 
						app.personService.read().forEach(System.out::println);
						break;
					case"PHONES":
						System.out.println("INGRESE DNI");
						line = in.readLine();
						System.out.println(app.personService.read(line).getPhones());
						app.personService.read(line).getPhones().forEach(System.out::println);
						break;
						default:
					}

					break;
				case"PHONE":
					System.out.println("LIST / PERSON");

					line = in.readLine();
					line = line.toUpperCase();
					switch(line){
					case"LIST":
						app.phoneService.read().forEach(System.out::println);
						break;
					case"PERSON":
						System.out.println("INGRESE EL TELEFONO");
						line = in.readLine();
						line = line.toUpperCase();
						System.out.println(app.personService.readByPhone(line));
						break;
					default:break;
					}

					break;
				case"PHONEOPERATOR":
					app.phoneOperatorService.read().forEach(System.out::println);
					break;
				default:
					System.out.println("oops");
					break;
				}
			}
		}catch(Exception e){
			
		}
		
	}
	
	public App(){
		Initializer initializer = new Initializer();
		
		initializer.Initialize();
		
		System.out.println(organizationService.read(1));
		
		
		
		
		
	}
}

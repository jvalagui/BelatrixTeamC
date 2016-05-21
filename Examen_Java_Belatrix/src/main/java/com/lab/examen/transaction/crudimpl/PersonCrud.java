package main.java.com.lab.examen.transaction.crudimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.examen.beans.Email;
import main.java.com.lab.examen.beans.Person;
import main.java.com.lab.examen.beans.Phone;

public class PersonCrud{

private static List<Person> list = new ArrayList<Person>();
	
	
	public void create(Person person) {
		list.add(person);	
	}

	
	public void update(Person person) {
		for(Person item : list){
			if(item.getDni()==person.getDni()){
				list.set(list.indexOf(item), person);
			}
		}
		
	}
	
	public List<Person> read() {
		return list;
	}

	public Person read(String dni){
		for(Person item : list){
			if(item.getDni()==dni){
				return item;
			}
		}
		
		return null;
	}
	
	public void delete(String dni){
		for(Person item : list){
			if(item.getDni() == dni){
				list.remove(item);
			}
		}
	}
	
	public Person readByPhoneId(int phoneId){
		for(Person item : list){
			int[] phoneIds = item.getPhoneIds();
			
			for(Integer intItem : phoneIds){
				if(intItem==phoneId){
					return item;
				}
			}
			
		}
		
		return null;
	}
	
	public Person readByEmailId(int emailId){
		for(Person item : list){
			int[] emailIds = item.getEmailIds();
			
			for(Integer intItem : emailIds){
				if(intItem==emailId){
					return item;
				}
			}
			
		}
		
		return null;
	}
	
	public Person readByPhone(String phone){
		for(Person item : list){
			List<Phone> phones = item.getPhones();
			
			for(Phone phoneItem : phones){
				if(phoneItem.getPhone().equals(phone)){
					return item;
				}
			}
			
		}
		
		return null;
	}
	
	public Person readByEmail(String email){
		for(Person item : list){
			List<Email> emails = item.getEmails();
			
			for(Email emailItem : emails){
				if(emailItem.getEmail().equals(email)){
					return item;
				}
			}
			
		}
		
		return null;
	}
}

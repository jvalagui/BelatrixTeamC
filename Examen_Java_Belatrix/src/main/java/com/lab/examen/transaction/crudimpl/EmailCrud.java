package main.java.com.lab.examen.transaction.crudimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.examen.beans.Email;
import main.java.com.lab.examen.beans.Person;
import main.java.com.lab.examen.transaction.crud.Crud;

public class EmailCrud implements Crud<Email>{

	private static List<Email> list = new ArrayList<Email>();
	private PersonCrud personService = new PersonCrud();
	
	
	@Override
	public void create(Email email) {
		list.add(email);	
	}

	@Override
	public void update(Email email) {
		for(Email item : list){
			if(item.getId()==email.getId()){
				list.set(list.indexOf(item), email);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(Email item : list){
			if(item.getId() == id){
				list.remove(item);
			}
		}
		
	}

	@Override
	public Email read(int id) {
		
		for(Email item : list){
			if(item.getId()==id){
				return item;
			}
		}
		
		return null;
	}

	@Override
	public List<Email> read() {
		return list;
	}

	
	public List<Email> emailsPerPerson(String dni){
		Person person = personService.read(dni);
		if(person != null){
			List<Email> personEmails = new ArrayList<Email>();
			
			for(Integer itemId : person.getEmailIds()){
				Email email = read(itemId);
				if(email!=null){
					personEmails.add(email);
				}
			}
			
			return personEmails;
		}
		return null;
	}
	
}

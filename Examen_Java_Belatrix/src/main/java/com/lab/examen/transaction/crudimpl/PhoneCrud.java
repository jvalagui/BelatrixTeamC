package main.java.com.lab.examen.transaction.crudimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.examen.beans.Phone;
import main.java.com.lab.examen.beans.Person;
import main.java.com.lab.examen.transaction.crud.Crud;

public class PhoneCrud implements Crud<Phone>{


	private static List<Phone> list = new ArrayList<Phone>();
	private PersonCrud personService = new PersonCrud();
	
	
	@Override
	public void create(Phone phone) {
		list.add(phone);	
	}

	@Override
	public void update(Phone phone) {
		for(Phone item : list){
			if(item.getId()==phone.getId()){
				list.set(list.indexOf(item), phone);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(Phone item : list){
			if(item.getId() == id){
				list.remove(item);
			}
		}
		
	}

	@Override
	public Phone read(int id) {
		
		for(Phone item : list){
			if(item.getId()==id){
				return item;
			}
		}
		
		return null;
	}

	@Override
	public List<Phone> read() {
		return list;
	}

	
	public List<Phone> emailsPerPerson(String dni){
		
		Person person = personService.read(dni);
		
		if(person != null){
			List<Phone> personPhones = new ArrayList<Phone>();
			
			for(Integer itemId : person.getPhoneIds()){
				Phone phone = read(itemId);
				if(phone!=null){
					personPhones.add(phone);
				}
			}
			
			return personPhones;
		}
		return null;
	}
}

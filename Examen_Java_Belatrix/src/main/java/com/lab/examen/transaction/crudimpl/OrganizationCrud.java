package main.java.com.lab.examen.transaction.crudimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.examen.beans.Organization;
import main.java.com.lab.examen.transaction.crud.Crud;

public class OrganizationCrud implements Crud<Organization>{

	private static List<Organization> list = new ArrayList<Organization>();
	
	@Override
	public void create(Organization organization) {
		list.add(organization);	
	}

	@Override
	public void update(Organization organization) {
		for(Organization item : list){
			if(item.getId()==organization.getId()){
				list.set(list.indexOf(item), organization);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(Organization item : list){
			if(item.getId() == id){
				list.remove(item);
			}
		}
		
	}

	@Override
	public Organization read(int id) {
		
		for(Organization item : list){
			if(item.getId()==id){
				return item;
			}
		}
		
		return null;
	}

	@Override
	public List<Organization> read() {
		return list;
	}

}

package main.java.com.lab.examen.transaction.crudimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.examen.beans.Country;
import main.java.com.lab.examen.transaction.crud.Crud;

public class CountryCrud implements Crud<Country>{

	private static List<Country> list = new ArrayList<Country>();
	
	@Override
	public void create(Country country) {
		list.add(country);	
	}

	@Override
	public void update(Country country) {
		for(Country item : list){
			if(item.getId()==country.getId()){
				list.set(list.indexOf(item), country);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(Country item : list){
			if(item.getId() == id){
				list.remove(item);
			}
		}
		
	}

	@Override
	public Country read(int id) {
		
		for(Country item : list){
			if(item.getId()==id){
				return item;
			}
		}
		
		return null;
	}

	@Override
	public List<Country> read() {
		return list;
	}
	
}

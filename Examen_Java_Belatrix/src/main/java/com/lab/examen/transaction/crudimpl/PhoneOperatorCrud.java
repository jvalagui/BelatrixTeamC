package main.java.com.lab.examen.transaction.crudimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.examen.beans.PhoneOperator;
import main.java.com.lab.examen.transaction.crud.Crud;

public class PhoneOperatorCrud implements Crud<PhoneOperator>{

	private static List<PhoneOperator> list = new ArrayList<PhoneOperator>();
	
	@Override
	public void create(PhoneOperator phoneOperator) {
		list.add(phoneOperator);	
	}

	@Override
	public void update(PhoneOperator phoneOperator) {
		for(PhoneOperator item : list){
			if(item.getId()==phoneOperator.getId()){
				list.set(list.indexOf(item), phoneOperator);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(PhoneOperator item : list){
			if(item.getId() == id){
				list.remove(item);
			}
		}
		
	}

	@Override
	public PhoneOperator read(int id) {
		
		for(PhoneOperator item : list){
			if(item.getId()==id){
				return item;
			}
		}
		
		return null;
	}

	@Override
	public List<PhoneOperator> read() {
		return list;
	}
}

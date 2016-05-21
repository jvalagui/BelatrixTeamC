package main.java.com.lab.examen.transaction.crudimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.examen.beans.DocumentType;
import main.java.com.lab.examen.transaction.crud.Crud;

public class DocumentTypeCrud implements Crud<DocumentType>{

	private static List<DocumentType> list = new ArrayList<DocumentType>();
	
	@Override
	public void create(DocumentType docType) {
		list.add(docType);	
	}

	@Override
	public void update(DocumentType docType) {
		for(DocumentType item : list){
			if(item.getId()==docType.getId()){
				list.set(list.indexOf(item), docType);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(DocumentType item : list){
			if(item.getId() == id){
				list.remove(item);
			}
		}
		
	}

	@Override
	public DocumentType read(int id) {
		
		for(DocumentType item : list){
			if(item.getId()==id){
				return item;
			}
		}
		
		return null;
	}

	@Override
	public List<DocumentType> read() {
		return list;
	}

}

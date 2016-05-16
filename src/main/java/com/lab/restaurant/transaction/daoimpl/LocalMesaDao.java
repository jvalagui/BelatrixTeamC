package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class LocalMesaDao implements DaoManager<Mesa>{
	private static List<Mesa> lista = new ArrayList<Mesa>();

	@Override
	public void create(Mesa mesa){
		lista.add(mesa);
	}
	
	@Override
	public List<Mesa> read(){
		return lista;
	}
	
	@Override
	public Mesa read(int id){
		Mesa mesa = null;
		for(Mesa reg : lista){
			if(reg.getId() == id){
				mesa = reg;
			}
		}
		return mesa;
	}
	
	@Override
	public void update(Mesa mesa){
		for(Mesa reg : lista){
			if(reg.getId() == mesa.getId()){
				lista.set(lista.indexOf(reg), mesa);
			}
		}
	}
	
	@Override
	public void delete(int id){
		for(Mesa reg : lista){
			if(reg.getId() == id){
				lista.remove(reg);
			}
		}
	}

}

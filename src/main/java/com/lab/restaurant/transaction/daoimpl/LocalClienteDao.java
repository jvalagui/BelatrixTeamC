package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class LocalClienteDao implements DaoManager<Cliente>{
	private  List<Cliente> lista = new ArrayList<Cliente>();

	@Override
	public void create(Cliente cliente){
		lista.add(cliente);
	}
	
	public List<Cliente> read(){
		return lista;
	}
	
	@Override
	public Cliente read(int id){
		Cliente cliente = null;
		
		for(Cliente reg: lista){
			if(reg.getId() == id){
				cliente = reg;
			}
		}
		return cliente;
	}
	
	@Override
	public void update(Cliente cliente){
		for(Cliente reg : lista){
			if(reg.getId() == cliente.getId()){
				lista.set(lista.indexOf(reg), cliente);
			}
		}
	}
	
	@Override
	public void delete(int id){
		for(Cliente reg: lista){
			if(reg.getId() == id){
				lista.remove(reg);
			}
		}
	}

}

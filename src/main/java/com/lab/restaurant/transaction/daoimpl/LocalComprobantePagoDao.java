package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.ComprobantePago;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class LocalComprobantePagoDao implements DaoManager<ComprobantePago>{
	private static List<ComprobantePago> lista = new ArrayList<ComprobantePago>();

	@Override
	public List<ComprobantePago> read(){
		return lista;
	}

	@Override
	public ComprobantePago read(int id) {
		ComprobantePago comprobantePago = null;
		for(ComprobantePago reg : lista){
			if(reg.getId() == id){
				comprobantePago = reg;
			}
		}
		return comprobantePago;
	}

	@Override
	public void create(ComprobantePago comprobantePago) {
		lista.add(comprobantePago);
	}

	@Override
	public void update(ComprobantePago comprobantePago) {
		for(ComprobantePago reg : lista){
			if(reg.getId() == comprobantePago.getId()){
				lista.set(lista.indexOf(reg), comprobantePago);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(ComprobantePago reg : lista){
			if(reg.getId() == id){
				lista.remove(reg);
			}
		}
		
	}

}

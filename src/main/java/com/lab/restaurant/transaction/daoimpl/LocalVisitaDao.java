package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class LocalVisitaDao implements DaoManager<Visita> {
	private static List<Visita> lista = new ArrayList<Visita>();

	@Override
	public List<Visita> read() {
		return lista;
	}
	
	@Override
	public Visita read(int id) {
		Visita visita = null;
		for(Visita v : read()){
			if(v.getId() == id){
				visita = v;
			}
		}
		return visita;
	}
	
	@Override
	public void create(Visita visita) {	
		lista.add(visita);
	}
	
	@Override
	public void update(Visita visita) {	
		for(Visita reg : lista){
			if(reg.getId() == visita.getId()){
				lista.set(lista.indexOf(reg), visita);
			}
		}
	}
	
	@Override
	public void delete(int id) { //Visita visita?
		for(Visita reg : lista){
			if(reg.getId() == id){
				lista.remove(reg);
			}
		}
	}
}

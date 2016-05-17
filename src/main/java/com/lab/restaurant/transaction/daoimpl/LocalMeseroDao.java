package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;
import main.java.com.lab.restaurant.transaction.services.MesaService;

public class LocalMeseroDao implements DaoManager<Mesero>{
	private static List<Mesero> lista = new ArrayList<Mesero>();
	private MesaService mesaService = new MesaService();
	
	@Override
	public List<Mesero> read(){
		return lista;
	}
	
	@Override
	public void create(Mesero mesero){
		try{
			lista.add(mesero);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public Mesero read(int id){
		Mesero mesero = null;
		for(Mesero reg : lista){
			if(reg.getId() == id){
				mesero = reg;
			}
		}
		return mesero;
	}
	
	@Override
	public void update(Mesero mesero){
		try{
			for(Mesero reg : lista){
				if(reg.getId() == mesero.getId()){
					lista.set(lista.indexOf(reg), mesero);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int id){
		try{
			for(Mesero reg : lista){
				if(reg.getId() == id){
					lista.remove(reg);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

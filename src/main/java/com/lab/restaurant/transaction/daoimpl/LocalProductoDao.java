package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.transaction.dao.DaoManager;

public class LocalProductoDao implements DaoManager<Producto>{

	private static List<Producto> lista = new ArrayList<Producto>();
	@Override
	public void create(Producto meal){
        try{
            lista.add(meal);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	@Override
    public Producto read(int id){
        Producto registro = null;
        for(Producto meal : lista){
            if(meal.getId()==id){
                registro = meal;
            }
        }
        return registro;
    }

	@Override
    public void update(Producto registro){
        try{
            for(Producto meal : lista){
                if(meal.getId()==registro.getId()){
                    lista.set(lista.indexOf(meal), registro);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	@Override
    public void delete(int id){
        try{
            for(Producto meal : lista){
                if(meal.getId() == id){
                    lista.remove(meal);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	@Override
	public List<Producto> read() {
		return lista;
	}

}

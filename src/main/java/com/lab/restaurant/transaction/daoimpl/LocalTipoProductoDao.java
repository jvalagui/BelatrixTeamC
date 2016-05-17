package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.com.lab.restaurant.model.TipoProducto;

public class LocalTipoProductoDao {

private static Map<Integer, TipoProducto> mapaTipos = mapaTipos();
	
	private static Map<Integer, TipoProducto> mapaTipos(){
		Map<Integer, TipoProducto> mapa = new HashMap<Integer, TipoProducto>();
		
		mapa.put(1, new TipoProducto(1, "Preparado"));
		mapa.put(2, new TipoProducto(2, "Envasado"));
		
		return mapa;
	}
	
	public ArrayList<TipoProducto> read(){
		return new ArrayList<TipoProducto>(mapaTipos.values());
	}
	
	public TipoProducto read(int id){
		return mapaTipos.get(id);
	}
}

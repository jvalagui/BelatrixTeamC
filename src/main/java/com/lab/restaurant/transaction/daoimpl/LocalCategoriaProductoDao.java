package main.java.com.lab.restaurant.transaction.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.com.lab.restaurant.model.CategoriaProducto;

public class LocalCategoriaProductoDao {

	private static Map<Integer, CategoriaProducto> mapaCategorias = mapaCategorias();
	
	private static Map<Integer, CategoriaProducto> mapaCategorias(){
		Map<Integer, CategoriaProducto> mapa = new HashMap<Integer, CategoriaProducto>();
		
		mapa.put(1, new CategoriaProducto(1, "Comida"));
		mapa.put(2, new CategoriaProducto(2, "Bebida"));
		
		return mapa;
	}
	
	public ArrayList<CategoriaProducto> read(){
		return new ArrayList<CategoriaProducto>(mapaCategorias.values());
	}
	
	public CategoriaProducto read(int id){
		return mapaCategorias.get(id);
	}
	
}

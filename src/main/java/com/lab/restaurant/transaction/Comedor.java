package main.java.com.lab.restaurant.transaction;

import java.util.ArrayList;
import java.util.List;

import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.services.MesaService;
import main.java.com.lab.restaurant.transaction.services.MeseroService;
import main.java.com.lab.restaurant.transaction.services.ProductoService;
import main.java.com.lab.restaurant.transaction.services.VisitaService;
import main.java.com.lab.restaurant.utils.Carrito;
import main.java.com.lab.restaurant.utils.Pedidos;

public class Comedor{
	MesaService mesaService = new MesaService();
	MeseroService meseroService = new MeseroService();
	VisitaService visitaService = new VisitaService();
	ProductoService productoService = new ProductoService();
	static Pedidos pedidosVisitas = new Pedidos();

	private List<Mesa> listaMesas = mesaService.read();
	private List<Mesero> listaMeseros = meseroService.read();
	
	public boolean lleno(){
		boolean lleno = true;
		for(Mesa mesa : listaMesas){
			if(mesa.isUsada()==false){ lleno = false;}
		}
		return lleno;
	}
	
	public List<Mesa> getMesasDisponibles(){
		return mesaService.getMesasDisponibles();
	}
	
	public Mesa obtenerMesaDisponible(){
		return mesaService.obtenerMesaDisponible();
	}
	
	
	public List<Mesero> getMeserosDisponibles(){
		
		List<Mesero> disponibles = new ArrayList<>();
		
		for(Mesero mesero : listaMeseros){
			if(!mesero.isDisponible()){
				disponibles.add(mesero);
			}
		}
		
		return disponibles;
	}
	
	public Mesa asignarMesa(Visita visita){
		
		if(mesaService.obtenerMesaDisponible()==null){
			return null;
		}
		
		int idMesa = mesaService.obtenerMesaDisponible().getId();
		
		Mesa mesa = mesaService.read(idMesa);
		mesa.setUsada(true);
		visita.setIdMesa(idMesa);
		
		return mesa;
	}
	
	public boolean asignarMesero(int idMesero, int idVisita){
		if(visitaService.cantidadAtendidasPorMesero(idMesero) < Mesero.LIMITE_MESAS){
			Visita visita = visitaService.read(idVisita);
			visita.setIdMesero(idMesero);
			return true;
		}else{
			System.out.println("El mesero ya llegó a su límite de mesas");
			return false;
		}
		
	}
			
	public void despedirVisita(Visita visita){
		Mesa mesa = mesaService.read(visita.getIdMesa());
		mesa.setUsada(false);
	}
	
	// Determina si un producto existe en el inventario o si existe la cantidad suficiente de este
	public int productoDisponible(int idProducto, int cantidadRequerida){
		int disponible = -1;
		Producto producto = productoService.read(idProducto); 
		if(producto == null){
			return disponible;
		}
		if(producto.getStock()-cantidadRequerida < 0){
			disponible = 0;
		}else{
			disponible = 1;
		}
		return disponible;
	}
	
	public void agregarProductoACarritoDeVisita(int idVisita, int idProducto, int cantidad){
		Carrito carrito = null;
		if(pedidosVisitas.containsKey(idVisita)){
			if((carrito = pedidosVisitas.get(idVisita)).containsKey(idProducto)){
				modificarProductoDeCarritoDeVisita(idVisita, idProducto, cantidad);
			}else{
				agregarProductoACarrito(idVisita, idProducto, cantidad, carrito);
			}
		}else{
			carrito = new Carrito();
			agregarProductoACarrito(idVisita, idProducto, cantidad, carrito);
		}
	}

	private void agregarProductoACarrito(int idVisita, int idProducto, int cantidad, Carrito carrito) {
		carrito.put(idProducto, cantidad);
		pedidosVisitas.put(idVisita, carrito);
	}
	
	public void modificarProductoDeCarritoDeVisita(int idVisita, int idProducto, int cantidad){
		Carrito carrito = pedidosVisitas.get(idVisita);
		carrito.replace(idProducto, cantidad);
	}
	
	public void eliminarProductoDeCarritoDeVisita(int idVisita, int idProducto){
		Carrito carrito = pedidosVisitas.get(idVisita);
		carrito.remove(idProducto);
	}
}

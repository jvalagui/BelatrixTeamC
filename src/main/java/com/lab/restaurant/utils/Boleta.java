package main.java.com.lab.restaurant.utils;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;


import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.model.Producto;
import main.java.com.lab.restaurant.model.Venta;
import main.java.com.lab.restaurant.model.Venta_Detalle;
import main.java.com.lab.restaurant.model.Visita;
import main.java.com.lab.restaurant.transaction.services.ClienteService;
import main.java.com.lab.restaurant.transaction.services.MesaService;
import main.java.com.lab.restaurant.transaction.services.MeseroService;
import main.java.com.lab.restaurant.transaction.services.ProductoService;
import main.java.com.lab.restaurant.transaction.services.VisitaService;


public class Boleta {

	private Venta venta;
	private List<Venta_Detalle> venta_detalle;
	private Cliente cliente;
	private Visita visita;
	private Mesa mesa;
	private Mesero mesero;
	
	//Servicios
	private ClienteService clienteService = new ClienteService();
	private VisitaService visitaService = new VisitaService();
	private MeseroService meseroService = new MeseroService();
	private MesaService mesaService = new MesaService();
	private ProductoService productoService = new ProductoService();
	
	public Boleta(Venta venta, List<Venta_Detalle> venta_detalle) {
		this.venta = venta;
		this.venta_detalle = venta_detalle;
		visita = visitaService.read(venta.getIdVisita());
		cliente = clienteService.read(visita.getIdCliente());
		mesero = meseroService.read(visita.getIdMesero());
		mesa = mesaService.read(visita.getIdMesa());
	}

	public Venta getVenta() {
		return venta;
	}

	public List<Venta_Detalle> getVenta_detalle() {
		return venta_detalle;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public void setVenta_detalle(List<Venta_Detalle> venta_detalle) {
		this.venta_detalle = venta_detalle;
	}
	
	@Override
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		Consumer<Object> appender = (linea) -> {
				buffer.append(linea+"\n");
		};
		
		appender.accept("Boleta de venta N° : "+venta.getNumeroVenta());
		appender.accept("Fecha              : "+dateFormat(venta.getFechaVenta()));
		appender.accept("DNI del cliente    : "+cliente.getDni());
		appender.accept("Nombre del cliente : "+cliente.getNombre()+" "+cliente.getApellidoPaterno());
		appender.accept("Mesero             : "+mesero.getNombre()+" "+mesero.getApellidoPaterno());
		appender.accept("Mesa               : "+mesa.getId());
		appender.accept("");
		appender.accept("DETALLE DE VENTA");
		appender.accept("Item \tNombre \tCantidad \tSubtotal");
		
		
		int[] nroItem = {0};
		
		venta_detalle.forEach(item -> {
			
			String linea = "";
			nroItem[0]++;
			Producto producto = productoService.read(item.getIdProducto());
			double subtotal = producto.getPrecio()*item.getCantidad();
			
			linea+=(nroItem[0])+"\t"+producto.getNombre()+"\t"+item.getCantidad()+"\t"+subtotal;
			appender.accept(linea);
			
		});
		
		appender.accept("\t\tTotal\t"+venta.getTotalVenta());
		
		return buffer.toString();
	}
	
	private String dateFormat(Date myDate){
		return Helper.dateFormat(myDate);
	}
}

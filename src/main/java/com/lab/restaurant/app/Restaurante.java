package main.java.com.lab.restaurant.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.java.com.lab.restaurant.model.Cliente;
import main.java.com.lab.restaurant.model.Mesa;
import main.java.com.lab.restaurant.model.Mesero;
import main.java.com.lab.restaurant.transaction.Recepcion;
import main.java.com.lab.restaurant.transaction.services.ClienteService;
import main.java.com.lab.restaurant.transaction.services.MesaService;
import main.java.com.lab.restaurant.transaction.services.MeseroService;
import main.java.com.lab.restaurant.transaction.services.VisitaService;
import main.test.Inicializador;

public class Restaurante {

	ClienteService clienteService = new ClienteService();
	VisitaService visitaService = new VisitaService();
	MeseroService meseroService = new MeseroService();
	MesaService mesaService = new MesaService();
	Recepcion recepcion = new Recepcion();

	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante();
		try {
			
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			while (true) {
				System.out.println("INGRESE UN COMANDO: VISITA / CLIENTE / MESERO / MESA / SALA ESPERA / SALIR");
				String line = bufferRead.readLine(); 
				line = line.toUpperCase();

				switch (line) {
					case "SALA ESPERA":
						System.out.println(restaurante.recepcion.getSalaDeEspera());
						break;
						
					case "VISITA":
						System.out.println("Visita -> NUEVO / DESPEDIR / LISTAR / NO ASIGNADAS / SALIR");
						ejecutarVisita(restaurante, bufferRead);
						break;
						
					case "CLIENTE":
						System.out.println("Cliente -> NUEVO / LISTAR / SALIR");
						ejecutarCliente(restaurante, bufferRead);
						break;
						
					case "MESERO":
						System.out.println("MESERO -> LISTAR / SALIR");
						ejecutarMesero(restaurante, bufferRead);
						break;
						
					case "MESA":
						System.out.println("MESA -> LISTAR / SALIR");
						ejecutarMesa(restaurante, bufferRead);
						break;
						
					case "SALIR":
						System.out.println("CHAU");
						System.exit(0);
						break;
						
					default:
						System.out.println("Comando desconocido.");
						break;
				}

			}
		} catch (Exception e) {

		}
	}

	public Restaurante() {
		System.out.println("HOLA!");
		Inicializador inicializador = new Inicializador();

		inicializador.inicializar();
		
		for (int i = 0; i < 10; i++) {
			recepcion.generarVisita(0,i + 1, "12345678",
					"Cliente " + String.format("%02d", i + 1), "ApePat", "ApeMat");
		}
		
		
		int cantidadMeseros = meseroService.read().size(), cantidadMesas = mesaService
				.read().size(), cantidadClientes = clienteService.read().size();
		System.out.println("He inicializado:\n" + cantidadMeseros+ " meseros,\n"
				+ cantidadMesas + " mesas,\n"
				+ cantidadClientes + " clientes.\n"
				+ "Los meseros pueden atender como maximo "
				+ Mesero.LIMITE_MESAS + " mesas.\n");

		

		System.out.println("He generado y asignado "
				+ visitaService.read().size() + " visitas.");
	}

	public static void ejecutarVisita(Restaurante restaurante, BufferedReader br)
			throws IOException {
		String linea = br.readLine(); linea = linea.toUpperCase();

		switch (linea) {
			case "LISTAR":
				System.out.println("Lista de Visitas");
	
				restaurante.visitaService.read().forEach(
						visita -> {
							System.out.println(visita);
							Mesa mesa = restaurante.mesaService.read(visita
									.getIdMesa());
							if(mesa!=null){System.out.println(restaurante.meseroService.read(visita
									.getIdMesero()));}
							
							System.out.println();
						});
				break;
			case "NUEVO":
				System.out.println("Ingrese los datos de la visita (IdVisita, IdCliente, ,DNI(Opcional), NombreCliente(Opcional), ApePat(Opcional), ApeMat(Opcional. Si el id del cliente ya esta registrado, se generara la visita con ese cliente.\n"
						+ "Si no desea escribir un id de visita, digite \"0\"\n"
						+ "Ejemplo: 0, 14, 12345678, Juanito, Torres, Moreno");
				linea = br.readLine();
				try{
					String[] datos = linea.split(",");
					if(datos.length<2){throw new Exception();}
					
					if(datos.length<3){
						if(restaurante.clienteService.read(Integer.valueOf(datos[1].trim()))==null){throw new Exception();}
						restaurante.recepcion.generarVisita(Integer.valueOf(datos[0].trim()), Integer.valueOf(datos[1].trim()));
					}else{
						restaurante.recepcion.generarVisita(Integer.valueOf(datos[0].trim()), Integer.valueOf(datos[1].trim()), datos[2].trim(), datos[3].trim(), datos[4].trim(), datos[5].trim());
					}
					
					System.out.println("Visita generada.");
					
					
				}catch(Exception e){
					System.out.println("Error al registrar visita. Compruebe que los datos sean ingresados correctamente.");
				}
				break;
			case "DESPEDIR":
				System.out.println("Ingrese el id de la visita");
				linea = br.readLine();
				int id = Integer.valueOf(linea);
	
				while (!restaurante.recepcion.despedirVisita(id)) {
					System.out.println("Id incorrecto, o visita ya fue despedida. Ingrese otro Id.");
					linea = br.readLine();
					id = Integer.valueOf(linea);
				}
				System.out.println("Visita despedida");
				break;
			
			case "NO ASIGNADAS":
				System.out.println("Visitas no asignadas");
				if(restaurante.visitaService.noAsignadas().isEmpty()){
					System.out.println("No hay visitas asignadas.\n");
				}
				restaurante.visitaService.noAsignadas().forEach(System.out::println);
				break;
			default:
				System.out.println("Comando incorrecto");
			case "SALIR":
				System.out.println("Saliendo..\n");
				break;
		}
	}

	public static void ejecutarCliente(Restaurante restaurante,
			BufferedReader br) throws IOException {
		String linea = br.readLine(); linea = linea.toUpperCase();

		switch (linea) {
			case "LISTAR":
				restaurante.clienteService.read().forEach(System.out::println);
				break;
			case "NUEVO":
				
				System.out.println("Ingrese los datos del cliente, separados por coma (id, nombre):\n"
						+ "Ejemplo: 1, Carlos");
				linea = br.readLine();
				
				try{
					
					String datos[] = linea.split(",");
					restaurante.clienteService.create(new Cliente(Integer.valueOf(datos[0].trim()), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim()));
					System.out.println("Cliente registrado");
					
				}catch(Exception e){
					System.out.println("Error al registrar cliente. Verifique que los datos esten ingresados correctamente.");
				}
				break;
			default:
				System.out.println("Comando incorrecto");
			case "SALIR":
				System.out.println("Saliendo..\n");
				break;

		}
	}

	public static void ejecutarMesero(Restaurante restaurante,
			BufferedReader br) throws IOException {
		String linea = br.readLine(); linea = linea.toUpperCase();

		switch (linea) {
			case "LISTAR":
				restaurante.meseroService.read().forEach(System.out::println);
				break;
			default:
				System.out.println("Comando incorrecto");
			case "SALIR":
				System.out.println("Saliendo..\n");
				break;

		}
	}
	public static void ejecutarMesa(Restaurante restaurante,
			BufferedReader br) throws IOException {
		String linea = br.readLine(); linea = linea.toUpperCase();

		switch (linea) {
			case "LISTAR":
				restaurante.mesaService.read().forEach(System.out::println);
				break;
			default:
				System.out.println("Comando incorrecto");
			case "SALIR":
				System.out.println("Saliendo..\n");
				break;

		}
	}
}

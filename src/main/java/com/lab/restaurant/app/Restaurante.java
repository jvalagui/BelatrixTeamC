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
				System.out.println("INGRESE UN COMANDO: VISITA / CLIENTE / SALA ESPERA / SALIR");
				String line = bufferRead.readLine();
				switch (line) {
					case "SALA ESPERA":
						System.out.println(restaurante.recepcion.getSalaDeEspera());
						break;
					case "VISITA":
						System.out.println("Visita -> NUEVO / DESPEDIR / LISTAR");
						ejecutarVisita(restaurante, bufferRead);
						break;
					case "CLIENTE":
						System.out.println("Cliente -> NUEVO / LISTAR");
						ejecutarCliente(restaurante, bufferRead);
						break;
					case "SALIR":
						System.out.println("CHAU");
						System.exit(0);
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
			recepcion.generarVisita(0,i + 1,
					"Cliente " + String.format("%02d", i + 1));
		}
		
		
		int cantidadMeseros = meseroService.read().size(), cantidadMesas = mesaService
				.read().size(), cantidadClientes = clienteService.read().size();
		System.out.println("He inicializado:\n" + cantidadMeseros+ " meseros,\n"
				+ cantidadMesas + " mesas,\n"
				+ cantidadClientes + " clientes.\n"
				+ "Los meseros pueden atender como maximo "
				+ Mesero.LIMITE_MESAS + " mesas.\n");

		
		visitaService.read().forEach(
				visita -> recepcion.asignarMesa(visita
						.getId())
				);

		System.out.println("He generado y asignado "
				+ visitaService.read().size() + " visitas.");
	}

	public static void ejecutarVisita(Restaurante restaurante, BufferedReader br)
			throws IOException {
		String linea = br.readLine();

		switch (linea) {
			case "LISTAR":
				System.out.println("Lista de Visitas");
	
				restaurante.visitaService.read().forEach(
						visita -> {
							System.out.println(visita);
							Mesa mesa = restaurante.mesaService.read(visita
									.getIdMesa());
							if(mesa!=null){System.out.println(restaurante.meseroService.read(mesa
									.getIdMesero()));}
							
							System.out.println();
						});
				break;
			case "NUEVO":
				System.out.println("Ingrese los datos de la visita (IdVisita, IdCliente, NombreCliente(Opcional)). Si el id del cliente ya esta registrado, se generara la visita con ese cliente.\n"
						+ "Si no desea escribir un id de visita, digite \"0\"\n"
						+ "Ejemplo: 0, 14, Juanito");
				linea = br.readLine();
				try{
					String[] datos = linea.split(",");
					if(datos.length<2){throw new Exception();}
					if(datos.length<3){
						if(restaurante.clienteService.read(Integer.valueOf(datos[1].trim()))==null){throw new Exception();}
						restaurante.recepcion.generarVisita(Integer.valueOf(datos[0].trim()), Integer.valueOf(datos[1].trim()));
					}else{
						restaurante.recepcion.generarVisita(Integer.valueOf(datos[0].trim()), Integer.valueOf(datos[1].trim()), datos[2].trim());
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
			
			
			default:
				System.out.println("Comando incorrecto");
			case "SALIR":
				System.out.println("Saliendo..\n");
				break;
		}
	}

	public static void ejecutarCliente(Restaurante restaurante,
			BufferedReader br) throws IOException {
		String linea = br.readLine();

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
					restaurante.clienteService.create(new Cliente(Integer.valueOf(datos[0].trim()), datos[1].trim()));
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
}

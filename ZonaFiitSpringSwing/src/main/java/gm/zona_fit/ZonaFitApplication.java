package gm.zona_fit;

import ch.qos.logback.core.net.server.Client;
import gm.zona_fit.entity.Cliente;
import gm.zona_fit.service.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteService service;
	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);
	private String nl = System.lineSeparator();



	public static void main(String[] args) {
		SpringApplication.run(ZonaFitApplication.class, args);

	}

	//nota: Se levanta la aplicacion con main, una vez cargada en memoria los objetos de Spring
	//utilizamos el metodo run para ejecutar la aplicacion
	@Override
	public void run(String... args) throws Exception {

		zonaFitApp();
	}

	private void zonaFitApp (){
		Boolean salir = false;
		Scanner consola = new Scanner(System.in);
		while(!salir){
			int opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(nl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info(nl + nl +"""
	*** Aplicacion Zona Fit (GYM) ***
		1. Listar Clientes
		2. Buscar Cliente
		3. Agregar Cliente
		4. Modificar Cliente
		5. Eliminar Cliente
		6. Salir
		Elije una opcion: """);
		return Integer.parseInt(consola.nextLine());
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion ){

		switch (opcion){
			case 1 -> {
				logger.info(nl +"---Listado de clientes---" + nl);
				List<Cliente> clientes = service.listarClientes();
				clientes.forEach(cliente-> logger.info(cliente.toString() + nl));
			}
			case 2 ->{
				logger.info(nl +"---Buscar Cliente por ID---" + nl);
				logger.info("ingresar ID: ");
				int idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = new Cliente();
				cliente = service.buscarClientePorId(idCliente);
				logger.info(cliente.toString() + nl);
			}
			case 3 ->{
				logger.info(nl +"---Agregar Cliente---" + nl);
				Cliente cliente = new Cliente();
				logger.info("nombre: ");
				cliente.setNombre(consola.nextLine());
				logger.info("apellido: ");
				cliente.setApellido(consola.nextLine());
				logger.info("membresia: ");
				cliente.setMembresia(Integer.parseInt(consola.nextLine()));
				logger.info(service.guardarCliente(cliente).toString());
			}
			case 4 ->{
				logger.info(nl +"---Modificar Cliente---" + nl);
				logger.info("Id a modificar: ");
				int id = Integer.parseInt(consola.nextLine());
				logger.info("nombre: ");
				String nombre= consola.nextLine();
				logger.info("apellido: ");
				String apellido = consola.nextLine();
				logger.info("membresia: ");
				int membresia= Integer.parseInt(consola.nextLine());
				Cliente cliente = new Cliente(id, nombre, apellido, membresia);
				logger.info(service.guardarCliente(cliente).toString());
			}
			case 5 ->{
				logger.info(nl +"---Eliminar Cliente---" + nl);
				logger.info("Id a eliminar: ");
				int idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = new Cliente();
				cliente.setId(idCliente);
				service.eliminarCliente(cliente);
			}
			case 6 ->{
				return true;
			}
		}
		return false;
	}

}

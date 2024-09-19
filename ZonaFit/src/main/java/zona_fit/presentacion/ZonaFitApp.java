package zona_fit.presentacion;

import zona_fit.datos.ClienteDao;
import zona_fit.datos.IClienteDao;
import zona_fit.dominio.Cliente;
import java.util.List;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp (){
        Boolean salir = false;
        Scanner consola = new Scanner(System.in);
        //Creamos un Objeto ICLIENTEDAO

        IClienteDao clienteDao = new ClienteDao();

        while (!salir){
            try{
              int opcion = mostrarMenu(consola);
              salir = ejecutarOpciones (consola, opcion, clienteDao);
            }catch (Exception e){
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }
    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                *** Zona Fit (GYM) ***
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elige una opcion:\s """
        );
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola, int opcion, IClienteDao clienteDao){
        boolean salir = false;
        switch (opcion){
            case 1 -> { //listar clientes
                System.out.println("--- Listado de Clientes ---");
                List<Cliente> clientes = clienteDao.listarClientes();
                clientes.forEach(cliente -> {
                    System.out.println("cliente = " + cliente);
                });
            }
            case 2 -> { //Buscar cliente por id
                System.out.println("--- Buscar por ID ---");
                System.out.print("Introduce el id del cliente a buscar: ");
                int idcliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = new Cliente(idcliente);
                Boolean encontrado = clienteDao.buscarClientePorId(cliente);
                if (encontrado){
                    System.out.println("Cliente encontrado: " + cliente);
                }else {
                    System.out.println("Cliente no encontrado");
                }
            }
            case 3 -> { //3. agregar cliente
                System.out.println("--- Agregar Cliente ---");
                System.out.print("Nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Apellido: ");
                String apellido = consola.nextLine();
                System.out.print("nro de membresia: ");
                int membresia = Integer.parseInt(consola.nextLine());
                //creamos el objeto Cliente

                Cliente cliente = new Cliente(nombre, apellido, membresia);
                Boolean agregado = clienteDao.agregarCliente(cliente);
                if (agregado){
                    System.out.println("Cliente agregado: " + cliente);
                }else {
                    System.out.println("Cliente no agregado");
                }
            }
            case 4 -> { // 4. Modificar cliente existente
                System.out.println("--- Modificar Cliente ---");
                System.out.print("ID del cliente: ");
                int idCliente = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Apellido: ");
                String apellido = consola.nextLine();
                System.out.print("nro de membresia: ");
                int membresia = Integer.parseInt(consola.nextLine());
                Cliente cliente = new Cliente(idCliente,nombre,apellido,membresia);
                Boolean modificado = clienteDao.modificarCliente(cliente);
                if (modificado){
                    System.out.println("El cliente fue modificado: " + cliente);
                }else{
                    System.out.println("El cliente no pudo ser modificado.");
                }
            }
            case 5 -> { // 5. Eliminar un cliente
                System.out.println("--- Eliminar Clietne ---");
                System.out.print("Id Cliente a eliminar: ");
                int idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = new Cliente(idCliente);
                Boolean eliminado = clienteDao.eliminarCliente(cliente);
                if(eliminado){
                    System.out.println("El cliente: " + cliente + " Fue eliminado");
                }else {
                    System.out.println("No se pudo eliminar cliente");
                }
            }
            case 6 -> { //6. salir
                System.out.println("See you later");
                salir = true;

            }
        }

        return salir;
    }
}

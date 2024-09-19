package gm.zona_fit.gui;


import gm.zona_fit.entity.Cliente;
import gm.zona_fit.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


@Component
public class ZonaFitForma extends JFrame {
    private JPanel panelPrincipal;
    private JTable clientesTabla;
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField membresiaTexto;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton limpiarButton;
    private IClienteService service;
    private DefaultTableModel tablaModeloClientes;
    private Integer idCliente;

    @Autowired
    public ZonaFitForma(IClienteService service){
        this.service = service;
        iniciarForma();
        guardarButton.addActionListener(evento -> guardarCliente());
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });
        eliminarButton.addActionListener(e -> {
            eliminarCliente();
        });
        limpiarButton.addActionListener(e -> {
            limpiarFormulario();
        });
    }

    private void iniciarForma(){
        //  FlatDarculaLaf.setup();
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null); //Centra ventana
    }

    private void createUIComponents() {
        //este metodo se ejecuta incluso antes que el constructor, de igual manera la inyeccion de dependencias
        //se realiza incluso antes, por lo que ya tenemos disponible los sevicios al momento de que este metodo se
        //ejecute, NOTA: este metodo realizara todas las modificaciones a los componentes que esten marcados como
        // Custom Create
        // Creamos la tabla
        //No la vamos a crear asi para no poder modificar graficamente
        // this.tablaModeloClientes = new DefaultTableModel(0, 4);
        this.tablaModeloClientes = new DefaultTableModel(0,4){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
        String [] cabeceras = {"Id", "Nombre", "Apellido", "Membresia" };
        this.tablaModeloClientes.setColumnIdentifiers(cabeceras);
        this.clientesTabla = new JTable(tablaModeloClientes);
        //permitimos la seleccion de a un solo registro.
        this.clientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Cargar listado de clientes
        listarClientes();
    }

    private void listarClientes(){
        this.tablaModeloClientes.setRowCount(0);
        List<Cliente> clientes = this.service.listarClientes();
        clientes.forEach(cliente -> {
            //Es de tipo Object porque tablaModeloClientes.addRow recibe un array de Object
            Object[] rowCliente = {
              cliente.getId(),
              cliente.getNombre(),
              cliente.getApellido(),
              cliente.getMembresia()
            };
            this.tablaModeloClientes.addRow(rowCliente);
        });
    }

    private void guardarCliente(){
        if(nombreTexto.getText().equals("")){
            mostrarMensaje("Proporciona un Nombre");
            nombreTexto.requestFocusInWindow();
            return;
        }
        if(apellidoTexto.getText().equals("")){
            mostrarMensaje("Proporciona un Apellido");
            apellidoTexto.requestFocusInWindow();
            return;
        }
        if(membresiaTexto.getText().equals("")){
            mostrarMensaje("Proporciona una Membresia");
            membresiaTexto.requestFocusInWindow();
            return;
        }
        //recuperamos los valores
        String nombre = nombreTexto.getText();
        String apellido = apellidoTexto.getText();
        int membresia = Integer.parseInt(membresiaTexto.getText());
        Cliente cliente = new Cliente(this.idCliente, nombre,apellido,membresia);
        this.service.guardarCliente(cliente);
        if(this.idCliente == null){
            mostrarMensaje("Se Agrego nuevo Cliente");
        }else{
            mostrarMensaje("Se actualizo Cliente");
        }
        limpiarFormulario();
        listarClientes();
    }

    private void  eliminarCliente(){

       if (this.idCliente != null) {
           String nombre = this.nombreTexto.getText();
           String apellido = this.apellidoTexto.getText();
           Integer membresia = Integer.parseInt(this.membresiaTexto.getText());
           Cliente cliente = new Cliente(this.idCliente, nombre, apellido, membresia);
           service.eliminarCliente(cliente);
           mostrarMensaje("Cliente eliminado");
           listarClientes();
           limpiarFormulario();
       }else {
           mostrarMensaje("Debe seleccionar un Cliente a Eliminar");
       }
    }

    private void cargarClienteSeleccionado(){
        //getSelectedRow devuelve -1 si no se ha seleccionado ningun registro
        int renglon = clientesTabla.getSelectedRow();
        if (renglon != -1){
            String id = clientesTabla.getModel().getValueAt(renglon, 0).toString();
            this.idCliente = Integer.parseInt(id);
            String nombre = clientesTabla.getModel().getValueAt(renglon, 1).toString();
            this.nombreTexto.setText(nombre);
            String apellido = clientesTabla.getModel().getValueAt(renglon, 2).toString();
            this.apellidoTexto.setText(apellido);
            String membresia = clientesTabla.getModel().getValueAt(renglon, 3).toString();
            this.membresiaTexto.setText(membresia);
        }
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void limpiarFormulario(){
        nombreTexto.setText("");
        apellidoTexto.setText("");
        membresiaTexto.setText("");
        //limpiamos el ID del cliente seleccionado
        this.idCliente = null;
        // Sacamos la seleccion del registro que habiamos seleccionado
        this.clientesTabla.getSelectionModel().clearSelection();
    }

}

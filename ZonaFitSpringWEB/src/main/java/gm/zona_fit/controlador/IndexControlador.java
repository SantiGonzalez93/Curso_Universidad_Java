package gm.zona_fit.controlador;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data // genera los metodos get y set automaticamente
@ViewScoped //
public class IndexControlador {

    @Autowired
    private IClienteServicio clienteServicio;
    private List<Cliente> clientes;
    private Cliente clienteSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    //Esto es como una especie de constructor, no podemos crear uno ya que JSF lo crea de
    //manera automática. al terminar de instanciar el objeto se va a llamar este metodo
    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.clientes = this.clienteServicio.listarClientes();
        //this.clientes.forEach(cliente -> logger.info(cliente.toString()));
    }

    public void agregarCliente(){
        this.clienteSeleccionado = new Cliente();
    }

    public void guardarCliente(){
        logger.info("cliente a guardar: " + this.clienteSeleccionado);
        if(this.clienteSeleccionado.getId()==null){
            this.clienteServicio.guardarCliente(this.clienteSeleccionado);
            this.clientes.add(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Agregado"));
        }else{
            this.clienteServicio.guardarCliente(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente Actualizado"));
        }
        //ocultar la ventana modal
        PrimeFaces.current().executeInitScript("PF('ventanaModalCliente').hide()");
        //actualizar la tabla usando ajax
        PrimeFaces.current().ajax().update("forma-clientes:mensajes " ,
                "forma-clientes:clientes-tabla");
        //reset del objeto clienteSeleccionado
        this.clienteServicio=null;
    }

    public void eliminarCliente(){
        logger.info("Cliente a Eliminar: " + this.clienteSeleccionado);
        this.clienteServicio.eliminarCliente(this.clienteSeleccionado);
        //Eliminamos el registro de la lista de Clientes
        this.clientes.remove(this.clienteSeleccionado);
        //reset del objeto seleccionado
        this.clienteSeleccionado= null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente eliminado"));
        PrimeFaces.current().ajax().update("forma-clientes:mensajes " ,
                "forma-clientes:clientes-tabla");

    }

}

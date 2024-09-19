package zona_fit.datos;

import zona_fit.dominio.Cliente;
import java.util.List;

public interface IClienteDao {

    public  abstract List<Cliente> listarClientes();
    public  abstract boolean buscarClientePorId(Cliente cliente);
    public  abstract boolean agregarCliente(Cliente cliente);
    public  abstract boolean modificarCliente (Cliente cliente);
    public  abstract boolean eliminarCliente(Cliente cliente);
}

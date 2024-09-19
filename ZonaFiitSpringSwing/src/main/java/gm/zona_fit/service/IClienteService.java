package gm.zona_fit.service;

import gm.zona_fit.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IClienteService {

    public List<Cliente> listarClientes();

    public Cliente buscarClientePorId (Integer idCliente);

    public Cliente guardarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);
}

package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author gabriel_piske
 */
public interface ClienteDao {
    void addCliente(Cliente cliente);
    Cliente getCliente(int id);
    List<Cliente> getAllClientes();
    void updateCliente(Cliente cliente);
    void deleteCliente(int id);
}

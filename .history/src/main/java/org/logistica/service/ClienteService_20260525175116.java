package org.logistica.service;

import java.sql.SQLException;

import org.logistica.model.Cliente;
import org.logistica.repository.ClienteRepository;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    public void criarCliente(Cliente cliente) {
        if (cliente != null) {
            try {

            }
            catch (SQLException e)
            {
                e
            }
        }
    }

}

package org.logistica.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                clienteRepository.store(cliente);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = clienteRepository.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public verificarCpfCnpj(Cliente cliente) {
        
    }

}

package org.logistica.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.logistica.model.Cliente;
import org.logistica.repository.ClienteRepository;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    public void criarCliente(Cliente cliente) {
        if (cliente != null) {
            throw new RuntimeException("Cliente não pode ser nulo");
        }

        if (verificarExistenciaCpfCnpj(cliente)) {
            throw new RuntimeException("Cliente já cadastrado neste cpf/cnpj");
        }

        try {
            clienteRepository.store(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void deletarCliente(Integer id) {
        try
    }

    private Boolean verificarExistenciaCpfCnpj(Cliente cliente) {
        List<Cliente> clientes = listarClientes();

        for(Cliente entrada : clientes) {
            if (entrada.getCpf_cnpj().equals(cliente.getCpf_cnpj())) {
                return true;
            }
        }
        return false;
    }

}

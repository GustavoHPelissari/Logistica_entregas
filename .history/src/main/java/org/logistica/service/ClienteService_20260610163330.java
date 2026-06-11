package org.logistica.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
        if (cliente == null) {
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

    public Map<Cliente, Double> listarClientesVolumeMaisAlto() {
        Map<Cliente, Double> rankingMap = new LinkedHashMap<>();
        try{
            rankingMap = clienteRepository.listClientesMaiorVolume();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rankingMap;
    }

    public void deletarCliente(Integer id) {
        try{
            clienteRepository.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new RuntimeException("Nome do cliente não pode ser vazio");
        }
        if () {
            
        }
    }
}

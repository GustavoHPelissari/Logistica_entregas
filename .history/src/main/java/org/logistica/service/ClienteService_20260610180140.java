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

        validarNome(cliente.getNome());
        validarCpfCnpj(cliente.getCpf_cnpj());
        validarEndereco(cliente.getEndereco());
        validarCidade(cliente.getCidade());
        validarEstado(cliente.getEstado());

        if (verificarExistenciaCpfCnpj(cliente)) {
            throw new RuntimeException("Cliente já cadastrado neste cpf/cnpj");
        }

        try {
            clienteRepository.store(cliente);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar um cliente: "+e.getStackTrace());
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = clienteRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: "+e.getStackTrace());
        }
        return clientes;
    }

    public Map<Cliente, Double> listarClientesVolumeMaisAlto() {
        Map<Cliente, Double> rankingMap = new LinkedHashMap<>();
        try{
            rankingMap = clienteRepository.listClientesMaiorVolume();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar ranking de clientes: "+e.getStackTrace());
        }
        return rankingMap;
    }

    public void deletarCliente(Integer id) {
        if (id == null) {
            throw new RuntimeException("")
        }

        try{
            clienteRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar cliente de clientes: "+e.getStackTrace());
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
        if (nome == null || nome.isEmpty()) {
            throw new RuntimeException("Nome do cliente não pode ser vazio");
        }
        if (nome.length() < 3) {
            throw new RuntimeException("NOme deve ter pelo menos 3 caracteres");
        }
    }

    private void validarCpfCnpj(String cpfCnpj) {
        if (cpfCnpj == null || cpfCnpj.isEmpty()) {
             throw new RuntimeException("CPF/CNPJ não pode ser vazio");
        }
        if (cpfCnpj.length() < 11 || cpfCnpj.length() > 14) {
             throw new RuntimeException("CPF deve ter 11 dígitos ou CNPJ deve ter 14 dígitos");
        }
    }

    private void validarEndereco(String endereco) {
        if (endereco == null || endereco.isEmpty()) {
            throw new RuntimeException("Endereço não pode ser vazio");
        }
    }

    private void validarCidade(String cidade) {
        if (cidade == null || cidade.isEmpty()) {
            throw new RuntimeException("Cidade não pode ser vazio");
        }
    }

    private void validarEstado(String estado) {
        if (estado == null || estado.isEmpty()) {
            throw new RuntimeException("Estado não pode ser vazio");
        }
        if (estado.length() != 2) {
            throw new RuntimeException("Estado deve ter 2 caracteres");
        }
    }
}

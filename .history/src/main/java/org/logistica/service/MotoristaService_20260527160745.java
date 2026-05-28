package org.logistica.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.logistica.model.Cliente;
import org.logistica.model.Motorista;
import org.logistica.repository.MotoristaRepository;

public class MotoristaService {
    private final MotoristaRepository motoristaRepository;

    public MotoristaService() {
        this.motoristaRepository = new MotoristaRepository();
    }

    public void criarMotorista(Motorista motorista) {
        if (motorista == null) {
            throw new RuntimeException("Motorista não pode ser nulo");
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

    public List<Motorista> listarMotoristas() {
        List<Motorista> motoristas = new ArrayList<>();
        try {
            motoristas = motoristaRepository.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    private Boolean verificarExistenciaCpfCnpj(Cliente cliente) {
        List<Motorista> motoristas = listarMotoristas();

        for(Cliente entrada : clientes) {
            if (entrada.getCpf_cnpj().equals(cliente.getCpf_cnpj())) {
                return true;
            }
        }
        return false;
    }
}

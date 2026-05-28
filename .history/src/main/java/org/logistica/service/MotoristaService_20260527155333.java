package org.logistica.service;

import java.sql.SQLException;

import org.logistica.model.Motorista;
import org.logistica.repository.MotoristaRepository;

public class MotoristaService {
    private final MotoristaRepository motoristaRepository;

    public MotoristaService() {
        this.motoristaRepository = new MotoristaRepository();
    }

    public void criarMotorista(Motorista motorista) {
        if (motorista != null) {
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
}

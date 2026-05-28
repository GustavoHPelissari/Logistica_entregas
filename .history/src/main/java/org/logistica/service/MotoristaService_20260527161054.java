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

        if (verificarExistenciaCpfCnpj(motorista)) {
            throw new RuntimeException("Motorista já cadastrado nesta cnh");
        }

        try {
            motoristaRepository.store(motorista);
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
        return motoristas;
    }

    private Boolean verificarExistenciaCpfCnpj(Motorista motorista) {
        List<Motorista> motoristas = listarMotoristas();

        for(Motorista entrada : motoristas) {
            if (entrada.getCnh().equals(motorista.getCnh())) {
                return true;
            }
        }
        return false;
    }
}

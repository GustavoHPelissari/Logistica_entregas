package org.logistica.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        validarNome(motorista.getNome());
        validarCnh(motorista.getCnh());
        validarVeiculo(motorista.getVeiculo());
        validarCidadeBase(motorista.getCidadeBase());

        if (verificarExistenciaCpfCnpj(motorista)) {
            throw new RuntimeException("Motorista já cadastrado nesta cnh");
        }

        try {
            motoristaRepository.store(motorista);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar motorista: " + e.getStackTrace());
        }
    }

    public List<Motorista> listarMotoristas() {
        List<Motorista> motoristas = new ArrayList<>();
        try {
            motoristas = motoristaRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar motoristas: " + e.getStackTrace());
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

    public void excluirMotorista(Integer id){
        try{
            Motorista motorista = motoristaRepository.findById(id);
            if (motorista == null) {
                throw new RuntimeException("Motorista não encontrado");
            }
            motoristaRepository.delete(id);
        } catch(SQLException e){
            throw new RuntimeException("Erro ao Motorista não encontrado");
        }
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new RuntimeException("Nome do motorista não pode ser vazio");
        }
        if (nome.length() < 3) {
            throw new RuntimeException("Nome deve ter pelo menos 3 caracteres");
        }
    }

    private void validarCnh(String cnh) {
        if (cnh == null || cnh.isEmpty()) {
            throw new RuntimeException("CNH não pode ser vazia");
        }
        if (cnh.length() != 11) {
            throw new RuntimeException("CNH deve ter 11 dígitos");
        }
    }

    private void validarVeiculo(String veiculo) {
        if (veiculo == null || veiculo.isEmpty()) {
            throw new RuntimeException("Veiculo não pode ser vazio");
        }
    }

    private void validarCidadeBase(String cidadeBase) {
        if (cidadeBase == null || cidadeBase.isEmpty()) {
            throw new RuntimeException("Cidade base não pode ser vazia");
        }
    }
}

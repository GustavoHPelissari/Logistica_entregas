package org.logistica.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.logistica.enums.StatusEntrega;
import org.logistica.model.Entrega;
import org.logistica.repository.EntregaRepository;

public class EntregaService {
    private final EntregaRepository entregaRepository;

    public EntregaService(){
        this.entregaRepository = new EntregaRepository();
    }

    public void criarEntrega(Entrega entrega){
        if (entrega == null) {
            throw new RuntimeException("Entrega não pode ser nula");
        }

        if (entrega.getPedidoId() == null || entrega.getPedidoId() <= 0) {
            throw new RuntimeException("Pedido inválido para entrega");
        }

        if (entrega.getMotoristaId() == null || entrega.getMotoristaId() <= 0) {
            throw new RuntimeException("Motorista inválido para a entrega");
        }

        if (entrega.getDataSaida() == null) {
            entrega.setDataSaida(LocalDate.now());
        }

        if (entrega.getStatusEntrega() == null) {
            entrega.setStatusEntrega(StatusEntrega.EM_ROTA);
        }

        try{
            entregaRepository.store(entrega);
        } catch(SQLException e){
            throw new RuntimeException("Erro ao criar entrega: "+ e.getStackTrace())
        }
    }

    public void atualizarEntrega(Entrega entrega) {
        if (entrega == null) {
            throw new RuntimeException("Entrega não pode ser nula");
        }

        try{
            entregaRepository.update(entrega);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Entrega> listarEntregas(){
        List<Entrega> entregas = new ArrayList<>();
        try{
            entregas =  entregaRepository.findAll();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return entregas;
    }

    public List<Entrega> listarEntregasAtrasadasPorCidade(String cidade){
        List<Entrega> entregas = new ArrayList<>();
        try{
            entregas = entregaRepository.findEntregasAtrasadasCidade(cidade);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return entregas;
    }

    public void excluirEntrega(Integer id) {
        try{
            entregaRepository.delete(id);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}

package org.logistica.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.logistica.model.Entrega;
import org.logistica.model.HistoricoEntrega;
import org.logistica.repository.HistoricoEntregaRepository;

public class HistoricoEntregaService {
    private HistoricoEntregaRepository historicoEntregaRepository;

    public HistoricoEntregaService(){
        this.historicoEntregaRepository = new HistoricoEntregaRepository();
    }

     public void criarHistoricoEntrega(HistoricoEntrega historicoEntrega){
        if (historicoEntrega == null) {
            throw new RuntimeException("Entrega não pode ser nula");
        }

        try{
            historicoEntregaRepository.store(historicoEntrega);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<HistoricoEntrega> listarHistoricoEntregas(){
        List<HistoricoEntrega> entregas = new ArrayList<>();
        try{
            entregas =  historicoEntregaRepository.findAll();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return entregas;
    }
}

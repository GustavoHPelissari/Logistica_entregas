package org.logistica.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.logistica.model.Entrega;
import org.logistica.repository.HistoricoEntregaRepository;

public class HistoricoEntregaService {
    private HistoricoEntregaRepository historicoEntregaRepository;

    public HistoricoEntregaService(){
        this.historicoEntregaRepository = new HistoricoEntregaRepository();
    }

     public void criarEntrega(Entrega entrega){
        if (entrega == null) {
            throw new RuntimeException("Entrega não pode ser nula");
        }

        try{
            entregaRepository.store(entrega);
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
}

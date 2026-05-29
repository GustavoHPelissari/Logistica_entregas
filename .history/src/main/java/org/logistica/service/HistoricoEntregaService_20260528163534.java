package org.logistica.service;

import java.sql.SQLException;

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



}

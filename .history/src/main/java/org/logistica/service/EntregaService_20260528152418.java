package org.logistica.service;

import java.sql.SQLException;
import java.util.List;

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

        try{
            entregaRepository.store(entrega);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Entrega> listarEntregas(){
        
    }
}

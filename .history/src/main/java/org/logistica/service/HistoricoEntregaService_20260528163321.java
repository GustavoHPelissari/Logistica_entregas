package org.logistica.service;

import org.logistica.repository.HistoricoEntregaRepository;

public class HistoricoEntregaService {
    private HistoricoEntregaRepository historicoEntregaRepository;

    public HistoricoEntregaService(){
        this.historicoEntregaRepository = new HistoricoEntregaRepository();
    }
}

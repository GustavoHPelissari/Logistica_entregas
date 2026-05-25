package org.logistica.model;

import java.time.LocalDate;

public class HistoricoEntrega {
    private Integer id;
    private Integer entregaId;
    private LocalDate dataEvento;
    private String descrisao;

    

    public HistoricoEntrega(Integer entregaId, LocalDate dataEvento, String descrisao) {
        this.entregaId = entregaId;
        this.dataEvento = dataEvento;
        this.descrisao = descrisao;
    }

    
}

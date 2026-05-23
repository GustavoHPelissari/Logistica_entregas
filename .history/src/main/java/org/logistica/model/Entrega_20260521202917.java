package org.logistica.model;

import java.time.LocalDateTime;

import org.logistica.enums.StatusEntrega;

public class Entrega {
    private Integer id;
    private Integer pedidoId;
    private Integer motoristaId;
    private LocalDateTime dataSaida;
    private LocalDateTime dataEntrega;
    private StatusEntrega statusEntrega;
    public Entrega(Integer id, Integer pedidoId, Integer motoristaId, LocalDateTime dataSaida,
            LocalDateTime dataEntrega, StatusEntrega statusEntrega) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.motoristaId = motoristaId;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.statusEntrega = statusEntrega;
    }

    
}

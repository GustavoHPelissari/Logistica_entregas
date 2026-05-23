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

    
}

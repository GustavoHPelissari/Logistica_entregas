package org.logistica.model;

import java.time.LocalDateTime;

import org.logistica.enums.StatusPedido;

public class Pedido {
    private Integer id;
    private Integer idCliente;
    private LocalDateTime dataPedido;
    private Double volumeM3; // Definindo que a medida utilizada para volume é M3 (metros cúbicos)
    private Double pesoKG; // Definindo que a medida utilizada para peso é KG (quilograma)
    private StatusPedido statusPedido; // Enum utilizada para Pedido
    
    public Pedido(Integer id, Integer idCliente, LocalDateTime dataPedido, Double volumeM3, Double pesoKG,
            StatusPedido statusPedido) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKG = pesoKG;
        this.statusPedido = statusPedido;
    }

    
}

package org.logistica.model;

import java.time.LocalDate;

import org.logistica.enums.StatusEntrega;

public class Entrega {
    private Integer id;
    private Integer pedidoId;
    private Integer motoristaId;
    private LocalDate dataSaida;
    private LocalDate dataEntrega;
    private StatusEntrega statusEntrega;
    
    public Entrega(Integer id, Integer pedidoId, Integer motoristaId, LocalDate dataSaida,
            LocalDate dataEntrega, StatusEntrega statusEntrega) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.motoristaId = motoristaId;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.statusEntrega = statusEntrega;
    }

    public Entrega(Integer pedidoId, Integer motoristaId, LocalDate dataSaida, LocalDate dataEntrega,
            StatusEntrega statusEntrega) {
        this.pedidoId = pedidoId;
        this.motoristaId = motoristaId;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.statusEntrega = statusEntrega;
    }

    private void concluirEntrega

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(Integer motoristaId) {
        this.motoristaId = motoristaId;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

}

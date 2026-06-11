package org.logistica.model;

import java.time.LocalDate;

import org.logistica.enums.StatusPedido;

public class Pedido {
    private Integer id;
    private Integer idCliente;
    private LocalDate dataPedido;
    private Double volumeM3; // Definindo que a medida utilizada para volume é M3 (metros cúbicos)
    private Double pesoKG; // Definindo que a medida utilizada para peso é KG (quilograma)
    private StatusPedido statusPedido; // Enum utilizada para Pedido
    
    public Pedido(Integer id, Integer idCliente, LocalDate dataPedido, Double volumeM3, Double pesoKG,
            StatusPedido statusPedido) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKG = pesoKG;
        this.statusPedido = statusPedido;
    }

    public Pedido(Integer idCliente, LocalDate dataPedido, Double volumeM3, Double pesoKG,
            StatusPedido statusPedido) {
        this.idCliente = idCliente;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKG = pesoKG;
        this.statusPedido = statusPedido;
    }

    public void cancelarPedido(){
        if (this) {
            
        }
        this.statusPedido = StatusPedido.CANCELADO;
    }

    public void concluirPedido(){
        this.statusPedido = StatusPedido.ENTREGUE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(Double volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public Double getPesoKG() {
        return pesoKG;
    }

    public void setPesoKG(Double pesoKG) {
        this.pesoKG = pesoKG;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    
}

package org.logistica.model;

import java.time.LocalDate;

public class HistoricoEntrega {
    private Integer id;
    private Integer entregaId;
    private LocalDate dataEvento;
    private String descrisao;

    public HistoricoEntrega(Integer id, Integer entregaId, LocalDate dataEvento, String descrisao) {
        this.id = id;
        this.entregaId = entregaId;
        this.dataEvento = dataEvento;
        this.descrisao = descrisao;
    }



    public HistoricoEntrega(Integer entregaId, LocalDate dataEvento, String descrisao) {
        this.entregaId = entregaId;
        this.dataEvento = dataEvento;
        this.descrisao = descrisao;
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getEntregaId() {
        return entregaId;
    }



    public void setEntregaId(Integer entregaId) {
        this.entregaId = entregaId;
    }



    public LocalDate getDataEvento() {
        return dataEvento;
    }



    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }



    public String getDescrisao() {
        return descrisao;
    }



    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }

    
}

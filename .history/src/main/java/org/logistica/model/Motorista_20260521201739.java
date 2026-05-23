package org.logistica.model;

public class Motorista {
    private Integer id;
    private String nome;
    private String cnh;
    private String veiculo;
    private String cidadeBase;
    
    public Motorista(Integer id, String nome, String cnh, String veiculo, String cidadeBase) {
        this.id = id;
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidadeBase = cidadeBase;
    }

    
}

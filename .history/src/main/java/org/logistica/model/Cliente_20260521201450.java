package org.logistica.model;

public class Cliente {
    private Integer id;
    private String nome;
    private String cpf_cnpj;
    private String endereco;
    private String cidade;
    private String estado;
    
    public Cliente(Integer id, String nome, String cpf_cnpj, String endereco, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Cliente(String nome, String cpf_cnpj, String endereco, String cidade, String estado) {
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    
}

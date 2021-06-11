package com.associacaodesuperherois.cadastroheroi;

import java.io.Serializable;

public class Heroi implements Serializable {
    private int id;
    private String nomereal;
    private String nomeheroi;
    private String idade;
    private String cpf;
    private String habilidade;
    private String descricao;

    public Heroi(){
    }

    public Heroi(int id, String nomereal, String nomeheroi, String idade, String cpf, String habilidade, String descricao){
        this.id = id;
        this.nomereal = nomereal;
        this.nomeheroi = nomeheroi;
        this.idade = idade;
        this.cpf = cpf;
        this.habilidade = habilidade;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomereal() {
        return nomereal;
    }

    public void setNomereal(String nomereal) {
        this.nomereal = nomereal;
    }

    public String getNomeheroi() {
        return nomeheroi;
    }

    public void setNomeheroi(String nomeheroi) {
        this.nomeheroi = nomeheroi;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return nomeheroi;
    }
}

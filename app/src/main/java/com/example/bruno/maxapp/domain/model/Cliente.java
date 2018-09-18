package com.example.bruno.maxapp.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cliente {

    long id;
    String codigo;
    @SerializedName("razao_social")
    String razaoSocial;
    String nomeFantasia;
    String cnpj;
    @SerializedName("ramo_atividade")
    String ramoAtividade;
    String endereco;
    String status;
    List<Contato> contatos;

    public long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getStatus() {
        return status;
    }

    public List<Contato> getContatos() {
        return contatos;
    }
}

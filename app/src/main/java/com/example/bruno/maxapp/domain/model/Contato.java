package com.example.bruno.maxapp.domain.model;

import com.google.gson.annotations.SerializedName;

public class Contato {

    String nome;
    String telefone;
    String celular;
    String conjuge;
    String tipo;
    String time;
    @SerializedName("e_mail")
    String email;
    @SerializedName("data_nascimento")
    String dataNascimento;
    String dataNascimentoConjuge;

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getConjuge() {
        return conjuge;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTime() {
        return time;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoConjuge() {
        return dataNascimentoConjuge;
    }
}

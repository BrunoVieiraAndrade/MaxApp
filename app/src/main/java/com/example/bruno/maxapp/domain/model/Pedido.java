package com.example.bruno.maxapp.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pedido {

    @SerializedName("numero_ped_Rca")
    private Integer numeroPedRca;
    @SerializedName("numero_ped_erp")
    private String numeroPedErp;
    @SerializedName("codigoCliente")
    private String codigoCliente;
    @SerializedName("NOMECLIENTE")
    private String nomeCliente;
    @SerializedName("data")
    private String data;
    @SerializedName("status")
    private String status;
    @SerializedName("critica")
    private String critica;
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("legendas")
    private List<String> legendas = null;

    public Integer getNumeroPedRca() {
        return numeroPedRca;
    }

    public String getNumeroPedErp() {
        return numeroPedErp;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getCritica() {
        return critica;
    }

    public String getTipo() {
        return tipo;
    }

    public List<String> getLegendas() {
        return legendas;
    }
}

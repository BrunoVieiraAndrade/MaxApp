package com.example.bruno.maxapp.utils;

import com.example.bruno.maxapp.application.App;
import com.example.bruno.maxapp.domain.model.Cliente;
import com.example.bruno.maxapp.domain.model.ClienteContainer;
import com.example.bruno.maxapp.domain.model.Pedido;
import com.example.bruno.maxapp.domain.model.PedidoContainer;

import java.util.List;

public class JsonUtils {
    public static Cliente getClientFromString(String jsonString) {
        ClienteContainer clienteContainer = App.getGson().fromJson(jsonString, ClienteContainer.class);
        return clienteContainer.getCliente();
    }

    public static List<Pedido> getPedidoFromString(String jsonString) {
        PedidoContainer pedidoContainer = App.getGson().fromJson(jsonString, PedidoContainer.class);
        return pedidoContainer.getPedidos();
    }
}

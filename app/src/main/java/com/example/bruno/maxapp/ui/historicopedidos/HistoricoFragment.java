package com.example.bruno.maxapp.ui.historicopedidos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.bruno.maxapp.R;
import com.example.bruno.maxapp.domain.model.Pedido;
import com.example.bruno.maxapp.domain.model.PedidoContainer;
import com.example.bruno.maxapp.utils.FileUtils;
import com.example.bruno.maxapp.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class HistoricoFragment extends Fragment {

    RecyclerView pedidosRecyclerView;
    List<Pedido> pedidos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getActivity().setTitle(getString(R.string.hist_pedidos));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.historico_pedidos, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.legendas:
                showLegendasDialog();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void showLegendasDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setView(LayoutInflater.from(getActivity()).inflate(R.layout.legendas_dialog, null, false))
                .setPositiveButton(R.string.fechar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historico, null);
        pedidosRecyclerView = view.findViewById(R.id.pedidosRecyclerView);
        bindPedidos();
        initializeList();
        return view;
    }

    private void bindPedidos() {
        this.pedidos = JsonUtils.getPedidoFromString(FileUtils.getJsonString(getActivity(), "pedidos.json"));
    }

    private void initializeList() {
        pedidosRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        pedidosRecyclerView.setAdapter(new HistoricoPedidosAdapter(getActivity(), pedidos));
    }
}

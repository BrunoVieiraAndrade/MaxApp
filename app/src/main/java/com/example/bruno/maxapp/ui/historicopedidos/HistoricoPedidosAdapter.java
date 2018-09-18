package com.example.bruno.maxapp.ui.historicopedidos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bruno.maxapp.R;
import com.example.bruno.maxapp.domain.model.Pedido;
import com.example.bruno.maxapp.utils.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoricoPedidosAdapter extends RecyclerView.Adapter<HistoricoPedidosAdapter.PedidoHolder> {

    private final Context context;
    List<Pedido> pedidos;


    public HistoricoPedidosAdapter(Context context, List<Pedido> pedidos) {
        this.pedidos = pedidos;
        this.context = context;
    }

    @NonNull
    @Override
    public PedidoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PedidoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoHolder holder, int position) {
        Pedido pedido = pedidos.get(position);
        holder.numeroPedidoTxt.setText(pedido.getNumeroPedErp());
        holder.numeroRcaTxt.setText(String.valueOf(pedido.getNumeroPedRca()));
        holder.dataPedidoTxt.setText(DateUtils.getDataOuHora(pedido.getData()));
        holder.nomeClienteTxt.setText(pedido.getNomeCliente());
        holder.statusTxt.setText(pedido.getStatus());
        if(pedido.getCritica()== null){
            holder.criticaLabelTxt.setVisibility(View.INVISIBLE);
        }
        handleImageStates(holder, pedido);
    }

    private void handleImageStates(PedidoHolder holder, Pedido pedido) {
        switch (pedido.getStatus().toUpperCase()) {
            case "EM PROCESSAMENTO":
                holder.statusImage.setVisibility(View.VISIBLE);
                holder.statusImageText.setVisibility(View.INVISIBLE);
                holder.statusImage.setImageDrawable(context.getDrawable(R.drawable.ic_maxima_em_processamento));
                break;
            case "PENDENTE":
                holder.statusImage.setVisibility(View.INVISIBLE);
                holder.statusImageText.setVisibility(View.VISIBLE);
                holder.statusImageText.setText("P");
                break;
            case "Processado":
                holder.statusImage.setVisibility(View.INVISIBLE);
                holder.statusImageText.setVisibility(View.VISIBLE);
                holder.statusImageText.setText("L");
                break;
        }
        if(pedido.getLegendas()!= null && !pedido.getLegendas().isEmpty()){
            for (String legenda : pedido.getLegendas()) {
                switch (legenda.toUpperCase()){
                    case "PEDIDO_CANCELADO_ERP":
                        holder.statusImage.setVisibility(View.INVISIBLE);
                        holder.statusImageText.setVisibility(View.VISIBLE);
                        holder.statusImageText.setText("C");
                    case "PEDIDO_SOFREU_CORTE":
                        holder.corteImg.setVisibility(View.VISIBLE);
                        break;

                }
            }
        }

        if(pedido.getTipo().equalsIgnoreCase("ORCAMENTO")){
            holder.statusImage.setVisibility(View.INVISIBLE);
            holder.statusImageText.setVisibility(View.VISIBLE);
            holder.statusImageText.setText("O");
        }
        if(pedido.getCritica() != null){
            switch (pedido.getCritica().toUpperCase()){
                case "SUCESSO":
                    holder.criticaImg.setImageDrawable(context.getDrawable(R.drawable.ic_maxima_critica_sucesso));
                    break;
                case "FALHA_PARCIAL":
                    holder.criticaImg.setImageDrawable(context.getDrawable(R.drawable.ic_maxima_critica_alerta));
                    break;
            }
        }
    }


    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    class PedidoHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.numeroPedidoTxt)
        TextView numeroPedidoTxt;
        @BindView(R.id.numeroRcaTxt)
        TextView numeroRcaTxt;
        @BindView(R.id.dataPedidoTxt)
        TextView dataPedidoTxt;
        @BindView(R.id.nomeClienteTxt)
        TextView nomeClienteTxt;
        @BindView(R.id.corteImg)
        ImageView corteImg;
        @BindView(R.id.statusTxt)
        TextView statusTxt;
        @BindView(R.id.criticaLabelTxt)
        TextView criticaLabelTxt;
        @BindView(R.id.criticaImg)
        ImageView criticaImg;
        @BindView(R.id.valorPedido)
        TextView valorPedido;
        @BindView(R.id.statusImage)
        ImageView statusImage;
        @BindView(R.id.statusImageText)
        TextView statusImageText;

        PedidoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

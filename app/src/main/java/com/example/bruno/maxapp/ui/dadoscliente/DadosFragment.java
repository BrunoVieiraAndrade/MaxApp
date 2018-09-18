package com.example.bruno.maxapp.ui.dadoscliente;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bruno.maxapp.R;
import com.example.bruno.maxapp.domain.model.Cliente;
import com.example.bruno.maxapp.domain.model.Contato;
import com.example.bruno.maxapp.services.ClientStatusService;
import com.example.bruno.maxapp.utils.FileUtils;
import com.example.bruno.maxapp.utils.JsonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DadosFragment extends Fragment{

    @BindView(R.id.razaoSocialTxt)
    TextView razaoSocial;
    @BindView(R.id.fantasiaTxt)
    TextView fantasiaTxt;
    @BindView(R.id.cnpjTxt)
    TextView cnpjTxt;
    @BindView(R.id.ramoAtividadeTxt)
    TextView ramoAtividadeTxt;
    @BindView(R.id.enderecoTxt)
    TextView enderecoTxt;
    @BindView(R.id.nomeContatoTxt)
    TextView nomeContatoTxt;
    @BindView(R.id.telefoneTxt)
    TextView telefoneTxt;
    @BindView(R.id.celularTxt)
    TextView celularTxt;
    @BindView(R.id.conjugeTxt)
    TextView conjugeTxt;
    @BindView(R.id.tipoTxt)
    TextView tipoTxt;
    @BindView(R.id.timeTxt)
    TextView timeTxt;

    ClientStatusService clientStatusService;
    boolean mBound = false;
    View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(false);
        super.onCreate(savedInstanceState);
        getActivity().setTitle(getString(R.string.dados_cliente));
    }

    @Override
    public void onStart() {
        Intent intent = new Intent(getActivity(), ClientStatusService.class);
        getActivity().bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dados, null);
        ButterKnife.bind(this, view);
        mView = view;
        bindClient();
        return view;
    }

    private void bindClient() {
        Cliente cliente = JsonUtils.getClientFromString(FileUtils.getJsonString(getActivity(), "clientes.json"));
        razaoSocial.setText(cliente.getRazaoSocial());
        fantasiaTxt.setText(cliente.getNomeFantasia());
        cnpjTxt.setText(cliente.getCnpj());
        ramoAtividadeTxt.setText(cliente.getRamoAtividade());
        enderecoTxt.setText(cliente.getEndereco());
        bindContato(cliente.getContatos());
    }

    private void bindContato(List<Contato> contatos) {
        Contato contato = contatos.get(0);          // Se eu tivesse mais tempo, subtituiria
        nomeContatoTxt.setText(contato.getNome());  // o card estático na view por uma recyclerview, já que 'contatos' é uma lista.
        telefoneTxt.setText(contato.getTelefone()); // Mas como só há um item na lista, e não tenho mais tempo pra enviar o teste a vocês,
        celularTxt.setText(contato.getCelular());   // vou deixar assim.
        conjugeTxt.setText(contato.getConjuge());
        tipoTxt.setText(contato.getTipo());
        timeTxt.setText(contato.getTime());
    }

    @OnClick(R.id.button)
    public void onButtonClick(View v) {
        if (mBound) {
            String status = clientStatusService.getClientStatus();
            final Snackbar snackbar = Snackbar.make(mView, status, Snackbar.LENGTH_LONG);
            snackbar.setAction(getString(R.string.fechar), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            ClientStatusService.ClientStatusBinder binder = (ClientStatusService.ClientStatusBinder) service;
            clientStatusService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };
}

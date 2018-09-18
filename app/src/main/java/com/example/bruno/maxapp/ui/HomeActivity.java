package com.example.bruno.maxapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bruno.maxapp.R;
import com.example.bruno.maxapp.utils.NetworkUtils;
import com.example.bruno.maxapp.utils.PackageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.connectionCloud)
    ImageView connectionCloud;
    @BindView(R.id.appVersionTxt)
    TextView appVersionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        checkConnection();
        appVersionTxt.setText(PackageUtils.getVersion(this));
    }

    private void checkConnection() {
        if(NetworkUtils.isOnline(this)){
            connectionCloud.setImageDrawable(getDrawable(R.drawable.ic_maxima_nuvem_conectado));
        }else{
            connectionCloud.setImageDrawable(getDrawable(R.drawable.ic_maxima_nuvem_desconectado));
        }
    }

    @OnClick(R.id.clientesCard)
    public void onClientesCardClick(){
        startActivity(new Intent(this, FragmentBaseActivity.class));
    }
}

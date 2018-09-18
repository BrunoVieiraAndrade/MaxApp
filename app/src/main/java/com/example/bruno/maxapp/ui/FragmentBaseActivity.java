package com.example.bruno.maxapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.bruno.maxapp.R;
import com.example.bruno.maxapp.ui.dadoscliente.DadosFragment;
import com.example.bruno.maxapp.ui.alvaras.AlvaraFragment;
import com.example.bruno.maxapp.ui.historicopedidos.HistoricoFragment;

public class FragmentBaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_do_cliente);
        loadFragment(new DadosFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_dados:
                fragment = new DadosFragment();
                break;

            case R.id.navigation_historico:
                fragment = new HistoricoFragment();
                break;

            case R.id.navigation_alvaras:
                fragment = new AlvaraFragment();
                break;
        }

        return loadFragment(fragment);
    }
}

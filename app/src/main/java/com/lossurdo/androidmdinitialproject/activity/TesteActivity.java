package com.lossurdo.androidmdinitialproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lossurdo.androidmdinitialproject.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

public class TesteActivity extends AppCompatActivity {

    @Bind(R.id.btnDialog1)
    Button btnDialog1;

    @Bind(R.id.btnMapa)
    Button btnMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        ButterKnife.bind(this);

        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.d("Clicado no botão de Diálogo 1");
                Toast.makeText(TesteActivity.this, "Clicado no botão de Diálogo 1", Toast.LENGTH_SHORT).show();
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.d("Clicado no botão de MAPA");
                startActivity(new Intent(getBaseContext(), MapaActivity.class));
            }
        });
    }

}

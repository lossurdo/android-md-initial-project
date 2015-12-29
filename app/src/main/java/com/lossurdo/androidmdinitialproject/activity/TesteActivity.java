package com.lossurdo.androidmdinitialproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lossurdo.androidmdinitialproject.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import nl.changer.android.opensource.Utils;
import timber.log.Timber;

public class TesteActivity extends AppCompatActivity {

    @Bind(R.id.btnDialog1)
    Button btnDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        ButterKnife.bind(this);

        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.d("Clicado no botão de Diálogo 1");
                Utils.showConfirmDialog(v.getContext()
                        , "Deseja mesmo executar esta operação?", null, null
                        , "Sim", "Não");
            }
        });
    }

}

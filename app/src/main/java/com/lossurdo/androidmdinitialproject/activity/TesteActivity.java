package com.lossurdo.androidmdinitialproject.activity;

import android.os.storage.StorageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lossurdo.androidmdinitialproject.R;
import com.lossurdo.androidmdinitialproject.util.ActivityUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import nl.changer.android.opensource.AudioUtils;
import nl.changer.android.opensource.BuildConfig;
import nl.changer.android.opensource.ImageUtils;
import nl.changer.android.opensource.JSONUtils;
import nl.changer.android.opensource.MediaUtils;
import nl.changer.android.opensource.MimeType;
import nl.changer.android.opensource.NetworkManager;
import nl.changer.android.opensource.Utils;
import nl.changer.android.opensource.ViewUtils;
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

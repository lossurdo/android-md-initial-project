package com.lossurdo.androidmdinitialproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lossurdo.androidmdinitialproject.R;
import com.lossurdo.androidmdinitialproject.rest.OmdbService;
import com.lossurdo.androidmdinitialproject.util.infra.ConnectivityUtil;
import com.lossurdo.androidmdinitialproject.util.infra.Preferencias;
import com.lossurdo.androidmdinitialproject.util.infra.RestUtil;
import com.lossurdo.androidmdinitialproject.rest.Seriado;
import com.lossurdo.androidmdinitialproject.util.view.SnackbarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements Callback<Seriado> {

    @Bind(R.id.btnTrocarActivity)
    Button btnTrocarActivity;

    @Bind(R.id.btnPesquisar)
    Button btnPesquisar;

    @Bind(R.id.editPesquisa)
    EditText editPesquisa;

    @Bind(R.id.tvDebug)
    TextView tvDebug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Timber.plant(new Timber.DebugTree());
        ButterKnife.bind(this);

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OmdbService service = (OmdbService) RestUtil.create("http://www.omdbapi.com", OmdbService.class);
                Call<Seriado> call = service.consultaSeriadoPorTitulo(editPesquisa.getText().toString());
                call.enqueue(MainActivity.this);
            }
        });

        btnTrocarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), TesteActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timber.d("Abrindo snackbar");

                SnackbarUtil.make(view, "Salário: " +
                        Preferencias.getFloat(getBaseContext(), "vlrSalario"));
            }
        });
    }

    @Override
    public void onResponse(Response<Seriado> response, Retrofit retrofit) {
        Seriado s = response.body();
        tvDebug.setText(s.toString());
    }

    @Override
    public void onFailure(Throwable t) {
        Timber.e(t, "Ooops! Deu erro!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(getBaseContext(), PreferenciasActivity.class));
            return true;
        }

        if (id == R.id.action_check_connection) {
            boolean conectado = ConnectivityUtil.isConnected(this);
            boolean wifi = ConnectivityUtil.isConnectedWifi(this);
            boolean mobile = ConnectivityUtil.isConnectedMobile(this);

            StringBuilder sb = new StringBuilder();
            sb.append("Conectado? ").append(conectado).append(" | ");
            sb.append("Wifi? ").append(wifi).append(" | ");
            sb.append("3G/4G? ").append(mobile);

            Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

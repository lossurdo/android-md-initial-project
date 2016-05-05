package com.lossurdo.androidmdinitialproject.activity;

<<<<<<< HEAD
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
=======
import android.location.Location;
>>>>>>> 27677701f8562d6a0a0eda3f2aca2815915eb281
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lossurdo.androidmdinitialproject.R;
import com.lossurdo.androidmdinitialproject.util.infra.LocatorUtil;

import butterknife.ButterKnife;
import timber.log.Timber;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback {

    private GoogleMap mMap;
    private final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        ButterKnife.bind(this);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(MapaActivity.this, "Acesso ao GPS necessário!", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }

        } else {
            Timber.d("Permissão JÁ concedida!");
            renderizaMapa();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    renderizaMapa();
                } else {
                    Toast.makeText(MapaActivity.this, "No pain, no gain!", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void renderizaMapa() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentMapa);
        mapFragment.getMapAsync(this);
        Timber.d("Mapa carregado...");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

<<<<<<< HEAD
        Timber.d("Mapa pronto!");
        LocatorUtil loc = new LocatorUtil(getBaseContext());
        loc.getLocation(LocatorUtil.Method.NETWORK_THEN_GPS, new LocatorUtil.Listener() {
            @Override
            public void onLocationFound(Location location) {
                Timber.d("Localização encontrada");
                LatLng local = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(local).title("Estou aqui!"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 15));
=======
        LocatorUtil loc = new LocatorUtil(getBaseContext());
        loc.getLocation(LocatorUtil.Method.GPS, new LocatorUtil.Listener() {
            @Override
            public void onLocationFound(Location location) {
                LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latlng).title("Estou aqui!"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15));
>>>>>>> 27677701f8562d6a0a0eda3f2aca2815915eb281
            }

            @Override
            public void onLocationNotFound() {
<<<<<<< HEAD
                Toast.makeText(MapaActivity.this, "Localização não pode ser obtida!", Toast.LENGTH_SHORT).show();
            }
        });

=======
                Toast.makeText(MapaActivity.this,
                        "Localização não encontrada!", Toast.LENGTH_LONG).show();
            }
        });
>>>>>>> 27677701f8562d6a0a0eda3f2aca2815915eb281
    }
}

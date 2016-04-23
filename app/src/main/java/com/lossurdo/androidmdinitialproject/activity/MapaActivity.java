package com.lossurdo.androidmdinitialproject.activity;

import android.location.Location;
import android.os.Bundle;
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

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentMapa);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LocatorUtil loc = new LocatorUtil(getBaseContext());
        loc.getLocation(LocatorUtil.Method.GPS, new LocatorUtil.Listener() {
            @Override
            public void onLocationFound(Location location) {
                LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latlng).title("Estou aqui!"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15));
            }

            @Override
            public void onLocationNotFound() {
                Toast.makeText(MapaActivity.this,
                        "Localização não encontrada!", Toast.LENGTH_LONG).show();
            }
        });
    }
}

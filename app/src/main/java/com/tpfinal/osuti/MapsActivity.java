package com.tpfinal.osuti;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static Long mConsultorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng coordenadas = new LatLng(-31.648314702376766, -60.71884893690456);
        String titulo = "Hospital Jose Maria Cuyen";

        if (mConsultorio == 1) {
            coordenadas = new LatLng(-31.64149917120655, -60.700372162917716);
            titulo = "Sanatorio Santa Fe";
        } else if (mConsultorio == 2) {
            coordenadas = new LatLng(-31.640291200644462, -60.70225612064143);
            titulo = "Sanatorio Garay";
        } else if (mConsultorio == 3) {
            coordenadas = new LatLng(-31.648314702376766, -60.71884893690456);
            titulo = "Hospital Jose Maria Cuyen";
        } else if (mConsultorio == 4) {
            coordenadas = new LatLng(-31.63729916044289, -60.70589865778238);
            titulo = "Sanatorio San Geronimo";
        } else if (mConsultorio == 5) {
            coordenadas = new LatLng(-31.6387357750325, -60.70341425107057);
            titulo = "Sanatorio Diagnostico";
        } else if (mConsultorio == 6) {
            coordenadas = new LatLng(-31.640474500471992, -60.70326593297864);
            titulo = "Sanatorio Mayo";
        }
        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(coordenadas).title(titulo));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coordenadas));
        mMap.setMinZoomPreference(18.0f);
        mMap.setMaxZoomPreference(22.0f);
    }
}
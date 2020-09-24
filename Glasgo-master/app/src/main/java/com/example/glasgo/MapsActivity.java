package com.example.glasgo;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean isAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle = getIntent().getExtras();
        isAuth = bundle.getBoolean("authenticated");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Glasgow and move the camera
        LatLng mainBuilding = new LatLng(55.872332, -4.288034);
        mMap.addMarker(new MarkerOptions().position(mainBuilding).title("You starting here!"));

        float zoomLevel = 16.0f;
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mainBuilding, zoomLevel));

    }

    public void startExploreActivity(View view) {
        Intent exploreIntent;
        if (isAuth) {
            exploreIntent = new Intent(this,CameraActivity.class);
            startActivity(exploreIntent);
        } else {
            exploreIntent = new Intent(this, ExploreActivity.class);
            startActivity(exploreIntent);
        }
    }

    public void startBuildingActivity(View view) {
        Intent buildingIntent;
        buildingIntent = new Intent(this, BuildingInfoActivity.class);
        startActivity(buildingIntent);
    }

}

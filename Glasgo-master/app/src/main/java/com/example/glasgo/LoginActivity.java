package com.example.glasgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMapActivityAuth(View view){
        Intent mapPageIntent = new Intent(this, MapsActivity.class);
        mapPageIntent.putExtra("authenticated", true);
        startActivity(mapPageIntent);
    }

    public void startExploreActivity(View view) {
        Intent exploreIntent;
            exploreIntent = new Intent(this, ExploreActivity.class);
            startActivity(exploreIntent);
        }
}

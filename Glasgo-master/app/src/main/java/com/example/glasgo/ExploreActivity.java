package com.example.glasgo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ExploreActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Schools));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
    }

    public void startMapActivityAuth(View view){
        Intent mapPageIntent = new Intent(this, MapsActivity.class);
        mapPageIntent.putExtra("authenticated", true);
        startActivity(mapPageIntent);
    }



}

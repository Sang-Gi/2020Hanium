package com.example.master_piece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainGPSActivity extends AppCompatActivity {

    ImageButton gpsset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gpsset = (ImageButton) findViewById(R.id.gpsset);

        gpsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainGPSActivity.this, GpsActivity.class);
                MainGPSActivity.this.startActivity(registerIntent);
            }
        });

    }
}

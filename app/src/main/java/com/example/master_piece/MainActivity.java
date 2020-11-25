package com.example.master_piece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_search2 = (Button) findViewById(R.id.btn_search2);
        btn_search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addressIntent = new Intent(MainActivity.this, DaumWebViewActivity.class);
                MainActivity.this.startActivity(addressIntent);
            }
        });

        Button btn_locationset = (Button) findViewById(R.id.btn_locationset);
        btn_locationset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gpsIntent = new Intent(MainActivity.this, GpsActivity.class);
                MainActivity.this.startActivity(gpsIntent);
            }
        });
    }
}

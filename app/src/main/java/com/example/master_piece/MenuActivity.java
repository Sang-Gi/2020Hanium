package com.example.master_piece;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    TextView center;
    Button info_button, return_base, post_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        info_button = (Button)findViewById(R.id.info_button);
        post_btn = (Button)findViewById(R.id.post_btn);

        return_base = (Button)findViewById(R.id.return_base);

        center = (TextView) findViewById(R.id.center1);

        Bundle intent_info = getIntent().getExtras();
        center.setText(intent_info.getString("sisul"));


        final String center1 = center.getText().toString();


        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_info = new Intent(getApplicationContext(), info.class);
                intent_info.putExtra("center1", center1);
                startActivity(intent_info);
            }
        });

        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_post = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent_post);
            }
        });



        return_base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_return_base = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_return_base);
            }
        });







    }
}

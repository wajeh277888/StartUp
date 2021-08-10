package com.example.startup.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.startup.R;

public class mainSelection extends AppCompatActivity {

    Button buyprof,freightprof,shopprof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);

        buyprof=findViewById(R.id.buyersidebtn);
        freightprof=findViewById(R.id.freightsidebtn);
        shopprof=findViewById(R.id.shopsidebtn);

        buyprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mainSelection.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        freightprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(mainSelection.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        shopprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(mainSelection.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
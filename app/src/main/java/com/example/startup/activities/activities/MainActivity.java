package com.example.startup.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.startup.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button starting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAuth mainauth;
        starting=findViewById(R.id.getstartedbtn);

        starting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FirebaseAuth.getInstance().getCurrentUser()!=null)
                {
                    Toast.makeText(MainActivity.this, "You are already logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, home.class));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Not logged in?", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, login.class));
                }
            }
        });
    }
}
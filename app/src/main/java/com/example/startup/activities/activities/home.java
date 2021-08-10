package com.example.startup.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startup.R;
import com.example.startup.activities.Models.prods;
import com.example.startup.activities.adaptars.prodAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    ActionBarDrawerToggle synch;
    private FirebaseAuth Authent;

    ActionBarDrawerToggle obj;
    ArrayList<prods> prodlist = new ArrayList<>();
    prodAdapter adapter = new prodAdapter(prodlist);
    FirebaseFirestore firebaseFirestore;


    RecyclerView recyclerView;

    Button logout;
    private MenuItem item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpFirestore();
        setUpViews();
        setUpRecyclerView();


        logout = findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(home.this, MainActivity.class));
                finish();
            }


        });

    }


    public void setUpViews(){
        setUpFirestore();
        setupdrawerlayout();
    }
    public void setupdrawerlayout(){
        setSupportActionBar(findViewById(R.id.appbar));
        synch= new ActionBarDrawerToggle(home.this, findViewById(R.id.main_drawer), R.string.app_name, R.string.app_name);
        synch.syncState();
    }

  /*  @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.item = item;
        if(synch.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);

    }*/

    private void populateDummyData() {
        prodlist.add(new prods("12-01-2021", "Mango",1000));
        prodlist.add(new prods("12-01-2021", "Mango",1000));
        prodlist.add(new prods("12-01-2021", "Mango",1000));
        prodlist.add(new prods("12-01-2021", "Mango",1000));

    }
    private void setUpFirestore() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        String TAG = "WISHA123";

        firebaseFirestore.collection("quizzes").addSnapshotListener((value, error) -> {
            if (value != null) {
                Log.i(TAG, "setUpFirestore: " + value);
                Log.i(TAG, value.toObjects(prods.class).toString());
                prodlist.clear();
                prodlist.addAll(value.toObjects(prods.class));
                adapter.notifyDataSetChanged();

            }
            if (value == null || error != null) {
                Toast.makeText(this, "Cannot retrieve Data", Toast.LENGTH_SHORT);
            }
        });


    }

/*    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (prodlist.onOptionsItemSelected(item)) {
            return (true);

        }
        return super.onOptionsItemSelected(item);
    }*/

    private void setUpRecyclerView() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = findViewById(R.id.prodRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }


}
package com.example.startup.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.startup.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private FirebaseAuth authent;
    Button signinbtn;
    EditText em,ps;       //em=email, ps=password
    TextView tosignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        authent=FirebaseAuth.getInstance();
        signinbtn=findViewById(R.id.loginbtn);
        em=findViewById(R.id.logemail);
        ps=findViewById(R.id.logpass);
        tosignup=findViewById(R.id.logtosignup);
        //cps=findViewById(R.id.confirmpassword);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsignin();

                Intent intent=new Intent(login.this, mainSelection.class);
                startActivity(intent);
                finish();
            }
        });
        tosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this, signup.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void newsignin(){
        String email=em.getText().toString();
        String pass=ps.getText().toString();
        //String cpass=cps.getText().toString();
        Log.i("wajeh",email);
        Log.i("wajeh",pass);
        //Log.i("wajeh",cpass);


        authent.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(login.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                            //Log.d("wajeh", "createUserWithEmail:success");
                            // FirebaseUser user = authent.getCurrentUser();
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w("wajeh", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });

    }
}
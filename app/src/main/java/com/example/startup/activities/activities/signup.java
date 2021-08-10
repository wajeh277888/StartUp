package com.example.startup.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.startup.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    private FirebaseAuth authent;
    Button signupbtn;
    EditText em,ps,cps;       //em=email, ps=password, cpc=confirmpassword
    TextView tolog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        authent=FirebaseAuth.getInstance();
        signupbtn=findViewById(R.id.btnSignUp);
        em=findViewById(R.id.emailaddress);
        ps=findViewById(R.id.password);
        cps=findViewById(R.id.confirmpassword);
        tolog=findViewById(R.id.tologin);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsignup();

                Intent intent=new Intent(signup.this, mainSelection.class);
                startActivity(intent);
                finish();

            }
        });
        tolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signup.this, login.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void newsignup(){
        String email=em.getText().toString();
        String pass=ps.getText().toString();
        String cpass=cps.getText().toString();
        Log.i("wajeh",email);
        Log.i("wajeh",pass);
        Log.i("wajeh",cpass);


        authent.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user=new User(email,pass);
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);
                            Toast.makeText(signup.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                            Log.d("wajeh", "createUserWithEmail:success");
                           // FirebaseUser user = authent.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("wajeh", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
package com.example.indkoebsliste;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createuser);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button createUserBtn = findViewById(R.id.createUserButton);

        createUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailInput = findViewById(R.id.editTextLoginEmail);
                EditText passwordInput = findViewById(R.id.editTextPassword);

                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent goToHome = new Intent(CreateUserActivity.this, HomeActivity.class);
                            startActivity(goToHome);
                        } else {
                            Toast.makeText(CreateUserActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}

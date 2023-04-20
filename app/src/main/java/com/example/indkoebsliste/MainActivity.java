package com.example.indkoebsliste;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listlayout = findViewById(R.id.linearLayout1);
        addVareBtn = findViewById(R.id.button2);
        Button test = findViewById(R.id.button3);
                test.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goToUserCreation = new Intent(MainActivity.this, CreateUserActivity.class);
                        startActivity(goToUserCreation);
                    }
                });

    }
}



/* private FirebaseFirestore db = FirebaseFirestore.getInstance(); */
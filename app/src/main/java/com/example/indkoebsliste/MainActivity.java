package com.example.indkoebsliste;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button test = findViewById(R.id.button3);
                test.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goToList = new Intent(MainActivity.this, HverdagslistActivity.class);
                        startActivity(goToList);
                    }
                });

    }
}



/* private FirebaseFirestore db = FirebaseFirestore.getInstance(); */
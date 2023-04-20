package com.example.indkoebsliste;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.widget.Button;

import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout listlayout;
    private Button addVareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Vare vare = new Vare("Mælk", false);
        Hverdagslisten hverdagslisten = new Hverdagslisten();
        hverdagslisten.addVare(vare);
        System.out.println(hverdagslisten);
        listlayout = findViewById(R.id.linearLayout1);
        addVareBtn = findViewById(R.id.button2);
    }
}



/* private FirebaseFirestore db = FirebaseFirestore.getInstance(); */
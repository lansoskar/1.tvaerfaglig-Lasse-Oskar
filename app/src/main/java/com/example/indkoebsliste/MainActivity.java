package com.example.indkoebsliste;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hverdagslisten);
        Vare vare = new Vare("Mælk", false);
        Hverdagslisten hverdagslisten = new Hverdagslisten();
        hverdagslisten.addVare(vare);
        System.out.println(hverdagslisten);
    }
    }


/* private FirebaseFirestore db = FirebaseFirestore.getInstance(); */
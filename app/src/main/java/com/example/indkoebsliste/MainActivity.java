package com.example.indkoebsliste;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout listlayout;
    private Button addVareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hverdagslisten);
        Vare vare = new Vare("Mælk", false);
        Hverdagslisten hverdagslisten = new Hverdagslisten();
        hverdagslisten.addVare(vare);
        System.out.println(hverdagslisten);
        listlayout = findViewById(R.id.linearLayout1);
        addVareBtn = findViewById(R.id.button2);
    }
}



/* private FirebaseFirestore db = FirebaseFirestore.getInstance(); */
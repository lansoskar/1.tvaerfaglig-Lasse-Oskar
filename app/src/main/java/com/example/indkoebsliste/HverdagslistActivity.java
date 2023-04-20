package com.example.indkoebsliste;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HverdagslistActivity extends AppCompatActivity {
    private LinearLayout listlayout;
    private Button addVareBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hverdagslisten);
        listlayout = findViewById(R.id.linearLayout1);
        addVareBtn = findViewById(R.id.button2);

        addVareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}

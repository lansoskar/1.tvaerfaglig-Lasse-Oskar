package com.example.indkoebsliste;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HverdagslistActivity extends AppCompatActivity {
    private LinearLayout listlayout;
    private Button addVareBtn;
    private EditText userInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hverdagslisten);

        listlayout = findViewById(R.id.LinearLayout1);
        addVareBtn = findViewById(R.id.button2);
        EditText userInput = findViewById(R.id.editTextAddVare);

        addVareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //take text from edittext as string
                String vareToAdd = userInput.getText().toString();
                //create new textview and add to linear layout (+ add button / convert to vare objekt?)
                //relativt layout line - textview + checkbox
                RelativeLayout line = new RelativeLayout(HverdagslistActivity.this);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                line.setLayoutParams(layoutParams);
                //textview baseret på userinput
                TextView displayAddedVare = new TextView(HverdagslistActivity.this);
                RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                textParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                displayAddedVare.setText(vareToAdd);
                displayAddedVare.setTextSize(30f);
                displayAddedVare.setTypeface(Typeface.DEFAULT_BOLD);
                line.addView(displayAddedVare);
                //checkbox
                CheckBox checkBox = new CheckBox(HverdagslistActivity.this);
                RelativeLayout.LayoutParams checkboxParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                checkboxParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                checkBox.setLayoutParams(checkboxParams);
                checkBox.setScaleX(2f);
                checkBox.setScaleY(2f);
                line.addView(checkBox);
                //tilføj relativt layout til linear layout
                listlayout.addView(line);
                userInput.setHint("Indsæt vare her");


                // lav horizontal layout og smid elementer i + tilføj til vertical layout
            }
        });
    }

}

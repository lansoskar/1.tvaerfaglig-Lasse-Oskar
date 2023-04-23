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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HverdagslistActivity extends AppCompatActivity {
    private LinearLayout listlayout;
    private Button addVareBtn;
    private Button syncListBtn;
    private EditText userInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hverdagslisten);

        listlayout = findViewById(R.id.LinearLayout1);
        addVareBtn = findViewById(R.id.button2);
        syncListBtn = findViewById(R.id.syncList);
        EditText userInput = findViewById(R.id.editTextAddVare);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        //Oskar
        //specificer hvilken collection og subcollection vi skal hive fat i
        CollectionReference usersRef = db.collection("Users");
        String userId = auth.getCurrentUser().getEmail();
        DocumentReference userDocRef = usersRef.document(userId);
        CollectionReference subCollectionRef = userDocRef.collection("List");
        //for hvert elemetn i collection lav textview og checkbox sammen i relativt layout og tilføj-
        //- til linear layout
        //Oskar
        subCollectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot querySnapshot = task.getResult();
                    for (QueryDocumentSnapshot documentSnapshot : querySnapshot) {
                        String name = documentSnapshot.getString("name");
                        boolean isChecked = documentSnapshot.getBoolean("isChecked").booleanValue();

                        RelativeLayout line = new RelativeLayout(HverdagslistActivity.this);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        line.setLayoutParams(layoutParams);

                        TextView displayAddedVare = new TextView(HverdagslistActivity.this);
                        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        textParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                        displayAddedVare.setText(name);
                        displayAddedVare.setTextSize(30f);
                        displayAddedVare.setTypeface(Typeface.DEFAULT_BOLD);
                        line.addView(displayAddedVare);

                        CheckBox checkBox = new CheckBox(HverdagslistActivity.this);
                        RelativeLayout.LayoutParams checkboxParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        checkboxParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        checkBox.setLayoutParams(checkboxParams);
                        checkBox.setScaleX(2f);
                        checkBox.setScaleY(2f);
                        checkBox.setChecked(isChecked);
                        line.addView(checkBox);
                        listlayout.addView(line);
                    }
                }
            }
        });
        //Oskar + Lasse
        addVareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //take text from edittext as string
                String vareToAdd = userInput.getText().toString();
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
                displayAddedVare.setId(View.generateViewId());
                line.addView(displayAddedVare);
                //checkbox
                CheckBox checkBox = new CheckBox(HverdagslistActivity.this);
                RelativeLayout.LayoutParams checkboxParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                checkboxParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                checkBox.setLayoutParams(checkboxParams);
                checkBox.setScaleX(2f);
                checkBox.setScaleY(2f);
                checkBox.setId(View.generateViewId());
                line.addView(checkBox);
                //tilføj relativt layout til linear layout
                listlayout.addView(line);
                userInput.setHint("Indsæt vare her");

                Map<String, Object> itemToFireStore = new HashMap<>();
                itemToFireStore.put("name", vareToAdd);
                itemToFireStore.put("isChecked", false);

                subCollectionRef.document(displayAddedVare.getId() + "").set(itemToFireStore);
            }
        });
        syncListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Gå igennem alle child elements af linear layout
            //  opdater FireStore baseret på status af checkBox værdi
            }
        });
    }

}

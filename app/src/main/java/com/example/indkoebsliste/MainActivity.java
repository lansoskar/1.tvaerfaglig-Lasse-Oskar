package com.example.indkoebsliste;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        String userId = auth.getCurrentUser().getEmail();
        DocumentReference userDocRef = db.collection("Users").document(userId);

        CollectionReference subCollectionRef = userDocRef.collection("List");
        //Hvis brugeren ikke har en liste lav en under List i FireStore
        subCollectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot querySnapshot = task.getResult();
                    if (querySnapshot.isEmpty()) {
                        // The subcollection doesn't exist, create it
                        Map<String, Object> subDocument = new HashMap<>();
                        subCollectionRef.add(subDocument);
                    } else {

                    }
                }
            }
        });

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

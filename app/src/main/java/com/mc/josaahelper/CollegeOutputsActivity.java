package com.mc.josaahelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CollegeOutputsActivity extends AppCompatActivity {
    private TextView rank,branch,gender,exam;
    private RecyclerView recyclerView;
    private ArrayList<CollegeDetails>coDetails = new ArrayList<>();
    private CollegeAdapter collegeAdapter;
    private Bundle bundle;
    private FirebaseFirestore db;
    private CollectionReference docRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_outputs);

        rank = findViewById(R.id.enteredRank1);
        branch = findViewById(R.id.selectedBranch1);
        gender = findViewById(R.id.selectedGender1);
        exam = findViewById(R.id.selectedExam1);
        //FirebaseApp.initializeApp(CollegeOutputsActivity.this);
        //FirebaseApp app = FirebaseApp.initializeApp(this);
        db = FirebaseFirestore.getInstance();
        docRef = db.collection("ORCR1");

        bundle = getIntent().getExtras();
        //Bundle bundle = getIntent().getExtras();
        rank.setText(bundle.getString("Rank"));
        branch.setText(bundle.getString("Branch"));
        gender.setText(bundle.getString("Gender"));
        exam.setText(bundle.getString("Exam"));

        Log.d("OnCreate","On Create");
        recyclerView = findViewById(R.id.collegeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //getData();
        //getData2();
        showData();
        collegeAdapter = new CollegeAdapter(coDetails);
        recyclerView.setAdapter(collegeAdapter);
    }

    private void getData2() {
        db.collection("JOSSA_INSTITUTE")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("CollegeOutputActivity", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("CollegeOutputActivity", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    private void showData() {
    db.collection("ORCR1")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        coDetails.clear();
                        for (QueryDocumentSnapshot snapshot : task.getResult()) {
                            if(snapshot.getString("exam").equals((String)exam.getText())  && snapshot.getString("gender").equals((String)gender.getText()) &&
                                    snapshot.getString("seatType").equals(bundle.getString("Category")) && snapshot.getString("quota").equals(bundle.getString("Quota")) &&
                                    Integer.parseInt((String)rank.getText()) <= Integer.parseInt(snapshot.getString("closingRank")) && Integer.parseInt((String) rank.getText()) >= Integer.parseInt(snapshot.getString("openingRank"))){
                                Log.d("CollegeOutputActivity", snapshot.getString("exam"));
                                String a = snapshot.getString("academicProgramName");
                                String b = (String)branch.getText();
                                Set<String> words = new HashSet<>(Arrays.asList(a.toLowerCase().split("\\s+")));
                                Set<String>words1 = new HashSet<>(Arrays.asList(b.toLowerCase().split("\\s+")));
                                words.retainAll(words1);
                                if(words.size()>=2 || (words.size()==1 && words.contains("engineering")==false)){
                                    CollegeDetails cod = new CollegeDetails(snapshot.getString("institute"),snapshot.getString("academicProgramName"),snapshot.getString("seatType"),
                                            snapshot.getString("exam"),snapshot.getString("gender"),Integer.parseInt(snapshot.getString("openingRank")),Integer.parseInt(snapshot.getString("closingRank"))
                                            , snapshot.getString("quota"));
                                    coDetails.add(cod);
                                }
                            };
                        }
                        collegeAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(CollegeOutputsActivity.this, "Error getting documents.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
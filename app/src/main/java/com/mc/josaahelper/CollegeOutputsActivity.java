package com.mc.josaahelper;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_outputs);

        rank = findViewById(R.id.enteredRank1);
        branch = findViewById(R.id.selectedBranch1);
        gender = findViewById(R.id.selectedGender1);
        exam = findViewById(R.id.selectedExam1);
        db = FirebaseFirestore.getInstance();

        bundle = getIntent().getExtras();
        rank.setText(bundle.getString("Rank"));
        branch.setText(bundle.getString("Branch"));
        gender.setText(bundle.getString("Gender"));
        exam.setText(bundle.getString("Exam"));

        Log.d("OnCreate","On Create");
        recyclerView = findViewById(R.id.collegeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        showData();
        collegeAdapter = new CollegeAdapter(coDetails);
        recyclerView.setAdapter(collegeAdapter);
    }

    private void showData() {
        //CollectionReference orcr1=;
        db.collection("ORCR1")
                .whereEqualTo("exam", exam.getText())
                .whereEqualTo("gender", gender.getText())
                .whereEqualTo("seatType", (String)bundle.getString("Category"))
                .whereEqualTo("quota", (String)bundle.getString("Quota"))
                //.orderBy("exam")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            coDetails.clear();
                            for (QueryDocumentSnapshot snapshot : task.getResult()) {
                                Log.d("CollegeOutputActivity", snapshot.getString("exam")+" "+ snapshot.getString("seatType")+" "+ snapshot.getString("gender"));
                                Log.d("CollegeOutputActivity",exam.getText().toString()+" "+bundle.getString("Category")+" "+gender.getText().toString());
                                Log.d("CollegeOutputActivity",snapshot.getString("quota")+" "+snapshot.getString("openingRank")+" "+snapshot.getString("closingRank"));
                                Log.d("CollegeOutputActivity",bundle.getString("Quota")+" "+ rank.getText().toString());
                                if(rank.getText().toString().compareTo(snapshot.getString("closingRank"))<=0) {
                                    String a = snapshot.getString("academicProgramName");
                                    Log.d("CollegeActivity", snapshot.getString("academicProgramName") + " " + branch.getText().toString());
                                    String b = (String) branch.getText();
                                    Set<String> words = new HashSet<>(Arrays.asList(a.toLowerCase().split("\\s+")));
                                    Set<String> words1 = new HashSet<>(Arrays.asList(b.toLowerCase().split("\\s+")));
                                    words.retainAll(words1);
                                    if (words.size() >= 2 || (words.size() == 1 && words.contains("engineering") == false)) {
                                        String openrank = snapshot.getString("openingRank");
                                        String closerank = snapshot.getString("closingRank");
                                        if(closerank.charAt(closerank.length()-1)=='P')
                                        {
                                            openrank = openrank.substring(0,openrank.length()-1);
                                            closerank= closerank.substring(0,closerank.length()-1);
                                        }
                                        CollegeDetails cod = new CollegeDetails(snapshot.getString("institute"), snapshot.getString("academicProgramName"), snapshot.getString("seatType"),
                                                snapshot.getString("exam"), snapshot.getString("gender"), Integer.parseInt(openrank), Integer.parseInt(closerank)
                                                , snapshot.getString("quota"));
                                        coDetails.add(cod);
                                    }
                                }
                            }
                            collegeAdapter.notifyDataSetChanged();
                        }else {
                            Log.d("CollegeOutputActivity","Error getting documents");
                            Toast.makeText(CollegeOutputsActivity.this, "Error getting documents.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        Collections.sort(coDetails, new Comparator<CollegeDetails>() {
            @Override
            public int compare(CollegeDetails a, CollegeDetails b) {
                if (a.getCloserank()<= b.getCloserank()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        Log.d("GetData","Get Data");
    }
}
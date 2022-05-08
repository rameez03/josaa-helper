package com.mc.josaahelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollegeProfileActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirebaseFirestore db;
    private CollegeProfileAdapter mCollegeProfileAdapter;
    private List<CollegeModel> mCollegeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_profile);

        mRecyclerView = findViewById(R.id.profileRecylerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        mCollegeList = new ArrayList<>();
        mCollegeProfileAdapter = new CollegeProfileAdapter(this , mCollegeList);
        mRecyclerView.setAdapter(mCollegeProfileAdapter);
        
        showData();

        //addUser();
        
    }

    private void addUser() {
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("CollegeProfileActivity", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("CollegeProfileActivity", "Error adding document", e);
                    }
                });
    }

    private void showData() {
        db.collection("JOSSA_INSTITUTE")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            mCollegeList.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("CollegeProfileActivity", document.getId() + " => " + document.getData());
                                CollegeModel model = new CollegeModel(document.getString("sNo"), document.getString("instituteCodeAndName"));
                                mCollegeList.add(model);
                            }
                            mCollegeProfileAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(CollegeProfileActivity.this, "Error getting documents.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
//        db.collection("JOSSA_INSTITUTE").get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        mCollegeList.clear();
//                        for (DocumentSnapshot snapshot: task.getResult()){
//                            CollegeModel model = new CollegeModel(snapshot.getString("sNo"), snapshot.getString("instituteCodeAndName"));
//                            mCollegeList.add(model);
//                        }
//                        mCollegeProfileAdapter.notifyDataSetChanged();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(CollegeProfileActivity.this, "Something went Wrong!!!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
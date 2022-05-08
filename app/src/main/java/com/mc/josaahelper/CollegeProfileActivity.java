package com.mc.josaahelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CollegeProfileActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CollegeProfileAdapter mCollegeProfileAdapter;
    private FirebaseFirestore db;
    private List<CollegeModel> mCollegeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_profile);

        mRecyclerView = findViewById(R.id.profileRecylerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        mCollegeList = new ArrayList<>();
        showData();
        mCollegeProfileAdapter = new CollegeProfileAdapter(this , mCollegeList);
        mRecyclerView.setAdapter(mCollegeProfileAdapter);
        

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
                            Log.d("CollegeProfileActivity", document.getString("sNo") + " => " + document.getString("instituteCodeAndName"));
                            CollegeModel model = new CollegeModel(document.getString("sNo"), document.getString("instituteCodeAndName"));
                            mCollegeList.add(model);
                        }
                        mCollegeProfileAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(CollegeProfileActivity.this, "Error getting documents.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
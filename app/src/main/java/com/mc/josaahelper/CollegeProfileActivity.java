package com.mc.josaahelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CollegeProfileActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private CollegeProfileAdapter adapter;
    private List<CollegeModel> list;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_profile);

        recyclerView=findViewById(R.id.recylerview);
        searchView=findViewById(R.id.searchview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        adapter =new CollegeProfileAdapter(this,list);
        recyclerView.setAdapter(adapter);
        showdata();
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterlist(newText);
                return true;
            }
        });
        adapter.OnRecyclerViewClickListener(new CollegeProfileAdapter.OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(int position) {

                Intent intent = new Intent(CollegeProfileActivity.this, DetailCollegeActivity.class);
                intent.putExtra("CollegeName", list.get(position).getInstituteCodeName() );
                intent.putExtra("Address", list.get(position).getAddress());
                intent.putExtra("Contactinfo", list.get(position).getContactinfo() );
                intent.putExtra("Emailid", list.get(position).getEmailid() );
                intent.putExtra("Phonefax", list.get(position).getPhoneFax());
                intent.putExtra("Sno", list.get(position).getSno() );
                startActivity(intent);
            }
        });

    }
    private void filterlist(String text){
        List<CollegeModel> filter = new ArrayList<>();
        for (CollegeModel model:list){
            if(model.getInstituteCodeName().toLowerCase(Locale.ROOT).contains(text.toLowerCase())){
                filter.add(model);
            }
        }
        if(filter.isEmpty()){
            Toast.makeText(this,"No Data found",Toast.LENGTH_SHORT).show();

        }
        else{
            adapter.setfilter(filter);
        }
    }
    private void showdata(){
        db.collection("JOSSA_INSTITUTE").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for(DocumentSnapshot snap : task.getResult()){
//                            Model model=new Model(snap.getString("id"),snap.getString("instituteCodeAndName"));
                            CollegeModel model=new CollegeModel(snap.getString("address"),snap.getString("contactInformation"),snap.getString("emailId"),snap.getString("instituteCodeAndName"),snap.getString("phoneFaxWebsite"),snap.getString("sNo"));

                            Log.d("CollegeProfileActivity", snap.getString("sNo") + " => " + snap.getString("instituteCodeAndName"));
                            list.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CollegeProfileActivity.this, "ooops...failed", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
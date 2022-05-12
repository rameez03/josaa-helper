package com.mc.josaahelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class DetailCollegeActivity extends AppCompatActivity {
    private TextView collegename,detail;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_college);

        collegename=findViewById(R.id.collegename);
        detail=findViewById(R.id.detail);

        String collegeName=getIntent().getStringExtra("CollegeName");
        String Address=getIntent().getStringExtra("Address");
        String Sno=getIntent().getStringExtra("Sno");
        String Emailid=getIntent().getStringExtra("Emailid");
        String Phonefax=getIntent().getStringExtra("Phonefax");
        String ContactInfo=getIntent().getStringExtra("Contactinfo");
        Log.d("TAG", "onCreate: "+collegeName);


        String message= "\nAddress : "+ Address
                +"\nEmail-id : "+Emailid+"\nPhone Fax Website: \n"+Phonefax+"\nContact Info : "+ContactInfo;

        collegename.setText(collegeName);
        detail.setText(message);

    }
}
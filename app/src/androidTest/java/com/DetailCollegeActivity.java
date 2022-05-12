package com;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.mc.josaahelper.R;

public class DetailCollegeActivity extends AppCompatActivity {
    private TextView collegename,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_college);

        collegename=findViewById(R.id.collegename);
        detail=findViewById(R.id.detail);

        String collegeName=getIntent().getStringExtra("CollegeName");
        String Address=getIntent().getStringExtra("Address");
        String Emailid=getIntent().getStringExtra("Emailid");
        String Phonefax=getIntent().getStringExtra("Phonefax");
        String ContactInfo=getIntent().getStringExtra("Contactinfo");
        String curr_rating=getIntent().getStringExtra("Rating");
        String curr_count=getIntent().getStringExtra("Count");
        String id=getIntent().getStringExtra("id");

        Log.d("TAG", "onCreate: "+collegeName);


        String message= "\nAddress : "+ Address
                +"\nEmail-id : "+Emailid+"\nPhone Fax Website: \n"+Phonefax+"\nContact Info : "+ContactInfo;

        collegename.setText(collegeName);
        detail.setText(message);

    }
}
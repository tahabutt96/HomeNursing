package com.example.homenursing.dashboardmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.homenursing.R;
import com.example.homenursing.feedbackmodule.nurse_feedback;
import com.example.homenursing.nurse_avilibility.nurse_category;
import com.example.homenursing.pharmacymodule.pharmacy_List;

public class patient_dashboard extends AppCompatActivity {
    Button pharm,nurseavailible;
    Button one, two,three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);
        pharm = (Button)findViewById(R.id.patient_pharmacy);
        pharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(patient_dashboard.this, pharmacy_List.class);
                startActivity(intent);
            }
        });
        nurseavailible = (Button)findViewById(R.id.nurse_avalibility);
        nurseavailible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(patient_dashboard.this, nurse_category.class);
                startActivity(intent);
            }
        });
        one = (Button)findViewById(R.id.pthree);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(patient_dashboard.this, "This page is under development", Toast.LENGTH_SHORT).show();
            }
        });
        two = (Button)findViewById(R.id.pfour);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(patient_dashboard.this, "This page is under development", Toast.LENGTH_SHORT).show();
            }
        });

        three = (Button)findViewById(R.id.pfive);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(patient_dashboard.this, nurse_feedback.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
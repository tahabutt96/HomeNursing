package com.example.homenursing.dashboardmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.homenursing.R;
import com.example.homenursing.feedbackmodule.nurse_feedback;
import com.example.homenursing.pharmacymodule.pharmacy_List;
import com.example.homenursing.pharmacymodule.pharmacy_details;

public class nurse_dashboard extends AppCompatActivity {

    Button pharm;
    Button two,three,four,five;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_dashboard);
        pharm = (Button)findViewById(R.id.nurse_pharmacy);
        pharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nurse_dashboard.this, pharmacy_List.class);
                startActivity(intent);
            }
        });

        two = (Button)findViewById(R.id.takeexambtn);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_dashboard.this, "This page is under development", Toast.LENGTH_SHORT).show();
            }
        });

        three = (Button)findViewById(R.id.patient_history_btn);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_dashboard.this, "This page is under development", Toast.LENGTH_SHORT).show();
            }
        });

        four = (Button)findViewById(R.id.nurse_historybutton);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_dashboard.this, "This page is under development", Toast.LENGTH_SHORT).show();
            }
        });

        five = (Button)findViewById(R.id.nurse_feedbackbtn);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nurse_dashboard.this,nurse_feedback.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
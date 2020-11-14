package com.example.homenursing.nurse_avilibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.homenursing.R;
import com.example.homenursing.dashboardmodule.nurse_dashboard;
import com.example.homenursing.dashboardmodule.patient_dashboard;

public class nurse_list extends AppCompatActivity {

    Button hire1,hire2, hire3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_list);

        hire1 = (Button)findViewById(R.id.nurehired1);
        hire1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_list.this, "Nurse Anusha is hired", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(nurse_list.this, nurse_dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        hire2 = (Button)findViewById(R.id.nurehired2);
        hire2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_list.this, "Nurse Rukhsana is hired", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(nurse_list.this, patient_dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        hire3 = (Button)findViewById(R.id.nurehired3);
        hire3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_list.this, "Nurse Farzana is hired", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(nurse_list.this, patient_dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
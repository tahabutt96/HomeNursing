package com.example.homenursing.loginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homenursing.R;

public class UserSelector extends AppCompatActivity {

    Button nursebutt, patientbutt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selector);

        nursebutt = (Button)findViewById(R.id.nurseselector);
        nursebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserSelector.this, NurseLogin.class);
                startActivity(intent);
            }
        });
        patientbutt = (Button)findViewById(R.id.patientselector);
        patientbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserSelector.this, PatientLogin.class);
                startActivity(intent);
            }
        });

    }
}
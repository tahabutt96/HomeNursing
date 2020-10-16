package com.example.homenursing.loginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.homenursing.R;

public class PatientSignUp extends AppCompatActivity {

    Button loginpatient, signuppatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_patient_sign_up);

        loginpatient = findViewById(R.id.login_again);

        loginpatient.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientSignUp.this, PatientLogin.class);
                startActivity(intent);
                finish();
            }
        });

        signuppatient = findViewById(R.id.signuppatient);
        signuppatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientSignUp.this, PatientLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
package com.example.homenursing.patientmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homenursing.Dashboard;
import com.example.homenursing.R;
import com.google.android.material.textfield.TextInputLayout;

public class PatientLogin extends AppCompatActivity {

    Button forgotpasspatient, callsignup, login;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_patient_login);

        callsignup = findViewById(R.id.Signup_screen_nurse);
        image = findViewById(R.id.Logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login = (Button)findViewById(R.id.loginpatient);
        forgotpasspatient =(Button)findViewById(R.id.forgotpasswordpatient);
        forgotpasspatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientLogin.this, Forgotpasswordpatient.class);
                startActivity(intent);
                finish();
            }
        });

        callsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientLogin.this, PatientSignUp.class);
                startActivity(intent);
                finish();
            }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientLogin.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
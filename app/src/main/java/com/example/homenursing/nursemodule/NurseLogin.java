package com.example.homenursing.nursemodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homenursing.dashboardmodule.patient_dashboard;
import com.example.homenursing.R;
import com.google.android.material.textfield.TextInputLayout;

public class NurseLogin extends AppCompatActivity {

    Button callsignup, login, forgotpassnurse;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nurse_login);

        callsignup = findViewById(R.id.Signup_screen_patient);
        image = findViewById(R.id.Logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginnurse);
        forgotpassnurse = findViewById(R.id.forgotpasswordnurse);

        forgotpassnurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NurseLogin.this, Forgetpasswordnurse.class);
                startActivity(intent);
                finish();
            }
        });

        callsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NurseLogin.this, NurseSignUp.class);
                startActivity(intent);
                finish();
            }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NurseLogin.this, patient_dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}


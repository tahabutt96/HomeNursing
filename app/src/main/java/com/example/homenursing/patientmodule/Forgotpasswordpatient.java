package com.example.homenursing.patientmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homenursing.R;

public class Forgotpasswordpatient extends AppCompatActivity {

    Button fn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpasswordpatient);

        fn = findViewById(R.id.recoverpasspatient);
        fn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forgotpasswordpatient.this, PatientLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
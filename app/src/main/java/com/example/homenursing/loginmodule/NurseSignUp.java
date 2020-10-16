package com.example.homenursing.loginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homenursing.R;

public class NurseSignUp extends AppCompatActivity {

    Button signupnurse,loginnurse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_sign_up);

        signupnurse = findViewById(R.id.signupnurse);
        signupnurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NurseSignUp.this, NurseLogin.class);
                startActivity(intent);
                finish();
            }
        });

        loginnurse = findViewById(R.id.login_again);

        loginnurse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NurseSignUp.this, NurseLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
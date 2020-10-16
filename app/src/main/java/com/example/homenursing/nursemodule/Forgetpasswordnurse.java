package com.example.homenursing.nursemodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homenursing.R;

public class Forgetpasswordnurse extends AppCompatActivity {
    Button fp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpasswordnurse);

        fp = findViewById(R.id.recoverpassnurse);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forgetpasswordnurse.this, NurseLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
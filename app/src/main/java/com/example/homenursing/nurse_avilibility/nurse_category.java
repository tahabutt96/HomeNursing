package com.example.homenursing.nurse_avilibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homenursing.R;

public class nurse_category extends AppCompatActivity {

    Button cata, catb, catc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_category);

        cata =(Button)findViewById(R.id.platinumcategory);
        cata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nurse_category.this, nurse_list.class);
                startActivity(intent);
            }
        });
        catb =(Button)findViewById(R.id.bronze_category);
        catb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nurse_category.this, nurse_list.class);
                startActivity(intent);
            }
        });
        catc =(Button)findViewById(R.id.silver_category);
        catc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nurse_category.this, nurse_list.class);
                startActivity(intent);
            }
        });
    }
}
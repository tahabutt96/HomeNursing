package com.example.homenursing.pharmacymodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homenursing.R;

public class pharmacy_List extends AppCompatActivity {

    Button one,two,three,four,five,six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy__list);
        one = (Button)findViewById(R.id.medbtn1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pharmacy_List.this, pharmacy_details.class);
                startActivity(intent);
                finish();
            }
        });
        two = (Button)findViewById(R.id.medbtn2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pharmacy_List.this, pharmacy_details.class);
                startActivity(intent);
                finish();
            }
        });
        three = (Button)findViewById(R.id.medbtn3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pharmacy_List.this, pharmacy_details.class);
                startActivity(intent);
                finish();
            }
        });
        four = (Button)findViewById(R.id.medbtn4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pharmacy_List.this, pharmacy_details.class);
                startActivity(intent);
                finish();
            }
        });
        five = (Button)findViewById(R.id.medbtn5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pharmacy_List.this, pharmacy_details.class);
                startActivity(intent);
                finish();
            }
        });
        six = (Button)findViewById(R.id.medbtn6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pharmacy_List.this, pharmacy_details.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
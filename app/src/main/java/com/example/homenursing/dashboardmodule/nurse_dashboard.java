package com.example.homenursing.dashboardmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.homenursing.R;
import com.example.homenursing.accountmodule.nurse_account;
import com.example.homenursing.common.contact_us;
import com.example.homenursing.common.emergencycall;
import com.example.homenursing.common.nearbymedicalstore;
import com.example.homenursing.common.notifications;
import com.example.homenursing.feedbackmodule.nurse_feedback;
import com.example.homenursing.nursemodule.NurseLogin;
import com.example.homenursing.pharmacymodule.pharmacy_List;
import com.example.homenursing.pharmacymodule.pharmacy_details;
import com.google.android.material.navigation.NavigationView;

public class nurse_dashboard extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private NavigationView nv;

    Button pharm;
    Button two,three,four,five;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_dashboard);

        // this is how navigation drawer is made
        dl = (DrawerLayout)findViewById(R.id.nurse_dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv =(NavigationView)findViewById(R.id.nurse_nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.emergencycall) {
                    Intent intent = new Intent(nurse_dashboard.this, emergencycall.class);
                    startActivity(intent);
                    Toast.makeText(nurse_dashboard.this, "Emergency Call", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nearbyhospt) {
                    Intent intent = new Intent(nurse_dashboard.this, nearbymedicalstore.class);
                    startActivity(intent);
                    Toast.makeText(nurse_dashboard.this, "Nearby Medical Store", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.useraccount) {
                    Intent intent = new Intent(nurse_dashboard.this, nurse_account.class);
                    startActivity(intent);
                    Toast.makeText(nurse_dashboard.this, "User Account", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.notification) {
                    Intent intent1 = new Intent(nurse_dashboard.this, notifications.class);
                    startActivity(intent1);
                    Toast.makeText(nurse_dashboard.this, "notifications", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.settings) {
                    Intent intent2 = new Intent(nurse_dashboard.this, contact_us.class);
                    startActivity(intent2);
                    Toast.makeText(nurse_dashboard.this, "Contact Us", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.logout) {
                    SharedPreferences sharedPreferences = getSharedPreferences("userId", MODE_PRIVATE);
                    SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();
                    //  preferenceEditor.putInt("id", id);
                    preferenceEditor.putString("logged", "");
                    preferenceEditor.apply();

                    Intent intent3 = new Intent(nurse_dashboard.this, NurseLogin.class);
                    startActivity(intent3);

                    Toast.makeText(nurse_dashboard.this, "Logged out", Toast.LENGTH_SHORT).show();
                    finish();

                }
                return true;
            }
        });
        pharm = (Button)findViewById(R.id.nurse_pharmacy);
        pharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nurse_dashboard.this, pharmacy_List.class);
                startActivity(intent);
            }
        });

        two = (Button)findViewById(R.id.takeexambtn);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_dashboard.this, "This page is under development", Toast.LENGTH_SHORT).show();
            }
        });

        three = (Button)findViewById(R.id.patienthistorybutton);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_dashboard.this, "This page is under development", Toast.LENGTH_SHORT).show();
            }
        });

        four = (Button)findViewById(R.id.nurse_historybutton);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(nurse_dashboard.this, "This page is under development", Toast.LENGTH_SHORT).show();
            }
        });

        five = (Button)findViewById(R.id.nurse_feedbackbtn);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nurse_dashboard.this,nurse_feedback.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(abdt.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
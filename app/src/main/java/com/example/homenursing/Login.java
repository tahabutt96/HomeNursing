package com.example.homenursing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button callsignup, login;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        callsignup = findViewById(R.id.Signup_screen);
        image = findViewById(R.id.Logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        callsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
                finish();

                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this, Dashboard.class);
                        startActivity(intent);
                        finish();



                        Pair[] pairs = new Pair[7];
                        pairs[0] = new Pair<View, String>(image, "logo_image");
                        pairs[1] = new Pair<View, String>(logoText, "logo_text");
                        pairs[2] = new Pair<View, String>(sloganText, "slogan_text");
                        pairs[3] = new Pair<View, String>(username, "username_tan");
                        pairs[4] = new Pair<View, String>(password, "password_tan");
                        pairs[5] = new Pair<View, String>(login, "login_tan");
                        pairs[6] = new Pair<View, String>(callsignup, "signup_tan");


                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                            startActivity(intent, options.toBundle());
                        }

                    }
                });

            }

        });
    }
}


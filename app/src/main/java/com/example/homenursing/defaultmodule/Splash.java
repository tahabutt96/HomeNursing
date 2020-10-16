package com.example.homenursing.defaultmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homenursing.R;

public class Splash extends AppCompatActivity {

    private static int SPLASH_SCREEN= 5000;
    //variables

    Animation topanim, bottomanim;
    ImageView image;
    TextView logo,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //animation

        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks

        image = findViewById(R.id.imageview);
        logo = findViewById(R.id.textview);
        slogan = findViewById(R.id.textview2);

        image.setAnimation(topanim);
        logo.setAnimation(bottomanim);
        slogan.setAnimation(bottomanim);

        final Pair [] pairs = new Pair[2];
        pairs[0] = new Pair<View,String>(image, "logo_image");
        pairs[1] = new Pair<View,String>(logo, "logo_text");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, UserSelector.class);
                startActivity(intent);
                finish();
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Splash.this,pairs);
//                    startActivity(intent,options.toBundle());
//                }
            }
        }, 3000);
    }
}







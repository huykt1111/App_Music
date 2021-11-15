package com.example.nguyenquanghuy_1911505310224.Splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nguyenquanghuy_1911505310224.Activity.Menu_Fragment;
import com.example.nguyenquanghuy_1911505310224.R;

public class SplashScreen extends AppCompatActivity {

    //Thoi gian cho 3 giay
    int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Menu_Fragment.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
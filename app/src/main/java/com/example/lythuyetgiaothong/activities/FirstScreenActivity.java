package com.example.lythuyetgiaothong.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.lythuyetgiaothong.MainActivity;
import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.utils.Contants;


public class FirstScreenActivity extends AppCompatActivity {

    protected boolean _active = true;
    protected int _splashTime = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                finish();
                SharedPreferences sharedPreferences = FirstScreenActivity.this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                if (sharedPreferences.getString(Contants.id, "").isEmpty()){
                    Intent i3 = new Intent(FirstScreenActivity.this, LoginActivity.class);
                    startActivity(i3);
                }else{
                    Intent i3 = new Intent(FirstScreenActivity.this, MainActivity.class);
                    startActivity(i3);
                    finish();
                }
            }
        }, _splashTime);
    }

}
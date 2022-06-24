package com.example.lythuyetgiaothong.activities;
import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterThi;
import com.example.lythuyetgiaothong.models.ItemThiModel;
import com.example.lythuyetgiaothong.utils.Contants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ThiActivity extends AppCompatActivity {
    private Button start,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi);
        initUi();
        startTest();
        showResult();
    }

    private void showResult() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = ThiActivity.this.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                if (sharedPreferences.getString(Contants.email, "").isEmpty()){

                }else{
                    Intent intent = new Intent(ThiActivity.this, TestResultActivity.class);
                    intent.putExtra("act","testAct");
                    startActivity(intent);
                }

            }
        });
    }

    private void startTest() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              {
                    Intent intent = new Intent(ThiActivity.this, TestDoingActivity.class);
                    startActivity(intent);
                }

            }
        });

    }





    private void initUi() {
        start = findViewById(R.id.btn_test_start);
        result = findViewById(R.id.btn_test_result);

    }

}
package com.example.lythuyetgiaothong.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lythuyetgiaothong.MainActivity;
import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.UserLogin;
import com.example.lythuyetgiaothong.models.UserResponse;
import com.example.lythuyetgiaothong.utils.Contants;
import com.example.lythuyetgiaothong.utils.StoreUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText us;
    private  EditText pw;
    private Button sign;
    private  Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Initui();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(LoginActivity.this , CreateActivity.class);
                startActivity(first);

            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                logIn();
            }
        });
    }



    private void logIn() {
        String mail = us.getText().toString();
        String pass = pw.getText().toString();

        UserLogin userLogin1 = new UserLogin(mail,pass);
        Call<UserResponse> responseDTOCall = (Call<UserResponse>) ApiClient.getapiUser().Login(userLogin1);
        responseDTOCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body().getStatus()==200)
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    StoreUtils.save(LoginActivity.this, Contants.id, String.valueOf(response.body().getId()));
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void Initui() {
       us = findViewById(R.id.lg_us);
       pw = findViewById(R.id.lg_pass);
       sign = findViewById(R.id.bt_edtpf);
       signup =findViewById(R.id.bt_back);


    }
}
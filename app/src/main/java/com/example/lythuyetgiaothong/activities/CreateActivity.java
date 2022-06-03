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
import com.example.lythuyetgiaothong.models.UserCreate;
import com.example.lythuyetgiaothong.models.UserLogin;
import com.example.lythuyetgiaothong.models.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {

    private EditText us;
    private  EditText pw;
    private EditText name;
    private  EditText address;
    private EditText number;
    private EditText cfpw;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Initui();

        create.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                creaTe();
            }
        });
    }



    private void creaTe() {
        String mail = us.getText().toString();
        String cfpass = cfpw.getText().toString();
        String pass = pw.getText().toString();
        String fullname = name.getText().toString();
        String phone = number.getText().toString();
        String add = address.getText().toString();

        if(cfpass.equals(pass))
        {
            UserCreate userCreate1 = new UserCreate(mail,pass,fullname,phone,add);
            Call<UserResponse> responseDTOCall = (Call<UserResponse>) ApiClient.getapiUser().Create(userCreate1);
            responseDTOCall.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if (response.body().getStatus()==200)
                    {
                        Intent intent = new Intent(CreateActivity.this, LoginActivity.class);
                        startActivity(intent);
//                    StoreUtils.save(LoginActivity.this, Contants.email, mail);
//                    StoreUtils.save(LoginActivity.this, Contants.id, String.valueOf(response.body().getId()));
                    finish();
                    }
                    else
                    {
                        Toast.makeText(CreateActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }

                }
                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Toast.makeText(CreateActivity.this, "Connecting... ", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            Toast.makeText(CreateActivity.this, "pass k gioosng", Toast.LENGTH_SHORT).show();
        }


    }

        private void Initui() {
            us = findViewById(R.id.cr_us);
            pw = findViewById(R.id.cr_pass);
            name = findViewById(R.id.cr_name);
            address = findViewById(R.id.cr_address);
            number = findViewById(R.id.cr_phonenumber);
            cfpw = findViewById(R.id.cr_cfpass);
            create =findViewById(R.id.cr_dk);
        }

}
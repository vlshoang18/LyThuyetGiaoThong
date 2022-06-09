package com.example.lythuyetgiaothong.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lythuyetgiaothong.MainActivity;
import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.ResponseUDT;
import com.example.lythuyetgiaothong.models.UserProfile;
import com.example.lythuyetgiaothong.models.UserUpdate;
import com.example.lythuyetgiaothong.utils.Contants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileUpdateActivity extends AppCompatActivity {
//    private CircleImageView avt;
//    private ImageView edtAvt;
    private TextView user,email,phoneNum,address,gender;
    private Button btnSave,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);
        initUi();
        getIn4();
        saveChange();
        exit();
    }
    @Override
    public void onBackPressed() {
        openDialog(Gravity.BOTTOM);
    }
    private void openDialog(int gravity){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_user_back);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        window.setAttributes(windowAtribute);

        // show dialog
        Button btnSave = dialog.findViewById(R.id.btn_back_user);
        Button btnExit = dialog.findViewById(R.id.btn_exit_user);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
                dialog.dismiss();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        dialog.show();
}
    private void getIn4() {
        String id = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE).getString(Contants.id,"");
        Call<UserProfile> responseDTOCall = ApiClient.getapiUser().getProfile(id);
        responseDTOCall.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                String url = response.body().getData().get(0).getImage().getUrl();
//                Picasso.with(ProfileUpdateActivity.this)
//                        .load(url).fit().centerInside().into(avt);
                String name = String.valueOf(response.body().getData().get(0).getFullName());
                user.setText(name);
                email.setText(response.body().getData().get(0).getEmail());
                phoneNum.setText(String.valueOf(response.body().getData().get(0).getPhoneNumber()));
                address.setText(String.valueOf(response.body().getData().get(0).getAddress()));
                Toast.makeText(ProfileUpdateActivity.this, "Chào "+name, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                Toast.makeText(ProfileUpdateActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void saveChange() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }
    private void exit(){
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(Gravity.BOTTOM);
            }
        });
    }
    private void back(){
        Intent intent = new Intent(ProfileUpdateActivity.this, MainActivity.class);
        startActivity(intent);
        ProfileUpdateActivity.this.finish();
    }
    private void update() {
        String name = String.valueOf(user.getText());
        String mail = String.valueOf(email.getText());
        String phone = String.valueOf(phoneNum.getText());
        String add = String.valueOf(address.getText());
        UserUpdate userUpdate = new UserUpdate(mail,name,phone,add);
        String id = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE).getString(Contants.id,"");
        Call<ResponseUDT> responseDTOCall = ApiClient.getapiUser().UpdateUser(userUpdate,id);
        responseDTOCall.enqueue(new Callback<ResponseUDT>() {
            @Override
            public void onResponse(Call<ResponseUDT> call, Response<ResponseUDT> response) {
                if (response.body().getStatus()==200){
                    back();
                }
                else {
                    Toast.makeText(ProfileUpdateActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ResponseUDT> call, Throwable t) {
                Toast.makeText(ProfileUpdateActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initUi() {
//        avt = findViewById(R.id.img_edit_user);
        user = findViewById(R.id.edt_name);
        email = findViewById(R.id.edt_email);
        phoneNum = findViewById(R.id.edt_phone);
        address = findViewById(R.id.edt_address);
//        edtAvt = findViewById(R.id.img_edit_avt);
        btnSave = findViewById(R.id.bt_edtpf);
        exit = findViewById(R.id.bt_back);
    }

}
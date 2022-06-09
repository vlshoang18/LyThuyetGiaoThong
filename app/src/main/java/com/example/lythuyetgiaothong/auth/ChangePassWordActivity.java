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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lythuyetgiaothong.MainActivity;
import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.PasswordChange;
import com.example.lythuyetgiaothong.models.ResponseUDT;
import com.example.lythuyetgiaothong.models.UserProfile;
import com.example.lythuyetgiaothong.utils.Contants;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePassWordActivity extends AppCompatActivity {
    private EditText pass, newPass, confirmPass;
    private Button btok , btback;
    private CircleImageView avt;

    private TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass_word);
        initUI();
        getIn4();
       
        saveChange();
        exit();
    }
    @Override
    public void onBackPressed() {
        openDialog(Gravity.BOTTOM);
    }



//    private void changeAvt() {
//    }

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
                Picasso.with(ChangePassWordActivity.this)
                        .load(url).fit().centerInside().into(avt);
                String name = String.valueOf(response.body().getData().get(0).getFullName());
                user.setText(name);
            }
            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                Toast.makeText(ChangePassWordActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void saveChange() {
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }
    private void back(){
        Intent in10t = new Intent(ChangePassWordActivity.this, MainActivity.class);
        startActivity(in10t);
        ChangePassWordActivity.this.finish();
    }
    private void exit(){
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(Gravity.BOTTOM);
            }
        });
    }
    private void update() {
        String p = String.valueOf(pass.getText());
        String newP = String.valueOf(newPass.getText());
        String confirmP = String.valueOf(confirmPass.getText());
        PasswordChange passwordChange = new PasswordChange(p,newP,confirmP);
        String id = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE).getString(Contants.id,"");
        Call<ResponseUDT> responseDTOCall = ApiClient.getapiUser().UpdatePass(passwordChange,id);
        responseDTOCall.enqueue(new Callback<ResponseUDT>() {
            @Override
            public void onResponse(Call<ResponseUDT> call, Response<ResponseUDT> response) {
                if (response.body().getStatus() == 200){
                    Toast.makeText(ChangePassWordActivity.this, "Đổi mật khẩu thành công ", Toast.LENGTH_SHORT).show();
                    back();

                }
                else {
                    Toast.makeText(ChangePassWordActivity.this, response.body().getMsg() , Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ResponseUDT> call, Throwable t) {
                Toast.makeText(ChangePassWordActivity.this, "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUI() {
        pass = findViewById(R.id.edt_pw);
        newPass = findViewById(R.id.edt_newpw);
        confirmPass = findViewById(R.id.edt_cfpw);
        btok = findViewById(R.id.bt_ok);
        btback = findViewById(R.id.bt_back);
        avt = findViewById(R.id.img_user);
        user = findViewById(R.id.tv_user);

    }
}
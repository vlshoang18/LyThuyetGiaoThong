package com.example.lythuyetgiaothong.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.auth.ChangePassWordActivity;
import com.example.lythuyetgiaothong.auth.ProfileUpdateActivity;
import com.example.lythuyetgiaothong.models.UserProfile;
import com.example.lythuyetgiaothong.utils.Contants;
import com.example.lythuyetgiaothong.utils.StoreUtils;
import com.squareup.picasso.Picasso;

import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingFragment extends Fragment {
    private View SettingView;
    private TextView st_name;
    private  TextView st_email;
    private ImageView image;
    private TextView st_pw;
    private  TextView st_add;
    private  TextView st_phone;
    private  TextView st_edit;
    private  TextView logOutUser,changepw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SettingView = inflater.inflate(R.layout.fragment_setting,container, false);
        initUi(); // khoi tao ham giao dien
        editProfile();
        getIn4();
        logOutUsr();
        changepw();

        return SettingView;
    }

    private void changepw() {
        changepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChangePassWordActivity.class);
                startActivity(intent);
                getActivity().onBackPressed();
            }
        });

    }



    private void logOutUsr() {
            logOutUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog(Gravity.BOTTOM);
                }
            });
        }
        private void openDialog(int gravity){
            final Dialog dialog = new Dialog(getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_user_back);
            TextView tvMessage = dialog.findViewById(R.id.tv_warning_user);
            Button btnContinue = dialog.findViewById(R.id.btn_back_user);
            Button btnExit = dialog.findViewById(R.id.btn_exit_user);
            btnContinue.setText(" Ở Lại");
            btnExit.setText("Thoát");
            tvMessage.setText("Bạn Có Chắc Muốn Đăng Xuất?");

            Window window = dialog.getWindow();
            if (window == null) {
                return;
            }
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            WindowManager.LayoutParams windowAtribute = window.getAttributes();
            window.setAttributes(windowAtribute);
            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            btnExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences email = getContext().getSharedPreferences("MySharedPref", 0);
                    email.edit().remove("email").commit();
                    email.edit().remove("id").commit();
                    getActivity().onBackPressed();
                }
            });
            dialog.show();
        }
    private void editProfile() {
        { st_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileUpdateActivity.class);
                startActivity(intent);
                getActivity().onBackPressed();

            }
        });
        }
    }


    private void getIn4() {
        String id = StoreUtils.get(getContext() ,Contants.id);
        Call<UserProfile> responseDTOCall = ApiClient.getapiUser().getProfile(id);
        responseDTOCall.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if (response.isSuccessful()){
                    String url = response.body().getData().get(0).getImage().getUrl();
                    Picasso.with(getContext())
                            .load(url).fit().centerInside().into(image);
                    String name = String.valueOf(response.body().getData().get(0).getFullName());
                    st_name.setText(name);
                    st_email.setText(response.body().getData().get(0).getEmail());
                    st_phone.setText(String.valueOf(response.body().getData().get(0).getPhoneNumber()));
                    st_add.setText(String.valueOf(response.body().getData().get(0).getAddress()));
                }


            }
            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                Toast.makeText(getContext(), "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUi() {
        st_name = SettingView.findViewById(R.id.st_tv_name);
        st_email = SettingView.findViewById(R.id.st_tv_email);
        st_add = SettingView.findViewById(R.id.st_tv_address);
        st_phone = SettingView.findViewById(R.id.st_tv_number);
        image = SettingView.findViewById(R.id.imageView8);
        st_edit =SettingView.findViewById(R.id.st_tv_edt);
        logOutUser = SettingView.findViewById(R.id.st_tv_logout);
        changepw = SettingView.findViewById(R.id.st_tv_edtpw);

    }
}

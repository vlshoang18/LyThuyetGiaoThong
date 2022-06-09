package com.example.lythuyetgiaothong.api;

import com.example.lythuyetgiaothong.models.PasswordChange;
import com.example.lythuyetgiaothong.models.ResponseUDT;
import com.example.lythuyetgiaothong.models.UserCreate;
import com.example.lythuyetgiaothong.models.UserLogin;
import com.example.lythuyetgiaothong.models.UserProfile;
import com.example.lythuyetgiaothong.models.UserResponse;
import com.example.lythuyetgiaothong.models.UserUpdate;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiUser {
    @POST("user/login")
    Call<UserResponse> Login(@Body UserLogin userLogin);

    @POST("user/register")
    Call<UserResponse> Create(@Body UserCreate userCreate);

    @GET("user/getProfile/{id}")
    Call<UserProfile> getProfile(@Path("id") String id);

    @PATCH("user/updateUser/{id}")
    Call<ResponseUDT> UpdateUser(@Body UserUpdate userUpdate, @Path("id") String id);
    @PATCH("user/changePassword/{id}")
    Call<ResponseUDT> UpdatePass(@Body PasswordChange passwordChange, @Path("id") String id);
}

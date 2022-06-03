package com.example.lythuyetgiaothong.api;

import com.example.lythuyetgiaothong.models.UserCreate;
import com.example.lythuyetgiaothong.models.UserLogin;
import com.example.lythuyetgiaothong.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiUser {
    @POST("user/login")
    Call<UserResponse> Login(@Body UserLogin userLogin);

    @POST("user/register")
    Call<UserResponse> Create(@Body UserCreate userCreate);
}

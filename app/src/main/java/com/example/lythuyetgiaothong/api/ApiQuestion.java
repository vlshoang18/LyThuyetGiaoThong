package com.example.lythuyetgiaothong.api;

import com.example.lythuyetgiaothong.models.QuestionCategoryResponse;
import com.example.lythuyetgiaothong.models.TheoryAllModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiQuestion {


    @GET("categoryLearn/getAll")
    Call<TheoryAllModel> getall();
    @GET("learn/getLearnFollowIdCategory/{id}")
    Call<QuestionCategoryResponse> getChapter(@Path("id") String id);
}

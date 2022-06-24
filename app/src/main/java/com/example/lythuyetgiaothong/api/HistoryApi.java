package com.example.lythuyetgiaothong.api;

import com.example.lythuyetgiaothong.models.History;
import com.example.lythuyetgiaothong.models.ResponseUDT;
import com.example.lythuyetgiaothong.models.TestHistoryResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HistoryApi {

    @GET("history/getAll")
    Call<TestHistoryResponse> getHistory();

    @POST("history/add")
    Call<ResponseUDT> saveHistory(@Body History history);

}

package com.example.lythuyetgiaothong.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit getRetrofit(){
        //http://192.168.1.2:5000/customer/login

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://driving-license-thainam.herokuapp.com/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }


    public static ApiSign getapiSign(){
        ApiSign apiSign = getRetrofit().create(ApiSign.class);
        return apiSign;
    }
    public static  ApiUser getapiUser(){
        ApiUser apiUser = getRetrofit().create(ApiUser.class);
        return apiUser;
    }
    public static ApiQuestion apiQuestion(){
        ApiQuestion apiQuestion = getRetrofit().create(ApiQuestion.class);
        return  apiQuestion;
    }
    public static HistoryApi historyApi(){
        HistoryApi historyApi = getRetrofit().create(HistoryApi.class);
        return  historyApi;
    }
}

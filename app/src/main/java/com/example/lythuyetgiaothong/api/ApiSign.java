package com.example.lythuyetgiaothong.api;

import com.example.lythuyetgiaothong.models.SignDetailModel;
import com.example.lythuyetgiaothong.models.SignModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiSign {

    @GET("trafficSign/getTrafficSignFollowIdCategory/628200c77b71473bad5e2814")
    Call<SignModel> getsignProhibition(); // biển báo cấm
    @GET("trafficSign/getTrafficSignFollowIdCategory/628201977b71473bad5e2816")
    Call<SignModel> getsignAuxiliary();     // biển báo phụ
    @GET("trafficSign/getTrafficSignFollowIdCategory/628201f17b71473bad5e281a")
    Call<SignModel> getsignCommand();        //biển hiệu lệnh
    @GET("trafficSign/getTrafficSignFollowIdCategory/628201e77b71473bad5e2818")
    Call<SignModel> getsignWarning();       // biển cảnh báo
    @GET("trafficSign/getTrafficSignFollowIdCategory/628201f97b71473bad5e281c")
    Call<SignModel> getsignPost();          // biển chỉ dẫn
    @GET("/trafficSign/getDetail/{id_sp}")
    Call<SignDetailModel> getsigndetail(@Path("id_sp") String id);

}

package com.example.lythuyetgiaothong.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterLyThuyet;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.TheoryAllDataModel;
import com.example.lythuyetgiaothong.models.TheoryAllModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LyThuyetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterLyThuyet adapterLyThuyet;
    List<TheoryAllDataModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly_thuyet);
        initUi();
        setRecycleView();
        recyclerView.setLayoutManager(new LinearLayoutManager(LyThuyetActivity.this));
        recyclerView.setHasFixedSize(true);
    }

        private void setRecycleView() {
            ApiClient.apiQuestion().getall().enqueue(new Callback<TheoryAllModel>() {
                @Override
                public void onResponse(Call<TheoryAllModel> call, Response<TheoryAllModel> response) {
                    adapterLyThuyet = new AdapterLyThuyet(response.body().getData(),LyThuyetActivity.this ) ;
                    recyclerView.setAdapter(adapterLyThuyet);
                }

                @Override
                public void onFailure(Call<TheoryAllModel> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }

        private void initUi() {
            recyclerView = findViewById(R.id.rv_document);
        }

    }
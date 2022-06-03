package com.example.lythuyetgiaothong.fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterBienBao;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.ItemBienBaoModel;
import com.example.lythuyetgiaothong.models.SignDataModel;
import com.example.lythuyetgiaothong.models.SignModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BienBaoCamFragment extends Fragment {
    private View bienBao1View;
    private RecyclerView recyclerView;
    private AdapterBienBao adapterBienBao;
    List<SignDataModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bienBao1View = inflater.inflate(R.layout.fragment_bien_bao_1, container, false);
        initUi();

        setRecycleView();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        return bienBao1View;

    }

    private void setRecycleView() {
        ApiClient.getapiSign().getsignProhibition().enqueue(new Callback<SignModel>() {
            @Override
            public void onResponse(Call<SignModel> call, Response<SignModel> response) {
                adapterBienBao = new AdapterBienBao(response.body().getData(),getContext());
                recyclerView.setAdapter(adapterBienBao);
            }

            @Override
            public void onFailure(Call<SignModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void initUi() {
        recyclerView = bienBao1View.findViewById(R.id.rv_bienbao1);
    }

}
package com.example.lythuyetgiaothong.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lythuyetgiaothong.R;

import com.example.lythuyetgiaothong.adapters.CarAdapter;
import com.example.lythuyetgiaothong.adapters.MotoAdapter;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.ItemLuatModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Luat1Fragment extends Fragment {
    private View luat1view;
    private RecyclerView recyclerView;
    private MotoAdapter lawAdapter;
    private GridLayoutManager gridLayoutManager;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        luat1view = inflater.inflate(R.layout.fragment_luat1, container, false);
        intiUi();
        setAdapter();
        return luat1view;
    }

    private void setAdapter() {
        lawAdapter = new MotoAdapter(this.getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(luat1view.getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        lawAdapter.setData(getListLaw());
        recyclerView.setAdapter(lawAdapter);
    }

    private List<ItemLuatModel> getListLaw() {
        List<ItemLuatModel> listLaw = new ArrayList<>();
        listLaw.add(new ItemLuatModel(R.drawable.signpost, "Hiệu lệnh, biển chỉ dẫn"));
        listLaw.add(new ItemLuatModel(R.drawable.chuyenhuong, "Chuyển hướng, nhường đường"));
        listLaw.add(new ItemLuatModel(R.drawable.doxe, "Dừng xe, đỗ xe"));
        listLaw.add(new ItemLuatModel(R.drawable.horn, "Thiết bị ưu tiên, còi"));
        listLaw.add(new ItemLuatModel(R.drawable.speed, "Tốc độ, khoảng cách an toàn"));
        listLaw.add(new ItemLuatModel(R.drawable.vanchuyen, "Vận chuyển người, hàng hóa"));
        listLaw.add(new ItemLuatModel(R.drawable.thietbi, "Trang thiết bị phương tiện"));
        listLaw.add(new ItemLuatModel(R.drawable.stop, "Đường cấm, đường một chiều"));
        listLaw.add(new ItemLuatModel(R.drawable.ruou, "Nồng độ cồn, chất kích thích"));
        listLaw.add(new ItemLuatModel(R.drawable.idcard, "Giấy tờ xe"));
        listLaw.add(new ItemLuatModel(R.drawable.more, "Khác"));

        return listLaw;
    }
    private void intiUi() {
        recyclerView = luat1view.findViewById(R.id.rv_luat1);
    }
}
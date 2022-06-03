package com.example.lythuyetgiaothong.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterLuat;
import com.example.lythuyetgiaothong.models.ItemLuatModel;

import java.util.ArrayList;


public class Luat2Fragment extends Fragment {

    private View luat2View;
    private com.example.lythuyetgiaothong.fragments.Luat2Fragment luat2Fragment;
    private RecyclerView recyclerView;
    private AdapterLuat adapterLuat;

    private ArrayList<ItemLuatModel> itemLuatModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        luat2View = inflater.inflate(R.layout.fragment_luat2, container, false);
        initUi();
        setRecycleView();
        return luat2View;

    }

    private void setRecycleView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(luat2View.getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapterLuat = new AdapterLuat(itemLuatModels, this.luat2View.getContext());
        recyclerView.setAdapter(adapterLuat);

        itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
        adapterLuat.notifyDataSetChanged();
    }

    private void initUi() {
        recyclerView = luat2View.findViewById(R.id.rv_luat2);
    }

}
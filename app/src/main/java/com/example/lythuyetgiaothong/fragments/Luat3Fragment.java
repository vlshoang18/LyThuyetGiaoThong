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


public class Luat3Fragment extends Fragment {
    private View luat3View;
    private com.example.lythuyetgiaothong.fragments.Luat3Fragment luat3Fragment;
    private RecyclerView recyclerView;
    private AdapterLuat adapterLuat;
    private LinearLayoutManager layoutManager;
    private ArrayList<ItemLuatModel> itemLuatModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        luat3View = inflater.inflate(R.layout.fragment_luat3, container, false);
        initUi();
        setRecycleView();
        return luat3View;

    }

    private void setRecycleView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(luat3View.getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapterLuat = new AdapterLuat(itemLuatModels, this.luat3View.getContext());
        recyclerView.setAdapter(adapterLuat);

        itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
        itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
        adapterLuat.notifyDataSetChanged();
    }

    private void initUi() {
        recyclerView = luat3View.findViewById(R.id.rv_luat3);
    }

}
package com.example.lythuyetgiaothong.activities;
import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterThi;
import com.example.lythuyetgiaothong.models.ItemThiModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ThiActivity extends AppCompatActivity {
    private ArrayList<ItemThiModel> itemThiModels;
    private RecyclerView recyclerView;
    private AdapterThi adapterThi;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi);
        recyclerView = findViewById(R.id.rv_thi);
        itemThiModels = new ArrayList<>();

        setAdapter();

    }
    private void setAdapter() {
        adapterThi = new AdapterThi(itemThiModels,ThiActivity.this);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterThi);
        setIteminfo();
        adapterThi.notifyDataSetChanged();
    }


    private void setIteminfo() {


        itemThiModels.add(new ItemThiModel(R.drawable.img_1,"Đề Thi 1" ));
        itemThiModels.add(new ItemThiModel(R.drawable.img_2,"Đề Thi 2" ));
        itemThiModels.add(new ItemThiModel(R.drawable.img_3,"Đề Thi 3" ));
        itemThiModels.add(new ItemThiModel(R.drawable.img_4,"Đề Thi 4" ));
        itemThiModels.add(new ItemThiModel(R.drawable.img_1,"Đề Thi 5" ));
        itemThiModels.add(new ItemThiModel(R.drawable.img_2,"Đề Thi 6" ));
        itemThiModels.add(new ItemThiModel(R.drawable.img_3,"Đề Thi 7" ));

    }
}

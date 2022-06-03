package com.example.lythuyetgiaothong.activities;
import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterBienBao;
import com.example.lythuyetgiaothong.adapters.AdapterTabLayoutBienBao;
import com.example.lythuyetgiaothong.adapters.AdapterThi;
import com.example.lythuyetgiaothong.models.ItemBienBaoModel;
import com.example.lythuyetgiaothong.models.ItemThiModel;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class BienBaoActivity extends AppCompatActivity {
    private TabLayout tabLayoutSignal;
    private ViewPager viewPagerSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);
        initUi();
        AdapterTabLayoutBienBao adapterBienBao = new AdapterTabLayoutBienBao(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerSignal.setAdapter(adapterBienBao);
        tabLayoutSignal.setupWithViewPager(viewPagerSignal);
    }

    private void initUi() {
        tabLayoutSignal =  findViewById(R.id.tab_layout_bienbao);
        viewPagerSignal =  findViewById(R.id.view_pager_bienbao);
    }
}
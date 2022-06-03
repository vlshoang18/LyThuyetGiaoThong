package com.example.lythuyetgiaothong.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterTabLayoutBienBao;
import com.example.lythuyetgiaothong.adapters.AdapterTabLayoutLuat;
import com.google.android.material.tabs.TabLayout;

public class LuatActivity extends AppCompatActivity {
    private TabLayout tabLayoutSignal;
    private ViewPager viewPagerSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luat);
        initUi();
        AdapterTabLayoutLuat adapterLuat = new AdapterTabLayoutLuat(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerSignal.setAdapter(adapterLuat);
        tabLayoutSignal.setupWithViewPager(viewPagerSignal);
    }

    private void initUi() {
        tabLayoutSignal =  findViewById(R.id.tab_layout_luat);
        viewPagerSignal =  findViewById(R.id.view_pager_luat);
    }
}

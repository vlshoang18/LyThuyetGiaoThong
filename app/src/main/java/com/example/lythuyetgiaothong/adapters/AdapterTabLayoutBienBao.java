package com.example.lythuyetgiaothong.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.lythuyetgiaothong.fragments.BienBaoCamFragment;
import com.example.lythuyetgiaothong.fragments.BienBaoHieuLenhFragment;
import com.example.lythuyetgiaothong.fragments.BienBaoChiDanFragment;
import com.example.lythuyetgiaothong.fragments.BienBaoCanhbaoFragment;
import com.example.lythuyetgiaothong.fragments.BienBaoPhuFragment;

public class AdapterTabLayoutBienBao extends FragmentStatePagerAdapter {
    public AdapterTabLayoutBienBao(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new BienBaoCamFragment();
            case 1:
                return new BienBaoHieuLenhFragment();
            case 2:
                return new BienBaoChiDanFragment();
            case 3:
                return new BienBaoCanhbaoFragment();
            case 4:
                return new BienBaoPhuFragment();
            default:
                return new BienBaoCamFragment();
        }

    }
    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position) {
            case 0:
                return title="Biển cấm";
            case 1:
                return title="Biển hiệu lệnh";
            case 2:
                return title="Biển chỉ dẫn";
            case 3:
                return title="Biển cảnh báo và nguy hiểm";
            case 4:
                return title="Biển phụ";
            default:
                return title="Biển cấm";

        }
    }
}


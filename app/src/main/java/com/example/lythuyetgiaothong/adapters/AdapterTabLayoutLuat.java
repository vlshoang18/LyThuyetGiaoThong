package com.example.lythuyetgiaothong.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.lythuyetgiaothong.fragments.Luat1Fragment;
import com.example.lythuyetgiaothong.fragments.Luat2Fragment;
import com.example.lythuyetgiaothong.fragments.Luat3Fragment;

public class AdapterTabLayoutLuat extends FragmentStatePagerAdapter {
    public AdapterTabLayoutLuat(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
}
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Luat1Fragment();
            case 1:
                return new Luat2Fragment();
            case 2:
                return new Luat3Fragment();

            default:
                return new Luat1Fragment();
        }

    }
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position) {
            case 0:
                return title="Xe Máy";
            case 1:
                return title="Ô Tô";
            case 2:
                return title="Khác";

            default:
                return title="Xe Máy";

        }
    }
}


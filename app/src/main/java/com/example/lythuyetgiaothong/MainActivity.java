package com.example.lythuyetgiaothong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lythuyetgiaothong.fragments.HomeFragment;
import com.example.lythuyetgiaothong.fragments.LearnFragment;
import com.example.lythuyetgiaothong.fragments.SettingFragment;
import com.example.lythuyetgiaothong.fragments.TestFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                new HomeFragment()).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.action_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.action_learn:
                    fragment = new LearnFragment();
                    break;
                case R.id.action_setting:
                    fragment = new SettingFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                    fragment).commit();
            return true;
        }
    };
}
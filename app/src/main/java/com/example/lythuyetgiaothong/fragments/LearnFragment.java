package com.example.lythuyetgiaothong.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterLearn;
import com.example.lythuyetgiaothong.adapters.AdapterRecycler;
import com.example.lythuyetgiaothong.models.ItemHomeModel;
import com.example.lythuyetgiaothong.models.ItemLearnModel;
import com.example.lythuyetgiaothong.sliders.SliderActivity;

import java.util.ArrayList;

public class LearnFragment extends Fragment {
    private ViewFlipper viewFlipper;

    private ArrayList<ItemLearnModel> itemLearnModels;
    private RecyclerView recyclerView;
    private AdapterLearn adapterLearn;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learn,container, false);
        initUi();
        viewFlipper = view.findViewById(R.id.view_flipper);
        int images[] = {R.drawable.img_1, R.drawable.img_2,
                R.drawable.img_3, R.drawable.img_4 };
        for (int image : images) {
            flipperImages(image);
        }
        itemLearnModels = new ArrayList<>();
        setIteminfo();
        setAdapter();

        return view;
    }
    private void initUi(){
        recyclerView = view.findViewById(R.id.rv_functionl);
    }
    private void setAdapter() {
        adapterLearn = new AdapterLearn(itemLearnModels,view.getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterLearn );
    }
    public void flipperImages(int image) {
        ImageView imageView = new ImageView(view.getContext());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2900);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(view.getContext(), android.R.anim.slide_in_left);
    }
    private void setIteminfo() {


        itemLearnModels.add(new ItemLearnModel(R.drawable.thisathach,"Thi Sát Hạch" ));
        itemLearnModels.add(new ItemLearnModel(R.drawable.lythuyet,"Học Lý Thuyết" ));
        itemLearnModels.add(new ItemLearnModel(R.drawable.bienbao,"Các Biển Báo" ));
        itemLearnModels.add(new ItemLearnModel(R.drawable.luat,"Luật Giao Thông" ));



    }
}


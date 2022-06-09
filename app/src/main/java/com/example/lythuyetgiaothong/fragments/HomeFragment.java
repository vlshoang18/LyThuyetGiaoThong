package com.example.lythuyetgiaothong.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.adapters.AdapterRecycler;
import com.example.lythuyetgiaothong.api.ApiClient;
import com.example.lythuyetgiaothong.models.ItemHomeModel;
import com.example.lythuyetgiaothong.models.UserProfile;
import com.example.lythuyetgiaothong.sliders.SliderActivity;
import com.example.lythuyetgiaothong.utils.Contants;
import com.example.lythuyetgiaothong.utils.StoreUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ViewFlipper viewFlipper;
    private TextView homename;
    private  TextView homegmail;
    private  ImageView image;


    private ArrayList<ItemHomeModel> itemHomeModels;
    private RecyclerView recyclerView;
    private AdapterRecycler adapterRecycler;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container, false);

        initUi(); // khoi tao ham giao dien
        getIn4();
        viewFlipper = view.findViewById(R.id.view_flipper);
        int images[] = {R.drawable.img_1, R.drawable.img_2,
                R.drawable.img_3, R.drawable.img_4 };
        for (int image : images) {
            flipperImages(image);
        }


        return view;
    }

    private void getIn4() {
        String id = StoreUtils.get(getContext() , Contants.id);
        Call<UserProfile> responseDTOCall = ApiClient.getapiUser().getProfile(id);
        responseDTOCall.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if (response.isSuccessful()){
                    String url = response.body().getData().get(0).getImage().getUrl();
                    Picasso.with(getContext())
                            .load(url).fit().centerInside().into(image);
                    String name = String.valueOf(response.body().getData().get(0).getFullName());
                    homename.setText(name);
                    homegmail.setText(response.body().getData().get(0).getEmail());

                }


            }
            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                Toast.makeText(getContext(), "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUi(){
        homename = view.findViewById(R.id.home_nameus);
        homegmail= view.findViewById(R.id.home_gmailus);
        image = view.findViewById(R.id.imageView);
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(view.getContext());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2900);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(view.getContext(), android.R.anim.slide_in_left);
    }

}

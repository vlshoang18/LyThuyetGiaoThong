package com.example.lythuyetgiaothong.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lythuyetgiaothong.R;

import com.example.lythuyetgiaothong.api.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Luat1Fragment extends Fragment {
        TextView tv_vietnam;
        TextView tv_continent;
//        ImageView img_vietnam;
         View luat1View;
//        private RecyclerView recyclerView;
//         RecyclerView rcvCovid;
//        private AdapterLuat adapterLuat;

//        private ArrayList<ItemLuatModel> itemLuatModels = new ArrayList<>();



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            luat1View = inflater.inflate(R.layout.fragment_luat1, container, false);
            initUi();
//            countryData = new ArrayList<>();
//
//
//            rcvCovid.setLayoutManager(new LinearLayoutManager(getContext()));
//            rcvCovid.setHasFixedSize(true);
//            adapterCovid19 = new AdapterCovid19(countryData,getContext());
//            rcvCovid.setAdapter(adapterCovid19);
//         setCovid();

//          //  setRecycleView();
            return luat1View;
        }

//    private void setCovid() {
//        Call<CountryData> responseDTOCall = ApiClient.getApiCovid19().getDataVietNam();
//        responseDTOCall.enqueue(new Callback<CountryData>() {
//            @Override
//            public void onResponse(Call<CountryData> call, Response<CountryData> response) {
//
//                String country = response.body().getCountryInfo().getIso2();
//                String continent = response.body().getCountryInfo().getIso3();
////                String img = response.body().getCountryInfo().getFlag();
////                Picasso.with(getContext())
////                .load(img).fit().centerInside().into(img_vietnam);
//                tv_vietnam.setText(country);
//                tv_continent.setText(continent);





//            }
//
//            @Override
//            public void onFailure(Call<CountryData> call, Throwable t) {
//                Toast.makeText(getContext(), "Connect internet is wrong! ", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

//    private void setRecycleView() {
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(luat1View.getContext(),3);
//            recyclerView.setLayoutManager(gridLayoutManager);
//            adapterLuat = new AdapterLuat(itemLuatModels, this.luat1View.getContext());
//            recyclerView.setAdapter(adapterLuat);
//
//            itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
//            itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
//            itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
//            itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
//            itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
//            itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
//            itemLuatModels.add(new ItemLuatModel(R.drawable.img_3,"abc"));
//            itemLuatModels.add(new ItemLuatModel(R.drawable.img_2,"abc"));
//            adapterLuat.notifyDataSetChanged();
//        }

        private void initUi() {
//            recyclerView = luat1View.findViewById(R.id.rv_luat1);
           tv_vietnam = luat1View.findViewById(R.id.tv_country);
           tv_continent= luat1View.findViewById(R.id.tv_continent);
//           img_vietnam = luat1View.findViewById(R.id.img_vietnam);
        }

    }
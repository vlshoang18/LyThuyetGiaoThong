package com.example.lythuyetgiaothong.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.models.ItemLuatModel;

import java.util.ArrayList;

public class AdapterLuat extends RecyclerView.Adapter<AdapterLuat.MyviewHolder> {
    private ArrayList<ItemLuatModel> itemLuatModels;
    private Context context;

    public AdapterLuat(ArrayList<ItemLuatModel> itemLuatModels, Context context) {
        this.itemLuatModels = itemLuatModels;
        this.context = context;
    }


    public AdapterLuat.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemluat, parent, false);
        return new AdapterLuat.MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLuat.MyviewHolder holder, int position) {
        ItemLuatModel sign = itemLuatModels.get(position);
        if (sign == null) {
            return;

        }
        holder.img.setImageResource(sign.getImgluat());
        holder.tv.setText(sign.getTvluat());
    }

    @Override
    public int getItemCount() {
        if (itemLuatModels != null) {
            return itemLuatModels.size();
        }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private ImageView img;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_item_luat);
            tv = itemView.findViewById(R.id.tv_item_luat);


        }
    }
}
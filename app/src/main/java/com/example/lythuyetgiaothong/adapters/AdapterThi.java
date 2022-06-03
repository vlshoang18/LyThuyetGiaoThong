package com.example.lythuyetgiaothong.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.activities.DetailSignActivity;
import com.example.lythuyetgiaothong.models.ItemThiModel;

import java.util.ArrayList;

public class AdapterThi extends RecyclerView.Adapter<AdapterThi.MyviewHolder> {
    private ArrayList<ItemThiModel> itemThiModels;
    private Context context;  // là màn hình luôn khai báo

    public AdapterThi(ArrayList<ItemThiModel> itemThiModels,Context context){
        this.itemThiModels = itemThiModels;
        this.context = context;
    }
    public class MyviewHolder  extends RecyclerView.ViewHolder // ánh xạ  giao diện của item của cái list
    {
        private ImageView img;
        private TextView tv;

        public MyviewHolder(@NonNull View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.img_item_thi);
            tv = itemView.findViewById(R.id.tv_item_thi);
        }
    }
    @NonNull
    @Override
    public AdapterThi.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) //khai báo giao diện của item
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemthi,parent, false);
        return new AdapterThi.MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterThi.MyviewHolder holder, int position) // truyền dữ liệu từng phần tử của list vào item tương tự on create
    { ItemThiModel testing = itemThiModels.get(position);
        int a = position;
        if ( testing == null){
            return ;
        }
        holder.img.setImageResource(testing.getImg_thi());
        holder.tv.setText(testing.getTv_thi());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second = new Intent(context, DetailSignActivity.class);
                // tao 1 bien gan vao edt
                second.putExtra("ho ten", String.valueOf(a));
                context.startActivity(second);
            }
        });


    }

    @Override
    public int getItemCount() //trả về số lượng item trong list
    {
        if ( itemThiModels!= null){
            return itemThiModels.size();
        }
        return 0;
    }


}

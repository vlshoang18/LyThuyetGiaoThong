package com.example.lythuyetgiaothong.adapters;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.activities.BienBaoActivity;
import com.example.lythuyetgiaothong.activities.CreateActivity;
import com.example.lythuyetgiaothong.activities.LoginActivity;
import com.example.lythuyetgiaothong.activities.LuatActivity;
import com.example.lythuyetgiaothong.activities.LyThuyetActivity;
import com.example.lythuyetgiaothong.activities.ThiActivity;
import com.example.lythuyetgiaothong.fragments.HomeFragment;
import com.example.lythuyetgiaothong.models.ItemHomeModel;
import com.example.lythuyetgiaothong.models.ItemLearnModel;

import java.util.ArrayList;




public class AdapterLearn extends RecyclerView.Adapter<AdapterLearn.MyviewHolder> {
    private ArrayList<ItemLearnModel> itemLearnModels;
    private Context context;

    public AdapterLearn(ArrayList<ItemLearnModel> itemLearnModels,Context context){
        this.itemLearnModels = itemLearnModels;
        this.context = context;
    }
    public class MyviewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv;
        private ConstraintLayout ct;


        public  MyviewHolder(final View view){
            super(view);
            img = view.findViewById(R.id.img_item_learn);
            tv = view.findViewById(R.id.tv_item_learn);
            ct = view.findViewById(R.id.item_type_learn);



        }
    }

    @NonNull
    @Override
    public AdapterLearn.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlearn,parent, false);
        return new MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        String tvlearn = itemLearnModels.get(position).getTvlearn();
        int a = position;
        int imglearn = itemLearnModels.get(position).getImglearn();

        holder.tv.setText(tvlearn);
        holder.img.setImageResource(imglearn);
        holder.ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (a) {
                    case 0:
                        Intent intent = new Intent(context, ThiActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, LyThuyetActivity.class);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, BienBaoActivity.class);
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(context, LuatActivity.class);
                        context.startActivity(intent3);
                        break;

                }


            }
        });

    }

    @Override
    public int getItemCount() {
        if ( itemLearnModels != null){
            return itemLearnModels.size();
        }
        return 0;

    }
}


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
import com.example.lythuyetgiaothong.fragments.HomeFragment;
import com.example.lythuyetgiaothong.models.ItemHomeModel;

import java.util.ArrayList;




public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyviewHolder> {
    private ArrayList<ItemHomeModel> itemHomeModels;
    private Context context;

    public AdapterRecycler(ArrayList<ItemHomeModel> itemHomeModels, Context context){
        this.itemHomeModels = itemHomeModels;
        this.context = context;
    }
    public class MyviewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv;


        public  MyviewHolder(final View view){
            super(view);
            img = view.findViewById(R.id.img_item_home);
            tv = view.findViewById(R.id.tv_item_home);


        }
    }

    @NonNull
    @Override
    public AdapterRecycler.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemhome,parent, false);
        return new MyviewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler.MyviewHolder holder, int position) {
        String tvhome = itemHomeModels.get(position).getTvhome();

        int imghome = itemHomeModels.get(position).getImghome();
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, HomeFragment.class);
                context.startActivity(it );
            }

        });
        holder.tv.setText(tvhome);

        holder.img.setImageResource(imghome);

    }

    @Override
    public int getItemCount() {
        if ( itemHomeModels != null){
            return itemHomeModels.size();
        }
        return 0;

    }
}


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
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.activities.MoToActivity;
import com.example.lythuyetgiaothong.activities.OtherActivity;
import com.example.lythuyetgiaothong.models.ItemLuatModel;

import java.util.List;

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.LawViewHolder>{
    private Context context;
    private List<ItemLuatModel> law;

    public OtherAdapter(Context context) {
        this.context = context;
    }


    public OtherAdapter(List<ItemLuatModel> law) {
        this.context = context;
        this.law = law;
    }

    public void setData(List<ItemLuatModel> law) {
        this.law = law;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public OtherAdapter.LawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemluat, parent, false);
        return new OtherAdapter.LawViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull OtherAdapter.LawViewHolder holder, int position) {
        ItemLuatModel l = law.get(position);
        int a = position;
        if (l == null) {
            return;
        }
        holder.imgLaw.setImageResource(l.getImgluat());
        holder.typeLaw.setText(l.getTvluat());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OtherActivity.class);
                intent.putExtra("lawPos",String.valueOf(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        if (law != null) {
            return law.size();
        }
        return 0;
    }
    public class LawViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgLaw;
        private TextView typeLaw;
        private ConstraintLayout constraintLayout;
        public LawViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLaw = itemView.findViewById(R.id.img_item_luat);
            typeLaw = itemView.findViewById(R.id.tv_item_luat);
            constraintLayout = itemView.findViewById(R.id.item_list_luat);
        }
    }
}



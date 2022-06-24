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
import com.example.lythuyetgiaothong.models.ItemLaw;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LawAdapter extends RecyclerView.Adapter<LawAdapter.ItemLawViewHolder> {
    private Context itemLawContext;
    private List<ItemLaw> itemLaw;

    public LawAdapter(Context itemLawContext, List<ItemLaw> itemLaw) {
        this.itemLawContext = itemLawContext;
        this.itemLaw = itemLaw;
    }

    @NonNull
    @Override
    public LawAdapter.ItemLawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_law, parent, false);
        return new LawAdapter.ItemLawViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LawAdapter.ItemLawViewHolder holder, int position) {
        ItemLaw itemL = itemLaw.get(position);
        int a = position;
        if (itemL == null) {
            return;
        }
        holder.imgItemLaw.setImageResource(itemL.getImgItemLaw());
        holder.tittleItemLaw.setText(itemL.getTittleItemLaw());
        holder.contentItemLaw.setText(itemL.getContentItemLaw());


    }

    @Override
    public int getItemCount() {
        if (itemLaw != null) {
            return itemLaw.size();
        }
        return 0;
    }


    public class ItemLawViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgItemLaw;
        private TextView tittleItemLaw,contentItemLaw;
        private ConstraintLayout constraintLayout;
        public ItemLawViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItemLaw = itemView.findViewById(R.id.img_item_list_law);
            tittleItemLaw = itemView.findViewById(R.id.tv_law_name);
            contentItemLaw = itemView.findViewById(R.id.tv_law_content);

            constraintLayout = itemView.findViewById(R.id.item_list_law);
        }
    }

}

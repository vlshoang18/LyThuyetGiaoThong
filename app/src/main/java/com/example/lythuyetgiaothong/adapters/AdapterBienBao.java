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
import com.example.lythuyetgiaothong.models.SignDataModel;
import com.squareup.picasso.Picasso;


import java.util.List;

public class AdapterBienBao extends RecyclerView.Adapter<AdapterBienBao.MyviewHolder> {
    private List<SignDataModel> signDataModels;
    private Context context; // đây

    public AdapterBienBao(List<SignDataModel> signDataModels, Context context) {
        this.signDataModels = signDataModels;
        this.context = context;
    }

    public AdapterBienBao.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembienbao, parent, false);
        return new AdapterBienBao.MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBienBao.MyviewHolder holder, int position) {
        SignDataModel sign = signDataModels.get(position);
        if (sign == null) {
            return;

        }
//
        holder.tv.setText(sign.getName());
        holder.tv2.setText(sign.getDescription());
//       holder.img.setImageResource(sign.getImage().getUrl().

        //mContext là tên mình đặt cho Context
               Picasso.with(context)
               .load(
                      sign.getImage().getUrl()). // cái này là dữ liệu api trả về
                       error(R.drawable.background). // cái này là option muôn hay k cũng dược, nếu mà ảnh load
                       // về lỗi thì nó hiện 1 hình mình set cứng.
                       fit().centerInside().
                       into((holder).img);// cái này là đẩy dữ liệu ảnh lên image view trong item.

                    holder.tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailSignActivity.class);
                intent.putExtra("Key_1", sign.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (signDataModels != null) {
            return signDataModels.size();
        }

        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        private TextView tv2;
        private TextView tv3;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_item_bienbao);
            tv = itemView.findViewById(R.id.tv_item_bienbao);
            tv2 = itemView.findViewById(R.id.tv_item_bienbao2);
            tv3 = itemView.findViewById(R.id.tv_ct);

        }
    }
}


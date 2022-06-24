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
import com.example.lythuyetgiaothong.activities.QuestionActivity;
import com.example.lythuyetgiaothong.models.TheoryAllDataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterLyThuyet extends RecyclerView.Adapter<AdapterLyThuyet.DocumentViewHolder> {


    private List<TheoryAllDataModel> theoryAllDataModels;
    private Context context;

    public AdapterLyThuyet(List<TheoryAllDataModel> theoryAllDataModels, Context context) {
        this.theoryAllDataModels = theoryAllDataModels;
        this.context = context;
    }

    public AdapterLyThuyet.DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlythuyet, parent, false);
        return new AdapterLyThuyet.DocumentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLyThuyet.DocumentViewHolder holder, int position) {
        TheoryAllDataModel currentItem = theoryAllDataModels.get(position);
        if (currentItem == null) {
            return;

        }

        holder.tv.setText(currentItem.getName());

        Picasso.with(context)
                .load(
                        currentItem.getImage().getUrl()). // cái này là dữ liệu api trả về
                error(R.drawable.background). // cái này là option muôn hay k cũng dược, nếu mà ảnh load
                // về lỗi thì nó hiện 1 hình mình set cứng.
                        fit().centerInside().
                into((holder).img);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, QuestionActivity.class);
                intent.putExtra("Keychapter", currentItem.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (theoryAllDataModels != null) {
            return theoryAllDataModels.size();
        }

        return 0;
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        private TextView tv2;
        private  TextView tv3;

        private ConstraintLayout constraintLayout;

        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_item_lythuyet);
            tv = itemView.findViewById(R.id.tv_item_lythuyet);

            tv3 = itemView.findViewById(R.id.tv_ct);
            constraintLayout = itemView.findViewById(R.id.itemlt);


        }
    }
}


package com.example.lythuyetgiaothong.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.activities.QuestionActivity;
import com.example.lythuyetgiaothong.models.Answer;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {
    private Context context;
    List<Answer> answers ;

    public AnswerAdapter(Context context, List<Answer> answers) {
        this.context = context;
        this.answers = answers;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_answer, parent, false);
        return new AnswerAdapter.AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        Answer currentItem = answers.get(position);
        holder.ans.setText(currentItem.getTitle());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (currentItem.getTrue().equals("1")) {
                    holder.ans.setBackgroundResource(R.color.green);

                    Toast toast = Toast.makeText(v.getContext(), "Đáp án chính xác", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER, 20, 30);
                    toast.show();
                } else{

                }
            }
        });

    }


    @Override
    public int getItemCount() {
        if (answers != null){
            return answers.size();
        }
        return 0;
    }

    public class AnswerViewHolder extends RecyclerView.ViewHolder {
        private TextView ans;
        private ConstraintLayout constraintLayout;
        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            ans = itemView.findViewById(R.id.tv_answer);
            constraintLayout = itemView.findViewById(R.id.parent_answer);
        }
    }
}

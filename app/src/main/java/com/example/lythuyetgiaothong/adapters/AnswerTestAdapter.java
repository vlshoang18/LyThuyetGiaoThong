package com.example.lythuyetgiaothong.adapters;

import static com.example.lythuyetgiaothong.utils.Contants.listId;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.models.AnswerAll;
import com.example.lythuyetgiaothong.utils.StoreUtils;

import java.util.List;

public class AnswerTestAdapter extends RecyclerView.Adapter<AnswerTestAdapter.AnswerViewHolder> {
    private Context context;
    List<AnswerAll> answers ;

    private int checkedPosition =0;

    public AnswerTestAdapter(Context context, List<AnswerAll> answers) {
        this.context = context;
        this.answers = answers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnswerTestAdapter.AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_answer, parent, false);
        return new AnswerTestAdapter.AnswerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AnswerTestAdapter.AnswerViewHolder holder, int position) {
        holder.bind(answers.get(position));
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
        void bind(final AnswerAll answer){
            ans.setText(String.valueOf(answer.getTitle()));
            ans.setBackgroundResource(R.drawable.border_white);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = String.valueOf(answer.getId());

                    if (checkedPosition == -1){
                        ans.setBackgroundResource(R.drawable.border_white);
                    }
                    else {
                        ans.setBackgroundResource(R.drawable.border_blue);
                        if (answer.getTrue().equals("1")){
                            ans.setBackgroundResource(R.drawable.border_green);
                            int n = listId.size();
                            if (n==0){
                                listId.add(id);
                                StoreUtils.writeListInPref(context,listId,"listID");
                            }
                            else {
                                int k =0;
                                for (int i = 0;i<n;i++){
                                    if (id!= listId.get(i)){
                                        k= k+1;
                                    }
                                }
                                if (k==n){
                                    listId.add(id);
                                    StoreUtils.writeListInPref(context,listId,"listID");
                                }
                            }

                        }
                        else {
                            ans.setBackgroundResource(R.drawable.border_red);
                        }
                    }
                    if (checkedPosition!= getAdapterPosition()){
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();

                    }

                }
            });
        }
    }
}


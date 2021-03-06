package com.example.lythuyetgiaothong.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lythuyetgiaothong.R;
import com.example.lythuyetgiaothong.models.AnswerAll;
import com.example.lythuyetgiaothong.models.QuestionAll;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionTestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
private Context context;
        List<QuestionAll> questions;

public QuestionTestAdapter(Context context, List<QuestionAll> questions) {
        this.context = context;
        this.questions = questions;
        }

public Context getContext() {
        return context;
        }

public void setContext(Context context) {
        this.context = context;
        }




@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_question,parent,false);
        return new QuestionTestAdapter.QuestionViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List<AnswerAll> ans =new ArrayList<>();
        QuestionAll currentItem = questions.get(position);
        String nullUrl ="";
        if (currentItem.getImage().getUrl().equals(nullUrl)){
        ((QuestionTestAdapter.QuestionViewHolder)holder).img.setVisibility(View.GONE);
        }
        else {
        ((QuestionTestAdapter.QuestionViewHolder)holder).img.setVisibility(View.VISIBLE);
        String url = currentItem.getImage().getUrl();
        Picasso.with(getContext())
        .load(url).fit().centerInside().into(((QuestionTestAdapter.QuestionViewHolder)holder).img);
        }
        ((QuestionTestAdapter.QuestionViewHolder)holder).itemTitle.setText(currentItem.getQuestion());
        ((QuestionTestAdapter.QuestionViewHolder)holder).answer.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        ((QuestionTestAdapter.QuestionViewHolder)holder).answer.setItemAnimator(new DefaultItemAnimator());
        ans.addAll(currentItem.getAnswer());
        Collections.shuffle(ans);
        AnswerTestAdapter answerLearnAdapter = new AnswerTestAdapter( context,ans);
        ((QuestionTestAdapter.QuestionViewHolder)holder).answer.setAdapter(answerLearnAdapter);

        }
@Override
public int getItemCount() {
        if (questions != null){
        return questions.size();
        }
        return 0;
        }

public class QuestionViewHolder extends RecyclerView.ViewHolder {
    private TextView itemTitle;
    private RecyclerView answer;
    private ImageView img;
    public QuestionViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.image);
        itemTitle = itemView.findViewById(R.id.tv_quest);
        answer = itemView.findViewById(R.id.answer);
    }
}

    }

